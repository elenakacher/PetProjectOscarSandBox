package com.telran.oscarOldVersion.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.utils.MyListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //public WebDriver wd;

    public EventFiringWebDriver wd;



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
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.get("http://selenium1py.pythonanywhere.com");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wd.register(new MyListener());

        //new HomePage(wd).selectLanguageWithRobot("British English");
        new HomePage(wd).selectLanguage("British English");
    }

    @AfterMethod
    public void tierDown () {
        wd.quit();
    }
}
