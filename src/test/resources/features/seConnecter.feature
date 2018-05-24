# language: fr
Fonctionnalité: Connection à l'application Kiabi
  En tant que cliente
  Je veux me connecter à l'application Kiabi
  Afin d'accéder à mon compte

    @connection
    Scénario: connection à l'application
	Soit un client sur lapplication Kiabi
    Lorsque je passe le tutoriel
    Et j'accède à la gestion de compte
    Et je renseigne mes identifiants pour me connecter
        | email                           |  password    |
        | nadia.ahassouni@pictime.com     |  Pictime01   |
    Et il valide la connexion
    Alors la page indiquant que je suis connectée est affichée
