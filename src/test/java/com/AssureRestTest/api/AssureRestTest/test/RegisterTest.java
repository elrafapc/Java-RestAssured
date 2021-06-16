package com.AssureRestTest.api.AssureRestTest.test;

import com.AssureRestTest.api.AssureRestTest.dom.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RegisterTest extends BaseTest {

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
