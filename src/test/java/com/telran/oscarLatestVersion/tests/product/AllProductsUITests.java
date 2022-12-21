package com.telran.oscarLatestVersion.tests.product;

import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AllProductsUITests extends TestBaseLatestVersion {

     @Test
    public void homePageLinkTest() {
         Assert.assertTrue(new AllProductsPage(wd).isHomePageLinkPresent());
     }

    @Test
    public void basketTotalTextTest() {
        Assert.assertTrue(new AllProductsPage(wd).isBasketTotalTextPresent());
    }

    @Test
    public void viewBasketBtnTest() {
        Assert.assertTrue(new AllProductsPage(wd).isViewBasketBtnPresent());
    }

    @Test
    public void viewBasketDropdownMenuTest() {
        Assert.assertTrue(new AllProductsPage(wd).isviewBasketDropdownMenuPresent());
    }

    @Test
    public void navbarSupportedContentTest() {
        Assert.assertTrue(new AllProductsPage(wd).isNavbarSupportedContentPresent());
    }

    @Test
    public void browseStoreTest() {
        Assert.assertTrue(new AllProductsPage(wd).isBrowseStoreDropdownMenuPresent());
    }

    @Test
    public void SearchFieldTest() {
        Assert.assertTrue(new AllProductsPage(wd).isSearchFieldPresent());
    }

    @Test
    public void SearchBtnTest() {
        Assert.assertTrue(new AllProductsPage(wd).isSearchBtnPresent());
    }

    @Test
    public void breadcrumbTest() {
        Assert.assertTrue(new AllProductsPage(wd).isBreadcrumbPresent());
    }

    @Test
    public void sidePanelTest() {
        Assert.assertTrue(new AllProductsPage(wd).isSidePanelPresent());
    }

    @Test
    public void showResultsForTest() {
        Assert.assertTrue(new AllProductsPage(wd).isShowResultsForPresent());
    }

    @Test
    public void pageHeaderTest() {
        Assert.assertTrue(new AllProductsPage(wd).isPageHeaderPresent());
    }

    @Test
    public void statisticMessageTest() {
        Assert.assertTrue(new AllProductsPage(wd).isStatisticMessagePresent());
    }

    @Test
    public void bottomNavigationTest() {
        Assert.assertTrue(new AllProductsPage(wd).isBottomNavigationPresent());
    }

    @Test
    public void checkMissingImagesTest() {
        new AllProductsPage(wd).checkBrockenImages();
    }

    @Test
    public void checkBrockenLinksTest() {
        new AllProductsPage(wd).checkBrockenLinks();
    }

    @Test
    public void randomBookFirstTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookFirstPresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookFirstScorePresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookFirstPricePresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookFirstInStockPresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookFirstAddToBasketPresent());
    }

    @Test
    public void randomBookMittelTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookMittelPresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookMittelScorePresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookMittelPricePresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookMittelInStockPresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookMittelAddToBasketPresent());

    }

    @Test
    public void randomBookLastTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookLastPresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookLastScorePresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookLastPricePresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookLastInStockPresent());
        softAssert.assertTrue(new AllProductsPage(wd).isRandomBookLastAddToBasketPresent());

    }

}
