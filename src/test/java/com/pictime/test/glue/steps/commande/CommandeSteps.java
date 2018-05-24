package com.pictime.test.glue.steps.commande;

import com.pictime.test.common.TechnicalSteps;
import com.pictime.test.pages.commande.CommandPage;
import com.pictime.test.pages.commande.delivery.Delivery;
import com.pictime.test.pages.commande.payment.Payment;

public class CommandeSteps extends TechnicalSteps {

    public void goToCommand() {

        getPage(CommandPage.class).goToCommand();
    }

    public void commandWithoutLogin() {

        getPage(CommandPage.class).commandWithoutLogin();
    }

    public void deliveryTypeHome() {

        getPage(Delivery.class).deliveryTypeHome();
    }

    public void fillDeliveryAddress(String rue, String cp, String ville) {
        getPage(Delivery.class).fillDeliveryAddress(rue,cp,ville);
    }

    public void validateDeliveryAddress() {

        getPage(Delivery.class).validateDeliveryAddress();
    }

    public void fillContactInformation(String fName, String lName, String email, String tel) {
        getPage(CommandPage.class).fillContactInformation(fName,lName,email,tel);
    }

    public void validateContactInformation() {

        getPage(CommandPage.class).validateContactInformation();
    }

    public void commandWithoutFidelity() {
        getPage(CommandPage.class).commandWithoutFidelity();
    }

    public void validateFidelity() {

        getPage(CommandPage.class).validateFidelity();
    }

    public void commandOnLinePayment() {

        getPage(Payment.class).commandOnLinePayment();
    }

    public void commandBankCardPayment() {

        getPage(Payment.class).commandBankCardPayment();
    }

    public void fillBankCardInformation(String numero, String date, String code) {
        getPage(Payment.class).fillBankCardInformation(numero, date, code);
    }

    public void validatePayment() {

        getPage(Payment.class).validatePayment();
    }

    public void checkCommandConfirmation() {

        getPage(CommandPage.class).checkCommandConfirmation();
    }

    public void PaymentKiabiStore() {
        getPage(Payment.class).kiabiStorePayment();
    }

    public void insertCodeCaptcha() {
        getPage(Payment.class).insertCodeCaptcha();
    }

    public void valideReservationEBooking() {
        getPage(Payment.class).validateEReservation();
    }

    public void deliveryKiabiStore() {
        getPage(Delivery.class).deliveryTypeKiabiStore();
    }

    public void geolocalisation() {
        getPage(Delivery.class).localiseKiabiStore();
    }

    public void chooseStoreKiabi() {
        getPage(Delivery.class).chooseKiabiStore();
    }

    public void validateKiabiStore() {
        getPage(Delivery.class).validateKiabiStore();
    }

    public void checkEresaConfirmed() {
        getPage(CommandPage.class).checkEresaConfirmed();
    }

    public void deliveryPickupPoint() {
        getPage(Delivery.class).deliveryTypePickupPoint();
    }

    public void selectPickupPoint() {
        getPage(Delivery.class).selectPickupPoint();
    }

    public void localisePickUpPoint() {
        getPage(Delivery.class).localisePickupPoint();
    }
}
