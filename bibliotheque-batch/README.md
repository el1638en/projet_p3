- Pour utiliser Gmail comme serveur SMTP, penser à autoriser l'accès aux applications  : https://myaccount.google.com/security?pli=1#connectedapps
- Pour ajouter le lancement à un crontab : 
Taper crontab -e pour éditer le crontab du serveur
Ajouter la ligne ci-dessous pour un lancement tous les jours à 00:00

0 0 * * * java -jar /path/to/bibliotheque-batch.jar