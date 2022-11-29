package com.appium.stepDefinitions;

import com.appium.pages.HeaderPage;
import com.appium.utils.PagesFactory;
import io.cucumber.java.en.And;

public class HeaderSteps {

    HeaderPage headerPage = new HeaderPage();

    /* CUCUMBER STEPS */

    @And("El usuario acepta el pop-up de cookies")
    public void elUsuarioAceptaElPopUpDeCookies() { headerPage.clickAcceptCookies(); }
}