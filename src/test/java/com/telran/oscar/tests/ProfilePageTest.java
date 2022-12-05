package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginPage;
import com.telran.oscar.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectLanguage("British English");
        new HomePage(wd).clickOnLoginButton();
        new LoginPage(wd).login("tom@gmail.com", "Tommy1980!");
        new HomePage(wd).clickOnAccountButton();
    }

    @Test
    public void editUserData() {
        new ProfilePage(wd).inputUserName("Tom", "Tailor");
        Assert.assertTrue(new ProfilePage(wd).getConfirmMessage().contains("Profile updated"));
        Assert.assertTrue(new ProfilePage(wd).getUserName().contains("Tom Tailor"));

    }

}
