package com.telran.oscar.tests;

import com.telran.oscar.pages.LoginPage;
import com.telran.oscar.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).selectLanguage("British English");
        new HomePage(wd).clickOnLoginButton();
    }

    @Test
    public void LoginPositiveTest() {
        new LoginPage(wd).login("tom@gmail.com", "Tommy1980!");
        new HomePage(wd).verifyUserName();
    }

    @AfterMethod
    public void logOut() {
        new HomePage(wd).logOut();
    }
}
