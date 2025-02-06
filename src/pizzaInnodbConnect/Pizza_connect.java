package pizzaInnodbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza_connect {
    private static final String URL = "jdbc:mysql://localhost:3306/pizzabox"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    public static Connection getConnection() {
        try {
            // Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<PizzaInfo> getPizzasFromDB(Connection cn) {
        Map<String, PizzaInfo> pizzaMap = new HashMap<>();
        String sql = """
        	    SELECT ingredient.NOMINGR, pizza.DESIGNPIZZ, composer.QTECOMP
        	    FROM ingredient
        	    JOIN composer ON ingredient.CODEINGR = composer.CODEINGR
        	    JOIN pizza ON pizza.nropizz = composer.nropizz
        	    """;

        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String pizzaName = rs.getString("DESIGNPIZZ");
                String ingredient = rs.getString("NOMINGR");
                int quantity = rs.getInt("QTECOMP");

                pizzaMap.putIfAbsent(pizzaName, new PizzaInfo(pizzaName, 1, new ArrayList<>()));
                PizzaInfo pizza = pizzaMap.get(pizzaName);
                pizza.getIngredients().add(ingredient + " (x" + quantity + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(pizzaMap.values());
    }

    public static void main(String[] args) {
        System.out.println("Connexion à MySQL pizzaboxinnodb...");
        Connection cn = getConnection();

        if (cn != null) {
            System.out.println("Connexion réussie ! Récupération des données...");
            List<PizzaInfo> pizzaList = getPizzasFromDB(cn);

            // Affichage de toutes les pizzas avec leurs ingrédients
            System.out.println("\n🍕 Liste des pizzas avec leurs ingrédients :");
            for (PizzaInfo pizza : pizzaList) {
                System.out.println(pizza);
            }
        } else {
            System.out.println("Échec de connexion à la base de données !");
        }
    }
}
