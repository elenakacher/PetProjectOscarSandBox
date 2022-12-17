package com.telran.oscar.pages.user;

import com.telran.oscar.pages.BasePage;
import com.telran.oscar.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAndRegistrationPage extends BasePage {

    public LoginAndRegistrationPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "id_login-username")
    WebElement loginUserName;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(xpath = "//button[.='Log In']")
    WebElement logInBtn;

    public HomePage login(String name, String pwd) {
        type(loginUserName, name);
        type(loginPassword, pwd);
        click(logInBtn);
        return new HomePage(wd);
    }

    @FindBy(id = "id_registration-email")
    WebElement emailField;

    @FindBy(id = "id_registration-password1")
    WebElement PwdField1;

    @FindBy(id = "id_registration-password2")
    WebElement PwdField2;

    @FindBy(xpath = "//button[.='Register']")
    WebElement regBtn;


    public HomePage userRegistration(String name, String pwd) {
        int i = (int) (System.currentTimeMillis()) / 10000;
        type(emailField, i + name);
        type(PwdField1, pwd);
        type(PwdField2, pwd);
        click(regBtn);
        return new HomePage(wd);
    }

    public HomePage userRegistrationWithDataProvider(String email, String password) {
        type(emailField, email);
        type(PwdField1, password);
        type(PwdField2, password);
        click(regBtn);
        return new HomePage(wd);
    }

    @FindBy(css = ".error-block")
    WebElement errorBlock;

    public boolean isErrorExists() {
        return errorBlock.isDisplayed();
    }

    public HomePage userRegistrationWithoutConcat(String name, String pwd) {
        type(emailField, name);
        type(PwdField1, pwd);
        type(PwdField2, pwd);
        click(regBtn);
        return new HomePage(wd);
    }

    public LoginAndRegistrationPage userRegistrationWithDifferentPasswords(String name, String pwd1, String pwd2) {
        type(emailField, name);
        type(PwdField1, pwd1);
        type(PwdField2, pwd2);
        click(regBtn);
        return this;
    }

    public LoginAndRegistrationPage loginWithDataProvider(String email, String pwd) {
        type(loginUserName, email);
        type(loginPassword, pwd);
        click(logInBtn);
        return this;
    }

    public boolean isLoginButtonPresent() {
        return logInBtn.isDisplayed();
    }
}
