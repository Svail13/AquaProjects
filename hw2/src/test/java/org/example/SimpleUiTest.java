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
    public void userCanNotCreateAccountOnlyWithNameAndSurname (){
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
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountOnlyWithAdress (){
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement adress = element(Selectors.byId("customer.address.street"));
        adress.sendKeys("улица Короля 1-20");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
        firstNameError.shouldHave(Condition.exactText("First name is required."));

        SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
        lastNameError.shouldHave(Condition.exactText("Last name is required."));

        SelenideElement adressError = element(Selectors.byId("customer.address.street.errors"));
        adressError.shouldNot(Condition.exist);

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithCity (){
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Minsk");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
        firstNameError.shouldHave(Condition.exactText("First name is required."));

        SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
        lastNameError.shouldHave(Condition.exactText("Last name is required."));

        SelenideElement adressError = element(Selectors.byId("customer.address.street.errors"));
        adressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldNotBe(Condition.exist);

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));


    }

    @Test
    public void userCanNotCreateAccountOnlyWithState () {
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Minsk state");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
        firstNameError.shouldHave(Condition.exactText("First name is required."));

        SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
        lastNameError.shouldHave(Condition.exactText("Last name is required."));

        SelenideElement adressError = element(Selectors.byId("customer.address.street.errors"));
        adressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldNotBe(Condition.exist);

        SelenideElement zipError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));

    }
    @Test
    public void userCanNotCreateAccountOnlyWithZipCode () {
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("220035");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
        firstNameError.shouldHave(Condition.exactText("First name is required."));

        SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
        lastNameError.shouldHave(Condition.exactText("Last name is required."));

        SelenideElement adressError = element(Selectors.byId("customer.address.street.errors"));
        adressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldNot(Condition.exist);

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithSSN () {
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement SSN = element(Selectors.byId("customer.ssn"));
        SSN.sendKeys("112233445566998877");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
        firstNameError.shouldHave(Condition.exactText("First name is required."));

        SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
        lastNameError.shouldHave(Condition.exactText("Last name is required."));

        SelenideElement adressError = element(Selectors.byId("customer.address.street.errors"));
        adressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldNot(Condition.exist);

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithUsername () {
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement username = element(Selectors.byId("customer.username"));
        username.sendKeys("username");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
        firstNameError.shouldHave(Condition.exactText("First name is required."));

        SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
        lastNameError.shouldHave(Condition.exactText("Last name is required."));

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

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldNot(Condition.exist);

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithPassword () {
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("Test1234567890");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
        firstNameError.shouldHave(Condition.exactText("First name is required."));

        SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
        lastNameError.shouldHave(Condition.exactText("Last name is required."));

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

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldNot(Condition.exist);

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithRepeatedPassword () {
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));
        repeatedPassword.sendKeys("Test1234567890");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
        firstNameError.shouldHave(Condition.exactText("First name is required."));

        SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
        lastNameError.shouldHave(Condition.exactText("Last name is required."));

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

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldNot(Condition.exist);

    }

    @Test
    public void userCanCreateAccountOnlyWithRequiredFields () {
        //Precondition
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Ivan");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Ivanov");

        SelenideElement adress = element(Selectors.byId("customer.address.street"));
        adress.sendKeys("street 20");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Minsk");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Minsk state");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("220035");

        SelenideElement SSN = element(Selectors.byId("customer.ssn"));
        SSN.sendKeys("123456");

        SelenideElement username = element(Selectors.byId("customer.username"));
        username.sendKeys("Qwerty12");

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("Test1234567890");

        SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));
        repeatedPassword.sendKeys("Test1234567890");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Expected result
        /*SelenideElement titleUserName = element(Selectors.byClassName("title"));
        titleUserName.shouldHave(Condition.exactText("Welcome Qwertyqqqq"));
*/
        SelenideElement mainWindow = element(Selectors.byId("rightPanel"));
        mainWindow.shouldHave(Condition.partialText("Welcome Qwerty12"));
        mainWindow.shouldHave(Condition.partialText("was created successfully. You are now logged in."));



    }

}
