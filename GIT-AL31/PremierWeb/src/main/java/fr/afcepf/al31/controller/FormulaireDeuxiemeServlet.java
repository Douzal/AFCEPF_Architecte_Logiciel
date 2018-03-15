package fr.afcepf.al31.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class FormulaireDeuxiemeServlet
 */
@WebServlet("/formulaire_jsp.aspx")
public class FormulaireDeuxiemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass());
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug(request.getCharacterEncoding());
		request.setCharacterEncoding("UTF-8");
		log.debug(request.getCharacterEncoding());
		String nom = request.getParameter("form-nom");
		String prenom = request.getParameter("form-prenom");
		String civilite = request.getParameter("form-civilite");
		String naissance = request.getParameter("form-naissance");
		String activite = request.getParameter("form-activite");
		String adresse = request.getParameter("form-adresse");
		String[] choix = request.getParameterValues("form-choix");
		// creation des attributs de request pour envoyer le
		// résultat de traitement a la classe JSP
		request.setAttribute("nom", nom.toUpperCase()); // petit traitement
		request.setAttribute("civilite", civilite);
		request.setAttribute("prenom", prenom);
		request.setAttribute("naissance", naissance);
		request.setAttribute("activite", activite);
		request.setAttribute("adresse", 
				adresse.replaceAll(System.lineSeparator(), "<br />"));
		request.setAttribute("choix", choix);
		// forward vers la classe JSP
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/formulaire.jsp").forward(request, response);
	}
}
