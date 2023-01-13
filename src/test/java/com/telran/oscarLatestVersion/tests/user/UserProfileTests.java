package com.telran.oscarLatestVersion.tests.user;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserProfileTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new HomePage(wd).clickOnAccountButton();
    }

    @Test (dataProvider = "EditProfileWithInvalidEmailWithCsv", dataProviderClass = DataProviders.class)
    public void editProfileWithInvalidEmailNegativeTestWithCsv(String email) {
        new ProfilePage(wd).clickOnEditProfileBtn().editEmail(email).clickOnSaveBnt();
        Assert.assertTrue(new ProfilePage(wd).isSaveBtnPresent());
    }

    @Test
    public void deleteAccountWithInvalidPasswordNegativeTest() {
        new ProfilePage(wd).deleteUser(LoginPasswordData.USER_PASSWORD2);
        Assert.assertTrue(new ProfilePage(wd).isErrorMsgPresent());
    }

    @Test
    public void cancelChangePasswordPositiveTest() {
        new ProfilePage(wd).changePassword(LoginPasswordData.USER_PASSWORD1, LoginPasswordData.USER_PASSWORD2).clickOnCancelBnt();
        new HomePage(wd).clickOnLogoutBtn().clickOnLoginButton().login(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        Assert.assertTrue(new HomePage(wd).isAccountCreated());
    }

    @Test
    public void changePasswordPositiveTest() {
        new ProfilePage(wd).changePassword(LoginPasswordData.USER_PASSWORD1, LoginPasswordData.USER_PASSWORD2).clickOnSaveBnt();
        Assert.assertTrue(new ProfilePage(wd).isConfirmationMsgPresent());
        new ProfilePage(wd).changePassword(LoginPasswordData.USER_PASSWORD2, LoginPasswordData.USER_PASSWORD1).clickOnSaveBnt();
    }

    @Test
    public void editEmailPositiveTest() {
        new ProfilePage(wd).clickOnEditProfileBtn().editEmail(LoginPasswordData.USER_LOGIN2).clickOnSaveBnt();
        Assert.assertTrue(new ProfilePage(wd).isConfirmationMsgPresent());
        new ProfilePage(wd).clickOnEditProfileBtn().editEmail(LoginPasswordData.USER_LOGIN1).clickOnSaveBnt();

    }

    @Test
    public void cancelDeleteProfilePositiveTest() {
        new ProfilePage(wd).clickOnDeleteProfileBtn().deleteProfile(LoginPasswordData.USER_PASSWORD1).clickOnCancelBnt();
        Assert.assertTrue(new ProfilePage(wd).isLogoutLinkPresent());
    }

    @Test
    public void cancelEditProfilePositiveTest() {
        new ProfilePage(wd).clickOnEditProfileBtn().inputUserName(UserData.USER_FIRSTNAME, UserData.USER_LASTNAME).clickOnCancelBnt();
        Assert.assertTrue(new ProfilePage(wd).getUserName().contains("-"));
    }

    @Test
    public void editProfilePositiveTest() {
        new ProfilePage(wd).clickOnEditProfileBtn().inputUserName(UserData.USER_FIRSTNAME, UserData.USER_LASTNAME).clickOnSaveBnt();
        Assert.assertTrue(new ProfilePage(wd).getUserName().contains("Tom Tailor"));
    }

    @AfterMethod
    public void TierDown() {
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }

}
