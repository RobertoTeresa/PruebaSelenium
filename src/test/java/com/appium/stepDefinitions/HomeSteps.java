package com.appium.stepDefinitions;

import com.appium.pages.HomePage;
import com.appium.utils.PagesFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeSteps {

    HomePage homePage = new HomePage();

    /* CUCUMBER STEPS */

    @Given("El usuario se encuentra en la página de inicio")
    public void elUsuarioSeEncuentraEnLaPaginaDeInicio() {
        homePage.navigateHome();
    }

    @And("El usuario se desplaza hasta el listado de artículos")
    public void elUsuarioSeDesplazaHastaElListadoDeArticulos() {
        homePage.scrollDown(3500);
        homePage.waitSeconds(3);
    }
}