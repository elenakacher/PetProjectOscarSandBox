package com.telran.oscarOldVersion.tests.user;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscarOldVersion.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(wd).clickOnLoginButton();
    }

    @Test
    public void LoginPositiveTest() {
        new LoginAndRegistrationPage(wd).login(LoginPasswordData.USER_LOGIN,LoginPasswordData.USER_PASSWORD);
        new HomePage(wd).verifyUserName();
        new LoginAndRegistrationPage(wd).takeScreenshotWithScrollDown();
    }


    @AfterMethod(enabled = true)
    public void tierDown () {
        new HomePage(wd).logOut();
    }

}
