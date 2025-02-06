package pizzaInnodbConnect;

public class Pizza {
	
	String nomPizza ;
	double  prixPizza;
	Integer numeroPizza;
	String cheminImage;
	
	public Pizza(String nomPizza, double prixPizza, Integer numeroPizza, String cheminImage) {
		super();
		this.nomPizza = nomPizza;
		this.prixPizza = prixPizza;
		this.numeroPizza = numeroPizza;
		this.cheminImage = cheminImage;
	}

	@Override
	public String toString() {
		return "objet de classe Pizza [nomPizza=" + nomPizza + ", prixPizza=" + prixPizza + ", numeroPizza=" + numeroPizza
				+ ", cheminImage=" + cheminImage + "]";
	}
	
	 
	

}