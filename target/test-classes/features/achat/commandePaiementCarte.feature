# language: fr
Fonctionnalité: Achat d'un produit via l'application kiabi
  En tant que client
  Je veux utiliser le cannal de commande
  Afin de commander un produit via l'application


  ###################### Livraison domicile - Paiement carte bancaire ######################

  @commandeCarte @tunnel @carteBancaire
  Scénario: Passer une commande en livraison a domicile paiement carte bancaire
    Soit un client sur lapplication Kiabi
    Lorsque je passe le tutoriel
    Et je choisis la première collection sur la page d'accueil
    Et je clique sur le premier produit dans la liste des produits
    Et j'ajoute ce produit dans mon panier
    Et je consulte mon panier
    Et je choisis de continuer ma commander
    Et je choisis de continuer sans compte client
    Et je chois la livraison a domicile
    Et je renseigne mon adresse
      |rue                  |cp       |ville  |
      |10 RUE NATIONALE     |59800    |LILLE  |
    Et je confirme les informations de mon adresse
    Et je renseigne mes informations de contact
      | FName        | LName          | email                 | tel         |
      | nadia        | ahassouni      | nadia@pictime.com     | 0636363636  |
    Et je valide mes informations de contact
    Et je ne demande pas de carte de fidelite
    Et je valide mes avantages et fidelite
    Et je choisis de payer en ligne
    Et je choisis de payer par carte bancaire
    Et je renseigne les informations de ma carte bancaire
      | numero               |  date    | code |
      | 4444333322221111     |  0220    | 254  |
    Et je valide  mon paiement
    Alors la confirmation de ma commande est affichee

