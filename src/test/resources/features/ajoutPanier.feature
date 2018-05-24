# language: fr
Fonctionnalité: Navigation au sein de l'application Kiabi
  En tant que client
  Je veux utiliser le moteur de recherche
  Afin de retrouver un produit et l'ajouter à mon panier

  @panier
  Scénario: chercher un produit et l'ajouter au panier
    Soit un client sur lapplication Kiabi
    Lorsque je passe le tutoriel
    Et je cherche le produit "Robe" dans le moteur de recherche
    Et je choisis la première suggestion dans la liste
    Et je clique sur le premier produit dans la liste des produits
    Et j'ajoute ce produit dans mon panier
    Et je consulte mon panier
    Alors je retrouve dans le panier le produit que j'ai ajouté
