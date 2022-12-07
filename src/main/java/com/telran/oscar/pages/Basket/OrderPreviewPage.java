package com.telran.oscar.pages.Basket;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPreviewPage extends BasePage {
    public OrderPreviewPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "place-order")
    WebElement placeOrder;

    public OrderConfirmationPage clickOnPlaceOrderButton() {
        clickWithJSExecutor(placeOrder, 800, 0);
        return new OrderConfirmationPage(wd);
    }
}
