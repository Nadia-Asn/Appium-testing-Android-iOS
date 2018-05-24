package com.pictime.test.pages.compte.accoutCreation;

import net.serenitybdd.core.pages.PageObject;

public abstract class AccountCreationPage extends PageObject {
    public abstract void createAccount();

    public abstract void fillAccountInformation(String prenom, String nom, String email, String password, String code);

    public abstract void validateAccountCreation();

    public abstract void assertCreationAccountOK();
    public abstract String generateMailAdr();
}
