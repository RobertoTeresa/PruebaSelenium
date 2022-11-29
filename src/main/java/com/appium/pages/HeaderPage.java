package com.appium.pages;

import com.appium.locators.HeaderLocators;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HeaderPage extends BasePageObject {

    HeaderLocators headerLoc;

    /* CONSTRUCTOR */

    public HeaderPage() {
    }

    /* ACTIONS */

    /** Aceptar las cookies */
    public void clickAcceptCookies() {
        try {
            if (isElementPresent(headerLoc.btnCookies)) click(headerLoc.btnCookies);
        } catch (Exception e) {
            log.info("No se han encontrado las cookies");
        }
    }

    /** Pulsar el icono de AS en la cabecera */
    public void clickAsLogo() { click(headerLoc.logoAs); }

    /** Desplegar el menú del header indicado  */
    public void clickDropdown(String name) {
        WebElement element = find(By.cssSelector("//a[@data-subnav='" + name + "']"));
        moveTo(element);
        waitSeconds(1);
    }

    /** Acceder a las noticias seleccionadas */
    public void clickDropdownOption(String name) {
        WebElement element = find(By.cssSelector("//li/a[@title='" + name + "']"));
        moveToAndClick(element);
    }
}