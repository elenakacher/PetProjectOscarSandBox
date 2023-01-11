package com.telran.oscarLatestVersion.tests.basket;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutForLoggedUser extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new AllProductsPage(wd).addToBasket();
        new HomePage(wd).clickOnViewBasketButton();
    }

    @Test
    public void UITest() {

    }
}
