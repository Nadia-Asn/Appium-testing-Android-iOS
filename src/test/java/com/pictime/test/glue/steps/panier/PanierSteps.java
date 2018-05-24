package com.pictime.test.glue.steps.panier;

import com.pictime.test.common.TechnicalSteps;
import com.pictime.test.pages.navigation.catalogue.CatalogPage;
import com.pictime.test.pages.navigation.homePage.HomePage;
import com.pictime.test.pages.navigation.panier.PanierPage;
import com.pictime.test.pages.navigation.tabBar.TabBar;
import net.thucydides.core.annotations.Step;

public class PanierSteps extends TechnicalSteps {

    private static final long serialVersionUID = 8719348179721640957L;



    /**
     * Recherche un produit
     *
     * @param nomProduit
     */
    @Step
    public void rechercherProduit(String nomProduit) {
        getPage(TabBar.class).searchProduct(nomProduit);
    }

    @Step
    public void chooseProductInSuggestion() {
        getPage(TabBar.class).chooseProductInSuggestion();
    }

    @Step
    public void visualizeProductDetails() {
        getPage(CatalogPage.class).visualizeProductDetails();
    }

    @Step
    public void addToCart() {
        getPage(PanierPage.class).addToCart();
    }

    @Step
    public void assertProductInCart() {
        getPage(PanierPage.class).checkProductInCart();
    }

    @Step
    public void consulterPanier() {
        getPage(PanierPage.class).consulterMonPanier();
    }
}
