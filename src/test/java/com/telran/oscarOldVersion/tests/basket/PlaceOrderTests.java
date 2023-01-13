package com.telran.oscarOldVersion.tests.basket;

import com.telran.oscar.data.AddressData;
import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.*;
import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.Basket.OrderConfirmationPage;
import com.telran.oscar.pages.Basket.OrderPreviewPage;
import com.telran.oscar.pages.Basket.ShippingAddressPage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarOldVersion.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaceOrderTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void placeOrderTest() {
        new HomePage(wd).clickOnAllProductsButton();
        new AllProductsPage(wd).addToBasketOldVersion();
        new HomePage(wd).clickOnViewBasketButton();
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1);
        new ShippingAddressPage(wd).selectCountry("Germany").clickOnFirstContinueButton()
                .clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnPlaceOrderButton();
        Assert.assertTrue(new OrderConfirmationPage(wd).getBookTitel().contains("The shellcoder's handbook"));
    }

    @AfterMethod
    public void tierDown(){
        new HomePage(wd).clickOnOscarLink().deleteUserOldVersion(LoginPasswordData.USER_PASSWORD1);
    }

}
