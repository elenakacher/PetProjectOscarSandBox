package com.telran.oscar.pages.product;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage {
    public AllProductsPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//ol[@class = 'row list-unstyled ml-0 pl-0']/li[2]//button")
    WebElement bookFirst;

    @FindBy(xpath = "//ol[@class = 'row list-unstyled ml-0 pl-0']/li[20]//button")
    WebElement bookLast;

    public AllProductsPage addToBasket() {
        click(bookFirst);
        clickWithJSExecutor(bookLast, 800, 0);
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'next')]")
    WebElement nextBtn;

    public AllProductsPage clickOnNextButton() {
        clickWithJSExecutor(nextBtn, 600, 0);
        return this;
    }

    @FindBy(xpath = "//ol[@class = 'row list-unstyled ml-0 pl-0']/li[20]//h3")
    WebElement lastBookTitel;

    public String getLastBookTitel() {
        return lastBookTitel.getText();
    }

    @FindBy(xpath = "//a[contains(text(),'previous')]")
    WebElement previousBtn;

    public AllProductsPage clickOnPreviousButton() {
        clickWithJSExecutor(previousBtn, 600, 0);
        return this;
    }

    @FindBy(xpath = "//ol[@class = 'row list-unstyled ml-0 pl-0']/li[2]//h3")
    WebElement firstBookTitel;

    public String getFirstBookTitel() {
        return firstBookTitel.getText();
    }

    @FindBy(xpath = "//div[@id= 'messages']/div[1]")
    WebElement addToBasketConfirmMsg;

    public String getConfirmMessage() {
        return addToBasketConfirmMsg.getText();
    }

    @FindBy(xpath = "//div[@id= 'messages']/div[1]")
    WebElement viewBasketBtn;

    public boolean isViewBasketButtonExists() {
        return viewBasketBtn.isDisplayed();
    }

    @FindBy(xpath = "//div[@id= 'messages']/div[2]")
    WebElement checkoutNowBtn;

    public boolean isCheckoutNowButtonExists() {
        return checkoutNowBtn.isDisplayed();
    }

    public BookPage clickOnFirstBookTitle() {
        click(firstBookTitel);
        return new BookPage(wd);
    }

    public BookPage clickOnLastBookTitle() {
        click(lastBookTitel);
        return new BookPage(wd);
    }

    @FindBy (css = ".breadcrumb")
    WebElement breadcrumb;

    public String getbreadCrumbsText() {
        System.out.println(breadcrumb.getText());
        return breadcrumb.getText();
    }

    @FindBy(css = "a[href*=computers-in-literature]")
    WebElement compInLitLink;

    public AllProductsPage clickOnComputersInLiteratureLink() {
        click(compInLitLink);
        return this;
    }

    @FindBy(css = ".page-header")
    WebElement pageTitel;

    public String getPageTitelText() {
        return pageTitel.getText();
    }

    @FindBy(css = "a[href*=essential-programming]")
    WebElement essentProgrLink;

    public AllProductsPage clickOnEssentialProgrammingLink() {
        click(essentProgrLink);
        return this;
    }

    @FindBy(css = "a[href*=hacking]")
    WebElement hackingLink;

    public AllProductsPage clickOnHackingLink() {
        click(hackingLink);
        return this;
    }

    @FindBy(css = ".breadcrumb-item:nth-child(3)")
    WebElement nonFictionLink;

    public AllProductsPage clickOnNonFictionLinkOnBreadcrumbs() {
        click(nonFictionLink);
        return this;
    }

    @FindBy(css = ".breadcrumb-item:nth-child(3)")
    WebElement fictionLink;

    public AllProductsPage clickOnFictionLinkOnBreadcrumbs() {
        click(fictionLink);
        return this;
    }

    @FindBy(css = ".breadcrumb-item:nth-child(2)")
    WebElement booksLink;

    public AllProductsPage clickOnBooksLinkOnBreadcrumbs() {
        click(booksLink);
        return this;
    }

    @FindBy(css = ".breadcrumb-item:nth-child(1)")
    WebElement homeLink;

    public AllProductsPage clickOnHomeLinkOnBreadcrumbs() {
        click(homeLink);
        return this;
    }
}
