package org.example.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.example.api.models.Unicorn;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {


    //Создание единорога
    public static Unicorn createUnicorn(Unicorn unicorn) {

        String unicornJson = "";
        try {
            unicornJson = new ObjectMapper().writeValueAsString(unicorn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return given()
                     .body(unicornJson)
                     .contentType(ContentType.JSON)
                     .post("/unicorn")
                .then()
                    .assertThat()
                         .statusCode(HttpStatus.SC_CREATED)
                         .body("$", hasKey("_id"))
                .extract().as(Unicorn.class, ObjectMapperType.GSON);
    }


    public static void updateTailColorUnicorn(Unicorn unicorn, String tailColor) {

        unicorn.setTailColor(tailColor);

        String unicornJson;
        try {
            unicornJson = new ObjectMapper().writeValueAsString(unicorn);
            System.out.println("Сгенерированный JSON: " + unicornJson); // Логирование JSON
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        given()
                .body(unicornJson)
                .contentType(ContentType.JSON)
                .when()
                .put("/unicorn/" + unicorn.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }







    //Удаление единорога
    public static void deleteUnicorn(String id) {
        given().delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }



}
