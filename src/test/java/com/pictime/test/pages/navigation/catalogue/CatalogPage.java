package com.pictime.test.pages.navigation.catalogue;

import net.serenitybdd.core.pages.PageObject;

/**
 * Created by zeggaim on 17/05/2016.
 */
public abstract class CatalogPage extends PageObject{

    /**
     * Ajoute le produit à une liste de courses
     * 
     * @param liste
     * @param nomProduit
     */
	public abstract void addToBuyList(String liste, String nomProduit);

	public abstract void visualizeProductDetails();
}
