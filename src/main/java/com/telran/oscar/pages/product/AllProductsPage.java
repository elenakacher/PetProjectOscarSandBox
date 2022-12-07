package com.telran.oscar.pages.product;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage {
    public AllProductsPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//ol[@class = 'row']/li[1]//button")
    WebElement bookFirst;

    @FindBy(xpath = "//ol[@class = 'row']/li[19]//button")
    WebElement bookLast;

    public AllProductsPage addToBasket() {
        click(bookFirst);
        pause(1000);
        clickWithJSExecutor(bookLast, 800, 0);
        return this;
    }

}
