package tests.restAssured;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

 class PCIComplianceTests {

    private static String token = "your_bearer_token_here";

    @BeforeSuite
    public static void setup() {
        RestAssured.baseURI = "https://secure.payments.com/api";

        // Global PCI filter: fail if sensitive data is exposed
        Filter pciFilter = (reqSpec, resSpec, ctx) -> {
            Response res = ctx.next(reqSpec, resSpec);
            String body = res.asString();
            if (body.contains("cardNumber") || body.contains("cvv")) {
                throw new AssertionError("PCI violation: sensitive data exposed!");
            }
            return res;
        };
        RestAssured.filters(pciFilter);
    }

    @Test
    public void testHttpsOnly() {
        given()
                .relaxedHTTPSValidation()
                .when()
                .get("/health")
                .then()
                .statusCode(200);
    }

    @Test
    public void testMaskedCardData() {
        Response res = given()
                .auth().oauth2(token)
                .when()
                .post("/payments");

        assertFalse(res.asString().contains("4111111111111111")); // raw PAN must not appear
        assertTrue(res.asString().contains("****1111"));          // masked value is acceptable
    }

    @Test
    public void testValidAndInvalidTokens() {
        // Valid token should succeed
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/secure")
                .then()
                .statusCode(200);

        // Invalid token should fail
        given()
                .header("Authorization", "Bearer " + "expired_or_fake_token")
                .when()
                .get("/secure")
                .then()
                .statusCode(401);
    }

    @Test
    public void testNoSensitiveFieldsInResponse() {
        Response res = given()
                .auth().oauth2(token)
                .when()
                .get("/transactions/123");

        assertFalse(res.asString().contains("cvv")); // CVV must never appear
    }

    @Test
    public void testInvalidCardInput() {
        given()
                .auth().oauth2(token)
                .body("{\"card\":\"1234\"}") // invalid card
                .when()
                .post("/payments")
                .then()
                .statusCode(400);
    }

    @Test
    public void testTokenizationResponse() {
        String validCardJson = "{ \"card\": \"4111111111111111\", \"expiry\": \"12/25\" }";

        Response res = given()
                .auth().oauth2(token)
                .body(validCardJson)
                .when()
                .post("/payments");

        String paymentToken = res.jsonPath().getString("token");
        assertNotNull(paymentToken); // must return a token instead of raw card data
    }
}


 public class FilterInvocationTests {

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Filter testFilter = (reqSpec, resSpec, ctx) -> {
            System.out.println(">>> Filter invoked BEFORE request");
            Response res = ctx.next(reqSpec, resSpec);
            System.out.println("Inside filter "+res);
            System.out.println(">>> Filter invoked AFTER response");
            return res;
        };
        RestAssured.filters(testFilter);
    }

    @Test
    public void testFilterInvocation() {
        Response response = given()
                .relaxedHTTPSValidation()
                .when()
                .get("/posts")
                .then()
                .statusCode(200).extract().response();
        System.out.println("in the test"+response);
    }
}