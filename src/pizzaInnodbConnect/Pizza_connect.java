package pizzaInnodbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pizza_connect {
    private static final String URL = "jdbc:mysql://localhost:3306/pizzabox"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    public static Connection getConnection() {
        try {
            // Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<PizzaInfo> getPizzasFromDB(Connection cn) {
        List<PizzaInfo> pizzaList = new ArrayList<>();
        String sql = "SELECT DESIGNPIZZ, TARIFPIZZ, NROPIZZ, image1_chemin FROM PIZZA";
        
        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("----------- Récupération des données MySQL ------------------------");
                PizzaInfo p = new PizzaInfo(
                    rs.getString("DESIGNPIZZ"),
                    5, // Quantité par défaut
                    Arrays.asList("Ingrédient inconnu") 
                );
                pizzaList.add(p);
                System.out.println(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzaList;
    }

    public static void main(String[] args) {
        System.out.println("Connexion à MySQL pizzaboxinnodb...");
        Connection cn = getConnection();

        if (cn != null) {
            System.out.println("Connexion réussie ! Récupération des données...");
            List<PizzaInfo> pizzaList = getPizzasFromDB(cn);

            // Ajout manuel de pizzas
            pizzaList.add(new PizzaInfo("Hawaïenne", 2, Arrays.asList("Tomate", "Mozzarella", "Ananas", "Jambon")));
            pizzaList.add(new PizzaInfo("Végétarienne", 1, Arrays.asList("Tomate", "Mozzarella", "Champignons", "Poivrons", "Oignons")));

            // Affichage des pizzas après ajout
            System.out.println("\nListe complète des pizzas :");
            for (PizzaInfo pizza : pizzaList) {
                System.out.println(pizza);
            }
        } else {
            System.out.println("Échec de connexion à la base de données !");
        }
    }
}
