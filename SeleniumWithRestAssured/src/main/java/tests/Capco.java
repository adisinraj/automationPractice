package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.stream.Stream;

public class Capco {
    public static void main(String[] args) {
        System.out.println("Prime no: "+ Stream.of(1,2,3,4,5)
                .filter(Capco::isPrime).toList());
    }
    public static boolean isPrime(Integer num){
        for(int i=2; i<num;i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

    public Response postRequest(RequestSpecification specs, String URI){
       return RestAssured.given()
                .spec(specs)
                .when()
                .post(URI)
                .then()
                .extract()
                .response();
    }


}
