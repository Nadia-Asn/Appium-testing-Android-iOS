package com.pictime.test.glue.steps.storeLocation;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Lorsque;
import net.thucydides.core.annotations.Steps;

/**
 * Definit les steps fonctionnels de la localisation des stores Kiabi
 */
public class LocalisationMagasinFeature {

    @Steps
    StoreLocationSteps storeLocationSteps;

    @Lorsque("^je tape \"([^\"]*)\" comme ville$")
    public void je_tape_comme_ville(String arg1) throws Exception {
        storeLocationSteps.chercherMagasin();
    }

    @Lorsque("^je choisi la première ville suggérée dans la liste des villes$")
    public void je_choisi_la_première_ville_suggérée_dans_la_liste_des_villes() throws Exception {
        storeLocationSteps.choisirVille();
    }

    @Lorsque("^j'appuie sur liste$")
    public void j_appuie_sur_liste() throws Exception {
        storeLocationSteps.listeMagasins();
    }

    @Alors("^la liste des magasins est affichée$")
    public void la_liste_des_magasins_est_affichée() throws Exception {

    }
}
