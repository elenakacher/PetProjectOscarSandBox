package com.telran.oscarLatestVersion.tests.user;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
    }

    @Test(dataProvider = "regUserDataWithCsv", dataProviderClass = DataProviders.class)
    public void registrationPositiveTestWithCsv(String email, String password) {
        new LoginAndRegistrationPage(wd).userRegistrationWithDataProvider(email, password).deleteUser(password);
    }

    @Test
    public void registrationPositiveTest() {
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(
                LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1)
                .deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void registrationDeletedUserPositiveTest() {
        new LoginAndRegistrationPage(wd).userRegistration(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1).deleteUser(LoginPasswordData.USER_PASSWORD1);
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistration(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        Assert.assertTrue(new HomePage(wd).isAccountCreated());
        new LoginAndRegistrationPage(wd).deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void registrationExistingUserNegativeTest() {
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new HomePage(wd).clickOnLogoutBtn().clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        Assert.assertTrue(new LoginAndRegistrationPage(wd).isErrorExists());
        new LoginAndRegistrationPage(wd).login(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1).deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

    @Test
    public void registrationWithDifferentPasswordNegativeTest() {
        new LoginAndRegistrationPage(wd).userRegistrationWithDifferentPasswords(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1,
                LoginPasswordData.USER_PASSWORD2);
        Assert.assertTrue(new LoginAndRegistrationPage(wd).isErrorExists());
     }

    @Test(dataProvider = "regInvalidUserEmailWithCsv", dataProviderClass = DataProviders.class)
    public void registrationInvalidEmailNegativeTestWithCsv(String email, String password) {
        new LoginAndRegistrationPage(wd).userRegistrationWithDataProvider(email, password);
        Assert.assertTrue(new LoginAndRegistrationPage(wd).isRegBtnExists());
    }

    @Test(dataProvider = "regInvalidUserPasswordWithCsv", dataProviderClass = DataProviders.class)
    public void registrationInvalidPasswordNegativeTestWithCsv(String email, String password) {
        new LoginAndRegistrationPage(wd).userRegistrationWithDataProvider(email, password);
        Assert.assertTrue(new LoginAndRegistrationPage(wd).isRegBtnExists());
    }
}
