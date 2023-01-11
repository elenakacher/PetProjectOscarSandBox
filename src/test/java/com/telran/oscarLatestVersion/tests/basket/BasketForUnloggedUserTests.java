package com.telran.oscarLatestVersion.tests.basket;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.BasePage;
import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.product.BookPage;
import com.telran.oscar.pages.user.AddressBookPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BasketForUnloggedUserTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new AllProductsPage(wd).addToBasket();
        new HomePage(wd).clickOnViewBasketButton();
    }

    @Test
    public void proceedToCheckoutBtnTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Who are you?"));
    }

}

