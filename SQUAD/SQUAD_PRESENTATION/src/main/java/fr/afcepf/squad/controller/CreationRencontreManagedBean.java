package fr.afcepf.squad.controller;

import java.io.IOException;
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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.w3c.dom.DOMStringList;

import fr.afcepf.squad.entity.Evenement;
import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.entity.Squad;
import fr.afcepf.squad.enumeration.Sexe;
import fr.afcepf.squad.gestion.api.IBusinessParticipation;
import fr.afcepf.squad.gestion.api.IBusinessRencontre;
import fr.afcepf.squad.gestion.api.IBusinessSport;
import fr.afcepf.squad.gestion.api.IBusinessSquad;

@ManagedBean(name="mbCreationRencontre")
@ViewScoped
public class CreationRencontreManagedBean {

	private Rencontre rencontre = new Rencontre();
	private List<Sport> sports;
	private List<Squad> squads;
	private String recherche;
	private List<Squad> squadsSportSelectionne;
	private Squad squadSelectionne;
	private String sexe;
	private boolean orgaParticipant = true;
	private String dateDebut;
	private String dateFin;
	private SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

	@EJB
	private IBusinessSquad proxySquad;

	@EJB
	private IBusinessSport proxySport;

	@EJB
	private IBusinessRencontre proxyRencontre;

	@EJB
	private IBusinessParticipation proxyParticipation;

	@ManagedProperty(value="#{mbSession}")
	private SessionManagedBean sessionManagedBean;

	public IBusinessSport getProxySport() {
		return proxySport;
	}

	public void setProxySport(IBusinessSport proxySport) {
		this.proxySport = proxySport;
	}

	@PostConstruct
	public void init() {
		sports = proxySport.getAllSports();

		//test mode degueux mais pas li choix
		if(sessionManagedBean != null) {
			rencontre.setOrganisateur(sessionManagedBean.getMembreConnecte());
			squads = proxySquad.getAllSquadByMember(sessionManagedBean.getMembreConnecte());
			squadsSportSelectionne = proxySquad.getAllSquadByMember(sessionManagedBean.getMembreConnecte());

		}
		rencontre.setDateCreation(new Date());
	}

	public void rechercheSport() {
		sports = proxySport.searchSportByName(recherche);
	}

	public void posterRencontre() {

		rencontre = proxyRencontre.createRecontreComboInvitation(rencontre, squadSelectionne);


		if(orgaParticipant) {

			Membre organisateur = sessionManagedBean.getMembreConnecte();
			proxyParticipation.ajouter(organisateur, rencontre);

		}

		try {

			if(rencontre.getClass().getSimpleName().equals("Evenement")) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("detailsChampionnat.xhtml?idevenement="+rencontre.getId());
			}else{
				FacesContext.getCurrentInstance().getExternalContext().redirect("detailRencontre.xhtml?idrencontre="+rencontre.getId());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

	public void selectionSport(Sport sport) {

		rencontre.setSport(sport);

		System.out.println(">>> Set Sport : ****** " + rencontre.getSport().getLibelle() +  " ******");

		filtrerSquadSport();
	}

	public void changeNatureToRencontre() {
		Rencontre rencontreTemp = new Rencontre();

		jeMuteLoRencontreLo(rencontre, rencontreTemp);

		rencontre = rencontreTemp;

		System.out.println(">>>> Set Nature to :" + rencontre.getClass());
	}

	public void changeNatureToEvenement() {
		Evenement rencontreTemp = new Evenement();

		jeMuteLoRencontreLo(rencontre,rencontreTemp);

		rencontre = rencontreTemp;

		System.out.println(">>>> Set Nature to :" + rencontre.getClass());
	}


	public CreationRencontreManagedBean() {
		super();
	}

	public CreationRencontreManagedBean(Rencontre rencontre, List<Sport> sports, IBusinessSport proxySport) {
		super();
		this.rencontre = rencontre;
		this.sports = sports;
		this.proxySport = proxySport;
	}

	public Rencontre getRencontre() {
		return rencontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	public void jeMuteLoRencontreLo(Rencontre in, Rencontre out) {

		out.setOrganisateur(in.getOrganisateur());
		out.setSport(in.getSport());
		out.setSexe(in.getSexe());
		out.setLibelle(in.getLibelle());
		out.setDescription(in.getDescription());
		out.setDateCreation(in.getDateCreation());
		out.setDateDebut(in.getDateDebut());
		out.setDateFin(in.getDateFin());
		out.setNomLieu(in.getNomLieu());
		out.setAdresse(in.getAdresse());
		out.setAdresseLat(in.getAdresseLat());
		out.setAdresseLong(in.getAdresseLong());
		out.setCodePostal(in.getCodePostal());
		out.setNbMaxPart(in.getNbMaxPart());
		out.setSexe(in.getSexe());
		out.setVille(in.getVille());
	}

	public SessionManagedBean getSessionManagedBean() {
		return sessionManagedBean;
	}

	public void setSessionManagedBean(SessionManagedBean sessionManagedBean) {
		this.sessionManagedBean = sessionManagedBean;
	}

	public boolean isOrgaParticipant() {
		return orgaParticipant;
	}

	public void setOrgaParticipant(boolean orgaParticipant) {
		this.orgaParticipant = orgaParticipant;
	}

	public void filtrerSquadSport() {

		squadsSportSelectionne.clear();

		for (Squad s : squads) {

			if(s.getSport().getLibelle().equals(rencontre.getSport().getLibelle()) ) {

				squadsSportSelectionne.add(s);
			}
		}

		System.out.println(">> squad du membre : " + squadsSportSelectionne.size());
	}

	public void selectionnerSquadAInviter(Squad squad) {

		squadSelectionne = squad;

		System.out.println(">>>>>> ******* Squad selectionné : " + squadSelectionne.getNom());

		rencontre.setSquad(squad);

	}

	public List<Squad> getSquads() {
		return squads;
	}

	public void setSquads(List<Squad> squads) {
		this.squads = squads;
	}

	public List<Squad> getSquadsSportSelectionne() {
		return squadsSportSelectionne;
	}

	public void setSquadsSportSelectionne(List<Squad> squadsSportSelectionne) {
		this.squadsSportSelectionne = squadsSportSelectionne;
	}

	public Squad getSquadSelectionne() {
		return squadSelectionne;
	}

	public void setSquadSelectionne(Squad squadSelectionne) {
		this.squadSelectionne = squadSelectionne;
	}

	public IBusinessSquad getProxySquad() {
		return proxySquad;
	}

	public void setProxySquad(IBusinessSquad proxySquad) {
		this.proxySquad = proxySquad;
	}

	public IBusinessRencontre getProxyRencontre() {
		return proxyRencontre;
	}

	public void setProxyRencontre(IBusinessRencontre proxyRencontre) {
		this.proxyRencontre = proxyRencontre;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;

		switch (sexe) {
		case "homme":
			rencontre.setSexe(Sexe.HOMME);
			break;
		case "femme":
			rencontre.setSexe(Sexe.FEMME);
			break;
		default:
			rencontre.setSexe(Sexe.INDETERMINE);
			break;
		}
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) throws ParseException {
		this.dateDebut = dateDebut;


		rencontre.setDateDebut(sdf.parse(dateDebut));

	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) throws ParseException {
		this.dateFin = dateFin;

		rencontre.setDateFin(sdf.parse(dateFin));
	}




}
