package com.appium.pages;

import com.appium.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class BasePageObject {
    private AppiumDriver<?> driver;

    protected BasePageObject() {
        this.driver = new DriverManager().getDriver();
    }

    /* ==================== */
    /* ACTIONS - NAVEGACIÓN */
    /* ==================== */

    /**
     * Acceder a la página con la url indicada
     */
    protected void navigate(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            log.error("No se ha podido navegar hasta la url: " + url);
        }
    }

    /**
     * Devolver la url de la página actual
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Cambiar de ventana a la recién abierta
     */
    protected void switchWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    /* ===================== */
    /* ACTIONS - INTERACCIÓN */
    /* ===================== */

    /**
     * Encontrar el elemento indicado y devolverlo
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Pulsar sobre el elemento indicado
     */
    protected void click(WebElement element) {
        scrollToElement(element);
        element.click();
    }

    /**
     * Rellena el campo de texto indicado
     */
    protected void type(WebElement element, String text) {
        scrollToElement(element);
        element.sendKeys(text);
    }

    /**
     * Mover el cursor al elemento indicado
     */
    protected void moveTo(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * Mover el cursor al elemento indicado y pulsarlo
     */
    protected void moveToAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    /* =============================== */
    /* ACTIONS - ESPERA Y VERIFICACIÓN */
    /* =============================== */

    /**
     * Esperar el número de segundos indicado
     */
    public void waitSeconds(int seconds) {
        long millis = TimeUnit.SECONDS.toMillis(seconds);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.info("No se ha podido realizar el wait de " + seconds + " segundos");
        }
    }

    /**
     * Esperar a que el elemento indicado sea visible en el tiempo indicado en tres intentos
     */
    protected void waitForElementTime(WebElement element, int segundos) {
        int attempts = 0;
        WebDriverWait wait = new WebDriverWait(driver, segundos);
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (Exception e) {
                log.info("No se ha encontrado el elemento indicado. Intento: " + (attempts + 1) + "/2");
            }
            attempts++;
        }
    }

    /**
     * Esperar a que el elemento en 5 segundos
     */
    protected void waitForElement(WebElement element) {
        waitForElementTime(element, 3);
    }

    /**
     * Esperar a que el elemento en 5 segundos pasandole un By
     */
    protected void waitForElementBy(By locator) {
        try {
            WebElement element = find(locator);
            waitForElementTime(element, 3);
        } catch (Exception e) {
            log.info("No se encuentra el elemento a esperar");
        }
    }

    /**
     * Comprobar que existe el elemento indicado
     */
    protected boolean isElementPresent(WebElement element) {
        try {
            scrollToElement(element);
            if (element.isDisplayed()) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Comprobar que existe el elemento indicado pasandole un By
     */
    protected boolean isElementPresentBy(By locator) {
        try {
            WebElement element = find(locator);
            scrollToElement(element);
            if (element.isDisplayed()) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /* ===================== */
    /* ACTIONS - DESPLAZARSE */
    /* ===================== */

    /**
     * Desplazarse hacia arriba la cantidad de pixeles indicada
     */
    public void scrollUp(int pixels) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,-" + pixels + ")");
    }

    /**
     * Desplazarse hacia abajo la cantidad de píxeles indicada
     */
    public void scrollDown(int pixels) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0," + pixels + ")");
    }

    /**
     * Desplazarse hasta el elemento indicado + 300 píxeles extra
     */
    protected void scrollToElement(WebElement element) {
        if (((RemoteWebDriver) driver).getCapabilities().getBrowserName().equals("chrome")) {
            moveTo(element);
        } else {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        }
        scrollDown(300);
    }
}