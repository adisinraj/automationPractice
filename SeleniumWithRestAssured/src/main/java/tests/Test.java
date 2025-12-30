package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        RestAssured.baseURI = "some url";
        RestAssured.basePath = "some path";
     //   final RequestSpecification build = new RequestSpecBuilder().addPathParam().setContentType().build();

        Response response = RestAssured
                .given()
                .when().post("")
                .then().extract().response();

        Map map = Collections.synchronizedMap(new HashMap<>());
        Map map2 = new ConcurrentHashMap();

    }
}


