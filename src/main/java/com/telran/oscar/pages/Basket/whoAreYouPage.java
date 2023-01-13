package com.telran.oscar.pages.Basket;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class whoAreYouPage extends BasePage {
    public whoAreYouPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "id_username")
    WebElement loginField;

    @FindBy(id = "id_options_2")
    WebElement registriertUserRadioBtn;

    @FindBy(id = "id_options_1")
    WebElement newUserWithRegistrationRadioBtn;

    @FindBy(id = "id_options_0")
    WebElement newUserAsGastRadioBtn;

    @FindBy(id = "id_password")
    WebElement passwordField;

    @FindBy(id = "id_password1")
    WebElement password1Field;

    @FindBy(id = "id_password2")
    WebElement password2Field;

    @FindBy(css = ".col-sm-3")
    WebElement continueBtn;

    @FindBy(css = ".btn.btn-primary.btn-lg")
    WebElement registerBtn;

    public ShippingAddressPage login(String userLogin, String userPassword) {
        type(loginField, userLogin);
        registriertUserRadioBtn.click();
        type(passwordField, userPassword);
        click(continueBtn);
        return new ShippingAddressPage(wd);
    }

    public ShippingAddressPage registration(String userLogin1, String userPassword1) {
        type(loginField, userLogin1);
        click(newUserWithRegistrationRadioBtn);
        click(continueBtn);
        type(password1Field, userPassword1);
        type(password2Field, userPassword1);
        click(registerBtn);
        return new ShippingAddressPage(wd);
    }

    public ShippingAddressPage purshaseAsGast(String userLogin2) {
        type(loginField, userLogin2);
        click(newUserAsGastRadioBtn);
        click(continueBtn);
        return new ShippingAddressPage(wd);
    }
}
