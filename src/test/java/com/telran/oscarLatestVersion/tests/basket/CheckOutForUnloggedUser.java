package com.telran.oscarLatestVersion.tests.basket;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutForUnloggedUser extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new AllProductsPage(wd).addToBasket();
        new HomePage(wd).clickOnViewBasketButton();
    }

    @Test
    public void UITest() {

    }

}
