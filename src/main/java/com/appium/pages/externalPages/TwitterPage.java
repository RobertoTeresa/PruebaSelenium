package com.appium.pages.externalPages;

import com.appium.pages.BasePageObject;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class TwitterPage extends BasePageObject {

    private static final String TWITTER_URL = "https://twitter.com/";

    /* CONSTRUCTOR */

    public TwitterPage() {
    }

    /* ACTIONS */

    /** Devolver la url de facebook */
    public String getTwitterUrl() { return TWITTER_URL; }
}