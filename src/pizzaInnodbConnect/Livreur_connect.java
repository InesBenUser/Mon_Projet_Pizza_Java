package pizzaInnodbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Livreur_connect {
	
	public static void main(String[] args) {
		 	
		System.out.println("connection a mysql pizzaboxinnodb");
			
		String url = "jdbc:mysql://localhost:3306/pizzaboxinnodb?allowPublicKeyRetrieval=true&useSSL=false";
		
		String login = "root";
		String passwd = "";
		
		Connection cn =null; 
		Statement st =null;
		ResultSet rs =null;
 
		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM LIVREUR  "   ;

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);
			
			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)
			System.out.println(rs);
			
			while (rs.next()) {
				System.out.println("-----------------------------------");
				/*System.out.println(rs.getString("NOMLIVR"));
				System.out.println(rs.getString("PRENOMLIVR"));
				System.out.println(rs.getString("DATEEMBAUCHLIVR"));*/
				
				Livreur l1 = new Livreur(null, rs.getString("NOMLIVR"),rs.getString("PRENOMLIVR"),rs.getString("DATEEMBAUCHLIVR"));
				System.out.println(l1);
			}
			 
			
		} catch (ClassNotFoundException e) {//si il y un probleme de driver
		 
			e.printStackTrace();
		} catch (SQLException e) {//si il y un probleme de sql
	 
			e.printStackTrace();
		}

	}

}