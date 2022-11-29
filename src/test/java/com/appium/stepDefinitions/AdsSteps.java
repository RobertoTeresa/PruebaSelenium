package com.appium.stepDefinitions;

import com.appium.pages.AdsPage;
import com.appium.utils.PagesFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdsSteps {

    /* VARIABLES */

    AdsPage adsPage = new AdsPage();
    SoftAssert softAssert = new SoftAssert();
    boolean skinExists = false;

    /* CUCUMBER STEPS */

    @When("El usuario espera a que cargue la página por completo")
    public void elUsuarioESperaAQueCargueLaPaginaPorCompleto() {
        adsPage.waitAdElement("SKY1");
    }

    @Then("El usuario visualiza el contenedor SKIN o en su lugar los SKY")
    public void elUsuarioVisualizaElContenedorSkinOEnSuLugarLosSky() {
        skinExists = adsPage.isSkinElementPresent("raiSkinDesktop");
        if (!skinExists){
            boolean exists = adsPage.isAdsElementPresent("SKY1");
            softAssert.assertTrue(exists, "No se ha encontrado el contenedor SKY1");
            exists = adsPage.isAdsElementPresent("SKY2");
            softAssert.assertTrue(exists, "No se ha encontrado el contenedor SKY2");
            softAssert.assertAll();
        }
    }

    @And("En caso de no haber SKIN el contenedor tiene las dimensiones indicadas")
    public void enCasoDeNoHaberSkinElContenedorTieneLasDimensionesIndicadas(DataTable table) {
        if (!skinExists) {
            for (List<String> elem : table.asLists(String.class)) {
                boolean exists = adsPage.isAdsSizeCorrect(elem.get(0), elem.get(1));
                String elementSize = adsPage.getAdsDimensions(elem.get(0));
                String errorMessage = "Las dimensiones de " + elem.get(0) + " son " + elementSize + " y no cumple las indicadas: " + elem.get(1);
                Assert.assertTrue(exists, errorMessage);
            }
        }
    }

    @When("El usuario espera a que cargue el elemento {string}")
    public void elUsuarioEsperaAQueCargueElElemento(String name) {
        adsPage.waitAdElement(name);
    }

    @And("El usuario visualiza el elemento publicitario {string}")
    public void elUsuarioVisualizaElElementoPublicitario(String name) {
        boolean exists = adsPage.isAdsElementPresent(name);
        Assert.assertTrue(exists, "No se ha encontrado el contenedor " + name);
    }

    @And("El {string} tiene una de las dimensiones indicadas {string}")
    public void elElementoPublicitarioTieneUnaDeLasDimensionesIndicadas(String name, String size) {
        boolean exists = adsPage.isAdsSizeCorrect(name, size);
        String elementSize = adsPage.getAdsDimensions(name);
        String errorMessage = "Las dimensiones de " + name + " son " + elementSize + " y no cumple las indicadas: " + size;
        Assert.assertTrue(exists, errorMessage);
    }
}