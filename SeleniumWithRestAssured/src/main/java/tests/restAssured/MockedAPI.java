package tests.restAssured;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MockedAPI extends BaseMockTest{
    @Test
    public void testPlaceOrder_InventoryAvailable() {

        // --- 1. MOCK STUB DEFINITION (WireMock) ---
        // When the API under test calls the /inventory endpoint...
        stubFor(get(urlEqualTo("/products/P101/inventory"))
                // ...respond with a 200 OK and a body indicating availability.
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"productId\": \"P101\", \"available\": true, \"stock\": 50}")
                )
        );

        // --- 2. EXECUTE API UNDER TEST (RestAssured) ---
        Response response = given()
                .baseUri(API_UNDER_TEST_BASE_URL)
                .contentType("application/json")
                .body("{\"product_id\": \"P101\", \"quantity\": 1}") // Order for P101
                .when()
                .post("/orders");

        // --- 3. VALIDATE RESPONSE (RestAssured/TestNG) ---
        response.then()
                .statusCode(201)
                .body("status", equalTo("PLACED"))
                .body("product_id", equalTo("P101"));

        // --- 4. VERIFY CALL TO MOCK (WireMock) ---
        // Ensure the API under test actually called the downstream service as expected
        verify(1, getRequestedFor(urlEqualTo("/products/P101/inventory")));
    }
}

class BaseMockTest {

    public static final int MOCK_PORT = 8081;
    public WireMockServer wireMockServer;

    // The base URL of the API under test (which calls the downstream mock)
    protected final String API_UNDER_TEST_BASE_URL = "https://jsonplaceholder.typicode.com/";

    @BeforeClass
    public void startWireMockServer() {
        // 1. Initialize and start the WireMock server
        wireMockServer = new WireMockServer(wireMockConfig().port(MOCK_PORT));
        wireMockServer.start();

        // 2. Configure WireMock client to talk to the running server
        configureFor("localhost", MOCK_PORT);

        System.out.println("WireMock Server started on port " + MOCK_PORT);
    }

    @AfterClass
    public void stopWireMockServer() {
        // Stop the server after all tests in the class are done
        wireMockServer.stop();
        System.out.println("WireMock Server stopped.");
    }
}