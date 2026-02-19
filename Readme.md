# Gestion de boîtes à livres – Capgemini : Back-end : 

## Sujet : 
Ce projet est un projet académique réalisé dans le cadre de l'UE Développement Web.  
Ce dépôt concerne la partie back-end, incluant les API REST et la gestion des opérations sur la base de données.

L'application est multi-utilisateurs :
- Administrateur
- Utilisateur authentifié
- Utilisateur grand public

## Fonctionnalités

### Utilisateur grand public
- Consultation des boîtes à livres disponibles dans la ville
- Visualisation des boîtes sur une carte
- Accès sans authentification

### Utilisateur authentifié
- Consultation de toutes les boîtes à livres
- Consultation de ses réservations
- Possibilité d’effectuer une réservation
- Impossible de créer de nouvelles boîtes  

### Administrateur
- Création de nouveaux utilisateurs
- Création de nouvelles boîtes à livres
- Gestion des réservations

## Réalisé par 
- Mamadou Coulibaly  
- rdVirgo


## Schéma de la base des données : 
### les différentes tables : 

```text 
+-------------------+------------+
| Tables_in_bookbox | Table_type |
+-------------------+------------+
| box               | BASE TABLE |
| coordinates       | BASE TABLE |
| reservation       | BASE TABLE |
| users             | BASE TABLE |
+-------------------+------------+
La table user
:                                                                          
 +----------+--------------------------------+------+-----+---------+----------------+
| Field    | Type                           | Null | Key | Default | Extra          |
+----------+--------------------------------+------+-----+---------+----------------+
| user_id  | int(11)                        | NO   | PRI | NULL    | auto_increment |
| email    | varchar(255)                   | NO   |     | NULL    |                |
| name     | varchar(255)                   | NO   |     | NULL    |                |
| password | varchar(255)                   | NO   |     | NULL    |                |
| surname  | varchar(255)                   | NO   |     | NULL    |                |
| username | varchar(255)                   | NO   | UNI | NULL    |                |
| role     | enum('ROLE_USER','ROLE_ADMIN') | NO   |     | NULL    |                |
+----------+--------------------------------+------+-----+---------+----------------+
La table box : 
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| box_id         | int(11)      | NO   | PRI | NULL    | auto_increment |
| coordinates_id | int(11)      | YES  | UNI | NULL    |                |
| quantity       | int(11)      | NO   |     | NULL    |                |
| description    | varchar(255) | YES  |     | NULL    |                |
| name           | varchar(255) | NO   |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
La table coordinates : 
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| coordinates_id | int(11)      | NO   | PRI | NULL    | auto_increment |
| latitude       | varchar(255) | NO   |     | NULL    |                |
| longitude      | varchar(255) | NO   |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+

La table reservation : 
+----------------+---------+------+-----+---------+-------+
| Field          | Type    | Null | Key | Default | Extra |
+----------------+---------+------+-----+---------+-------+
| box_id         | int(11) | NO   | PRI | NULL    |       |
| reservation_nb | int(11) | NO   |     | NULL    |       |
| user_id        | int(11) | NO   | PRI | NULL    |       |
+----------------+---------+------+-----+---------+-------+

```
## Architecture de projet : 
Le projet est basé sur une architecture MVC (Model – View – Controller).
Chaque module possède une responsabilité bien définie, ce qui facilite la maintenance et l’évolutivité.

Cette architecture est implémentée grâce à : l'utilisation de SpringBoot et le principe de Rest API.

Pour organiser notre travail nous avons structuré notre code comme suit : 
# Structure du projet (src)

```text
src
 └── main
     ├── java
     │   └── fr.tours.boitelivre
     │       ├── config
     │       │   └── SecurityConfig       # Implémente les règles d'accès aux API et gère les niveaux d'utilisateurs (Admin, User, Public)
     │       ├── controller                # Contient les controllers pour chaque entité, gérant les opérations CRUD côté utilisateur
     │       ├── dto                       # Contient les Data Transfer Objects pour sécuriser et structurer les échanges avec le frontend (ex. ne pas exposer les mots de passe)
     │       ├── filter
     │       │   └── JWTAuthFilter         # Filtre qui gère l'authentification et la vérification des tokens JWT
     │       ├── mapstruct                 # Contient les mappers MapStruct pour convertir les DTO en entités et inversement
     │       ├── model                     # Contient les entités JPA représentant les tables de la base de données, avec getters et setters
     │       ├── repository                # Contient les interfaces Repository pour accéder aux opérations CRUD sur chaque entité
     │       ├── service                   # Contient les services qui font le lien entre controllers et repositories pour les opérations métier
     │       └── BookBoxApplication        # Fichier principal avec la fonction main, point d’entrée du projet
     └── resources
         └── application.properties       # Fichier de configuration de l’application (connexion base de données, paramètres divers)
 └── target                                # Contient les fichiers générés après compilation et build
pom.xml                                    # Fichier Maven gérant les dépendances et bibliothèques utilisées

```
## Création d’un utilisateur Admin

Pour créer un utilisateur Admin, utiliser Postman ou insérer directement l’utilisateur dans la base de données en précisant le rôle `ROLE_ADMIN`.

Exemple :
```json
{
  "name": "admin1",
  "surname": "admin1",
  "username": "admin1",
  "email": "root@admin1.com",
  "password": "rootadmin",
  "role": "ROLE_ADMIN"
}
```
mémoriser le mot de passe , car il sera chiffré !!


## Les technologies et outils utilisés : 
- SpringBoot 
- Hibernate pour le JPA (connectivité avec la base des données et realisation des operations CRUD)
- Maven : pour la gestion des dependances.
- Java version 21 ou plus.

## Comment avoir le projet en local : 
NB : le frontend n’est pas nécessaire pour tester les API vous pouvez utiliser Postman.

- 1- aller dans le dépot github et cloner le projet en utilisant l'url HTTPS du dépot en faisant : 
 git clone https://github.com/rdVirgo/BookBox_Backend.git

- 2- Importer le projet dans un IDE

- 3- Vérifier la configuration JDK

- 4- Lancer la classe BookBoxApplication

- 5- Tester les API avec Postman à l’adresse :
http://localhost:8080




