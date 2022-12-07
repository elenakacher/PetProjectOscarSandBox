package com.telran.oscar.pages.Basket;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//form[@class = 'basket_summary']/div[1]//h3")
    WebElement bookFirstTitel;

    @FindBy(xpath = "//form[@class = 'basket_summary']/div[2]//h3")
    WebElement bookLastTitel;

    public String getBookFirstTitel() {
        return bookFirstTitel.getText();
    }

    public String getBookLastTitel() {
        return bookLastTitel.getText();
    }

    @FindBy(xpath = "//a[. = 'Proceed to checkout']")
    WebElement proceedToCheckoutBtn;

    public ShippingAddressPage clickOnProceedToCheckoutButton() {
        click(proceedToCheckoutBtn);
        return new ShippingAddressPage(wd);
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement quantityBook;

    @FindBy(xpath = "//button[. = 'Update']")
    WebElement updateQuantity;

    public BasketPage removeBook() {
        quantityBook.clear();
        quantityBook.sendKeys("0");
        updateQuantity.click();
        return this;
    }

}
