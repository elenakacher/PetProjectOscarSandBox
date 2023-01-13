package com.telran.oscarLatestVersion;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.utils.MyListener;
import com.telran.oscarOldVersion.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBaseLatestVersion {

    //public WebDriver wd;
    public EventFiringWebDriver wd;

    @BeforeMethod
    public void init() {
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.get("https://latest.oscarcommerce.com");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wd.register(new MyListener());

        new HomePage(wd).selectLanguage("British English");
    }

    @AfterMethod(enabled = true)
    public void tierDown () {
        wd.quit();
    }

}
