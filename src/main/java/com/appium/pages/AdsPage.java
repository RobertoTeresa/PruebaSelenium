package com.appium.pages;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class AdsPage extends BasePageObject {

    /* CONSTRUCTOR */

    public AdsPage() {
    }

    /* ACTIONS */

    /** Esperar a que cargue el anuncio indicado */
    public void waitAdElement(String name) {
        By locator = By.id("gtp_diarioas_19753-" + name);
        waitForElementBy(locator);
        waitSeconds(4);
    }

    /** Comprobar si existe el anuncio indicado */
    public boolean isAdsElementPresent(String name) {
        By locator = By.id("gtp_diarioas_19753-" + name);
        return isElementPresentBy(locator);
    }

    /** Comprobar si existe el Skin en la página */
    public boolean isSkinElementPresent(String name) {
        By locator = By.className(name);
        return isElementPresentBy(locator);
    }

    /** Obtener las dimensiones del anuncio indicado */
    public String getAdsDimensions(String name) {
        String ad = "gtp_diarioas_19753-" + name;
        WebElement iframeElem = find(By.cssSelector("div#" + ad + " iframe"));
        return iframeElem.getAttribute("width") + "x" + iframeElem.getAttribute("height");
    }

    /** Comprobar si las dimensiones indicadas son las correctas en el anuncio */
    public boolean isAdsSizeCorrect(String name, String size) {
        String sizeElem = getAdsDimensions(name);
        List<String> sizeList = new ArrayList<>(Arrays.asList(size.split(", ")));
        for (String correctSize : sizeList) {
            if (correctSize.equals(sizeElem)) {
                return true;
            }
        }
        return false;
    }
}