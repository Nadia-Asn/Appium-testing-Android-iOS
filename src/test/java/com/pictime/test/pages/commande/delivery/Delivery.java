package com.pictime.test.pages.commande.delivery;

import net.serenitybdd.core.pages.PageObject;

/**
 * Created by ahassounin
 */
public abstract class Delivery extends PageObject {

    public abstract void deliveryTypeHome();

    public abstract void fillDeliveryAddress(String street, String pc, String city);

    public abstract void validateDeliveryAddress();


    public abstract void deliveryTypeKiabiStore();

    public abstract void localiseKiabiStore();

    public abstract void chooseKiabiStore();

    public abstract void validateKiabiStore();

    public abstract void deliveryTypePickupPoint();

    public abstract void selectPickupPoint();

    public abstract void localisePickupPoint();
}
