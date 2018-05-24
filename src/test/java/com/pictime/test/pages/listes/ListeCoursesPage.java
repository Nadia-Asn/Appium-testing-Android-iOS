package com.pictime.test.pages.listes;

import net.serenitybdd.core.pages.PageObject;

public abstract class ListeCoursesPage extends PageObject{
	/**
	 * Vérifie la présence d'un produit dans une liste de courses
	 * 
	 * @param nomProduit
	 */
	public abstract void produitDansListeCourses(String nomProduit);

	/**
	 * Accede à la liste de courses choisie
	 * 
	 * @param liste
	 */
	public abstract void selectListeCourses(String liste);

}
