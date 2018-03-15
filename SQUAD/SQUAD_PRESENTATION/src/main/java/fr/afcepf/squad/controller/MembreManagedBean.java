package fr.afcepf.squad.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Notification;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.gestion.api.IBusinessNotification;
import fr.afcepf.squad.gestion.api.IBusinessRencontre;
import fr.afcepf.squad.gestion.api.IBusinessSport;

@ManagedBean(name="mbMembre")
@ViewScoped
public class MembreManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{mbSession}")
	private SessionManagedBean sessionManagedBean;
	
	@EJB
	private IBusinessNotification proxyNotif;
	@EJB
	private IBusinessRencontre proxyRencontre;
	@EJB
	private IBusinessSport proxySport;
	
	private Membre membreConnecte;
	
	private List<Notification> notifications = new ArrayList<>();
	private List<Participation> totalParticipations = new ArrayList<>();
	private List<Participation> participations = new ArrayList<>();


	private List<Membre> partenaires = new ArrayList<>();

	private List<String> libelleSports = new ArrayList<>();
	private Sport sport = null;
	private String filtreSport = null;
	
	private Date date = null;
	private String filtreDate = null;
	
	private List<String> libelleVilles = new ArrayList<>();
	private String filtreVille = null;
	private String rencontres = "";
	private String demoListeRencontres;
	private String rencontresCal = "";
	private SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
	private String filtreDateParse = null;
	
	// Méthodes du ManagedBean
	
	@PostConstruct
	public void init() {
		membreConnecte = sessionManagedBean.getMembreConnecte();
		
		if (membreConnecte != null) {
			notifications = proxyNotif.getAllNotificationByMember(membreConnecte);
			totalParticipations = proxyRencontre.getAllParticipationByMembreSportVilleDate(membreConnecte, sport, filtreVille, date);
			participations = proxyRencontre.getAllParticipationByMembreSportVilleDate(membreConnecte, sport, filtreVille, date);
			
			rencontres = "";
			
			for (Participation participation : participations) {
				rencontres += "{\"lat\": " + participation.getRencontre().getAdresseLat() + ", \"lng\": "+ participation.getRencontre().getAdresseLong() + "}";
				if (participations.indexOf(participation)+1 != participations.size()) {
					rencontres += "/";
				}
			}
			
			rencontresCal = "";
			
			for (Participation participation : participations) {
				rencontresCal += "{"
						+ "\"title\": "+participation.getRencontre().getDateCreation()+","
						+ " \"start\": "+participation.getRencontre().getDateDebut()+","
						+ " \"end\": "+participation.getRencontre().getDateFin()+""
			+ "}";
			}
		}

		for (Sport sport : proxySport.getAllSports()) {
			libelleSports.add(sport.getLibelle());
		}
	}

	public void notifLues () {
		for (Notification notification : membreConnecte.getNotifications()) {
			notification.setEstLu(true);
		}
	}
	
	public List<Participation> getParticipantsByRencontre(Rencontre rencontre) {
		List <Participation> participants = proxyRencontre.getAllParticipationByRencontre(rencontre);
		
		return participants;
	}
	
	public String placesRestantesRencontre(Rencontre rencontre) {
		String nbPlaces = "";
		
		if (rencontre.getNbMaxPart() != null) {
			int diff = rencontre.getNbMaxPart() - getParticipantsByRencontre(rencontre).size();

			if (diff > 0) {
				nbPlaces = diff + " places restantes";
			}
			else {
				nbPlaces = "Sans limite de participant";
			}
		}
		else {
			nbPlaces = "Sans limite de participant";
		}
		
		
		return nbPlaces;
	}
	
	public void filtrerSport() {
		if (filtreSport=="") {
			participations = proxyRencontre.getRencontreByMembre(membreConnecte);
		} else if (libelleSports.contains(filtreSport)) {
			sport = proxySport.searchSportByName(filtreSport).iterator().next();
			participations = proxyRencontre.getAllParticipationByMembreSportVilleDate(membreConnecte, sport, filtreVille, date);
		} else {
			participations = proxyRencontre.getRencontreByMembre(membreConnecte);
		}
	}
	
	public void filtrerDate() {
		try {
			date = formatter.parse(filtreDate);
			participations = proxyRencontre.getAllParticipationByMembreSportVilleDate(membreConnecte, sport, filtreVille, date);
			System.out.println("mes couilles sur ton front");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void filtrerVille() {
		participations = proxyRencontre.getAllParticipationByMembreSportVilleDate(membreConnecte, sport, filtreVille, date);
		
		rencontres = "";
		
		for (Participation participation : participations) {
			rencontres += "{\"lat\": " + participation.getRencontre().getAdresseLat() + ", \"lng\": "+ participation.getRencontre().getAdresseLong() + "}";
			if (participations.indexOf(participation)+1 != participations.size()) {
				rencontres += "/";
			}
		}
	}
	
	// Constructeurs et getters/setters
	
	public MembreManagedBean() {
		super();
	}

	public SessionManagedBean getSessionManagedBean() {
		return sessionManagedBean;
	}

	public void setSessionManagedBean(SessionManagedBean sessionManagedBean) {
		this.sessionManagedBean = sessionManagedBean;
	}

	public IBusinessNotification getProxyNotif() {
		return proxyNotif;
	}

	public void setProxyNotif(IBusinessNotification proxyNotif) {
		this.proxyNotif = proxyNotif;
	}

	public Membre getMembreConnecte() {
		return membreConnecte;
	}

	public void setMembreConnecte(Membre membreConnecte) {
		this.membreConnecte = membreConnecte;
	}

	public IBusinessRencontre getProxyRencontre() {
		return proxyRencontre;
	}

	public void setProxyRencontre(IBusinessRencontre proxyRencontre) {
		this.proxyRencontre = proxyRencontre;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public IBusinessSport getProxySport() {
		return proxySport;
	}

	public void setProxySport(IBusinessSport proxySport) {
		this.proxySport = proxySport;
	}

	public List<String> getLibelleSports() {
		return libelleSports;
	}

	public void setLibelleSports(List<String> libelleSports) {
		this.libelleSports = libelleSports;
	}

	public List<String> getLibelleVilles() {
		return libelleVilles;
	}

	public void setLibelleVilles(List<String> libelleVilles) {
		this.libelleVilles = libelleVilles;
	}

	public List<Membre> getPartenaires() {
		return partenaires;
	}

	public void setPartenaires(List<Membre> partenaires) {
		this.partenaires = partenaires;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public String getFiltreSport() {
		return filtreSport;
	}

	public void setFiltreSport(String filtreSport) {
		this.filtreSport = filtreSport;
	}

	public String getFiltreVille() {
		return filtreVille;
	}

	public void setFiltreVille(String filtreVille) {
		this.filtreVille = filtreVille;
	}

	public String getFiltreDate() {
		return filtreDate;
	}

	public void setFiltreDate(String filtreDate) {
		this.filtreDate = filtreDate;
	}

	public List<Participation> getTotalParticipations() {
		return totalParticipations;
	}

	public void setTotalParticipations(List<Participation> totalParticipations) {
		this.totalParticipations = totalParticipations;
	}

	public String getRencontres() {
		return rencontres;
	}

	public void setRencontres(String rencontres) {
		this.rencontres = rencontres;
	}

	public String getDemoListeRencontres() {
		return demoListeRencontres;
	}

	public void setDemoListeRencontres(String demoListeRencontres) {
		this.demoListeRencontres = demoListeRencontres;
	}

	public String getRencontresCal() {
		return rencontresCal;
	}

	public void setRencontresCal(String rencontresCal) {
		this.rencontresCal = rencontresCal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}
	
	
}
