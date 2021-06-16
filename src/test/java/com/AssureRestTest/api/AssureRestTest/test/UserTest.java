package com.AssureRestTest.api.AssureRestTest.test;

import com.AssureRestTest.api.AssureRestTest.dom.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class UserTest extends BaseTest {

    private static final String USER_ENDPOINT = "/users";

    @Test
    public void GETListDataUser() {
        given().
            params("page","2").
        when().
            get(basePath + USER_ENDPOINT).
        then().
            statusCode(200).
            body("data", is(notNullValue())).
            body("data[0].email", is("michael.lawson@reqres.in")).
            body("data[0].first_name", is("Michael"));
    }

    @Test
    public void POSTAddUser(){
        User user = new User("Rafael","Eng Test","mail@mail.com");

        given().
            contentType(ContentType.JSON).
            body(user).
        when().
            post(basePath + USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_CREATED).
            body("name",is("Rafael"));
    }

    @Test
    public void testBodyItemsEqualsPerPage() {
        given().
            params("page","2").
        when().
            get(basePath + USER_ENDPOINT).
        then().
            statusCode(200).
            body(
            "page", is(2),
        "data.size()", is(6),
                "data.findAll{ it.avatar.startsWith('https://reqres.in')}.size()", is(6)
            );
    }
}
