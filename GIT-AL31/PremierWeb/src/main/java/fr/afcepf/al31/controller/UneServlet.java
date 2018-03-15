package fr.afcepf.al31.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
@WebServlet("/une-servlet.al31")
public class UneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass());
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saisie = request.getParameter("form-saisie");
		log.debug("dans servlet ");
		log.debug(saisie);
		String forward = "/toto.html";
		if (saisie.equals("toto")) {
			request.getRequestDispatcher(forward).forward(request, response);
		} else {
			response.sendRedirect(forward.substring(1));
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
