package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimpleTest {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/7f29056062c044478ea80d73f8e323d7";
    }

    @Test
    public void userShouldBeAbleCreateUnicorn() {
        // given -> when -> then

        //ШАГ 1 - Создание единорога

        Unicorn unicorn = Unicorn.builder().name("Розовый единорог").tailColor("серый").build();

        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        //ШАГ 2 - Удаление единорога после прогона теста
        UnicornRequests.deleteUnicorn(createdUnicorn.getId());
    }

    @Test
    public void userCanChangeNailColor() {
        //ШАГ 1 - Создание единорога
        Unicorn unicorn = Unicorn.builder().name("Розовый единорог").tailColor("серый").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        //ШАГ 2 - Обновление цвета хвоста единорога
        given()
                .body("{\"tail_color\": \"green\"}")
                .contentType(ContentType.JSON)
                .when()
                .put("/unicorn/" + createdUnicorn.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);


        //ШАГ 3 - Получение единорога для проверки цвета в ответе
        given()
                .get("/unicorn/" + createdUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("tail_color", equalTo("green"));

        //ШАГ 4 - Удаление единорога после прогона теста
        UnicornRequests.deleteUnicorn(createdUnicorn.getId());
    }

    @Test
    public void userCanDeleteUnicorn() {
        //ШАГ 1 - Создание единорога
        Unicorn unicorn = Unicorn.builder().name("Розовый единорог").tailColor("серый").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);
        //ШАГ 2 - Удаление единорога
        UnicornRequests.deleteUnicorn(createdUnicorn.getId());

        //ШАГ 3 - Проверка удаления единорога
        given()
                .get("/unicorn/" + createdUnicorn.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
