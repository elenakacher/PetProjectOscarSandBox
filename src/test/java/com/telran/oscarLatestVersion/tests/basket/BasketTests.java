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

public class BasketTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new AllProductsPage(wd).addToBasket();
        new HomePage(wd).clickOnViewBasketButton();
    }

    @Test
    public void totalAmountTest() {
        Assert.assertTrue(new BasketPage(wd).getTotalAmountNumber().contains("20.98"));
    }

    @Test
    public void bookLinkRedirectsToBookPageTest() {
        new BasketPage(wd).clickOnBookTitel();
        Assert.assertTrue(new BookPage(wd).getBookTitel().contains("The shellcoder's handbook"));
    }

    @Test
    public void browseStoreDropdownMenuTest() {
        new BasketPage(wd).ClickOnBrowseStoreDropdownMenu();
        Assert.assertTrue(new BasketPage(wd).isBrowseStoreDropdownMenuPresent());
    }

    @Test
    public void basketIsEmptyMsgTest() {
        new BasketPage(wd).deleteBooks();
        new BasePage(wd).pause(2000);
        Assert.assertTrue(new BasketPage(wd).getBasketIsEmptyMsg().contains("Your basket is empty."));
    }

    @Test
    public void saveBasketAfterLogoutAndLoginAgainTest() {
        new HomePage(wd).clickOnLogoutBtn().clickOnLoginButton().login(
                LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1).clickOnViewBasketButton();
        Assert.assertTrue(new BasketPage(wd).getBookFirstTitel().contains("The shellcoder's handbook"));
        Assert.assertTrue(new BasketPage(wd).getBookLastTitel().contains("The Cathedral & the Bazaar"));
    }

    @Test
    public void proceedToCheckoutBtnTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Shipping address"));
    }

    @Test
    public void removeButtonTest(){
        new BasketPage(wd).clickOnRemoveBtn();
        new BasePage(wd).pause(2000);
        Assert.assertFalse(new BasketPage(wd).getBookFirstTitel().contains("The shellcoder's handbook"));
    }

    @Test
    public void totalAmountByBookRemovingTest(){
        new BasketPage(wd).clickOnRemoveBtn();
        new BasePage(wd).pause(2000);
        Assert.assertTrue(new BasketPage(wd).getTotalAmountNumber().contains("10.99"));
    }

    @Test
    public void changeQuantityTest(){
        new BasketPage(wd).changeQuantity("5");
        new BasePage(wd).pause(2000);
        Assert.assertTrue(new BasketPage(wd).getQuantity().contains("5"));
        //Assert.assertTrue(new BasketPage(wd).getTotalAmountNumberWithDiscount().contains(5*));
    }

    @Test
    public void incDecQuantityTest(){
        new BasketPage(wd).incQuantity().incQuantity();
        new BasePage(wd).pause(2000);
        new BasketPage(wd).decQuantity();
        new BasePage(wd).pause(2000);
        //Assert.assertTrue(new BasketPage(wd).getQuantity().contains("1"));
        // Assert.assertTrue(new BasketPage(wd).getTotalAmountNumberWithDiscount().contains("60.94"));
    }

    @Test
    public void saveForLaterBtnTest() {
        SoftAssert softAssert = new SoftAssert();
        new BasketPage(wd).clicksaveForLaterBtn();
        new BasePage(wd).pause(3000);
        softAssert.assertFalse(new BasketPage(wd).getBookFirstTitel().contains("The shellcoder's handbook"));
        new BasePage(wd).pause(3000);
        softAssert.assertTrue(new BasketPage(wd).isItemsToBuyLaterAppered());
        softAssert.assertTrue(new BasketPage(wd).getTotalAmountNumber().contains("10.99"));
        softAssert.assertAll();
    }

    @Test
    public void moveToBasketAfterSaveFoeLaterBtnTest() {
        new BasketPage(wd).clicksaveForLaterBtn();
        new BasePage(wd).pause(3000);
        new BasketPage(wd).clickOnMoveToBasketBtn();
        Assert.assertTrue(new BasketPage(wd).getBookFirstTitel().contains("The shellcoder's handbook"));
        new BasePage(wd).pause(3000);
    }

    @AfterMethod(enabled = true)
    public void TierDown() {
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

}
