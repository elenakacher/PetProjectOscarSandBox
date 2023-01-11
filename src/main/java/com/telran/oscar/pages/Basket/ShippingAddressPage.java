package com.telran.oscar.pages.Basket;

import com.telran.oscar.pages.BasePage;
import com.telran.oscar.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;

public class ShippingAddressPage extends BasePage {
    public ShippingAddressPage(WebDriver wd) {
        super(wd);
    }

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

    @FindBy(xpath = "//*[.='Continue']")
    WebElement continueBtn;

    public ShippingAddressPage fillNewAddressForm(String firstName, String lastName,
                                                  String address, String city, String postCode) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(addressField, address);
        type(cityField, city);
        type(postCodeField, postCode);
        clickWithJSExecutor(continueBtn, 600, 0);
        return this;
    }

    @FindBy(id = "id_country")
    WebElement countryName;

    public ShippingAddressPage selectCountry(String text) {
        clickWithJSExecutor(countryName, 600, 0);
        Select select = new Select(countryName);
        select.selectByVisibleText(text);
        pause(1000);
        return this;
    }

    @FindBy(xpath = "//*[.='Continue']")
    WebElement continBtn;

    public ShippingAddressPage clickOnFirstContinueButton() {
        pause(1000);
        clickWithJSExecutor(continBtn, 600, 0);
        return this;
    }

    public OrderPreviewPage clickOnSecondContinueButton() {
        pause(1000);
        click(continBtn);
        return new OrderPreviewPage(wd);
    }

    @FindBy(css = ".sub-header")
    WebElement pageTitel;

    public String getPageTitelText() {
        return pageTitel.getText();
    }

    @FindBy(css = ".col-sm-6.h1 a")
    WebElement homeLinkOnHeader;

    public HomePage HomePageLink() {
        click(homeLinkOnHeader);
        return new HomePage(wd);
    }
}
