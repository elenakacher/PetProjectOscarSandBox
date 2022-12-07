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
    WebElement regEmail;

    @FindBy(id = "id_registration-password1")
    WebElement regPwd1;

    @FindBy(id = "id_registration-password2")
    WebElement regPwd2;

    @FindBy(xpath = "//button[.='Register']")
    WebElement regBtn;


    public HomePage userRegistration(String name, String pwd) {
        int i = (int) (System.currentTimeMillis()) / 10000;
        type(regEmail, i + name);
        type(regPwd1, pwd);
        type(regPwd2, pwd);
        click(regBtn);
        return new HomePage(wd);
    }
}
