package vdd.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainSql {

	public static void main(String[] args) {
		MainSql mainSql = new MainSql();
		mainSql.init();
	}

	private void init() {
		Connection con = null;
		ResultSet résultats = null;
		Statement stmt = null;
		String requete = "";

		// chargement du pilote
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			arret("Impossible de charger le pilote jdbc:odbc");
		}

		String login = "Active";
		String password = "VDDMichel";
//		String login = "root";
//		String password = "dLYZmjHnLR9Q";

		//connection a la base de données

		affiche("connection a la base de données");
		try {
			String DBurl = "jdbc:mysql://www.psyeval.fr/bddCV";
			con = DriverManager.getConnection(DBurl, login, password);
		} catch (SQLException e) {
			arret("Connection à la base de données impossible");
		}

		//Création d'une table 
		affiche("creation table");

		requete = "CREATE TABLE formation ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +//
				"dateFormation VARCHAR(30) NOT NULL," +//
				"lieuFormation VARCHAR(30) NOT NULL," +//
				"domaineFormation VARCHAR(30) NOT NULL" +//
				");";
		try {
			stmt=con.createStatement();
			int nbMaj = stmt.executeUpdate(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		//		private int typeQuestion;
		//	    private String question; // Texte ou image de la question
		//	    private int modeReponse;
		//	    private int typeChoix;
		//	    private String[][] choix; // liste des different choix
		//	    private int nbSolution; // nb de reponse attendue
		//	    private String[] solutionSaisie; // solution a saisir
		//	    private int[] solutionChoisie; // liste des solutions a choisir
		//	    private String[] reponseSaisie; // reponse faite
		//	    private int[] reponseChoisie; // lis
		affiche("fin du programme");
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void affiche(String message) {
		System.out.println(message);
	}

	private void arret(String message) {
		System.err.println(message);
		System.exit(99);
	}

}
