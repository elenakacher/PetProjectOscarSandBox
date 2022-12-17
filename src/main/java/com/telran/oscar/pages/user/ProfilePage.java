package com.telran.oscar.pages.user;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//a[@class = 'btn btn-primary'][2]")
    WebElement editProfileBtn;

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    @FindBy(id = "id_last_name")
    WebElement lastNameField;

    @FindBy (css = ".btn.btn-lg.btn-primary")
    WebElement saveBtn;

    public ProfilePage inputUserName(String firstName, String lastName) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        return this;
    }

    @FindBy(css = ".alertinner.wicon")
    WebElement confirmationMsg;

    public String getConfirmMessage() {
        return confirmationMsg.getText();
    }

    @FindBy(xpath = "//table[@class = 'table table-striped table-bordered']//tr[1]/td")
    WebElement userName;

    public String getUserName() {
        return userName.getText();
    }

    public ProfilePage clickOnEditProfileBtn() {
        click(editProfileBtn);
        return this;
    }

    @FindBy(id = "id_email")
    WebElement emailField;

    public ProfilePage editEmail(String email) {
        emailField.clear();
        type(emailField, email);
        return this;
    }

    public boolean isSaveBtnPresent() {
        return saveBtn.isDisplayed();
    }

    @FindBy (css = ".alert.alert-danger")
    WebElement errorMsg;

    public boolean isErrorMsgPresent() {
        return errorMsg.isDisplayed();
    }

    @FindBy(xpath = "//a[@class = 'btn btn-primary'][1]")
    WebElement changePasswordBtn;

    @FindBy(id = "id_old_password")
    WebElement oldPasswordField;

    @FindBy(id = "id_new_password1")
    WebElement newPasswordField;

    @FindBy(id = "id_new_password2")
    WebElement newPasswordConfirmationField;

    public ProfilePage changePassword(String oldPwd, String newPwd) {
        click(changePasswordBtn);
        type(oldPasswordField, oldPwd);
        type(newPasswordField, newPwd);
        type(newPasswordConfirmationField, newPwd);
        return this;
    }

    @FindBy (css = ".alertinner.wicon")
    WebElement confirmationMessage;

    public boolean isConfirmationMsgPresent() {
        try {
            return confirmationMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(xpath = "//a[contains(text(),'cancel')]")
    WebElement cancelBtn;

    public ProfilePage clickOnCancelBnt() {
        click(cancelBtn);
        return this;
    }

    public ProfilePage clickOnSaveBnt() {
        click(saveBtn);
        return this;
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    public ProfilePage clickOnDeleteProfileBtn() {
        click(deleteProfileBtn);
        return this;
    }

    @FindBy(id = "id_password")
    WebElement pwdField;

    public ProfilePage deleteProfile(String pwd) {
        type(pwdField, pwd);
        return this;
    }

    @FindBy(id = "logout_link")
    WebElement logoutLink;

    public boolean isLogoutLinkPresent() {
        return logoutLink.isDisplayed();
    }

    @FindBy(xpath = "//li[@class = 'nav-item'][3]")
    WebElement addressBookLink;

    public AddressBookPage clickOnAddressBookLink() {
        click(addressBookLink);
        return new AddressBookPage(wd);
    }
}
