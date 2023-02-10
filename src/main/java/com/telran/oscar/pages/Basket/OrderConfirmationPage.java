package com.telran.oscar.pages.Basket;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver wd) {
        super(wd);

    }

    @FindBy(xpath = "//div[@class = 'page_inner']/div[6]//h3")
    WebElement bookTitel;

    public String getBookTitel() {
        return bookTitel.getText();
    }

    @FindBy(tagName = "h1")
    WebElement pageTitel;

    public String getPageTitel() {
        System.out.println(pageTitel.getText());
        return pageTitel.getText();
    }

    public int getPageTitelNumber() {
        return Integer.parseInt(pageTitel.getText().substring(6, 12));
    }

    @FindBy(css = ".row .col-sm-4:nth-child(1)")
    WebElement printOrderBtn;

    public OrderConfirmationPage clickOnPrintBtn() {
        click(printOrderBtn);
        return this;
    }

    public OrderConfirmationPage closePrintPage() {
        pause(2000);
        try {
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }
}
