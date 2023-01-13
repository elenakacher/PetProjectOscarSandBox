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
        click(placeOrder);
        return new OrderConfirmationPage(wd);
    }

    @FindBy(css = ".row.shipping-payment .col-sm-6:nth-child(1) .card:nth-child(2) .float-right")
    WebElement changeAddressBtn;

    public ShippingAddressPage clickOnChangeAddressBtn() {
        click(changeAddressBtn);
        return new ShippingAddressPage(wd);
    }

    @FindBy(css = ".row.shipping-payment .col-sm-6:nth-child(2) .card:nth-child(2) .float-right")
    WebElement changePaymentBtn;

    public BasketPage clickOnChangePaymentBtn() {
        click(changePaymentBtn);
        return new BasketPage(wd);
    }

    @FindBy(css = ".page_inner .sub-header:nth-child(4) .float-right")
    WebElement editOrderBtn;

    public BasketPage clickOnEditOrderButton() {
        click(editOrderBtn);
        return new BasketPage(wd);
    }
}

