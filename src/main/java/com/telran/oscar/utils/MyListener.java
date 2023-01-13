package com.telran.oscar.utils;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start search " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info(by + " was found.");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a throwable --> " + throwable.getMessage());
        logger.info("We have a throwable --> " + throwable.getLocalizedMessage());
        logger.info("We have a throwable --> " + throwable.fillInStackTrace());

        int index = (int) (System.currentTimeMillis()/1000)%3600;
        String link = "screenshots/screen" + index + ".png";

        BasePage basePage = new BasePage(driver);
        basePage.takeScreenshotMyListener(link);

        logger.info("This is a link with error " + link);
    }
}
