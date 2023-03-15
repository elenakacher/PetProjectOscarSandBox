package com.telran.oscarLatestVersion.tests.basket;

import com.telran.oscar.data.AddressData;
import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.BasePage;
import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.Basket.OrderConfirmationPage;
import com.telran.oscar.pages.Basket.OrderPreviewPage;
import com.telran.oscar.pages.Basket.ShippingAddressPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.product.BookPage;
import com.telran.oscar.pages.user.AddressBookPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasketForLoggedUserTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new AllProductsPage(wd).addToBasket(2);
        new BasePage(wd).pause(2000);
        new HomePage(wd).clickOnViewBasketButton();
    }

    @Test
    public void totalAmountTest() {
        double priceForOne = new BasketPage(wd).getPriceForOne();
        new BasePage(wd).pause(2000);
        new BasketPage(wd).changeQuantity("3");
        new BasePage(wd).pause(2000);
        double totalAmountForMany = new BasketPage(wd).getTotalAmountForMany();
        double totalAmountForBasket = new BasketPage(wd).getBasketTotal();
        System.out.println(" " + priceForOne + totalAmountForMany + totalAmountForBasket);
        Assert.assertEquals(totalAmountForMany, priceForOne*3);
        Assert.assertEquals(totalAmountForMany, totalAmountForBasket);
    }

    @Test
    public void bookLinkRedirectsToBookPageTest() {
        new BasketPage(wd).clickOnBookTitel();
        Assert.assertTrue(new BookPage(wd).getBookTitel().contains("Hacking Exposed Wireless"));
    }

    @Test
    public void browseStoreDropdownMenuTest() {
        new BasketPage(wd).ClickOnBrowseStoreDropdownMenu();
        Assert.assertTrue(new BasketPage(wd).isBrowseStoreDropdownMenuPresent());
    }

    @Test
    public void saveBasketAfterLogoutAndLoginAgainTest() {
        new HomePage(wd).clickOnLogoutBtn().clickOnLoginButton().login(
                LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1).clickOnViewBasketButton();
        Assert.assertTrue(new BasketPage(wd).getBookTitel().contains("Hacking Exposed Wireless"));
    }

    @Test
    public void removeButtonTest(){
        new BasketPage(wd).clickOnRemoveBtn();
        new BasePage(wd).pause(2000);
        Assert.assertTrue(new BasketPage(wd).getBasketIsEmptyMsg().contains("Your basket is empty."));
    }

    @Test
    public void incDecQuantityTest(){
        new BasketPage(wd).incQuantity().incQuantity();
        new BasePage(wd).pause(2000);
        new BasketPage(wd).decQuantity();
        new BasePage(wd).pause(2000);
        Assert.assertTrue(new BasketPage(wd).getQuantity().contains("1"));
    }

    @Test
    public void saveForLaterBtnTest() {
        SoftAssert softAssert = new SoftAssert();
        new BasketPage(wd).clicksaveForLaterBtn();
        new BasePage(wd).pause(3000);
        Assert.assertTrue(new BasketPage(wd).isItemsToBuyLaterAppered());
    }

    @Test
    public void moveToBasketAfterSaveForLaterBtnTest() {
        new BasketPage(wd).clicksaveForLaterBtn();
        new BasePage(wd).pause(3000);
        new BasketPage(wd).clickOnMoveToBasketBtn();
        Assert.assertTrue(new BasketPage(wd).getBookTitel().contains(""));
        new BasePage(wd).pause(3000);
    }

    @Test
    public void proceedToCheckoutBtnTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Shipping address"));
    }

    @Test
    public void purshaseTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnPlaceOrderButton();
        Assert.assertTrue(new OrderConfirmationPage(wd).getPageTitel().contains("confirmation"));

    }

    @Test
    public void isBasketEmptyAfterPurshaseTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                        AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton()
                .clickOnPlaceOrderButton().clickOnOscarLink().clickOnViewBasketButton();
        Assert.assertTrue(new BasketPage(wd).getBasketIsEmptyMsg().contains("basket is empty"));
    }

    @Test
    public void comparisionOrderNumberInConfirmationPageAndInHistoryPageTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                        AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnPlaceOrderButton();
        int orderNumber1 = new OrderConfirmationPage(wd).getPageTitelNumber();
        new HomePage(wd).clickOnOscarLink().clickOnAccountButton().clickOnOrderHistoryBtn();
        int orderNumber2 = new ProfilePage(wd).getOrderNumber();
        System.out.println(" " + orderNumber1 + orderNumber2);
        Assert.assertEquals(orderNumber1, orderNumber2);
    }

    @Test (enabled = false)
    public void isDateOfOrderInHistoryPageActualTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                        AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnPlaceOrderButton();
        new HomePage(wd).clickOnOscarLink().clickOnAccountButton();
        new ProfilePage(wd).clickOnOrderHistoryBtn();
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        String date = dateFormat.format(currentDate);
        System.out.println(date);
        String strDate = date.replaceAll("[^A-Za-z0-9 ]", "");
        Assert.assertTrue(new ProfilePage(wd).getDate().contains(strDate));
    }

    @Test
    public void changeAddressTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                        AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnChangeAddressBtn();
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Shipping address"));
    }

    @Test
    public void changePaymentTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                        AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnChangePaymentBtn();
        Assert.assertTrue(new AddressBookPage(wd).getPageTitel().contains("Enter payment details"));
    }

    @Test
    public void editOrderTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                        AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnEditOrderButton();
        Assert.assertTrue(new BasketPage(wd).getPageTitel().contains("Basket"));
    }

    @Test(enabled = false)
    public void printOrderTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                        AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnPlaceOrderButton();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(wd);
        orderConfirmationPage.clickOnPrintBtn();
        orderConfirmationPage.closePrintPage();
    }

    @Test
    public void continueShoppingBtnTest() {
        new BasketPage(wd).clickOnProceedToCheckoutButton();
        new ShippingAddressPage(wd).fillNewAddressForm(AddressData.FIRST_NAME1, AddressData.LAST_NAME1,
                        AddressData.FIRST_LINE_OF_ADDRESS1, AddressData.CITY1, AddressData.POST_CODE1)
                .selectCountry("Germany").clickOnFirstContinueButton().clickOnSecondContinueButton();
        new OrderPreviewPage(wd).clickOnPlaceOrderButton();
        new BasketPage(wd).clickOnContinueShoppingButton();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitel().contains("All products"));
    }

    @AfterMethod(enabled = true)
    public void TierDown() {
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

}
