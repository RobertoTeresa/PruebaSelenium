package com.appium.pages.externalPages;

import com.appium.pages.BasePageObject;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class GooglePage extends BasePageObject {

    private static final String GOOGLE_URL = "https://www.google.com/";

    /* CONSTRUCTOR */

    public GooglePage() {
    }

    /* ACTIONS */

    /** Devolver la url de google */
    public String getGoogleUrl() { return GOOGLE_URL; }
}