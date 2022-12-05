package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//*[@name = 'language']")
    WebElement language;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement goBtn;

    public HomePage selectLanguage(String text) {
        click(language);
        Select select = new Select(language);
        select.selectByVisibleText(text);
        click(goBtn);
        return this;
    }

    @FindBy(id = "login_link")
    WebElement loginLink;

    public LoginPage clickOnLoginButton() {
        click(loginLink);
        return new LoginPage(wd);
    }

    @FindBy(id = "logout_link")
    WebElement logOutLink;

    @FindBy(xpath = "//*[.=' Account']")
    WebElement accountLink;

    public HomePage verifyUserName() {
        Assert.assertTrue(accountLink.isDisplayed());
        Assert.assertTrue(logOutLink.isDisplayed());
        return this;
    }

    public HomePage logOut() {
        click(logOutLink);
        return this;
    }


    public ProfilePage clickOnAccountButton() {
        click(accountLink);
        return new ProfilePage(wd);
    }
}
