Ce projet nécessite :


                 
 -maven 3.6.0 installé dans votre environnement de développement (voir : https://maven.apache.org/install.html)


 
 -tomcat 8.5 installé dans votre environnement de développement (voir :https://tomcat.apache.org/tomcat-8.0-doc/setup.html)


   
 - glassfish 5.0 installé dans votre environnement de développement               
 - java jdk1.8



-------------------------------Creation de la base de données--------------------------------------


Base de données Postgres SQL:

- Installer PostgreSQL 11.1
- Installer Dbeaver
- Cliquer sur "Creer une nouvelle connexion"
- Selectionner PostGreSql
- Renseigner les user et mdp
- Selectionner l'editeur SQL
- Executer le script 2_init_db.sql puis init_db.sql
- user: bibliot 
- mdp: admin


-------------------------------Build du projet-----------------------------------------------------




Ouvrir la console et aller à la source du dossier

Entrer la ligne de commande : mvn install



-------------------------------Lancement du webservice---------------------------------------------


Allez dans le repertoire d'installation de votre glassfish \bin et lancer le script asadmin.bat
la console s'ouvre, lancez le serveur glassfish en tapant la commande "start-domain".



-------------------------------Deploiement de l'application web------------------------------------



Copier le dossier webapp et le bibliot-webapp.war dvers le sous-dossier webapps de votre installation tomcat

Ouvrir une troisieme console, aller au dossier d'installation tomcat/bin et ecrire en ligne de commande 
catalina.bat start



-------------------------------Lancement du batch---------------------------------------------------


