package com.pictime.test.glue.steps.navigation;

import com.pictime.test.common.TechnicalSteps;
import com.pictime.test.pages.compte.accoutCreation.AccountCreationPage;
import com.pictime.test.pages.navigation.homePage.HomePage;
import com.pictime.test.pages.navigation.tabBar.TabBar;
import net.thucydides.core.annotations.Step;

public class NavigationSteps extends TechnicalSteps {

    @Step
    public void createAccount() { getPage(AccountCreationPage.class).createAccount(); }

    @Step
    public void je_passe_le_tutoriel() { getPage(HomePage.class).clickNextTuto(); }

    @Step
    public void accederMagasins() {
        getPage(TabBar.class).stores();
    }

    @Step
    public void accederCollection() {
        getPage(TabBar.class).gotoCollection();
    }
}
