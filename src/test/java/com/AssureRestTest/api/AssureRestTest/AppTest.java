package com.AssureRestTest.api.AssureRestTest;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppTest {

    @Test
    public void listDataUser() {
        when().
            get("https://reqres.in/api/users?page=2").
        then().
            statusCode(200).
            body("page", is(2));
    }

}
