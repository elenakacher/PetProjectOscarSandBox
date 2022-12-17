package com.telran.oscarLatestVersion.tests.user;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new HomePage(wd).clickOnLogoutBtn();
        new HomePage(wd).clickOnLoginButton();

    }

    @Test
    public void loginPositiveTest() {
        new LoginAndRegistrationPage(wd).login(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        Assert.assertTrue(new HomePage(wd).isAccountCreated());
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

    @Test(dataProvider = "loginInvalidDataWithCsv", dataProviderClass = DataProviders.class)
    public void loginNegativeTest(String email, String password) {
        new LoginAndRegistrationPage(wd).loginWithDataProvider(email, password);
        Assert.assertTrue(new LoginAndRegistrationPage(wd).isLoginButtonPresent());
        new LoginAndRegistrationPage(wd).login(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1)
                .deleteUser(LoginPasswordData.USER_PASSWORD1);
    }
}
