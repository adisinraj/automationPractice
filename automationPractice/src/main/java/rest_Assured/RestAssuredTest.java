package rest_Assured;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest {

	public static void main(String[] args) {
		
		
	//	getRequest();
		postRequest();
		
	}

	private static void postRequest() {
		RestAssured.baseURI = "https://reqres.in/api";
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject json = new JSONObject();
		json.put("name", "chaya");
		json.put("job", "BAA");
		 
		 request.body(json.toJSONString());		
		
		Response response = request.post("/users");
		
		System.err.println(response.getHeaders());
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		
		SuccessClass successClass = response.as(SuccessClass.class); //Representing a JSON, or any structured data including XML, 
		//into a programming class is called Deserialization of JSON. 
		//The term Deserialization here means the conversion from the String form of JSON to a Class form. 
		//This is also called Object Representation of structured data. Here structured data is the JSON.
		
		Assert.assertEquals(response.getStatusCode(), successClass.postSUCCESS);
	}

	private static void getRequest() {
		 // Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city/";
		
		// Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		RequestSpecification requestSpecification =  RestAssured.given();  //requestSpecification is the request object
	
		// Make a GET request call directly by using RequestSpecification.get() method.
		 // Make sure you specify the resource name.
		Response response = requestSpecification.get("/Pune");
		
		 // Response.asString method will directly return the content of the body
		 // as String.
	//	System.out.println(response.asString());
		
		//retrieve the body of response
		ResponseBody responseBody = response.getBody();
		
		System.out.println(responseBody.asPrettyString());
		
		
		// VALIDATING THE NODE FROM THE RESPONSE JSON
		JsonPath jsonPath = response.jsonPath();
		String actualHumidity = jsonPath.get("Humidity");
		
//		System.out.println(actualHumidity);
	
		System.err.println(response.headers());
		System.out.println(response.getHeaders());
		System.err.println(response.getStatusCode());
		System.err.println(response.getStatusLine());
		

		
	}
}
