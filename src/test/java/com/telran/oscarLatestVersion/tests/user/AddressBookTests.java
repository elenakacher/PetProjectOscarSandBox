package com.telran.oscarLatestVersion.tests.user;

import com.telran.oscar.data.AddressData;
import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.user.AddressBookPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscarLatestVersion.TestBaseLatestVersion;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressBookTests extends TestBaseLatestVersion {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new HomePage(wd).clickOnAccountButton();
        new ProfilePage(wd).clickOnAddressBookLink();
    }

    @Test
    public void addNewAddressPositiveTest() {
        new AddressBookPage(wd).fillAddressFormWithValidData(AddressData.FIRST_NAME2,
                AddressData.LAST_NAME2, AddressData.FIRST_LINE_OF_ADDRESS2,
                AddressData.CITY2, AddressData.POST_CODE2);
        new AddressBookPage(wd).selectCountry("Germany").clickOnSaveBtn();
        Assert.assertTrue(new AddressBookPage(wd).isConfirmMessagePresent());
    }

    @Test
    public void cancelAddNewAddressPositiveTest() {
        new AddressBookPage(wd).fillAddressFormWithValidData(AddressData.FIRST_NAME2,
                AddressData.LAST_NAME2, AddressData.FIRST_LINE_OF_ADDRESS2,
                AddressData.CITY2, AddressData.POST_CODE2);
        new AddressBookPage(wd).selectCountry("Germany").clickOnCancelBtn();
        Assert.assertTrue(new AddressBookPage(wd).isAddressBookEmptyMsg().contains("There are no addresses in your address book."));

    }

    @Test
    public void deleteAddressPositiveTest() {
        new AddressBookPage(wd).fillAddressFormWithValidData(AddressData.FIRST_NAME2,
                AddressData.LAST_NAME2, AddressData.FIRST_LINE_OF_ADDRESS2,
                AddressData.CITY2, AddressData.POST_CODE2);
        new AddressBookPage(wd).selectCountry("Germany").clickOnSaveBtn();
        new AddressBookPage(wd).clickOnEditDropdownMenu().deleteAddress();
        Assert.assertTrue(new AddressBookPage(wd).isConfirmMessagePresent());
    }

    @Test(dataProvider = "addNewAddressWithMissingRequiredFieldsWithCsv", dataProviderClass = DataProviders.class)
    public void addNewAddressNegativeTest(String firstName, String lastName,
                                          String firstLineOfAddress, String city,
                                          String postCode) {
        new AddressBookPage(wd).fillAddressFormWithInvalidDataWithDataProvider(firstName, lastName,
                firstLineOfAddress, city, postCode);
        new AddressBookPage(wd).selectCountry("Germany").clickOnSaveBtn();
        Assert.assertFalse(new AddressBookPage(wd).isConfirmMessagePresent());
    }

    @Test
    public void editAddressPositiveTest() {
        new AddressBookPage(wd).fillAddressFormWithValidData(AddressData.FIRST_NAME1,
                AddressData.LAST_NAME1, AddressData.FIRST_LINE_OF_ADDRESS1,
                AddressData.CITY1, AddressData.POST_CODE1);
        new AddressBookPage(wd).selectCountry("Germany").clickOnSaveBtn();
        new AddressBookPage(wd).clickOnEditBtn().editAllRequiredFields(AddressData.FIRST_NAME2,
                AddressData.LAST_NAME2, AddressData.FIRST_LINE_OF_ADDRESS2,
                AddressData.CITY2, AddressData.POST_CODE2).clickOnSaveBtn();
        Assert.assertTrue(new AddressBookPage(wd).getConfirmMessageText().contains
                ("Address '" + AddressData.FIRST_NAME2 + " " + AddressData.LAST_NAME2 +
                        ", " + AddressData.FIRST_LINE_OF_ADDRESS2 + ", " +
                        AddressData.CITY2 + ", " + AddressData.POST_CODE2 + ", Germany' updated"));
    }

    @Test
    public void cancelEditAddressPositiveTest() {
        new AddressBookPage(wd).fillAddressFormWithValidData(AddressData.FIRST_NAME1,
                AddressData.LAST_NAME1, AddressData.FIRST_LINE_OF_ADDRESS1,
                AddressData.CITY1, AddressData.POST_CODE1);
        new AddressBookPage(wd).selectCountry("Germany").clickOnSaveBtn().closeConfirmMsg();
        new AddressBookPage(wd).clickOnEditBtn().editAllRequiredFields(AddressData.FIRST_NAME2,
                AddressData.LAST_NAME2, AddressData.FIRST_LINE_OF_ADDRESS2,
                AddressData.CITY2, AddressData.POST_CODE2).clickOnCancelBtn();
        Assert.assertTrue(new AddressBookPage(wd).getAddressText().contains
                (AddressData.FIRST_NAME1));
        Assert.assertTrue(new AddressBookPage(wd).getAddressText().contains
                (AddressData.LAST_NAME1));
        Assert.assertTrue(new AddressBookPage(wd).getAddressText().contains
                (AddressData.FIRST_LINE_OF_ADDRESS1));
        Assert.assertTrue(new AddressBookPage(wd).getAddressText().contains
                (AddressData.CITY1));
        Assert.assertTrue(new AddressBookPage(wd).getAddressText().contains
                (AddressData.POST_CODE1));
    }

    @Test
    public void addSameAddressNegativeTest() {
        new AddressBookPage(wd).fillAddressFormWithValidData(AddressData.FIRST_NAME2,
                AddressData.LAST_NAME2, AddressData.FIRST_LINE_OF_ADDRESS2,
                AddressData.CITY2, AddressData.POST_CODE2);
        new AddressBookPage(wd).selectCountry("Germany").clickOnSaveBtn();
        new AddressBookPage(wd).fillAddressFormWithValidData(AddressData.FIRST_NAME2,
                AddressData.LAST_NAME2, AddressData.FIRST_LINE_OF_ADDRESS2,
                AddressData.CITY2, AddressData.POST_CODE2);
        new AddressBookPage(wd).selectCountry("Germany").clickOnSaveBtn();
        Assert.assertTrue(new AddressBookPage(wd).isErrorMessagePresent());
    }

    @AfterMethod
    public void TierDown() {
        new HomePage(wd).clickOnOscarLink().deleteUser(LoginPasswordData.USER_PASSWORD1);
    }
}
