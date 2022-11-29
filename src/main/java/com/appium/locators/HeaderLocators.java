package com.appium.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderLocators {

    /* LOCATORS */

    @FindBy(id = "didomi-notice-agree-button")
    public WebElement btnCookies;

    @FindBy(className = "ai-as")
    public WebElement logoAs;

    @FindBy(className = "hdr__newsl")
    public WebElement btnSub;

    @FindBy(className = "ai-mail")
    public WebElement btnNews;

    @FindBy(className = "ai-user")
    public WebElement btnUser;

    @FindBy(className = "ai-Search")
    public WebElement btnSearch;

    @FindBy(css = "button.hdr__eds")
    public WebElement btnEditions;
}