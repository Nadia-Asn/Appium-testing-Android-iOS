# language: fr
Fonctionnalité: Lacalisation des magasins
  En tant que client
  Je veux l'option de localisation
  Afin de retrouver un magasin

    @store
    Scénario: Utiliser la localisation des magasins
	Soit un client sur lapplication Kiabi
    Lorsque je passe le tutoriel
    Et je choisi magasin dans le menu
    Et je tape "Lille" comme ville
    Et je choisi la première ville suggérée dans la liste des villes
    Et j'appuie sur liste
    Alors la liste des magasins est affichée

