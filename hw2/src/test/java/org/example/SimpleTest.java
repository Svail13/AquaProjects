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
        RestAssured.baseURI = "https://crudcrud.com/api/95d3504f1687487d817355610be90cbc";
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
    public void userCanChangeTailColor() {
        //ШАГ 1 - Создание единорога
        Unicorn unicorn = Unicorn.builder()
                .name("Розовый единорог")
                .tailColor("серый").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        //ШАГ 2 - Обновление цвета хвоста единорога
        UnicornRequests.updateTailColorUnicorn(createdUnicorn,"зеленый");

        //ШАГ 3 - Получение единорога для проверки цвета в ответе
        given()
                .get("/unicorn/" + createdUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("tailColor", equalTo("зеленый"));

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
