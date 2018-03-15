package fr.afcepf.squad.controller;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.entity.Squad;
import fr.afcepf.squad.gestion.api.IBusinessSport;
import fr.afcepf.squad.gestion.api.IBusinessSquad;
import fr.afcepf.squad.gestion.api.IGestionMembre;


@ManagedBean(name="mbProfil")
@ViewScoped
public class ProfilManagedBean {


	@EJB
	private IBusinessSquad proxySquad;
	@EJB
	private IBusinessSport proxySport;

	@EJB
	private IGestionMembre proxyMembre;

	private List<Squad> squads= new ArrayList<>(); 
	private List<Sport> sports=new ArrayList<>(); 
	private HashMap<String,Double> frequence = new HashMap<>();
	private List<Squad> squadsInfos= new ArrayList<>(); 
	private HashMap<String,String> progressBar = new HashMap<>();
	private Integer idmembre;

	private Membre membreProfil;
	
	private List<Sport> sportsPratiques = new ArrayList<>();
	private List<String> frequences = new ArrayList<>();
	private String explicationFrequence;

	@PostConstruct
	public void init(){
		idmembre = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idmembre"));
		membreProfil = proxyMembre.getMemberById(idmembre);

		squads =proxySquad.getAllSquadByMember(membreProfil);
		frequence = proxySport.sportRateByMember(membreProfil);
		for (Map.Entry<String,Double> entry : frequence.entrySet()) {
			double pourcentage = entry.getValue();
			progressBar.put(entry.getKey(), Double.toString(pourcentage));
			
			sportsPratiques.add(proxySport.searchSportByName(entry.getKey()).get(0));
			frequences.add(Double.toString(pourcentage));
		}
	}
	
	public HashMap<String, String> getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(HashMap<String, String> progressBar) {
		this.progressBar = progressBar;
	}

	public List<Squad> getSquads() {
		return squads;
	}

	public void setSquads(List<Squad> squads) {
		this.squads = squads;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public HashMap<String, Double> getFrequence() {
		return frequence;
	}

	public void setFrequence(HashMap<String, Double> frequence) {
		this.frequence = frequence;
	}



	public List<Squad> getSquadsInfos() {
		return squadsInfos;
	}


	public void setSquadsInfos(List<Squad> squadsInfos) {
		this.squadsInfos = squadsInfos;
	}


	public ProfilManagedBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getIdmembre() {
		return idmembre;
	}


	public void setIdmembre(Integer idmembre) {
		this.idmembre = idmembre;
	}


	public Membre getMembreProfil() {
		return membreProfil;
	}


	public void setMembreProfil(Membre membreProfil) {
		this.membreProfil = membreProfil;
	}


	public IBusinessSquad getProxySquad() {
		return proxySquad;
	}


	public void setProxySquad(IBusinessSquad proxySquad) {
		this.proxySquad = proxySquad;
	}


	public IBusinessSport getProxySport() {
		return proxySport;
	}


	public void setProxySport(IBusinessSport proxySport) {
		this.proxySport = proxySport;
	}


	public IGestionMembre getProxyMembre() {
		return proxyMembre;
	}


	public void setProxyMembre(IGestionMembre proxyMembre) {
		this.proxyMembre = proxyMembre;
	}


	public List<Sport> getSportsPratiques() {
		return sportsPratiques;
	}


	public void setSportsPratiques(List<Sport> sportsPratiques) {
		this.sportsPratiques = sportsPratiques;
	}

	

}
