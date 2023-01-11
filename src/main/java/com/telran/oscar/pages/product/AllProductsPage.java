package com.telran.oscar.pages.product;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;

public class AllProductsPage extends BasePage {
    public AllProductsPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//ol[@class = 'row list-unstyled ml-0 pl-0']/li[1]//button")
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

    @FindBy(xpath = "//ol[@class = 'row list-unstyled ml-0 pl-0']/li[1]//h3")
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

    @FindBy(xpath = "//div[@id= 'messages']/div[3]//a[2]")
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
    WebElement nonFictionLinkOnBreadcrumbs;

    public AllProductsPage clickOnNonFictionLinkOnBreadcrumbs() {
        click(nonFictionLinkOnBreadcrumbs);
        return this;
    }

    @FindBy(css = ".breadcrumb-item:nth-child(3)")
    WebElement fictionLinkOnBreadcrumbs;

    public AllProductsPage clickOnFictionLinkOnBreadcrumbs() {
        click(fictionLinkOnBreadcrumbs);
        return this;
    }

    @FindBy(css = ".breadcrumb-item:nth-child(2)")
    WebElement booksLinkOnBreadcrumbs;

    public AllProductsPage clickOnBooksLinkOnBreadcrumbs() {
        click(booksLinkOnBreadcrumbs);
        return this;
    }

    @FindBy(css = ".breadcrumb-item:nth-child(1)")
    WebElement homeLinkOnBreadcrumbs;

    public AllProductsPage clickOnHomeLinkOnBreadcrumbs() {
        click(homeLinkOnBreadcrumbs);
        return this;
    }

    @FindBy(css = "li > a[href*=clothing_1]")
    WebElement clothingLink;

    public AllProductsPage clickOnClothingLink() {
        click(clothingLink);
        return this;
    }

    @FindBy(css = "li > a[href*=books_2]")
    WebElement bookLink;

    public AllProductsPage clickOnBooksLink() {
        click(bookLink);
        return this;
    }

    @FindBy(css = "li > a[href*=fiction_3]")
    WebElement fictionLink;

    public AllProductsPage clickOnFictionLink() {
        click(fictionLink);
        return this;
    }

    @FindBy(css = "li > a[href*=non-fiction_5]")
    WebElement nonfictionLink;


    public AllProductsPage clickOnNonFictionLink() {
        click(nonfictionLink);
        return this;
    }

    @FindBy(css = ".col-sm-6.h1")
    WebElement homeLinkOnHeader;

    public boolean isHomePageLinkPresent() {
        return homeLinkOnHeader.isDisplayed();
    }

    @FindBy(css = ".basket-mini.col-sm-5.text-right.d-none.d-md-block")
    WebElement basketTotalOnHeadertext;

    public boolean isBasketTotalTextPresent() {
        System.out.println(basketTotalOnHeadertext.getText());
        return basketTotalOnHeadertext.isDisplayed();
    }

    @FindBy(css = "button.btn.btn-outline-secondary:nth-child(1)")
    WebElement viewBasketBtnOnHeader;

    public boolean isViewBasketBtnPresent() {
        return viewBasketBtnOnHeader.isDisplayed();
    }

    @FindBy(css = "button.btn.btn-outline-secondary:nth-child(2)")
    WebElement viewBasketDropdownMenuOnHeader;

    public boolean isviewBasketDropdownMenuPresent() {
        return viewBasketDropdownMenuOnHeader.isDisplayed();
    }

    @FindBy (id = "navbarSupportedContent")
    WebElement navbarSupportedContent;

    public boolean isNavbarSupportedContentPresent() {
        return navbarSupportedContent.isDisplayed();
    }

    @FindBy (id = "navbarDropdown")
    WebElement browseStoreDropdownMenu;

    public boolean isBrowseStoreDropdownMenuPresent() {
        return browseStoreDropdownMenu.isDisplayed();
    }

    @FindBy (xpath = "//input[@placeholder = 'Search']")
    WebElement searchField;

    public boolean isSearchFieldPresent() {
        return searchField.isDisplayed();
    }

    @FindBy (css = ".btn.btn.btn-secondary.my-2.my-sm-0")
    WebElement searchBtn;

    public boolean isSearchBtnPresent() {
        return searchBtn.isDisplayed();
    }

    public boolean isBreadcrumbPresent() {
        return breadcrumb.isDisplayed();
    }

    @FindBy (css = ".nav.nav-list.flex-column")
    WebElement sidePanel;

    public boolean isSidePanelPresent() {
        return sidePanel.isDisplayed();
    }

    @FindBy (tagName = "h4")
    WebElement showResultsFor;

    public boolean isShowResultsForPresent() {
        return showResultsFor.isDisplayed();
    }

    public boolean isPageHeaderPresent() {
        return pageTitel.isDisplayed();
    }

    @FindBy (id = "messages")
    WebElement statisticMsg;

    public boolean isStatisticMessagePresent() {
        return statisticMsg.isDisplayed();
    }

    @FindBy (css = ".pagination,justify-content-center")
    WebElement bottomNavigation;

    public boolean isBottomNavigationPresent() {
        return bottomNavigation.isDisplayed();
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public AllProductsPage checkBrockenImages() {
        System.out.println("We have " + images.size() + " images");
        for (int i = 0; i < images.size(); i++) {
            WebElement element = images.get(i);

            // check to display image with JS executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) wd).executeScript(
                        "return (typeof arguments[0].naturalWidth != undefined " +
                                "&& arguments[0].naturalWidth < 150);", element);
                if (imageDisplayed) {
                    System.out.println("IMAGE" + (i + 1) + " DISPLAY - OK");;
                } else {
                    System.out.println("IMAGE" + (i + 1) + " DISPLAY - BROKEN");
                }
            } catch (Exception e) {
                System.out.println("Error occured");
            }
        }
        return this;
    }

    @FindBy(css = "h3 a")
    List<WebElement> links;

    public AllProductsPage checkBrockenLinks() {
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkUrl) {
        URL url = null;
        // create url-connection and get status code
        try {
            url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() +
                        " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " is a broken link");
        }
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(1)")
    WebElement randomBookOne;

    public boolean isRandomBookFirstPresent() {
        return randomBookOne.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(1) .star-rating")
    WebElement randomBookOneScore;

    public boolean isRandomBookFirstScorePresent() {
        return randomBookOneScore.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(1) .price_color")
    WebElement randomBookOnePrice;

    public boolean isRandomBookFirstPricePresent() {
        return randomBookOnePrice.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(1) .instock.availability")
    WebElement randomBookOneInStock;

    public boolean isRandomBookFirstInStockPresent() {
        return randomBookOneInStock.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(1) .btn")
    WebElement randomBookOneAddToBasket;

    public boolean isRandomBookFirstAddToBasketPresent() {
        return randomBookOneAddToBasket.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(10)")
    WebElement randomBookMittel;


    public boolean isRandomBookMittelPresent() {
        return randomBookMittel.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(10) .star-rating")
    WebElement randomBookMittelScore;

    public boolean isRandomBookMittelScorePresent() {
        return randomBookMittelScore.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(10) .price_color")
    WebElement randomBookMittelPrice;

    public boolean isRandomBookMittelPricePresent() {
        return randomBookMittelPrice.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(10) .instock.availability")
    WebElement randomBookMittelInStock;

    public boolean isRandomBookMittelInStockPresent() {
        return randomBookMittelInStock.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(10) .btn")
    WebElement randomBookMittelAddToBasket;

    public boolean isRandomBookMittelAddToBasketPresent() {
        return randomBookMittelAddToBasket.isDisplayed();
    }


    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(20)")
    WebElement randomBookLast;


    public boolean isRandomBookLastPresent() {
        return randomBookLast.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(20) .star-rating")
    WebElement randomBookLastScore;

    public boolean isRandomBookLastScorePresent() {
        return randomBookLastScore.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(20) .price_color")
    WebElement randomBookLastPrice;

    public boolean isRandomBookLastPricePresent() {
        return randomBookLastPrice.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(20) .instock.availability")
    WebElement randomBookLastInStock;

    public boolean isRandomBookLastInStockPresent() {
        return randomBookLastInStock.isDisplayed();
    }

    @FindBy (css = ".col-sm-6.col-md-4.col-lg-3:nth-child(20) .btn")
    WebElement randomBookLastAddToBasket;

    public boolean isRandomBookLastAddToBasketPresent() {
        return randomBookLastAddToBasket.isDisplayed();
    }

    public String getBasketTotal1() {
        String text = basketTotalOnHeadertext.getText();
        String digit = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch) || ch == '.')
                digit = digit + ch;
        }
        System.out.println(digit);
        return digit;
    }

    @FindBy(css = ".alert-info.fade.show .alertinner")
    WebElement basketTotalOnAllProductsPageText;

    public String getBasketTotal2() {
        String text = basketTotalOnAllProductsPageText.getText();
        String digit = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch) || ch == '.')
                digit = digit + ch;
        }
        System.out.println(digit);
        return digit;
    }

    public AllProductsPage clickOnCheckoutNowButton() {
        click(checkoutNowBtn);
        return this;
    }
}

