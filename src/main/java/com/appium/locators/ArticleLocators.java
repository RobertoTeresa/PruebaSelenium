package com.appium.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticleLocators {

    /* LOCATORS */

    @FindBy(css = "h1.art__hdl__tl")
    public WebElement titleArticle;

    @FindBy(xpath = "//a[@name='Navegar a facebook']")
    public WebElement btnFacebook;

    @FindBy(xpath = "//a[@name='Navegar a twitter']")
    public WebElement btnTwitter;
}