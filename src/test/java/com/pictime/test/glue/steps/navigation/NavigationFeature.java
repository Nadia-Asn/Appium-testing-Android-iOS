package com.pictime.test.glue.steps.navigation;

import cucumber.api.PendingException;
import cucumber.api.java.fr.Lorsque;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

/**
 * Definit les steps fonctionnels de la gestion de navigation à partir de la Home page
 */
public class NavigationFeature {

    @Steps
    NavigationSteps navigation;

    @Lorsque("^je je choisis de créer un compte$")
    public void je_je_choisis_de_créer_un_compte() throws Exception {
        navigation.createAccount();
    }

    @Lorsque("^je passe le tutoriel$")
    public void je_passe_le_tutoriel() throws Throwable {
        navigation.je_passe_le_tutoriel();
    }

    @Lorsque("^je choisi magasin dans le menu$")
    public void je_choisi_magasin_dans_le_menu() throws Exception {
        navigation.accederMagasins();
    }

    @Lorsque("^j'accède au shopping$")
    public void j_accède_au_shopping() throws Exception {
    }

    @Lorsque("^je choisis la première collection sur la page d'accueil$")
    public void je_choisis_la_première_collection_sur_la_page_d_accueil() throws Exception {
        navigation.accederCollection();
    }


}
