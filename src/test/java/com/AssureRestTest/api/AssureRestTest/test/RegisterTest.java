package com.AssureRestTest.api.AssureRestTest.test;

import com.AssureRestTest.api.AssureRestTest.dom.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RegisterTest {
    String basePath = "https://reqres.in/api";

    @BeforeTestClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testNotRegisterWhenPasswordIsMissing(){
        User user = new User();
        user.setEmail("sydney@fife");

        given().
            contentType(ContentType.JSON).
            body(user).
        when().
            post(basePath + "/register").
        then().statusCode(HttpStatus.SC_BAD_REQUEST).body("error", is("Missing password"));

    }
}
