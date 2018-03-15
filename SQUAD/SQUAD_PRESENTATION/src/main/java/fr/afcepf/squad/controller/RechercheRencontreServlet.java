package fr.afcepf.squad.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.gestion.api.IBusinessRencontre;

/**
 * Servlet implementation class RechercheRencontreServlet
 */
@WebServlet(urlPatterns = {"/rechercheRencontre"})
public class RechercheRencontreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IBusinessRencontre proxyRencontre;


	public RechercheRencontreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramVille = request.getParameter("ville");
		String paramDateString = request.getParameter("date");
		String paramSportString = (request.getParameter("sport")==null)?"":request.getParameter("sport");


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date paramDate = null;

		if(paramDateString != null) {
			try {
				paramDate = sdf.parse(paramDateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<Rencontre> rencontres = null;

		rencontres = proxyRencontre.getAllRencontreBySportVilleDate(paramSportString, paramVille, paramDate);


		//construction JSON
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		JSONArray listeRencontreJSON = new JSONArray();
		JSONObject rencontresJSON = new JSONObject();

		try {

			for (Rencontre r : rencontres) {
				JSONObject temp = new JSONObject();
				temp.put("id", r.getId());
				temp.put("libelle", r.getLibelle());
				temp.put("description", r.getDescription());
				temp.put("adresse", r.getAdresse());
				temp.put("adresseLat", r.getAdresseLat());
				temp.put("adresseLong", r.getAdresseLong());
				temp.put("codePostal", r.getCodePostal());
				temp.put("ville", r.getVille());
				temp.put("sexe", (r.getSexe() != null)?r.getSexe().name():null);
				temp.put("nbParticipant", r.getParticipations().size());
				temp.put("nbMaxPart", r.getNbMaxPart());
				temp.put("idSport", r.getSport().getId());
				temp.put("sportLibelle", r.getSport().getLibelle());
				temp.put("dateCreation", r.getDateCreation());
				temp.put("dateDebut", r.getDateDebut());
				temp.put("dateFin", r.getDateFin());
				temp.put("type", r.getClass().getSimpleName());

				listeRencontreJSON.put(temp);
			}	

			rencontresJSON.put("rencontres", listeRencontreJSON);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.getWriter().write(rencontresJSON.toString());


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramVille = request.getParameter("ville");
		String paramDateString = request.getParameter("date");
		String paramSportString = (request.getParameter("sport")==null)?"":request.getParameter("sport");


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SimpleDateFormat sdfDateHeure = new SimpleDateFormat("EEEE dd MMMM HH:mm");
		
		SimpleDateFormat sdfDateJour = new SimpleDateFormat("dd");
		
		SimpleDateFormat sdfDateMois = new SimpleDateFormat("MMM");
		
		Date paramDate = new Date();

		if(paramDateString != null) {
			try {
				paramDate = sdf.parse(paramDateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<Rencontre> rencontres = null;

		rencontres = proxyRencontre.getAllRencontreBySportVilleDate(paramSportString, paramVille, paramDate);


		//construction JSON
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		JSONArray listeRencontreJSON = new JSONArray();
		JSONObject rencontresJSON = new JSONObject();

		try {

			for (Rencontre r : rencontres) {
				JSONObject temp = new JSONObject();
				temp.put("id", r.getId());
				temp.put("libelle", r.getLibelle());
				temp.put("description", r.getDescription());
				temp.put("adresse", r.getAdresse());
				temp.put("adresseLat", r.getAdresseLat());
				temp.put("adresseLong", r.getAdresseLong());
				temp.put("codePostal", r.getCodePostal());
				temp.put("ville", r.getVille());
				temp.put("sexe", (r.getSexe() != null)?r.getSexe().name():null);
				temp.put("nbParticipant", r.getParticipations().size());
				temp.put("nbMaxPart", r.getNbMaxPart());
				temp.put("idSport", r.getSport().getId());
				temp.put("sportLibelle", r.getSport().getLibelle());
				temp.put("dateCreation", r.getDateCreation());
				temp.put("dateDebut", sdfDateHeure.format(r.getDateDebut()));
				temp.put("dateFin", sdfDateHeure.format(r.getDateFin()));
				temp.put("dateJour", sdfDateJour.format(r.getDateDebut()));
				temp.put("dateMois", sdfDateMois.format(r.getDateDebut()));
				temp.put("sportCouleur", r.getSport().getCouleur());
				temp.put("sportIcone", r.getSport().getIcone());
				temp.put("type", r.getClass().getSimpleName());
				temp.put("orga", r.getOrganisateur().getPrenomNomTronque());
				temp.put("orgaPhoto", r.getOrganisateur().getPhoto());

				listeRencontreJSON.put(temp);
			}	

			rencontresJSON.put("rencontres", listeRencontreJSON);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.getWriter().write(rencontresJSON.toString());


	}
}