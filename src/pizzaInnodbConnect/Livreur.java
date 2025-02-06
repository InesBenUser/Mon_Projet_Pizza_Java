package pizzaInnodbConnect;

public class Livreur {
	
	Integer NroLivr;
	String NomLivr;
	String PrenomLivr;
	String DateEmbauchLivr;
	
	public Livreur(Integer nroLivr, String nomLivr, String prenomLivr, String dateEmbauchLivr) {
		super();
		NroLivr = nroLivr;
		NomLivr = nomLivr;
		PrenomLivr = prenomLivr;
		DateEmbauchLivr = dateEmbauchLivr;
	}
	public String toString() {
		return "nomLivreur = " + NomLivr + ", prenomLivreur "+ PrenomLivr+", DateEmbauchLivr= "+ DateEmbauchLivr;
	}
}