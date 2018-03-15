package fr.afcepf.al31.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
@WebServlet("/formulaire.aspx")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass());
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/formulaire.html")
			.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nom = request.getParameter("form-nom");
		String prenom = request.getParameter("form-prenom");
		String civilite = request.getParameter("form-civilite");
		String naissance = request.getParameter("form-naissance");
		String activite = request.getParameter("form-activite");
		String adresse = request.getParameter("form-adresse");
		String[] choix = request.getParameterValues("form-choix");
		StringBuilder sb = new StringBuilder(System.lineSeparator())
				.append("civilité : ").append(civilite).append(System.lineSeparator())
				.append("nom : ").append(nom).append(System.lineSeparator())
				.append("prénom : ").append(prenom).append(System.lineSeparator())
				.append("adresse : ").append(System.lineSeparator())
				.append(adresse).append(System.lineSeparator())
				.append("activité : ").append(activite).append(System.lineSeparator())
				.append("naissance : ").append(naissance).append(System.lineSeparator());
		if (choix != null) {
			sb.append("choix :");
			for (String string : choix) {
				sb.append("\t").append(string).append(System.lineSeparator());
			}
		}
		log.debug(sb.toString());
		//response.setCharacterEncoding("UTF-8");
		response.getWriter().print("<html>");
		response.getWriter().print("<head content=\"text/html; charset=UTF-8\">");
		response.getWriter().print("<title>");
		response.getWriter().print("Reponse de la servlet");
		response.getWriter().print("</title>");
		response.getWriter().print("</head>");
		response.getWriter().print("<body>");
		response.getWriter().print("<h1>");
		response.getWriter().print(sb.toString());
		response.getWriter().print("</h1>");
		response.getWriter().print("</body>");
		response.getWriter().print("</html>");
	}
}
