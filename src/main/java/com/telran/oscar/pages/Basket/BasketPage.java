package com.telran.oscar.pages.Basket;

import com.telran.oscar.pages.BasePage;
import com.telran.oscar.pages.product.AllProductsPage;
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
    WebElement bookTitel;

    public String getBookTitel() {
        return bookTitel.getText();
    }

    @FindBy(css = ".btn.btn-lg.btn-primary.btn-block")
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

    public BasketPage clickOnBookTitel() {
        click(bookTitel);
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

    @FindBy(id = "content_inner")
    WebElement basketIsEmptyMsg;

    public String getBasketIsEmptyMsg() {
        return basketIsEmptyMsg.getText();
    }

    @FindBy(css = ".basket-line-actions")
    WebElement removeBtn;

    public BasketPage clickOnRemoveBtn() {
        click(removeBtn);
        return this;
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement quantity;

    public BasketPage changeQuantity(String number) {
        quantity.clear();
        type(quantity, number);
        click(updateQuantity);
        return this;
    }

    @FindBy(xpath = "//div[@class='basket-items'][1]//div[@class='basket-line-actions']/a[2]")
    WebElement saveForLaterBtn;

    public BasketPage clicksaveForLaterBtn() {
        click(saveForLaterBtn);
        return this;
    }

    @FindBy(css = ".sub-header")
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
        return quantity.getAttribute("value");
    }

    public BasketPage incQuantity() {
        quantity.sendKeys(Keys.ARROW_UP);
        click(updateQuantity);
        return this;
    }

    public BasketPage decQuantity() {
        quantity.sendKeys(Keys.ARROW_DOWN);
        click(updateQuantity);
        return this;
    }

    @FindBy(css = ".basket-items:nth-child(6) :nth-child(4)")
    WebElement priceForOne;

    public double getPriceForOne() {
        double numb1 = Double.parseDouble(priceForOne.getText().substring(1));
        return numb1;
    }

    @FindBy(css = ".basket-items .col-md-2 .price_color")
    WebElement totalAmountForMany;

    public double getTotalAmountForMany() {
        double numb2 = Double.parseDouble(totalAmountForMany.getText().substring(1));
        return numb2;
    }

    @FindBy(css = ".table.table-sm tr:nth-child(2) .text-right")
    WebElement basketTotal;

    public double getBasketTotal() {
        double numb3 = Double.parseDouble(basketTotal.getText().substring(1));
        return numb3;
    }

    @FindBy(css = ".page-header")
    WebElement pageTitel;

    public String getPageTitel() {
        return pageTitel.getText();
    }

    @FindBy(css = ".row .col-sm-4:nth-child(2)")
    WebElement continueShoppingBtn;

    public AllProductsPage clickOnContinueShoppingButton() {
        click(continueShoppingBtn);
        return new AllProductsPage(wd);
    }
}
