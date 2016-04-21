package sdpc.methodesScolaire;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sdpc.metierScolaire.FormationScolaire;
import sdpc.metierScolaire.ListeFormationScolaire;

public class MethodesScolaire {

	public static void main(String[] args) {
		MethodesScolaire m = new MethodesScolaire();
		m.init();
	}

	private void init() {

		File rep = new File("../ProjectCV/WebContent/WEB-INF/xml");
		File[] lf = rep.listFiles();
		creTable();
		for (int i = 0; i < lf.length; i++) {
			if (lf[i].isFile()) {
				if (lf[i].getName().toLowerCase().endsWith(".xml")) {
					File fLecture = new File(rep.getAbsolutePath()+lf[i].getName());
					ListeFormationScolaire listeFormation = lireFormationDom(fLecture);
					
					for (FormationScolaire formationScolaire : listeFormation) {
						insertTable(formationScolaire);
					}
				}
			}

		}

	}

	// methode qui extrait la liste des formations scolaires pour Cv XML
	// fLecture d'un etudiant.
	public ListeFormationScolaire lireFormationDom(File fLecture) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		ListeFormationScolaire listeFormationScolaire = new ListeFormationScolaire();
		try {
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(fLecture);

			Element racine = document.getDocumentElement();

			NodeList liste = racine.getChildNodes();
			int nbList = liste.getLength();
			for (int i = 0; i < nbList; i++) {
				if (liste.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element eFormation = (Element) liste.item(i);

					String date = eFormation.getAttribute("date");
					String diplome = eFormation.getAttribute("diplome");
					String ecole = eFormation.getAttribute("ecole");

					FormationScolaire form = new FormationScolaire(date, diplome, ecole);
					listeFormationScolaire.add(form);
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listeFormationScolaire;
	}

	// creation table vide de donnees dans SQL, de dimensions
	// listeFormationScolaire
	public void creTable() {
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
		// String login = "root";
		// String password = "dLYZmjHnLR9Q";

		// connection a la base de données

		affiche("connection a la base de données");
		try {
			String DBurl = "jdbc:mysql://www.psyeval.fr/bddCV";
			con = DriverManager.getConnection(DBurl, login, password);
		} catch (SQLException e) {
			arret("Connection à la base de données impossible");
		}

		// Création d'une table
		affiche("creation table");

		requete = "CREATE TABLE formation_scolaire ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " + //
				"date VARCHAR(20) NOT NULL," + //
				"diplome VARCHAR(40) NOT NULL," + //
				"ecole VARCHAR(40) NOT NULL" + //
				");";
		try {
			stmt = con.createStatement();
			stmt.execute(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		affiche("fin du programme");
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertTable(FormationScolaire formS) {
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
		// connection a la base de données
		affiche("connection a la base de données");
		try {
			String DBurl = "jdbc:mysql://www.psyeval.fr/bddCV";
			con = DriverManager.getConnection(DBurl, login, password);
		} catch (SQLException e) {
			arret("Connection à la base de données impossible");
		}

		// Création d'une table
		affiche("creation table");
		requete = "INSERT INTO formation_scolaire" + //
				"( date, diplome, ecole)" + //
				"VALUES ('" + formS.getDate() + "','" + formS.getDiplome() + "','" + formS.getEcole() + //
				");";

		try {
			stmt = con.createStatement();
			stmt.execute(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
