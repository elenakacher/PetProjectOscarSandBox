package com.telran.oscarLatestVersion.tests.product;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SidePanelTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void isClosingLinkRedirectsToClothingPage() {
        new AllProductsPage(wd).clickOnClothingLink();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().contains("Clothing"));
    }

    @Test
    public void isBooksLinkRedirectsToBooksPage() {
        new AllProductsPage(wd).clickOnBooksLink();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().contains("Books"));
    }

    @Test
    public void isFiktionLinkRedirectsToFictionPage() {
        new AllProductsPage(wd).clickOnFictionLink();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().contains("Fiction"));
    }

    @Test
    public void isCompInLitLinkRedirectsToCompInLitPage() {
        new AllProductsPage(wd).clickOnComputersInLiteratureLink();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().contains("Computers in Literature"));
    }

    @Test
    public void isNonFoctionLinkRedirectsToNonFictionPage() {
        new AllProductsPage(wd).clickOnNonFictionLink();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().contains("Non-Fiction"));
    }

    @Test
    public void isEssentialProgrLinkRedirectsToEssentialProgrPage() {
        new AllProductsPage(wd).clickOnEssentialProgrammingLink();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().contains("Essential programming"));
    }

    @Test
    public void isHackingLinkRedirectsToHackingPage() {
        new AllProductsPage(wd).clickOnHackingLink();
        Assert.assertTrue(new AllProductsPage(wd).getPageTitelText().contains("Hacking"));
    }

    @AfterMethod(enabled = true)
    public void TierDown() {
        new HomePage(wd).deleteUser(LoginPasswordData.USER_PASSWORD1);
    }
}
