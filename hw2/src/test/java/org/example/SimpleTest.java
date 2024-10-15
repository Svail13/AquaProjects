package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.net.ResponseCache;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @Test
    public void userShouldBeAbleCreateUnicorn(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        // given -> when -> then
        given()
                .body("{   \"name\": \"Западный Единорог\",\n" +
                        "    \"tail_color\": \"black\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .post("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"));


    }
}
