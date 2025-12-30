package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.concurrent.TimeUnit;

public class RestAssuredClass {
    public static void main(String[] args) {
        RequestSpecification specification = new RequestSpecBuilder()
                .setBaseUri("https://randomuser.me/")
                        .build();
       Response response = RestAssured
               .given().baseUri("https://randomuser.me/").basePath("api/")
               .when().get()
               .then().extract().response();
        System.out.println(response.path("results[0].nat").toString());
        System.out.println(response.timeIn(TimeUnit.MILLISECONDS));
       RestAssured.baseURI = "https://randomuser.me/";
       RestAssured.basePath = "api/";
       Response response1 =  RestAssured.given().auth().preemptive().basic("username","password")
               .get()
               .then().extract().response();

       RestAssured.given().header("request-id","1234").contentType(ContentType.JSON).body("{}")
               .auth()
               .oauth("","","","")
                       .post("/auth")
                               .then()
                                       .statusCode(201)
                                               .extract().response();



      /*  System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.path("info").toString());
        System.out.println(response.asPrettyString());

        UserResponse userResponse = response.as(UserResponse.class);
        System.out.println(userResponse.toString());


        System.out.println(userResponse.getResults().getFirst());
        System.out.println(response.jsonPath());*/
/**
 * Casting the response into the object and then we can assert on them.
 */

       /* System.out.println(response.jsonPath().getString("info.seed"));
        System.out.println(response.jsonPath().getString("results[0].login.username"));
        System.out.println(response.jsonPath().getString("results[0].name.title"));*/
/**
 * JSONPath in restassured lets you extract the exact element by traversing the json object.
 * Nested travesing is done using the .
 */
     //   System.out.println(response.asPrettyString());
    }
}
