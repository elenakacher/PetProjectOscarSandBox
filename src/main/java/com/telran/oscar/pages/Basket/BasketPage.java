package com.telran.oscar.pages.Basket;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

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

    @FindBy(css = ".col-sm-4.offset-sm-8")
    WebElement proceedToCheckoutBtn;

    public ShippingAddressPage clickOnProceedToCheckoutButton() {
        click(proceedToCheckoutBtn);
        return new ShippingAddressPage(wd);
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement quantityBook;

    @FindBy(xpath = "//div[@class='basket-items'][1]//button")
    WebElement updateQuantity;

    public BasketPage removeBook() {
        quantityBook.clear();
        quantityBook.sendKeys("0");
        updateQuantity.click();
        return this;
    }

    @FindBy(css = "tr:nth-child(2) > th.total.text-right:nth-child(2)")
    WebElement totalAmount;

    public String getTotalAmountNumber() {
        return totalAmount.getText();
    }

    public BasketPage clickOnBookTitel() {
        click(bookFirstTitel);
        return this;
    }

    @FindBy(id = "navbarDropdown")
    WebElement browseStoreDropdownMenu;

    public BasketPage ClickOnBrowseStoreDropdownMenu() {
        click(browseStoreDropdownMenu);
        return this;
    }

    @FindBy(css = ".dropdown-menu.show")
    WebElement dropdownMenuShow;


    public boolean isBrowseStoreDropdownMenuPresent() {
        return dropdownMenuShow.isDisplayed();
    }

    @FindBy(css = "#id_form-0-quantity.form-control")
    WebElement quantity1;

    @FindBy(id = "id_form-1-quantity")
    WebElement quantity2;

    public void deleteBooks() {
        quantity1.clear();
        type(quantity1, "0");
        quantity2.clear();
        type(quantity2, "0");
        click(updateQuantity);
    }

    @FindBy(id = "content_inner")
    WebElement basketIsEmptyMsg;

    public String getBasketIsEmptyMsg() {
        System.out.println(basketIsEmptyMsg.getText());
        return basketIsEmptyMsg.getText();
    }

    @FindBy(xpath = "//div[@class='basket-items'][1]//div[@class='basket-line-actions']/a[1]")
    WebElement removeBtn;

    public BasketPage clickOnRemoveBtn() {
        click(removeBtn);
        return this;
    }

    public BasketPage changeQuantity(String number) {
        quantity1.clear();
        type(quantity1, number);
        click(updateQuantity);
        return this;
    }

    @FindBy(css = "tr:nth-child(2) > td.text-right:nth-child(2)")
    WebElement totalAmountWithDiscount;

    public String getTotalAmountNumberWithDiscount() {
        System.out.println(totalAmountWithDiscount.getText());
        return totalAmountWithDiscount.getText();
    }

    @FindBy(xpath = "//div[@class='basket-items'][1]//div[@class='basket-line-actions']/a[2]")
    WebElement saveForLaterBtn;

    public BasketPage clicksaveForLaterBtn() {
        click(saveForLaterBtn);
        return this;
    }

    @FindBy(css = ".card.card-body .sub-header h2")
    WebElement itemsToBuyLaterTitel;

    public boolean isItemsToBuyLaterAppered() {
        return itemsToBuyLaterTitel.isDisplayed();
    }

    @FindBy(css = ".btn.float-right.btn-block")
    WebElement moveToBasketBtn;

    public BasketPage clickOnMoveToBasketBtn() {
        click(moveToBasketBtn);
        return this;
    }

    public String getQuantity() {
        System.out.println(quantity1.getAttribute("value"));
        return quantity1.getAttribute("value");
    }

    public BasketPage incQuantity() {
        quantity1.sendKeys(Keys.ARROW_UP);
        return this;
    }

    public BasketPage decQuantity() {
        quantity1.sendKeys(Keys.ARROW_DOWN);
        return this;
    }
}
