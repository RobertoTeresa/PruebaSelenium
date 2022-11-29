package com.appium.pages;

import com.appium.locators.HomeLocators;
import com.appium.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage extends BasePageObject {
    private AppiumDriver<?> driver;

    private static final String HOME_URL = "https://as.com/";
    HomeLocators homeLoc;

    /* CONSTRUCTOR */

    public HomePage() {
    }

    /* ACTIONS */

    /** Acceder a la página con la url indicada */
    public void navigateHome() { navigate(HOME_URL); }

    /** Devolver la url de la página de inicio */
    public String getHomeUrl() { return HOME_URL; }

    /** Acceder a primera noticia pulsando su título */
    public void clickFirstArticleTitle() { click(homeLoc.titleArticle); }

    /** Acceder a primera noticia pulsando su imagen */
    public void clickFirstArticleImage() { click(homeLoc.imgArticle); }
}