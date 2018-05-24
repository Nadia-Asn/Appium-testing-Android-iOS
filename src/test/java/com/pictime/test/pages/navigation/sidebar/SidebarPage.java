package com.pictime.test.pages.navigation.sidebar;

import net.serenitybdd.core.pages.PageObject;


/**
 * Created by zeggaim on 17/05/2016.
 */
public abstract class SidebarPage extends PageObject{

	/**
	 * Accéder à un univers depuis le menu
	 * 
	 * @param univers
	 */
    public abstract void consulterUnivers(String univers);
    
    /**
     * Accéder à une catégorie depuis le menu
     * 
     * @param categorie
     */
    public abstract void consulterCategorie(String categorie);
    
    /**
     * Accéder à une catégorie depuis le menu
     * 
     * @param sousCategorie
     */
    public abstract void consulterSousCategorie(String sousCategorie);
    
    /**
     * Développer le achat express dans le menu
     */
    public abstract void clickAchatExpress();
    
    /**
     * Accéder à aux listes de courses depuis le menu
     */
    public abstract void clickListesCourses();
}
