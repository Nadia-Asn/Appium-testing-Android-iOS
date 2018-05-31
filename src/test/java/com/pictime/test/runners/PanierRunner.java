package com.pictime.test.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ahassounin
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/ajoutPanier.feature", glue = { "com.pictime.test.glue" }, tags = {"@panier"})
public class PanierRunner {
}
