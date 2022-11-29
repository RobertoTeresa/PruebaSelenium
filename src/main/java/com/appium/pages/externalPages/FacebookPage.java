package com.appium.pages.externalPages;

import com.appium.pages.BasePageObject;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class FacebookPage extends BasePageObject {

    private static final String FACEBOOK_URL = "https://www.facebook.com/";

    /* CONSTRUCTOR */

    public FacebookPage() {
    }

    /* ACTIONS */

    /** Devolver la url de facebook */
    public String getFacebookUrl() { return FACEBOOK_URL; }
}