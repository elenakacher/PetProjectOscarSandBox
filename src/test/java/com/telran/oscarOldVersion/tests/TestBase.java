package com.telran.oscarOldVersion.tests;

import com.telran.oscar.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver wd;

    /*@BeforeMethod
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x800");
        wd = new ChromeDriver(options);
        wd.get("http://selenium1py.pythonanywhere.com");
    }*/

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.get("http://selenium1py.pythonanywhere.com");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        new HomePage(wd).selectLanguage("British English");

    }

    @AfterMethod(enabled = true)
    public void tierDown () {
        wd.quit();
    }

}
