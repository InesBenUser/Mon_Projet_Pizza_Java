package pizzaInnodbConnect;

import java.util.List;
import java.util.ArrayList;

public class PizzaInfo {
    private String nom;
    private int quantite;
    private List<String> ingredients;

    // Constructeur
    public PizzaInfo(String nom, int quantite, List<String> ingredients) {
        this.nom = nom;
        this.quantite = quantite;
        this.ingredients = new ArrayList<>(ingredients);
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public List<String> getIngredients() { return ingredients; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    // Affichage des infos
    @Override
    public String toString() {
        return "Pizza: " + nom + ", Quantité: " + quantite + ", Ingrédients: " + ingredients;
    }
}
