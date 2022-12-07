package com.telran.oscar.pages.Basket;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver wd) {
        super(wd);

    }

    @FindBy(xpath = "//div[@class = 'page_inner']/div[6]//h3")
    WebElement bookTitel;

    public String getBookTitel() {
        return bookTitel.getText();
    }
}
