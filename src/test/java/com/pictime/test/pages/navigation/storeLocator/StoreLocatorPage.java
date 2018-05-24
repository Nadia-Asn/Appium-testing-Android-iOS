package com.pictime.test.pages.navigation.storeLocator;

import net.serenitybdd.core.pages.PageObject;


/**
 * Created by zeggaim on 17/05/2016.
 */
public abstract class StoreLocatorPage extends PageObject{

	/**
	 * Sélectionne un magasin dans la liste
	 * 
	 * @param magasin
	 */
    public abstract void chooseStore(String magasin);

    /**
     * Renseigne une ville et lance la recherche des magasins à proximité
     * 
     * @param magasin
     */
	public abstract void renseignerVille(String magasin);
}
