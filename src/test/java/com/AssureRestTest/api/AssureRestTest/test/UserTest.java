package com.AssureRestTest.api.AssureRestTest.test;

import com.AssureRestTest.api.AssureRestTest.dom.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class UserTest extends BaseTest {

    private static final String USER_ENDPOINT = "/users";
    private static final String SHOW_USER_ENDPOINT = "/users/{userId}";

    @Test
    public void     testGetListDataUser() {
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
    public void testPostAddUser(){
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
        int page = 2;
        int expectedPerPage = getExpectedPerPage(page);

        given().
            params("page",page).
        when().
            get(basePath + USER_ENDPOINT).
        then().
            statusCode(200).
            body(
            "page", is(page),
        "data.size()", is(expectedPerPage),
                "data.findAll{ it.avatar.startsWith('https://reqres.in')}.size()", is(expectedPerPage)
            );
    }

    @Test
    public void testShowASpecificUser(){

        User user = given().
            pathParam("userId", 2).
        when().
            get(basePath + SHOW_USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
        extract().
            body().jsonPath().getObject("data",User.class);

        assertThat(user.getEmail(),containsString("@reqres.in"));
        assertThat(user.getName(),is("Janet"));
        assertThat(user.getLastName(),is("Weaver"));
    }



    private int getExpectedPerPage(int page) {
        int expectedPerPage = given().
                param("page",page).
            when().
                get(basePath + USER_ENDPOINT).
            then().
                statusCode(HttpStatus.SC_OK).
            extract().
                path("per_page");
        return expectedPerPage;
    }
}
