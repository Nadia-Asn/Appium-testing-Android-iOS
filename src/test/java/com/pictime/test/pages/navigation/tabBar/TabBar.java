package com.pictime.test.pages.navigation.tabBar;

import net.serenitybdd.core.pages.PageObject;

/**
 *
 * Created by ahassounin
 *
 */
public abstract class TabBar extends PageObject {

    /**
     * Recherche un produit dans la barre de recherche
     *
     * @param nomProduit
     */
	public abstract void searchProduct(String nomProduit);

	public abstract void chooseProductInSuggestion();

	/**
	 * Accéder à mon compte client
	 */
	public abstract void myAccount();

	/**
	 * Accéder aux magasins Kiabi
	 */
    public abstract void stores();

	public abstract void gotoCollection();


}
