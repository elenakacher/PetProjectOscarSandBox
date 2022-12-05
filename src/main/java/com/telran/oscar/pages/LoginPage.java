package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver wd) {
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

}
