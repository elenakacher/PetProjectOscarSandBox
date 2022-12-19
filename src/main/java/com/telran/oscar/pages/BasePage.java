package com.telran.oscar.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BasePage {

    public WebDriver wd;

    public BasePage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        element.click();
    }

    public void typeWithJSExecutor(WebElement element, String text, int x, int y) {
        if(text != null) {
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Screenshot takeScreenshotWithScrollDown() {
        Screenshot screen = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies
                        .scaling(1.5f), 1000)).takeScreenshot(wd);
        try {
            ImageIO.write(screen.getImage(), "png",
                    new File("screenshot/screen" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screen;
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    @FindBy(id = "id_password")
    WebElement pwdField;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteBtn;

    @FindBy(css = ".nav-link.mt-2.mt-lg-0")
    WebElement accountLink;

    public HomePage deleteUser(String pwd) {
        click(accountLink);
        click(deleteProfileBtn);
        type(pwdField, pwd);
        click(deleteBtn);
        return new HomePage(wd);
    }

    @FindBy(xpath = "//button[.='Register']")
    WebElement regBtn;

    public boolean isRegBtnExists() {
        return regBtn.isDisplayed();
    }

    @FindBy (xpath = "//a[.='Oscar']")
    WebElement oscarBtn;

    public HomePage clickOnOscarLink() {
        click(oscarBtn);
        return new HomePage(wd);
    }

    public void jumpDown() {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

}
