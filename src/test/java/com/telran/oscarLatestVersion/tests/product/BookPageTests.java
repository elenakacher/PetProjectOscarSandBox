package com.telran.oscarLatestVersion.tests.product;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.data.ReviewData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.product.BookPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BookPageTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new AllProductsPage(wd).clickOnFirstBookTitle();
    }

    @Test
    public void UITest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new BookPage(wd).isBreadcumbsPresent());
        softAssert.assertTrue(new BookPage(wd).isBookTitelPresent());
        softAssert.assertTrue(new BookPage(wd).isPricePresent());
        softAssert.assertTrue(new BookPage(wd).isInStockPresent());
        softAssert.assertTrue(new BookPage(wd).isPicturePresent());
        softAssert.assertTrue(new BookPage(wd).isProductDescriptionPresent());
        softAssert.assertTrue(new BookPage(wd).isProductInformationPresent());
        softAssert.assertTrue(new BookPage(wd).isCustomerReviewsPresent());
        new AllProductsPage(wd).clickOnBooksLinkOnBreadcrumbs();
        new AllProductsPage(wd).clickOnLastBookTitle();
        softAssert.assertTrue(new BookPage(wd).isProductsYouRecentlyViewedPresent());
        softAssert.assertAll();
    }

    @Test
    public void writeReviewForLoggedUserPositiveTest() {
        new BookPage(wd).writeReview(ReviewData.TITEL, ReviewData.BODY);
        Assert.assertTrue(new BookPage(wd).isReviewDisplayed());
    }

    @Test(dataProvider = "ReviewForLoggedUserWithMissingRequiredFieldsWithCsv", dataProviderClass = DataProviders.class)
    public void writeReviewForLoggedUserNegativeTest(String title, String body) {
        new BookPage(wd).writeReview(title, body);
        Assert.assertTrue(new BookPage(wd).isSaveBtnDisplayed());
    }

    @Test
    public void writeReviewForLoggedUserWithMissingRatingNegativeTest() {
        new BookPage(wd).writeReviewWithoutRating(ReviewData.TITEL, ReviewData.BODY);
        Assert.assertTrue(new BookPage(wd).isSaveBtnDisplayed());
    }

    @Test
    public void writeReviewForUnloggedUserPositiveTest() {
        new HomePage(wd).clickOnLogoutBtn();
        new AllProductsPage(wd).clickOnFirstBookTitle();
        new BookPage(wd).writeReviewUnloggedUser(ReviewData.TITEL, ReviewData.BODY,
                ReviewData.NAME, ReviewData.EMAIL);
        Assert.assertTrue(new BookPage(wd).isReviewDisplayed());
        new HomePage(wd).clickOnLoginButton().login(LoginPasswordData.USER_LOGIN1,
                LoginPasswordData.USER_PASSWORD1);
    }

    @Test(dataProvider = "ReviewForUnloggedUserWithMissingRequiredFieldsWithCsv", dataProviderClass = DataProviders.class)
    public void writeReviewForUnloggedUserNegativeTest(String title, String body,
                                                       String name, String email) {
        new HomePage(wd).clickOnLogoutBtn();
        new AllProductsPage(wd).clickOnFirstBookTitle();
        new BookPage(wd).writeReviewUnloggedUser(title, body, name, email);
        Assert.assertTrue(new BookPage(wd).isSaveBtnDisplayed());
        new HomePage(wd).clickOnLoginButton().login(LoginPasswordData.USER_LOGIN1,
                LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void writeReviewForUnloggedUserWithMissingRatingNegativeTest() {
        new HomePage(wd).clickOnLogoutBtn();
        new AllProductsPage(wd).clickOnFirstBookTitle();
        new BookPage(wd).writeReviewWithoutRatingUnloggedUser(ReviewData.TITEL, ReviewData.BODY, ReviewData.NAME, ReviewData.EMAIL);
        Assert.assertTrue(new BookPage(wd).isSaveBtnDisplayed());
        new HomePage(wd).clickOnLoginButton().login(LoginPasswordData.USER_LOGIN1,
                LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void addToBasketTest() {
        new BookPage(wd).addToBasketTest();
        Assert.assertTrue(new BookPage(wd).confirmMessageText().contains("has been added to your basket."));
        Assert.assertTrue(new BookPage(wd).isCheckoutNowBtnAppeared());

    }

   /* @Test
    public void addToWishListTest() {
        new BookPage(wd).addToWishListTest();
        Assert.assertTrue(new BookPage(wd).confirmMessageText().contains("has been added to your basket."));
        Assert.assertTrue(new BookPage(wd).isCheckoutNowBtnAppeared());
    }

    @Test
    public void beFirstToWriteOneTest() {
    }*/


    @AfterMethod(enabled = true)
    public void TierDown() {
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }
}
