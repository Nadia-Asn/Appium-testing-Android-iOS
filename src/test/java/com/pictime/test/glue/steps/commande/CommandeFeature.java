package com.pictime.test.glue.steps.commande;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Lorsque;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

/**
 * Definit les steps fonctionnels de la gestion de tunnel de commande sur Kiabi
 */
public class CommandeFeature {

    @Steps
    CommandeSteps command;

    @Lorsque("^je choisis de continuer ma commander$")
    public void je_choisis_de_continuer_ma_commander() throws Exception {
        command.goToCommand();
    }

    @Lorsque("^je choisis de continuer sans compte client$")
    public void je_choisis_de_continuer_sans_compte_client() throws Exception {
        command.commandWithoutLogin();
    }

    @Lorsque("^je chois la livraison a domicile$")
    public void je_chois_la_livraison_a_domicile() throws Exception {
        command.deliveryTypeHome();
    }

    @Lorsque("^je renseigne mon adresse$")
    public void je_renseigne_mon_adresse(DataTable adr) throws Exception {
         for (Map<String,String> map : adr.asMaps(String.class, String.class)) {
            command.fillDeliveryAddress(map.get("rue"),map.get("cp"),map.get("ville"));
        }
    }

    @Lorsque("^je confirme les informations de mon adresse$")
    public void je_confirme_les_informations_de_mon_adresse() throws Exception {
        command.validateDeliveryAddress();
    }

    @Lorsque("^je renseigne mes informations de contact$")
    public void je_renseigne_mes_informations_de_contact(DataTable infoContact) throws Exception {
        for (Map<String,String> map : infoContact.asMaps(String.class, String.class)) {
            command.fillContactInformation(map.get("FName"),map.get("LName"),map.get("email"), map.get("tel"));
            }
    }

    @Lorsque("^je valide mes informations de contact$")
    public void je_valide_mes_informations_de_contact() throws Exception {
        command.validateContactInformation();
    }

    @Lorsque("^je ne demande pas de carte de fidelite$")
    public void je_ne_demande_pas_de_carte_de_fidelite() throws Exception {
        command.commandWithoutFidelity();
    }

    @Lorsque("^je valide mes avantages et fidelite$")
    public void je_valide_mes_avantages_et_fidelite() throws Exception {
        command.validateFidelity();
    }

    @Lorsque("^je choisis de payer en ligne$")
    public void je_choisis_de_payer_en_ligne() throws Exception {
        command.commandOnLinePayment();
    }

    @Lorsque("^je choisis de payer par carte bancaire$")
    public void je_choisis_de_payer_par_carte_bancaire() throws Exception {
        command.commandBankCardPayment();
    }

    @Lorsque("^je renseigne les informations de ma carte bancaire$")
    public void je_renseigne_les_informations_de_ma_carte_bancaire(DataTable carteBancaireInfo) throws Exception {
        for (Map<String,String> map : carteBancaireInfo.asMaps(String.class, String.class)) {
            command.fillBankCardInformation(map.get("numero"), map.get("date"),map.get("code"));
        }
    }

    @Lorsque("^je valide  mon paiement$")
    public void je_valide_mon_paiement() throws Exception {
        command.validatePayment();
    }

    @Alors("^la confirmation de ma commande est affichee$")
    public void la_confirmation_de_ma_commande_est_affichee() throws Exception {
        command.checkCommandConfirmation();
    }

    // ********************** livraison magasin ******************************* //


    @Lorsque("^je choisis la livraison en magasin$")
    public void je_choisis_la_livraison_en_magasin() throws Exception {
        command.deliveryKiabiStore();
    }


    @Lorsque("^je choisis de me localiser$")
    public void je_choisis_de_me_localiser() throws Exception {
        command.geolocalisation();
    }

    @Lorsque("^je selectionne un magasin valide pamrmi les suggestions$")
    public void je_selectionne_un_magasin_valide_pamrmi_les_suggestions() throws Exception {
        command.chooseStoreKiabi();
    }

    @Lorsque("^je valide mon choix$")
    public void je_valide_mon_choix() throws Exception {
        command.validateKiabiStore();
    }

    @Lorsque("^je selectionne le payment en magasin$")
    public void je_selectionne_le_payment_en_magasin() throws Exception {
        command.PaymentKiabiStore();
    }

    @Lorsque("^je saisis le code de résérvation$")
    public void je_saisis_le_code_de_résérvation() throws Exception {
        command.insertCodeCaptcha();
    }

    @Lorsque("^je valide ma réservation$")
    public void je_valide_ma_réservation() throws Exception {
        command.valideReservationEBooking();
    }

    @Alors("^la confirmation de ma eresa est affichee$")
    public void la_confirmation_de_ma_eresa_est_affichee() throws Exception {
        command.checkEresaConfirmed();
    }

    // ********************** livraison point relais ******************************* //

    @Lorsque("^je choisis la livraison en point relais$")
    public void je_choisis_la_livraison_en_point_relais() throws Exception {
        command.deliveryPickupPoint();
    }

    @Lorsque("^je choisis de localiser les points de retraits à proximite$")
    public void je_choisis_de_localiser_les_points_de_retraits_à_proximite() throws Exception {
        command.localisePickUpPoint();
    }

    @Lorsque("^je selectionne un point relais valide parmi les suggestions$")
    public void je_selectionne_un_point_relais_valide_parmi_les_suggestions() throws Exception {
        command.selectPickupPoint();
    }


}
