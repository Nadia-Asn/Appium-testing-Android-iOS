package com.pictime.test.runners;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ahassounin
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/achat/commandePaiementCarte.feature", glue = { "com.pictime.test.glue" }, tags = {"@commandeCarte"})
public class commandePaiementCarteRunner {
}
