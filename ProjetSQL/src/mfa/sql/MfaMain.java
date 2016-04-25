package mfa.sql;

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

public class MfaMain {

	public static void main(String[] args) {
		MfaMain m = new MfaMain();
		m.init();
	}

	private void init() {
		// createExperience();
		ListeExperience lst = lireTousLesCv();
		insertExperience(lst);

	}

	private void insertExperience(ListeExperience listeExperience) {
		Connection con = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";

		// String login = "Active";
		// String password = "VDDMichel";
		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String urlBDD = "jdbc:mysql://www.psyeval.fr/bddCV";
		String urlBDD = "jdbc:mysql://localhost/bddcv";
		try {
			con = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < listeExperience.size(); i++) {

			Experience experience = listeExperience.get(i);
			requete = "INSERT INTO experience" + //
					"(id,dateExp,entreprise,poste,description)" + //
					"VALUES (" + //
					"'" + experience.getIdEtudiant() + "'," + //
					"'" + experience.getDateExp() + "'," + //
					"'" + experience.getEntreprise() + "'," + //
					"'" + experience.getPoste() + "'," + //
					"'" + experience.getDescription() + "'" + //
					");";

			try {
				statement = con.createStatement();
				statement.executeUpdate(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private ListeExperience lireTousLesCv() {
		ListeExperience lstExp = new ListeExperience();
		File file = new File("C:/DevFormation/GIT/FORMATION/ProjectCV/WebContent/WEB-INF/xml");
		File[] tableauCv = file.listFiles();

		for (int i = 0; i < tableauCv.length; i++) {
			if (tableauCv[i].isFile()) {
				if (tableauCv[i].getName().toUpperCase().startsWith("CV")
						&& tableauCv[i].getName().toLowerCase().endsWith(".xml")) {
					File fLecture = new File(file.getAbsolutePath() + "/" + tableauCv[i].getName());
					ListeExperience listeExperience = lectureDom(fLecture);
					lstExp.addAll(listeExperience);
					System.out.println(listeExperience);
				}
			}

		}

		return lstExp;
	}

	private ListeExperience lectureDom(File fLecture) {

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		ListeExperience listeDom = new ListeExperience();
		try {
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(fLecture);

			Element racine = document.getDocumentElement();
			String idEtudiant1 = racine.getAttribute("idEtudiant");
			if (idEtudiant1 != null) {
				NodeList list = racine.getChildNodes();
				int nbList = list.getLength();
				for (int i = 0; i < nbList; i++) {
					if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
						Element eExp = (Element) list.item(i);
						if (eExp.getNodeName().equals("ListeExperiences")) {
							NodeList lExp = eExp.getChildNodes();
							int nbExp = lExp.getLength();
							for (int j = 0; j < nbExp; j++) {
								if (lExp.item(j).getNodeType() == Node.ELEMENT_NODE) {
									Element eExperience = (Element) lExp.item(j);
									int idEtudiant=Integer.valueOf(eExperience.getAttribute("idEtudiant")).intValue();
									String dateExp = eExperience.getAttribute("dateExp");
									String entreprise = eExperience.getAttribute("entreprise");
									String poste = eExperience.getAttribute("poste");
									String description = eExperience.getTextContent();
									System.out.println(dateExp + " " + entreprise + " " + poste + " " + description);
									Experience exp = new Experience(idEtudiant,dateExp,entreprise,poste,description);
									listeDom.add(exp);
								}
							}
						}

					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listeDom;
	}

	private void createExperience() {

		Connection con = null;
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
			con = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		requete = "CREATE TABLE experience " + //
				"(id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," + //
				"dateExp VARCHAR(50)," + //
				"entreprise VARCHAR(100)," + //
				"poste VARCHAR(100)," + //
				"description TEXT" + //
				");";

		try {
			statement = con.createStatement();
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
