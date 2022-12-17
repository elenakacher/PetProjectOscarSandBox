package com.telran.oscar.pages;

import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.pages.user.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

    public LoginAndRegistrationPage clickOnLoginButton() {
        click(loginLink);
        return new LoginAndRegistrationPage(wd);
    }

    @FindBy(css = ".far.fa-user.mr-2")
    WebElement accountLink;

    public boolean isAccountCreated() {
        return accountLink.isDisplayed();
    }

    @FindBy(id = "logout_link")
    WebElement logOutLink;

    public HomePage clickOnLogoutBtn() {
        click(logOutLink);
        return this;
    }

    public ProfilePage clickOnAccountButton() {
        click(accountLink);
        return new ProfilePage(wd);
    }

    @FindBy(xpath = "//*[.='All products']")
    WebElement allProductsLink;

    public AllProductsPage clickOnAllProductsButton() {
        click(allProductsLink);
        return new AllProductsPage(wd);
    }

    @FindBy(xpath = "//div[@class = 'row']/div[2]//span/a")
    WebElement viewBasket;

    public BasketPage clickOnViewBasketButton() {
        click(viewBasket);
        return new BasketPage(wd);
    }

}
