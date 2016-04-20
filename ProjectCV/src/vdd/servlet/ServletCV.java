package vdd.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vdd.metier.Etudiant;
import vdd.metier.Formation;
import vdd.metier.ListeFormation;

/**
 * Servlet implementation class ServletCV
 */
@WebServlet("/ServletCV")
public class ServletCV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCV() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ListeFormation listeFormation = (ListeFormation) session.getAttribute("listeForm");
		Formation formation = (Formation) session.getAttribute("formation");
		String sEtudiant = request.getParameter("bEtudiant");
		Etudiant etudiant = formation.getListeEtudiant().get(Integer.valueOf(sEtudiant).intValue());
		session.setAttribute("etudiant", etudiant);
		File fHtml = new File("../GIT/FORMATION/ProjectCV/WebContent/WEB-INF/page/" + etudiant.getCv());
		BufferedReader buf = new BufferedReader(new FileReader(fHtml));
		PrintWriter out = response.getWriter();
		String line = buf.readLine();
		while (line != null) {
			out.println(line);
			line = buf.readLine();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
