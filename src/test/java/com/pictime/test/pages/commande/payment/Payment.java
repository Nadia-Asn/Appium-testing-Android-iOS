package com.pictime.test.pages.commande.payment;

import net.serenitybdd.core.pages.PageObject;

public abstract class Payment extends PageObject {
    public abstract void commandOnLinePayment();

    public abstract void commandBankCardPayment();

    public abstract void fillBankCardInformation(String numero, String date, String code);

    public abstract void validatePayment();

    public abstract void kiabiStorePayment();

    public abstract void insertCodeCaptcha();

    public abstract void validateEReservation();
}
