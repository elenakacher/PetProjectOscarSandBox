package com.telran.oscarLatestVersion.tests.basket;
import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.BasePage;
import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.Basket.whoAreYouPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;

import com.telran.oscar.pages.user.AddressBookPage;

import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BasketForUnloggedUserTests extends TestBaseLatestVersion {

    @Test
    public void proceedToCheckoutBtnTest() {
        new AllProductsPage(wd).addToBasket(2);
        new HomePage(wd).clickOnViewBasketButton();
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Who are you?"));
    }

    @Test
    public void loginByPurshaseForExistingUserTest() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1).clickOnLogoutBtn();
        new BasePage(wd).pause(2000);
        new AllProductsPage(wd).addToBasket(2);
        new HomePage(wd).clickOnViewBasketButton();
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new whoAreYouPage(wd).login(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Shipping address"));
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void loginByPurshaseForNewUserWithRegistrationTest() {
        new AllProductsPage(wd).addToBasket(2);
        new HomePage(wd).clickOnViewBasketButton();
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new whoAreYouPage(wd).registration(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Shipping address"));
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void loginByPurshaseForNewUserAsGastTest() {
        new AllProductsPage(wd).addToBasket(2);
        new HomePage(wd).clickOnViewBasketButton();
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new whoAreYouPage(wd).purshaseAsGast(LoginPasswordData.USER_LOGIN1);
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Shipping address"));
    }

}

