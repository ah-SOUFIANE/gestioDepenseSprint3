# Gestion des Dépenses d’École

##  Logo de l'Application
<img src="./logo.jpg" alt="Logo Gestion des Dépenses Étudiants" width="200"/>

##  Description
La **Gestion des Dépenses d’École** est une application **Java Swing** développée pour faciliter la gestion des dépenses scolaires.

Elle centralise toutes les informations relatives :
- Aux **étudiants**
- Aux **dépenses réalisées**
- Aux **paiements effectués**

 Cette solution offre une interface conviviale permettant aux responsables de **suivre et contrôler** les opérations financières liées aux activités pédagogiques et parascolaires.

---

##  Contexte
Dans un établissement scolaire, la gestion des dépenses est un défi majeur :
- Frais d’inscription
- Paiements des étudiants
- Autres dépenses diverses

 Aujourd'hui, ces opérations se font souvent sur Excel ou sur des notes papier, ce qui entraîne :
- Une perte de temps à chercher des informations
- Des erreurs de calcul
- Des difficultés à générer des rapports fiables

---

##  Objectifs
- Centraliser toutes les informations dans une base de données
- Faciliter la gestion des :
  - Étudiants
  - Dépenses
  - Paiements
- Permettre l’ajout, la modification et la suppression des enregistrements
- Générer des **rapports financiers fiables**
- Offrir un **suivi des paiements** en temps réel
- **Filtrer les paiements** par statut (Payé / Non Payé)
- **Optimiser la recherche**

---

##  Fonctionnalités
- Ajouter / Modifier / Supprimer :
  - Étudiants
  - Dépenses
  - Paiements
- Afficher les paiements dans un tableau
- Générer des rapports de paiements
- Visualiser les montants des dépenses par étudiant
- Rechercher un paiement par :
  - Nom de l'étudiant
  - Statut du paiement

---

##  Technologies utilisées
- Java SE
- Swing (Interface Graphique)
- JDBC (Connexion à la base de données MySQL)
- MySQL (Base de données)

---

##  Diagrammes
- Diagramme de classes 

![Aperçu de l'application](./Screenshot%202025-03-23%20111307.png)

- Diagramme de cas d'utilisation 

![Aperçu de l'application](Screenshot%202025-03-23%20104634.png)

---
 ##   Schéma SQL de la Base de Données
 ```sql
CREATE TABLE Etudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Depense (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL,
    montant DOUBLE NOT NULL,
    date DATE NOT NULL
);

CREATE TABLE Paiement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    etudiant_id INT NOT NULL,
    depense_id INT NOT NULL,
    date_paiement DATE NOT NULL,
    statut ENUM('Payé', 'Non Payé') DEFAULT 'Non Payé',
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id) ON DELETE CASCADE,
    FOREIGN KEY (depense_id) REFERENCES Depense(id) ON DELETE CASCADE
);

CREATE TABLE Utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'comptable', 'etudiant') NOT NULL
);
```
---
---
## Architecture du projet :
![Aperçu de l'application](./Architecture du projet.jpg)
##  Exécution
- Ouvrir le projet dans **NetBeans**
- Exécuter la classe `MDIApplication.java`

---

## 🎥 Démonstration Vidéo
https://github.com/user-attachments/assets/81362b27-5042-40ee-a336-79e5f2669ed6
