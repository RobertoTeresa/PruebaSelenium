package com.appium.pages;

import com.appium.locators.NewsLocators;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class NewsPage extends BasePageObject {

    private static final String NEWS_PAGE = "https://as.com/noticias/atletico-madrid/?omnil=src-sab";
    NewsLocators newsLoc;

    /* CONSTRUCTOR */

    public NewsPage() {
    }

    /* ACTIONS */

    /** Acceder a la página con la url indicada */
    public void navigateNews() { navigate(NEWS_PAGE); }

    /** Devolver la url de la página de noticias */
    public String getNewsUrl() { return NEWS_PAGE; }

    /** Acceder a primera noticia pulsando su título */
    public void clickFirstArticleTitle() { click(newsLoc.titleArticle); }

    /** Acceder a primera noticia pulsando su imagen */
    public void clickFirstArticleImage() { click(newsLoc.imgArticle); }
}