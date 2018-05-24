# language: fr
Fonctionnalité: Achat d'un produit via l'application kiabi
  En tant que client
  Je veux utiliser le cannal de commande
  Afin de commander un produit via l'application


##################### Livraison en magasin - Paiement en magasin ############################

  @commandeMagasin @tunnel
  Scénario: Passer une commande en livraison en magasin et paiement en magasin
    Soit un client sur lapplication Kiabi
    Lorsque je passe le tutoriel
  #Et j'accède au shopping
    Et je choisis la première collection sur la page d'accueil
    Et je clique sur le premier produit dans la liste des produits
    Et j'ajoute ce produit dans mon panier
    Et je consulte mon panier
    Et je choisis de continuer ma commander
    Et je choisis de continuer sans compte client
    Et je choisis la livraison en magasin
    Et je choisis de me localiser
    Et je selectionne un magasin valide pamrmi les suggestions
    Et je valide mon choix
    Et je renseigne mes informations de contact
      | FName       | LName     | email                           | tel         |
      | toto        | titi      | nadia.ahassouni@pictime.com     | 0636363636  |
    Et je valide mes informations de contact
    Et je ne demande pas de carte de fidelite
    Et je valide mes avantages et fidelite
    Et je selectionne le payment en magasin
    Et je saisis le code de résérvation
    Et je valide ma réservation
    Alors la confirmation de ma commande est affichee

