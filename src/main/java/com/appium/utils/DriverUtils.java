package com.appium.utils;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverUtils {

    private static ChromeOptions optionsChrome;

    @SuppressWarnings("deprecation")
    public static AppiumDriver setUpDriver(AppiumDriver driver, String browser, int timeout) {
        /*switch (browser) {
            case "chrome-desktop":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                optionsChrome = setCapabilities(browser);
                driver = WebDriverManager.chromedriver().capabilities(optionsChrome).create();
                break;
            case "chrome-mobile":
                break;
            case "safari-desktop":
                driver = WebDriverManager.safaridriver().create();
                break;
        }*/
        return driver;
    }

    public static void quitDriver(WebDriver driver) {
        driver.quit();
    }

    public static ChromeOptions setCapabilities(String browser) {
        switch (browser) {
            case "chrome-desktop":
                optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--no-sandbox");
                optionsChrome.addArguments("--disable-gpu");
                optionsChrome.addArguments("--disable-dev-shm-usage");
                optionsChrome.addArguments("--disable-site-isolation-trials");
                break;
            case "chrome-mobile":
                break;
        }
        return optionsChrome;
    }
}