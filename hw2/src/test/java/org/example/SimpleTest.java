package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.net.ResponseCache;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @Test
    public void userShouldBeAbleCreateUnicorn(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        // given -> when -> then

        //ШАГ 1 - Создание единорога
        String id = given()
                .body("{   \"name\": \"Западный Единорог\",\n" +
                        "    \"tail_color\": \"black\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .post("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn")
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("$", hasKey("_id"))
        .extract()
                .path("_id");

        //ШАГ 2 - Удаление единорога после прогона теста
        given()
                .delete("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);


    }
    @Test
    public void userCanChangeNailColor(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //ШАГ 1 - Создание единорога
        String id = given()
                .body("{   \"name\": \"Западный Единорог\",\n" +
                        "    \"tail_color\": \"black\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn")
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
                .put("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn/" + id)
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK);

        //ШАГ 3 - Получение единорога для проверки цвета в ответе
        given()
                .get("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn/" + id)
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .body("tail_color", equalTo("green"));

        //ШАГ 4 - Удаление единорога после прогона теста
        given()
                .delete("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn/" + id)
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void userCanDeleteUnicorn() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //ШАГ 1 - Создание единорога
        String id = given()
                .body("{   \"name\": \"Западный Единорог\",\n" +
                        "    \"tail_color\": \"black\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn")
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("$", hasKey("_id"))
                .extract()
                    .path("_id");

        //ШАГ 2 - Удаление единорога
        given()
                .delete("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn/" + id)
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK);

        //ШАГ 3 - Проверка удаления единорога
        given()
                .get("https://crudcrud.com/api/77ac29231e134a1cbba000a0db30ad1b/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
