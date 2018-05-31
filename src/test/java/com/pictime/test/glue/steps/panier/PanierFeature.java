package com.pictime.test.glue.steps.panier;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Lorsque;
import cucumber.api.java.fr.Soit;
import net.thucydides.core.annotations.Steps;

/**
 * Definit les steps fonctionnels de la gestion du panier
 */

public class PanierFeature {

    @Steps
    PanierSteps PanierSteps;

    @Lorsque("^je cherche le produit \"([^\"]*)\" dans le moteur de recherche$")
    public void je_cherche_le_produit_dans_le_moteur_de_recherche(String nomProduit) throws Throwable {
        PanierSteps.rechercherProduit(nomProduit);
    }

    @Lorsque("^je choisis la première suggestion dans la liste$")
    public void je_choisis_la_première_suggestion_dans_la_liste() throws Exception {
        PanierSteps.chooseProductInSuggestion();
    }

    @Lorsque("^je clique sur le premier produit dans la liste des produits$")
    public void je_clique_sur_le_premier_produit_dans_la_liste_des_produits() throws Exception {
        PanierSteps.visualizeProductDetails();
    }

    @Lorsque("^j'ajoute ce produit dans mon panier$")
    public void j_ajoute_ce_produit_dans_mon_panier() throws Exception {
        PanierSteps.addToCart();
    }

    @Lorsque("^je consulte mon panier$")
    public void je_consulte_mon_panier() throws Exception {
        PanierSteps.consulterPanier();
    }

    @Alors("^je retrouve dans le panier le produit que j'ai ajouté$")
    public void je_retrouve_dans_le_panier_le_produit_que_j_ai_ajouté() throws Exception {
        PanierSteps.assertProductInCart();
    }
}
