package vdd.servlet;

/**
 * Servlet implementation class ServletListeEtudiant
 */
@WebServlet("/ServletListeEtudiant")
public class ServletListeEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeEtudiant() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> par = request.getParameterNames();
		while (par.hasMoreElements()) {
			String sVal = par.nextElement();
			System.out.println(sVal);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
