package rest_Assured;

import static io.restassured.RestAssured.given;

public class RestAssuredBDD {
public static void main(String[] args) {
	given()
		.baseUri("https://demoqa.com/utilities/weather/city/")
	.when()
		.get("Pune")
	.then()
		.log().all();
	
		
	}
}
