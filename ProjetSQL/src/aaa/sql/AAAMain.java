package aaa.sql;

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

import aaa.metier.Competence;
import aaa.metier.ListeCompetence;

public class AAAMain {

	public static void main(String[] args) {
		AAAMain a = new AAAMain();
		a.init();
	}

	private void init() {
		createComp();
		File fLecture = new File("../ProjectCV/WebContent/WEB-INF/xml/cvAllan.xml");
		ListeCompetence listeCompetence = lireListe(fLecture);
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

	public ListeCompetence lireListe(File fLecture) {
		ListeCompetence listeCompetence = new ListeCompetence();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(fLecture);

			Element racine = document.getDocumentElement();

			NodeList liste = racine.getChildNodes();
			int nbList = liste.getLength();
			for (int i = 0; i < nbList; i++) {
				if (liste.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element eCompetence = (Element) liste.item(i);

					String type = eCompetence.getAttribute("type");
					String detail = eCompetence.getAttribute("detail");
					String niveau = eCompetence.getAttribute("niveau");

					Competence comp = new Competence(type, detail, niveau);
					listeCompetence.add(comp);
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listeCompetence;
	}
}