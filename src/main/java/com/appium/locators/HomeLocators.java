package com.appium.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLocators {

    /* LOCATORS */

    @FindBy(css = "article h2.s__tl a")
    public WebElement titleArticle;

    @FindBy(css = "article figure img")
    public WebElement imgArticle;
}