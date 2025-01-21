package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {
    @Test
    public void userCanNotCreateAccountWithNameAndSurname (){
        //Подготовка
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Шаги теста
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Вася");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Иванов");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Проверка ожидаемого результата
        SelenideElement adressError = element(Selectors.byId("customer.address.street.errors"));
        adressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));
        usernameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password confirmation is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }
}
