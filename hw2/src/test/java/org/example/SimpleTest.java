package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.ResponseCache;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b";
    }

    @Test
    public void userShouldBeAbleCreateUnicorn() {
        // given -> when -> then

        //ШАГ 1 - Создание единорога
        String id = given()
                .body("{   \"name\": \"Западный Единорог\",\n" +
                        "    \"tail_color\": \"black\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .post("/unicorn")
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("$", hasKey("_id"))
        .extract()
                .path("_id");

        //ШАГ 2 - Удаление единорога после прогона теста
        given()
                .delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);


    }
    @Test
    public void userCanChangeNailColor() {
        //ШАГ 1 - Создание единорога
        String id = given()
                .body("{   \"name\": \"Западный Единорог\",\n" +
                        "    \"tail_color\": \"black\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
        .extract()
                .path("_id");

        //ШАГ 2 - Обновление цвета единорога
        given()
                .body("{\"tail_color\": \"green\"}")
                .contentType(ContentType.JSON)
        .when()
                .put("/unicorn/" + id)
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK);

        //ШАГ 3 - Получение единорога для проверки цвета в ответе
        given()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .body("tail_color", equalTo("green"));

        //ШАГ 4 - Удаление единорога после прогона теста
        given()
                .delete("/unicorn/" + id)
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void userCanDeleteUnicorn() {
        //ШАГ 1 - Создание единорога
        String id = given()
                .body("{   \"name\": \"Западный Единорог\",\n" +
                        "    \"tail_color\": \"black\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("$", hasKey("_id"))
                .extract()
                    .path("_id");

        //ШАГ 2 - Удаление единорога
        given()
                .delete("/unicorn/" + id)
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK);

        //ШАГ 3 - Проверка удаления единорога
        given()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
