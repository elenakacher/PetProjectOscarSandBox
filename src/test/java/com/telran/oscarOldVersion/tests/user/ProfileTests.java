package com.telran.oscarOldVersion.tests.user;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscarOldVersion.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).login(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new HomePage(wd).clickOnAccountButton();
    }

    @Test
    public void editUserData() {
        new ProfilePage(wd).clickOnEditProfileBtn().inputUserName(UserData.USER_FIRSTNAME, UserData.USER_LASTNAME).clickOnSaveBnt();
        Assert.assertTrue(new ProfilePage(wd).getConfirmMessage().contains("Profile updated"));
        Assert.assertTrue(new ProfilePage(wd).getUserName().contains("Tom Tailor"));
    }


    @AfterMethod(enabled = true)
    public void tierDown () {
        new HomePage(wd).clickOnLogoutBtn();
    }

}
