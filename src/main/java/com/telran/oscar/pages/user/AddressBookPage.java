package com.telran.oscar.pages.user;

import com.telran.oscar.pages.BasePage;
import com.telran.oscar.pages.Basket.ShippingAddressPage;
import com.telran.oscar.pages.HomePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;

public class AddressBookPage extends BasePage {
    public AddressBookPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(css = ".btn.btn-primary")
    WebElement addNewAddressBtn;

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    @FindBy(id = "id_last_name")
    WebElement lastNameField;

    @FindBy(id = "id_line1")
    WebElement addressField;

    @FindBy(id = "id_line4")
    WebElement cityField;

    @FindBy(id = "id_postcode")
    WebElement postCodeField;

    public AddressBookPage fillAddressFormWithValidData(String firstName, String lastName,
                                                  String address, String city, String postCode) {
        click(addNewAddressBtn);
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(addressField, address);
        type(cityField, city);
        type(postCodeField, postCode);
        return this;
    }

    @FindBy(id = "id_country")
    WebElement countryName;

    public AddressBookPage selectCountry(String text) {
        clickWithJSExecutor(countryName, 600, 0);
        Select select = new Select(countryName);
        select.selectByVisibleText(text);
        pause(1000);
        return this;
    }

    @FindBy(css = ".btn.btn-lg.btn-primary")
    WebElement saveBtn;

    public AddressBookPage clickOnSaveBtn() {
        click(saveBtn);
        return this;
    }
    @FindBy (css = ".alertinner.wicon")
    WebElement confirmationMessage;

    public boolean isConfirmMessagePresent() {
        try {
            return confirmationMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(xpath = "//a[contains(text(),'cancel')]")
    WebElement cancelBtn;

    public AddressBookPage clickOnCancelBtn() {
        pause(3000);
        clickWithJSExecutor(cancelBtn, 600, 0);
        pause(3000);
        return this;
    }

    @FindBy(css = ".btn-secondary.dropdown-toggle")
    WebElement editDropdownMenu;

    public AddressBookPage clickOnEditDropdownMenu() {
        click(editDropdownMenu);
        return this;
    }

    @FindBy (xpath = "//div[@class = 'dropdown-menu show']/a[1]")
    WebElement deleteLink;

    @FindBy (css = ".btn-danger.btn-lg")
    WebElement deleteBtn;

    public AddressBookPage deleteAddress() {
        click(deleteLink);
        click(deleteBtn);
        return this;
    }

    public AddressBookPage fillAddressFormWithInvalidDataWithDataProvider(String firstName, String lastName,
                                                                          String firstLineOfAddress, String city, String postCode) {
        click(addNewAddressBtn);
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(addressField, firstLineOfAddress);
        type(cityField, city);
        typeWithJSExecutor(postCodeField, postCode, 600, 0);
        return this;
    }

    @FindBy (xpath = "//div[@class = 'btn-group']/a")
    WebElement editBtn;

    public AddressBookPage clickOnEditBtn() {
        click(editBtn);
        return this;
    }

    public AddressBookPage editAllRequiredFields(String editFirstName, String editLastName,
                                      String editFirstLineOfAddress, String editCity,
                                      String editPostCode) {
        type(firstNameField, editFirstName);
        type(lastNameField, editLastName);
        type(addressField, editFirstLineOfAddress);
        type(cityField, editCity);
        typeWithJSExecutor(postCodeField, editPostCode, 600, 0);
        return this;
    }

    public String isConfirmMessageText() {
        return confirmationMessage.getText();
    }

    @FindBy (xpath = "//*[contains(text(),'Oops! We found some errors')]")
    WebElement errorMsg;

    public boolean isErrorMessagePresent() {
        return errorMsg.isDisplayed();
    }

    @FindBy (css = ".close")
    WebElement close;

    public AddressBookPage closeConfirmMsg() {
        click(close);
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement pageTitel;

    public String getPageTitel() {
        return pageTitel.getText();
    }
}
