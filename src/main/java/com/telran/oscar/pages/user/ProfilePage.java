package com.telran.oscar.pages.user;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
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

    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    @FindBy(id = "id_password")
    WebElement pwdField;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteBtn;

    public ProfilePage deleteUser(String pwd) {
        click(deleteProfileBtn);
        type(pwdField, pwd);
        click(deleteBtn);
        return this;
    }
}
