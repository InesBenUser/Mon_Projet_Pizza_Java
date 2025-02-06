# 🍕 Mon projet Pizza - Documentation

## 📌 Description
Ce projet universitaire a pour objectif de s'entraîner aux bases des langages **Java** et **SQL** en développant une application de gestion de commandes de pizzas.

---

## 🗂️ Structure du projet
Le projet est organisé en plusieurs fichiers permettant son bon fonctionnement :

### 📂 **Classes principales**

#### **Pizza_connect.java**
- Gère la connexion à la base de données **MySQL**.
- Récupère et affiche les pizzas enregistrées en base.
- Permet d'ajouter de nouvelles pizzas en mémoire.

#### **PizzaInfo.java**
- Modèle représentant une pizza avec :
  - `nom` : Nom de la pizza
  - `quantite` : Quantité disponible
  - `ingredients` : Liste des ingrédients
- Permet de structurer les données pour éviter la manipulation brute des résultats SQL.

#### **Client.java & Client_connect.java**
- `Client.java` : Définit un client avec ses attributs (nom, adresse, etc.).
- `Client_connect.java` : Gère la connexion MySQL pour récupérer les clients depuis la base de données.

#### **Livreur.java & Livreur_connect.java**
- `Livreur.java` : Définit un livreur avec ses informations (nom, véhicule, etc.).
- `Livreur_connect.java` : Gère la connexion MySQL pour récupérer les livreurs depuis la base de données.

---

## 🔌 Connexion à la base de données
### **1️⃣ Configuration de MySQL**
- Assurez-vous que **MySQL est bien démarré**.
- Vérifiez les identifiants de connexion dans **Pizza_connect.java** :
  ```java
  private static final String URL = "jdbc:mysql://localhost:3306/pizzabox?serverTimezone=UTC";
  private static final String USER = "root";
  private static final String PASSWORD = "motdepasse";
  ```

### **2️⃣ Vérifier la connexion avec MySQL Connector/J**
- Ajoutez **`mysql-connector-java.jar`** à votre projet Java.
- Testez la connexion avec le fichier `TestConnexion.java` :
  ```java
  public static void main(String[] args) {
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
          System.out.println("✅ Connexion réussie !");
          conn.close();
      } catch (Exception e) {
          System.out.println("❌ Erreur de connexion : " + e.getMessage());
      }
  }
  ```

---

## 📌 Fonctionnalités principales
### 🔹 **Connexion MySQL**
- Établir une connexion à la base `pizzabox`.
- Gérer les erreurs de connexion et afficher un message clair en cas d'échec.

### 🔹 **Récupération des pizzas depuis la base de données**
- `Pizza_connect.java` exécute la requête suivante pour récupérer les pizzas :
  ```sql
  SELECT DESIGNPIZZ, TARIFPIZZ, NROPIZZ, image1_chemin FROM PIZZA;
  ```

### 🔹 **Stockage et affichage des pizzas**
- Utilisation d'une **ArrayList<PizzaInfo>** pour stocker les pizzas récupérées.
- Ajout manuel de pizzas en mémoire :
  ```java
  pizzaList.add(new PizzaInfo("Hawaïenne", 2, Arrays.asList("Tomate", "Mozzarella", "Ananas", "Jambon")));
  ```
- Affichage des pizzas :
  ```java
  for (PizzaInfo pizza : pizzaList) {
      System.out.println(pizza);
  }
  ```

### 🔹 **Gestion des clients et des livreurs**
- **Récupération des clients** depuis la base via `Client_connect.java`.
- **Récupération des livreurs** depuis la base via `Livreur_connect.java`.
- Affichage des clients et des livreurs après récupération.

---

## ⚠️ Problèmes fréquents et solutions
### ❌ **Erreur : Driver JDBC non trouvé**
🔹 **Solution** : Assurez-vous que `mysql-connector-java.jar` est bien ajouté au projet.

### ❌ **Erreur SQL : No suitable driver found**
🔹 **Solution** : Vérifiez que vous utilisez bien :
```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### ❌ **Accès refusé (`Access denied for user 'root'@'localhost'`)**
🔹 **Solution** : Vérifiez les identifiants dans `Pizza_connect.java` et dans MySQL avec :
```sql
SELECT user, host FROM mysql.user;
```

---

## 📌 Conclusion
🚀 Ce projet permet de s'entraîner aux bases de **Java**, **JDBC** et **SQL** en manipulant des données MySQL.





