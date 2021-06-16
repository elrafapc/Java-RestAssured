package com.AssureRestTest.api.AssureRestTest.test;

import io.restassured.RestAssured;
import org.springframework.test.context.event.annotation.BeforeTestClass;

public class BaseTest {
    String basePath = "https://reqres.in/api";

    @BeforeTestClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
