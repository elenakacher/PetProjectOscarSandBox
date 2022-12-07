package com.telran.oscar.tests.products;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.*;
import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProductsTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).login(LoginPasswordData.USER_LOGIN, LoginPasswordData.USER_PASSWORD);
        new HomePage(wd).clickOnAllProductsButton();
    }

    @Test
    public void addToBasketTest() {
        new AllProductsPage(wd).addToBasket();
        new HomePage(wd).clickOnViewBasketButton();
        Assert.assertTrue(new BasketPage(wd).getBookFirstTitel().contains("The shellcoder's handbook"));
        Assert.assertTrue(new BasketPage(wd).getBookLastTitel().contains("Social Engineering"));
    }

    @AfterMethod
    public void tierDown(){
        new BasketPage(wd).removeBook();
        new BasketPage(wd).removeBook();
    }
}
