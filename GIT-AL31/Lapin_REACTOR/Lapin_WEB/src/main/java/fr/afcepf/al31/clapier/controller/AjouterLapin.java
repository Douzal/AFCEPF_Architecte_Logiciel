package fr.afcepf.al31.clapier.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.business.api.IGestionClapier;
import fr.afcepf.al31.clapier.business.impl.GestionClapier;
import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;

@WebServlet("/ajouter-lapin.cretin")
public class AjouterLapin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/ajouter-lapin.jsp").forward(req, resp);;
	}
	private Logger log = Logger.getLogger(getClass());
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IGestionClapier gestionClapier = new GestionClapier();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Lapin newLapin = new Lapin(null, req.getParameter("lapin-nom"),
				Double.parseDouble(req.getParameter("lapin-oreille")),
				req.getParameter("lapin-couleur"), 
				sdf.parse(req.getParameter("lapin-naissance")),
				req.getParameter("lapin-sexe"));
			List<Lapin> liste = gestionClapier.ajouter(
				newLapin, new Clapier(
					Integer.parseInt(req.getParameter("selected-clapier")), 0));
			req.getSession().setAttribute("message", "il y a maintenant : " + liste.size() + " lapin(s) dans ce clapier");
		} catch (Exception e) {
			log.fatal(e);
			req.getSession().setAttribute("message", "erreur de saisie");
		}
		resp.sendRedirect("ajouter-lapin.cretin");
	}
}
