package com.pictime.test.pages.navigation.panier;

import net.serenitybdd.core.pages.PageObject;

/**
 * Created by ahassounin
 */
public abstract class PanierPage extends PageObject{

	public abstract void consulterMonPanier();

    public abstract void addToCart();

	public abstract void checkProductInCart();
}
