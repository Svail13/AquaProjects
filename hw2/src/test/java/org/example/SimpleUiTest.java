package org.example;

import com.codeborne.selenide.*;
import org.example.UI.datas.BankAccount;
import org.example.UIpages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {
    @BeforeAll
    public static void setupUiTests(){
        Configuration.baseUrl = "https://parabank.parasoft.com";
    }

    @Test
    public void userCanNotCreateAccountOnlyWithNameAndSurname (){
        //Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        //Шаги теста
        registerAccountPage.registerWithNames(bankAccount);

        //Проверка ожидаемого результата
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountOnlyWithAdress (){
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .address(RandomData.randomString())
                .build();

        //Steps
        registerAccountPage.registerWithAddress(bankAccount);

        //Expected result
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldNot(Condition.exist);
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithCity (){
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .city(RandomData.randomString())
                .build();

        //Steps
        registerAccountPage.registerWithCity(bankAccount);


        //Expected result
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldNot(Condition.exist);
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithState () {
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .state(RandomData.randomString())
                .build();

        //Steps
        registerAccountPage.registerWithState(bankAccount);


        //Expected result
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldNotBe(Condition.exist);
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));

    }
    @Test
    public void userCanNotCreateAccountOnlyWithZipCode () {
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .zipCode(RandomData.randomString())
                .build();

        //Steps
        registerAccountPage.registerWithZipCode(bankAccount);

        //Expected result
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldNot(Condition.exist);
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithSSN () {
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .SSN(RandomData.randomNumber())
                .build();

        //Steps
        registerAccountPage.registerWithSSN(bankAccount);

        //Expected result
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldNot(Condition.exist);
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithUsername () {
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .userName(RandomData.randomString())
                .build();

        //Steps
        registerAccountPage.registerWithUserName(bankAccount);


        //Expected result
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldNot(Condition.exist);
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithPassword () {
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .password(RandomData.randomString())
                .build();

        //Steps
        registerAccountPage.registerOnlyWithPassword(bankAccount);

        //Expected result
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldNot(Condition.exist);
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanNotCreateAccountOnlyWithRepeatedPassword () {
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .repeatPassword(RandomData.randomString())
                .build();
        //Steps
        registerAccountPage.registerOnlyWithRepeatedPassword(bankAccount);


        //Expected result
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldNot(Condition.exist);

    }

    @Test
    public void userCanCreateAccountOnlyWithRequiredFields () {
        //Precondition
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomString())
                .SSN(RandomData.randomNumber())
                .userName(RandomData.randomString())
                .password("Test123456789")
                .repeatPassword("Test123456789")
                .build();

        //Steps
        registerAccountPage.registerOnlyWithRequiredFields(bankAccount);

        //Expected result
        registerAccountPage.getAfterRegistryWindow().shouldHave(Condition.partialText("Welcome"));
        registerAccountPage.getAfterRegistryWindow().shouldHave(Condition.partialText("was created successfully. You are now logged in."));


    }

}
