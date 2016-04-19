package vdd.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer.Form;
import java.util.Enumeration;

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

import vdd.metier.Formation;
import vdd.metier.ListeFormation;

/**
 * Servlet implementation class ServletListeFormation
 */
@WebServlet("/ServletListeFormation")
public class ServletListeFormation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	private void chargerListeEtudiants(ListeFormation listeFormation) {
	}

	private ListeFormation chargerListeFormation() {
		ListeFormation listeFormation = new ListeFormation();
		File fXmlFormation = new File("../workspace/ProjectCV/WebContent/WEB-INF/xml/listeFormation.xml");

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
					Formation formation = new Formation(sDate, sLieu, sDomaine);
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
		HttpSession session=request.getSession();
		ListeFormation listeFormation=chargerListeFormation();
		chargerListeEtudiants(listeFormation);
		session.setAttribute("listeForm", listeFormation);
		PrintWriter out = response.getWriter();
		File fHtml = new File("../workspace/ProjectCV/WebContent/WEB-INF/page/pageListeFormation.html");
		BufferedReader buf = new BufferedReader(new FileReader(fHtml));
		String line = buf.readLine();
		while (line != null) {
			if (line.contains("%%date%%")|| line.contains("%%lieu%%") || line.contains("%%domaine%%") || line.contains("%%name%%") || line.contains("%%valeur%%")) {
			//if (line.contains("AJOUTER LA LISTE DES FORMATIONS")) {
				affListeFormation(out,line,listeFormation);
			}else {
				out.println(line);
			}
			line = buf.readLine();
		}
	}

	private void affListeFormation(PrintWriter out,String line, ListeFormation listeFormation) {
		for (int i = 0; i < listeFormation.size(); i++) {
			Formation formation=listeFormation.get(i);
			String ligneAAfficher=line;
//			out.println("<tr>");
//			out.println("<td style=\"width: 5%\">sel</td>");
//			out.println("<td style=\"width: 30%\">"+formation.getDateFormation()+"</td>");
//			out.println("<td style=\"width: 30%\">"+formation.getLieuFormation()+"</td></tr>");
//			out.println("<td style=\"width: 30%\">"+formation.getDomaineFormation()+"</td></tr>");
//			out.println("</tr>");
			//out.println("<tr><td style=\"width: 5%\">sel</td><td style=\"width: 30%\">"+formation.getDateFormation()+"</td><td style=\"width 40%\">"+formation.getLieuFormation()+"</td><td style=\"width: 30%\">"+formation.getDomaineFormation()+"</td></tr>");
			//out.println(formation.getDateFormation()+"<br>");
			ligneAAfficher=ligneAAfficher.replace("%%name%%", "bFormation");
			ligneAAfficher=ligneAAfficher.replace("%%valeur%%", Integer.toString(i));
			ligneAAfficher=ligneAAfficher.replace("%%date%%", formation.getDateFormation());
			ligneAAfficher=ligneAAfficher.replace("%%lieu%%", formation.getLieuFormation());
			ligneAAfficher=ligneAAfficher.replace("%%domaine%%", formation.getDomaineFormation());
			out.println(ligneAAfficher);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ListeFormation listeFormation=(ListeFormation) session.getAttribute("listeForm");
		int sel = 0;
		String sSel=request.getParameter("bFormation"); 
			
		Enumeration<String> par = request.getParameterNames();
		while (par.hasMoreElements()) {
			String sVal = par.nextElement();
			if (sVal.contains("sel")) {
				sel = Integer.valueOf(sVal.replace("sel", ""));
				break;
			}
		}
		Formation formation=listeFormation.get(Integer.valueOf(sel).intValue());
		session.setAttribute("formation", formation);
		
		File fHtml = new File("../workspace/ProjectCV/WebContent/WEB-INF/page/pageListeEtudiant.html");
		PrintWriter out = response.getWriter();
		BufferedReader buf = new BufferedReader(new FileReader(fHtml));
		String line = buf.readLine();
		while (line != null) {
			out.println(line);
			line = buf.readLine();
		}

	}
}
