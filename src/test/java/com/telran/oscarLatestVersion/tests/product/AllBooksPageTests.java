package com.telran.oscarLatestVersion.tests.product;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.product.BookPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllBooksPageTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void addToBasketTest() {
        new AllProductsPage(wd).addToBasket();
        new HomePage(wd).clickOnViewBasketButton();
        Assert.assertTrue(new BasketPage(wd).getBookFirstTitel().contains("Hacking Exposed Wireless"));
        Assert.assertTrue(new BasketPage(wd).getBookLastTitel().contains("The Cathedral"));
    }

    @Test
    public void addToBasketConfirmMessageTest() {
        new AllProductsPage(wd).addToBasket();
        Assert.assertTrue(new AllProductsPage(wd).getConfirmMessage().contains("has been added to your basket"));
    }

    @Test
    public void addToBasketCheckoutButtonTest() {
        new AllProductsPage(wd).addToBasket();
        Assert.assertTrue(new AllProductsPage(wd).isCheckoutNowButtonExists());
    }

    @Test
    public void addToBasketViewBasketButtonTest() {
        new AllProductsPage(wd).addToBasket();
        Assert.assertTrue(new AllProductsPage(wd).isViewBasketButtonExists());
    }

    @Test
    public void nextPageTest() {
        new AllProductsPage(wd).clickOnNextButton();
        Assert.assertFalse(new AllProductsPage(wd).getLastBookTitel().contains("The Cathedral"));
    }

    @Test
    public void previousPageTest() {
        new AllProductsPage(wd).clickOnNextButton().clickOnPreviousButton();
        Assert.assertTrue(new AllProductsPage(wd).getFirstBookTitel().contains("Hacking Exposed Wireless"));
    }

    @Test
    public void bookTitleLinkRedirectToBookPageTest() {
        new AllProductsPage(wd).clickOnFirstBookTitle();
        Assert.assertTrue(new BookPage(wd).getBookTitel().contains("Hacking Exposed Wireless"));
        new BookPage(wd).clickOnHomeLink();
        new AllProductsPage(wd).clickOnLastBookTitle();
        Assert.assertTrue(new BookPage(wd).getBookTitel().contains("The Cathedral"));
    }

    @Test
    public void breadCrumbsTest() {
        new AllProductsPage(wd).clickOnComputersInLiteratureLink();
        Assert.assertTrue(new AllProductsPage(wd).getbreadCrumbsText().contains("Home\n" + "Books\n" +
                "Fiction\n" + "Computers in Literature"));
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().equals("Computers in Literature"));
        new AllProductsPage(wd).clickOnFictionLinkOnBreadcrumbs();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().equals("Fiction"));

        new AllProductsPage(wd).clickOnEssentialProgrammingLink();
        Assert.assertTrue(new AllProductsPage(wd).getbreadCrumbsText().contains("Home\n" +
                "Books\n" + "Non-Fiction\n" + "Essential programming"));
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().equals("Essential programming"));

        new AllProductsPage(wd).clickOnHackingLink();
        Assert.assertTrue(new AllProductsPage(wd).getbreadCrumbsText().contains("Home\n" +
                "Books\n" + "Non-Fiction\n" + "Hacking"));
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().equals("Hacking"));

        new AllProductsPage(wd).clickOnNonFictionLinkOnBreadcrumbs();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().equals("Non-Fiction"));

        new AllProductsPage(wd).clickOnBooksLinkOnBreadcrumbs();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().equals("Books"));

        new AllProductsPage(wd).clickOnHomeLinkOnBreadcrumbs();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().equals("All products"));

    }

    @AfterMethod(enabled = true)
    public void TierDown() {
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

}
