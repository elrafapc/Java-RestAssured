package com.AssureRestTest.api.AssureRestTest.test;

import com.AssureRestTest.api.AssureRestTest.dom.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserTest {

    String basePath = "https://reqres.in/api";

    @BeforeTestClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void GETListDataUser() {
        given().
            params("page","2").
        when().
            get(basePath+"/users").
        then().
            statusCode(200).
            body("data", is(notNullValue())).
            body("data[0].email", is("michael.lawson@reqres.in")).
            body("data[0].first_name", is("Michael"));
    }

    @Test
    public void POSTAddUser(){
        User user = new User("Rafael","Eng Test");

        given().
            contentType(ContentType.JSON).
            body(user).
        when().
            post(basePath+"/users").
        then().
            statusCode(HttpStatus.SC_CREATED).
            body("name",is("Rafael"));
    }

}
