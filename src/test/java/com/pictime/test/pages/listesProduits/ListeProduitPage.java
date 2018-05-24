package com.pictime.test.pages.listesProduits;

import net.serenitybdd.core.pages.PageObject;

public abstract class ListeProduitPage extends PageObject{
	
	public abstract void verifierProduitDansLaListe(String produit);
	
	public abstract void choisirProduitDansLaListe(String produit);
}
