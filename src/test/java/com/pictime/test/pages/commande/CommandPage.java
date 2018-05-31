package com.pictime.test.pages.commande;

import net.serenitybdd.core.pages.PageObject;

/**
 * Created by ahassounin
 */
public abstract class CommandPage extends PageObject {
    public abstract void goToCommand();

    public abstract void commandWithoutLogin();

    public abstract void fillContactInformation(String fName, String lName, String email, String tel);

    public abstract void validateContactInformation();

    public abstract void commandWithoutFidelity();

    public abstract void validateFidelity();

    public abstract void checkCommandConfirmation();

    public abstract void checkEresaConfirmed();
}
