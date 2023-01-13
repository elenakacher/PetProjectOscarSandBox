package com.telran.oscarLatestVersion.tests.product;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.Basket.ShippingAddressPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.product.BookPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProductsPageTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void addToBasketTest() {
        new AllProductsPage(wd).addToBasket(2);
        new HomePage(wd).clickOnViewBasketButton();
        Assert.assertTrue(new BasketPage(wd).getBookTitel().contains("Hacking Exposed Wireless"));
    }

    @Test
    public void addToBasketPricesCompareTest() {
        new AllProductsPage(wd).addToBasket(2);
        double priceOnHeader = new AllProductsPage(wd).getBasketTotalOnHeader();
        double bookPrice = new AllProductsPage(wd).getBookPrice();
        double priceOnPage = new AllProductsPage(wd).getpriceOnPage();
        new HomePage(wd).clickOnViewBasketButton();
        double priceInBasket = new BasketPage(wd).getPriceForOne();
        Assert.assertEquals(bookPrice, priceOnHeader);
        Assert.assertEquals(priceOnHeader, priceOnPage);
        Assert.assertEquals(priceOnPage, priceInBasket);
    }

    @Test
    public void addToBasketConfirmMessageTest() {
        new AllProductsPage(wd).addToBasket(2);
        Assert.assertTrue(new AllProductsPage(wd).getConfirmMessage().contains("has been added to your basket"));
    }

    @Test
    public void nextPageTest() {
        new AllProductsPage(wd).clickOnNextButton();
        Assert.assertFalse(new AllProductsPage(wd).getLastBookTitel().contains("The Cathedral"));
    }

    @Test
    public void previousPageTest() {
        new AllProductsPage(wd).clickOnNextButton().clickOnPreviousButton();
        Assert.assertTrue(new AllProductsPage(wd).getFirstBookTitel().contains("The shellcoder's handbook"));
    }

    @Test
    public void bookTitleLinkRedirectToBookPageTest() {
        new AllProductsPage(wd).clickOnFirstBookTitle();
        Assert.assertTrue(new BookPage(wd).getBookTitel().contains("The shellcoder's handbook"));
        new BookPage(wd).clickOnHomeLink();
        new AllProductsPage(wd).clickOnLastBookTitle();
        Assert.assertTrue(new BookPage(wd).getBookTitel().contains("The Cathedral"));
    }

    @Test
    public void breadCrumbsTest() {
        new AllProductsPage(wd).clickOnComputersInLiteratureLink();
        Assert.assertTrue(new AllProductsPage(wd).getbreadCrumbsText().contains("Home\n" + "Books\n" +
                "Fiction\n" + "Computers in Literature"));
        Assert.assertTrue(new AllProductsPage(wd).getPageTitel().equals("Computers in Literature"));
        new AllProductsPage(wd).clickOnFictionLinkOnBreadcrumbs();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitel().equals("Fiction"));

        new AllProductsPage(wd).clickOnEssentialProgrammingLink();
        Assert.assertTrue(new AllProductsPage(wd).getbreadCrumbsText().contains("Home\n" +
                "Books\n" + "Non-Fiction\n" + "Essential programming"));
        Assert.assertTrue(new AllProductsPage(wd).getPageTitel().equals("Essential programming"));

        new AllProductsPage(wd).clickOnHackingLink();
        Assert.assertTrue(new AllProductsPage(wd).getbreadCrumbsText().contains("Home\n" +
                "Books\n" + "Non-Fiction\n" + "Hacking"));
        Assert.assertTrue(new AllProductsPage(wd).getPageTitel().equals("Hacking"));

        new AllProductsPage(wd).clickOnNonFictionLinkOnBreadcrumbs();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitel().equals("Non-Fiction"));

        new AllProductsPage(wd).clickOnBooksLinkOnBreadcrumbs();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitel().equals("Books"));

        new AllProductsPage(wd).clickOnHomeLinkOnBreadcrumbs();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitel().equals("All products"));

    }

    @AfterMethod(enabled = true)
    public void TierDown() {
        new HomePage(wd).clickOnOscarLink().clickOnAccountButton().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

}
