package aaa.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AAAMain {

	public static void main(String[] args) {
		AAAMain a = new AAAMain();
		a.init();
	}

	private void init() {
		createComp();
	}

	private void createComp() {
		Connection connex = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";

		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bddcv";
		try {
			connex = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		requete = "CREATE TABLE competence" + //
				"(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," + //
				"type VARCHAR(30)," + //
				"detail VARCHAR(30), " + //
				"niveau VARCHAR(30)" + //
				");";
		// requete = "CREATE TABLE competence" + //
		// "(id INT NOT NULL PRIMARY KEY," + //
		// "nom VARCHAR(30)," + //
		// "prenom VARCHAR(30)," + //
		// "metier VARCHAR(30)," + //
		// "mail VARCHAR(30)" + //
		// ");";
		try {
			statement = connex.createStatement();
			statement.executeUpdate(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}