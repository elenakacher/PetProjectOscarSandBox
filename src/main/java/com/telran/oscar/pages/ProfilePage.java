package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//*[.='Edit profile']")
    WebElement editProfileBtn;

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    @FindBy(id = "id_last_name")
    WebElement lastNameField;

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveBtn;

    public ProfilePage inputUserName(String firstName, String lastName) {
        click(editProfileBtn);
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        click(saveBtn);
        return this;
    }

    @FindBy(css = ".alertinner.wicon")
    WebElement confirmationMsg;

    public String getConfirmMessage() {
        return confirmationMsg.getText();
    }

    @FindBy(xpath = "//td[contains(text(), 'Tom Tailor')]")
    WebElement userName;

    public String getUserName() {
        return userName.getText();
    }
}
