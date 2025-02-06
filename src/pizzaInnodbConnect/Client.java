package pizzaInnodbConnect;

public class Client {
	Integer NroClie;
	String NomClie;
	String PrenomClie;
	String AdresseClie;
	Integer CodePostalClie;
	String TitreClie;
	String NroTelCLie;
	
	public Client(Integer nroClie, String nomClie, String prenomClie, String adresseClie, Integer codePostalClie,
			String titreClie, String nroTelCLie) {
		super();
		NroClie = nroClie;
		NomClie = nomClie;
		PrenomClie = prenomClie;
		AdresseClie = adresseClie;
		CodePostalClie = codePostalClie;
		TitreClie = titreClie;
		NroTelCLie = nroTelCLie;
	}
	public  String toString() {
		return "nomClient = " + NomClie +", prenom Client = "+PrenomClie+ ", Adresse Client = "+AdresseClie;
	}
}