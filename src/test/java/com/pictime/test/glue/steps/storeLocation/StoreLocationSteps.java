package com.pictime.test.glue.steps.storeLocation;

import com.pictime.test.common.TechnicalSteps;
import com.pictime.test.pages.magasins.LocalisationMagasinPage;
import com.pictime.test.pages.navigation.tabBar.TabBar;
import net.thucydides.core.annotations.Step;

public class StoreLocationSteps extends TechnicalSteps {

    @Step
    public void chercherMagasin() {
        getPage(LocalisationMagasinPage.class).searchStoreByCityName();
    }

    @Step
    public void choisirVille() { }

    @Step
    public void listeMagasins() {
        getPage(LocalisationMagasinPage.class).getMagasinsByCity();
    }

}
