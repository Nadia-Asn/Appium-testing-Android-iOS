package com.pictime.test.glue.steps.compte;

import cucumber.api.DataTable;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Lorsque;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

/**
 * Definit les steps fonctionnels de la gestion de création d'un nouveau compte client et le login
 */
public class CompteClientFeature {

    @Steps
    CompteClientSteps CompteClientSteps;

    //************* login ****************//

    @Lorsque("^je renseigne mes informations de compte$")
    public void je_renseigne_mes_informations_de_compte(DataTable info) throws Exception {
        for(Map<String, String> map: info.asMaps(String.class, String.class) ){
            CompteClientSteps.fillAccountInformation(map.get("prenom"), map.get("nom"), map.get("email"), map.get("password"),map.get("code"));
        }
    }

    @Lorsque("^il valide la création de compte$")
    public void il_valide_la_création_de_compte() throws Exception {
        CompteClientSteps.validateAccountCreation();
    }

    @Alors("^la page de login est affichée$")
    public void la_page_de_login_est_affichée() throws Exception {
        CompteClientSteps.assertAccountCreation();
    }


    //************** connection *************//


    @Lorsque("^j'accède à la gestion de compte$")
    public void j_accède_à_la_gestion_de_compte() throws Exception {
        CompteClientSteps.goToAccount();
    }

    @Lorsque("^je renseigne mes identifiants pour me connecter$")
    public void je_renseigne_mes_identifiants_pour_me_connecter(DataTable identifiants) throws Exception {
        for(Map<String,String> map: identifiants.asMaps(String.class, String.class)) {
            CompteClientSteps.login(map.get("email"), map.get("password"));
        }
    }

    @Lorsque("^il valide la connexion$")
    public void il_valide_la_connexion() throws Exception {
        CompteClientSteps.validateLogin();
    }

    @Alors("^la page indiquant que je suis connectée est affichée$")
    public void la_page_indiquant_que_je_suis_connectée_est_affichée() throws Exception {
        CompteClientSteps.connectionSuccess();
    }
}
