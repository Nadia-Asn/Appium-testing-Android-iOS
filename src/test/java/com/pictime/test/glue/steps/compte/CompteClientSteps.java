package com.pictime.test.glue.steps.compte;

import com.pictime.test.common.TechnicalSteps;
import com.pictime.test.pages.compte.login.LoginPage;
import com.pictime.test.pages.compte.accoutCreation.AccountCreationPage;
import com.pictime.test.pages.navigation.tabBar.TabBar;
import net.thucydides.core.annotations.Step;

public class CompteClientSteps extends TechnicalSteps {
    /**
     * Login & account creation
     */

    @Step
    public void goToAccount() {
        getPage(TabBar.class).myAccount();
    }

    @Step
    public void login(String userName,String passWord){
        getPage(LoginPage.class).login(userName,passWord);
    }

    @Step
    public void validateLogin() {
        getPage(LoginPage.class).validateLogin();
    }

    @Step
    public void connectionSuccess() {
        getPage(LoginPage.class).checkConnectionSuccess();
    }

    @Step
    public void fillAccountInformation(String prenom, String nom, String email, String password, String code) {
        getPage(AccountCreationPage.class).fillAccountInformation( prenom, nom, email, password, code);}

    @Step
    public void validateAccountCreation() { getPage(AccountCreationPage.class).validateAccountCreation(); }

    @Step
    public void assertAccountCreation() {
        getPage(AccountCreationPage.class).assertCreationAccountOK();
    }
}
