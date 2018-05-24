# language: fr
Fonctionnalité: Créer un compte client
  En tant que nouvelle cliente
  Je veux créer un compte client
  Afin d'accéder à d'autres fonctionnalitées de l'application

  @compteClient
  Scénario: créer un nouveau compte client
    Soit un client sur lapplication Kiabi
    Lorsque je passe le tutoriel
    Et j'accède à la gestion de compte
    Et je je choisis de créer un compte
    Et je renseigne mes informations de compte
      |  prenom  | nom           | email          | password   | code  |
      |  nadia   | pictime       | test@test.fr   | testtest1  | 12345 |
    Et il valide la création de compte
    Alors la page de login est affichée
