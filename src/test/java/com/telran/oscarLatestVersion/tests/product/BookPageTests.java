package com.telran.oscarLatestVersion.tests.product;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.product.BookPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookPageTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new AllProductsPage(wd).clickOnFirstBookTitle();
    }

    @Test
    public void UITest() {
        Assert.assertTrue(new BookPage(wd).isBreadcumbsPresent());
        Assert.assertTrue(new BookPage(wd).isBookTitelPresent());
        Assert.assertTrue(new BookPage(wd).isPricePresent());
        Assert.assertTrue(new BookPage(wd).isInStockPresent());
        Assert.assertTrue(new BookPage(wd).isPicturePresent());
        Assert.assertTrue(new BookPage(wd).isProductDescriptionPresent());
        Assert.assertTrue(new BookPage(wd).isProductInformationPresent());
        Assert.assertTrue(new BookPage(wd).isCustomerReviewsPresent());
        new AllProductsPage(wd).clickOnBooksLinkOnBreadcrumbs();
        new AllProductsPage(wd).clickOnLastBookTitle();
        Assert.assertTrue(new BookPage(wd).isProductsYouRecentlyViewedPresent());
    }

    @AfterMethod(enabled = true)
    public void TierDown() {
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }
}
