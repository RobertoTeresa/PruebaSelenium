package com.appium.stepDefinitions;

import com.appium.pages.ArticlePage;
import com.appium.utils.PagesFactory;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArticleSteps {

    ArticlePage articlePage = new ArticlePage();

    /* CUCUMBER STEPS */

    @Given("El usuario se encuentra en el artículo {string}")
    public void elUsuarioSeEncuentraEnElArticuloIndicado(String url) { articlePage.navigateArticle(url); }
}