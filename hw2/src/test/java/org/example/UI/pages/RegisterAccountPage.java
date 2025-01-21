package org.example.UIpages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.UI.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));

    private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));

    private SelenideElement stateInput= element(Selectors.byId("customer.address.state"));

    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));

    private SelenideElement SSNInput = element(Selectors.byId("customer.ssn"));

    private SelenideElement usernameInput = element(Selectors.byId("customer.username"));

    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));

    private SelenideElement repeatedPasswordInput = element(Selectors.byId("repeatedPassword"));

    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    private SelenideElement mainWindow = element(Selectors.byId("rightPanel"));




    //поля ошибок

    private SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));

    private SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));

    private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    private SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));

    private SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));

    private SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));

    private SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));

    private SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));

    private SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));

    private SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));

    //поля успешной регистрации
    private SelenideElement afterRegistryWindow = element(Selectors.byId("rightPanel"));

    public void open(){
        Selenide.open("/parabank/register.htm");
    }


    public void registerWithNames (BankAccount bankAccount){
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        registerButton.click();
    }

   public void registerWithAddress (BankAccount bankAccount){
        addressInput.sendKeys(bankAccount.getAddress());
        registerButton.click();
    }

    public void registerWithCity (BankAccount bankAccount){
        cityInput.sendKeys(bankAccount.getCity());
        registerButton.click();
    }

    public void registerWithState (BankAccount bankAccount){
        stateInput.sendKeys(bankAccount.getState());
        registerButton.click();
    }

    public void registerWithZipCode (BankAccount bankAccount){
        zipCodeInput.sendKeys(bankAccount.getZipCode());
        registerButton.click();
    }

    public void registerWithSSN (BankAccount bankAccount){
        SSNInput.sendKeys(bankAccount.getSSN());
        registerButton.click();
    }

    public void registerWithUserName (BankAccount bankAccount){
        usernameInput.sendKeys(bankAccount.getUserName());
        registerButton.click();
    }

    public void registerOnlyWithPassword (BankAccount bankAccount){
        passwordInput.sendKeys(bankAccount.getPassword());
        registerButton.click();
    }

    public void registerOnlyWithRepeatedPassword (BankAccount bankAccount){
        repeatedPasswordInput.sendKeys(bankAccount.getRepeatPassword());
        registerButton.click();
    }

    public void registerOnlyWithRequiredFields (BankAccount bankAccount){
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        addressInput.sendKeys(bankAccount.getAddress());
        cityInput.sendKeys(bankAccount.getCity());
        stateInput.sendKeys(bankAccount.getState());
        zipCodeInput.sendKeys(bankAccount.getZipCode());
        SSNInput.sendKeys(bankAccount.getSSN());
        usernameInput.sendKeys(bankAccount.getUserName());
        passwordInput.sendKeys(bankAccount.getPassword());
        repeatedPasswordInput.sendKeys(bankAccount.getRepeatPassword());
        registerButton.click();
    }







}

