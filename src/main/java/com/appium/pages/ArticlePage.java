package com.appium.pages;

import com.appium.locators.ArticleLocators;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ArticlePage extends BasePageObject {

    ArticleLocators articleLoc;

    /* CONSTRUCTOR */

    public ArticlePage() {
    }

    /* ACTIONS */

    /** Acceder a la página con la url indicada */
    public void navigateArticle(String url) { navigate(url); }

    /** Comprobar que el artículo tiene título */
    public boolean isArticleTitlePresent() {
        return isElementPresent(articleLoc.titleArticle);
    }

    /** Compartir articulo con Facebook */
    public void clickShareFacebook() { click(articleLoc.btnFacebook); }

    /** Compartir articulo con Twitter */
    public void clickShareTwitter() { click(articleLoc.btnTwitter); }
}