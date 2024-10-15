package org.example.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {

    //Создание единорога
    public static String createUnicorn(String body) {
        return given()
                     .body(body)
                     .contentType(ContentType.JSON)
                     .post("/unicorn")
                .then()
                    .assertThat()
                         .statusCode(HttpStatus.SC_CREATED)
                         .body("$", hasKey("_id"))
                .extract()
                     .path("_id");
    }




    //Удаление единорога
    public static void deleteUnicorn(String id) {
        given().delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }



}
