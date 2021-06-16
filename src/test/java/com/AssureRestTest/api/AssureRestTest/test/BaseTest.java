package com.AssureRestTest.api.AssureRestTest.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.springframework.test.context.event.annotation.BeforeTestClass;

public class BaseTest {
    String basePath = "https://reqres.in/api";

    @BeforeTestClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType(ContentType.JSON).build();
    }
}
