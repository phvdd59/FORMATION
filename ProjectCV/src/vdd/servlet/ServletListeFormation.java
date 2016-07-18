package vdd.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import vdd.metier.Competence;
import vdd.metier.Etudiant;
import vdd.metier.Experience;
import vdd.metier.Formateur;
import vdd.metier.Formation;
import vdd.metier.FormationScolaire;
import vdd.metier.ListeFormation;

/**
 * Servlet implementation class ServletListeFormation
 */
@WebServlet("/ServletListeFormation")
public class ServletListeFormation extends HttpServlet {
	private static final String REPERTOIRE="/home/psyeval/www/ProjectCV/"; 
	//private static final String REPERTOIRE="../GIT/FORMATION/ProjectCV/WebContent/"; 
	private static final long serialVersionUID = 1L;
	

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String LOGIN = "Active";
	private static final String PASSWORD = "VDDMichel";
	private static final String DBURL = "jdbc:mysql://www.psyeval.fr/bddCV";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeFormation() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	private void chargerListeEtudiantsXML(ListeFormation listeFormation) {
		File fXmlEtudiant = new File(REPERTOIRE+"WEB-INF/xml/listeEtudiant.xml");

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			final Document document = builder.parse(fXmlEtudiant);
			final Element racine = document.getDocumentElement();
			final NodeList nodeListeForm = racine.getChildNodes();
			for (int i = 0; i < nodeListeForm.getLength(); i++) {
				if (nodeListeForm.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element fFormation = (Element) nodeListeForm.item(i);
					final NodeList nodeListeEtudiant = nodeListeForm.item(i).getChildNodes();
					int idFormation = Integer.valueOf(fFormation.getAttribute("id")).intValue();
					Formation formation = listeFormation.get(idFormation);
					for (int j = 0; j < nodeListeEtudiant.getLength(); j++) {
						if (nodeListeEtudiant.item(j).getNodeType() == Node.ELEMENT_NODE) {
							final Element eEtudiant = (Element) nodeListeEtudiant.item(j);
							int id = Integer.valueOf(eEtudiant.getAttribute("id")).intValue();
							String sNom = eEtudiant.getAttribute("nom");
							String sPrenom = eEtudiant.getAttribute("prenom");
							String sMail = eEtudiant.getAttribute("mail");
							String sMetier = eEtudiant.getAttribute("metier");
							String sPhoto = eEtudiant.getAttribute("photo");
							String sCv = eEtudiant.getAttribute("cv");
							Etudiant etudiant = new Etudiant(id, sNom, sPrenom, sMail, sMetier, sPhoto, formation);
							formation.getListeEtudiant().add(etudiant);
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
		} finally {
		}
	}

	private ListeFormation chargerListeFormationSQL() {
		ListeFormation listeFormation = new ListeFormation();
		Connection con = null;
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			Class.forName(DRIVER);
			String login = LOGIN;
			String password = PASSWORD;
			//connection a la base de données
			String DBurl = DBURL;
			con = DriverManager.getConnection(DBurl, login, password);
			stmt = con.createStatement();
			requete = "SELECT * FROM formation";
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("idFormation");
				String date = set.getString("dateFormation");
				String lieu = set.getString("lieuFormation");
				String domaine = set.getString("domaineFormation");
				Formation formation = new Formation(id, date, lieu, domaine);
				chargeFormateurSQL(formation, con);
				chargeListeEtudiantSQL(formation, con);
				listeFormation.add(formation);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeFormation;
	}

	private void chargeFormateurSQL(Formation formation, Connection con) {
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM formateur WHERE idFormation = " + formation.getIdFormation();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			if (trouve) {
				int id = set.getInt("id");
				String nom = set.getString("nom");
				String mail = set.getString("mail");
				String tel = set.getString("tel");
				Formateur formateur = new Formateur(id, nom, mail, tel, formation);
				formation.setFormateur(formateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chargeListeEtudiantSQL(Formation formation, Connection con) {
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM etudiant WHERE idFormation = " + formation.getIdFormation();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String nom = set.getString("nom");
				String prenom = set.getString("prenom");
				String metier = set.getString("metier");
				String mail = set.getString("mail");
				String photo = set.getString("photo");
				Etudiant etudiant = new Etudiant(id, nom, prenom, mail, metier, photo, formation);
				chargeListeCompetenceSQL(etudiant, con);
				chargeListeExperienceSQL(etudiant, con);
				chargeListeFormationScolaireSQL(etudiant, con);
				formation.getListeEtudiant().add(etudiant);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chargeListeFormationScolaireSQL(Etudiant etudiant, Connection con) {
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM formation_scolaire WHERE idEtudiant = " + etudiant.getId();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String date = set.getString("date");
				String diplome = set.getString("diplome");
				String ecole = set.getString("ecole");
				FormationScolaire formationScolaire = new FormationScolaire(id, date, diplome, ecole, etudiant);
				etudiant.getListeFormationScolaire().add(formationScolaire);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chargeListeExperienceSQL(Etudiant etudiant, Connection con) {
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM experience WHERE idEtudiant = " + etudiant.getId();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String dateExp = set.getString("dateExp");
				String entreprise = set.getString("entreprise");
				String poste = set.getString("poste");
				String description = set.getString("description");
				Experience experience = new Experience(id, dateExp, entreprise, poste, description, etudiant);
				etudiant.getListeExperience().add(experience);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chargeListeCompetenceSQL(Etudiant etudiant, Connection con) {
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM competence WHERE idEtudiant = " + etudiant.getId();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String type = set.getString("type");
				String detail = set.getString("detail");
				String niveau = set.getString("niveau");
				Competence competence = new Competence(id, type, detail, niveau, etudiant);
				etudiant.getListeCompetence().add(competence);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private ListeFormation chargerListeFormationXml() {
		ListeFormation listeFormation = new ListeFormation();
		File fXmlFormation = new File(REPERTOIRE+"WEB-INF/xml/listeFormation.xml");

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			final Document document = builder.parse(fXmlFormation);
			final Element racineListeFormation = document.getDocumentElement();
			final NodeList nodeListeFormation = racineListeFormation.getChildNodes();
			for (int i = 0; i < nodeListeFormation.getLength(); i++) {
				if (nodeListeFormation.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element eFormation = (Element) nodeListeFormation.item(i);
					String sDate = eFormation.getAttribute("dateFormation");
					String sLieu = eFormation.getAttribute("lieuFormation");
					String sDomaine = eFormation.getAttribute("domaineFormation");
					Formation formation = new Formation(i, sDate, sLieu, sDomaine);
					synchronized (listeFormation) {
						listeFormation.add(formation);
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return listeFormation;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		File file = new File("");
		ListeFormation listeFormation = chargerListeFormationSQL();
		session.setAttribute("listeForm", listeFormation);
		PrintWriter out = response.getWriter();
		File fHtml = new File(REPERTOIRE+"WEB-INF/page/pageListeFormation.html");
		BufferedReader buf = new BufferedReader(new FileReader(fHtml));
		String line = buf.readLine();
		while (line != null) {
			if (line.contains("%%date%%") || line.contains("%%lieu%%") || line.contains("%%domaine%%") || line.contains("%%name%%") || line.contains("%%valeur%%")) {
				affListeFormation(out, line, listeFormation);
			} else {
				out.println(line);
			}
			line = buf.readLine();
		}
	}

	private void affListeFormation(PrintWriter out, String line, ListeFormation listeFormation) {
		for (int i = 0; i < listeFormation.size(); i++) {
			Formation formation = listeFormation.get(i);
			String ligneAAfficher = line;
			ligneAAfficher = ligneAAfficher.replace("%%name%%", "bFormation");
			ligneAAfficher = ligneAAfficher.replace("%%valeur%%", Integer.toString(i));
			ligneAAfficher = ligneAAfficher.replace("%%date%%", formation.getDateFormation());
			ligneAAfficher = ligneAAfficher.replace("%%lieu%%", formation.getLieuFormation());
			ligneAAfficher = ligneAAfficher.replace("%%domaine%%", formation.getDomaineFormation());
			out.println(ligneAAfficher);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ListeFormation listeFormation = (ListeFormation) session.getAttribute("listeForm");
		String sSel = request.getParameter("bFormation");
		Formation formation = listeFormation.get(Integer.valueOf(sSel).intValue());
		session.setAttribute("formation", formation);

		File fHtml = new File(REPERTOIRE+"WEB-INF/page/pageListeEtudiant.html");
		PrintWriter out = response.getWriter();
		BufferedReader buf = new BufferedReader(new FileReader(fHtml));
		String line = buf.readLine();
		while (line != null) {
			if (line.contains("%%nomFormateur%%")) {
				line = line.replace("%%nomFormateur%%", formation.getFormateur().getNom());
			}
			if (line.contains("%%mailFormateur%%")) {
				line = line.replace("%%mailFormateur%%", formation.getFormateur().getMail());
			}
			if (line.contains("%%telFormateur%%")) {
				line = line.replace("%%telFormateur%%", formation.getFormateur().getTel());
			}
			if (line.contains("%%name%%")) {
				for (int i = 0; i < formation.getListeEtudiant().size(); i++) {
					Etudiant etudiant = formation.getListeEtudiant().get(i);
					String ligneAAfficher = line;
					ligneAAfficher = ligneAAfficher.replace("%%name%%", "bEtudiant");
					ligneAAfficher = ligneAAfficher.replace("%%valeur%%", Integer.toString(i));
					ligneAAfficher = ligneAAfficher.replace("%%nom%%", etudiant.getNom() + " " + etudiant.getPrenom());
					ligneAAfficher = ligneAAfficher.replace("%%prenom%%", etudiant.getPrenom());
					ligneAAfficher = ligneAAfficher.replace("%%mail%%", etudiant.getMail());
					ligneAAfficher = ligneAAfficher.replace("%%metier%%", etudiant.getMetier());
					out.println(ligneAAfficher);
				}
			} else {
				out.println(line);
			}
			line = buf.readLine();
		}
	}
}
