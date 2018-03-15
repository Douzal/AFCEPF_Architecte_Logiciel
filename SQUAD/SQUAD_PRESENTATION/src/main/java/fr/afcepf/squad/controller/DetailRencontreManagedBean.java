package fr.afcepf.squad.controller;

import java.io.IOException;
import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.MessageRencontre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Squad;
import fr.afcepf.squad.gestion.api.IBusinessMessage;
import fr.afcepf.squad.gestion.api.IBusinessParticipation;
import fr.afcepf.squad.gestion.api.IBusinessRencontre;
import fr.afcepf.squad.gestion.api.IBusinessSquad;

@ManagedBean(name ="mbDetailRencontre")
@ViewScoped
public class DetailRencontreManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Rencontre rencontre= new Rencontre();
	private Rencontre rencontreMessage= new Rencontre();
	private MessageRencontre message= new MessageRencontre();
	private MessageRencontre messageEnvoye= new MessageRencontre();
	private boolean estParticipant;
	// Gmap
	private String infosRencontre;

	
	private Participation participation = new Participation();
	private String reponse;


	@ManagedProperty(value="#{mbSession}")
	private SessionManagedBean sessionManagedBean;
	private Integer paramId;

	@EJB
	private IBusinessSquad proxySquad;
	@EJB
	private IBusinessRencontre proxyRencontre;
	@EJB
	private IBusinessMessage proxyMessage;
	@EJB
	private IBusinessParticipation proxyParticipation;
	
	private Membre membreConnected;
	private Squad squad;

	private Participation p;
	
	@PostConstruct
	public void init(){

		paramId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idrencontre"));
		rencontre=proxyRencontre.getById(paramId);
		squad = proxySquad.getSquadFromRencontre(paramId);
		rencontreMessage=proxyRencontre.getMessageById(paramId);
		membreConnected=sessionManagedBean.getMembreConnecte();
		
		if(membreConnected != null) {
			estParticipant=checkParticipant();
		}
		//Gmap
		infosRencontre = "{\"lat\": " + rencontre.getAdresseLat() + ", \"lng\": " + rencontre.getAdresseLong() + "}";
		
		estParticipant=checkParticipant();
			
	}

	public void ajouterMessage() throws IOException{
		message.setMessage(reponse);
		message.setAuteur(membreConnected);
		message.setRencontre(rencontre);
		messageEnvoye= (MessageRencontre) proxyMessage.ajouter(message);
		//rencontreMessage=proxyRencontre.getMessageById(paramId);
		// FacesContext.getCurrentInstance().getExternalContext().redirect("/detailRencontre.xhtml?idrencontre="+paramId);
	//	return "detailRencontre.xhtml?idrencontre="+paramId+"&faces-redirect=true";
		rencontreMessage=proxyRencontre.getMessageById(paramId);
		
        reponse="";
	}

	
	public String inscriptionRencontre(){
		participation=proxyParticipation.ajouter(membreConnected, rencontre);
		return "detailRencontre.xhtml?idrencontre="+paramId+"&faces-redirect=true";
	}
	

	
	public boolean checkParticipant(){
	       
        for (Participation m : rencontre.getParticipations()) 
        {
			if(m.getParticipant().getId().equals(membreConnected.getId().intValue()))
			{   
				p=m;
			    System.out.println(p.getId());
				return true;
			}
        }
        return false;
	}
	
	public Participation getParticipation() {
		return participation;
	}

	public void setParticipation(Participation paramParticipation) {
		participation = paramParticipation;
	}

	public IBusinessParticipation getProxyParticipation() {
		return proxyParticipation;
	}

	public void setProxyParticipation(IBusinessParticipation paramProxyParticipation) {
		proxyParticipation = paramProxyParticipation;
	}

	
	
	public Participation getP() {
		return p;
	}

	public void setP(Participation paramP) {
		p = paramP;
	}

	public SessionManagedBean getSessionManagedBean() {
		return sessionManagedBean;
	}

	public void setSessionManagedBean(SessionManagedBean paramSessionManagedBean) {
		sessionManagedBean = paramSessionManagedBean;
	}

	public MessageRencontre getMessage() {
		return message;
	}

	public void setMessage(MessageRencontre paramMessage) {
		message = paramMessage;
	}

	public IBusinessMessage getProxyMessage() {
		return proxyMessage;
	}

	public void setProxyMessage(IBusinessMessage paramProxyMessage) {
		proxyMessage = paramProxyMessage;
	}

	public Membre getMembreConnected() {
		return membreConnected;
	}

	public void setMembreConnected(Membre paramMembreConnected) {
		membreConnected = paramMembreConnected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rencontre getRencontre() {
		return rencontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	public Integer getParamId() {
		return paramId;
	}

	public void setParamId(Integer paramId) {
		this.paramId = paramId;
	}

	public IBusinessRencontre getProxyRencontre() {
		return proxyRencontre;
	}

	public void setProxyRencontre(IBusinessRencontre proxyRencontre) {
		this.proxyRencontre = proxyRencontre;
	}

	public Rencontre getRencontreMessage() {
		return rencontreMessage;
	}

	public void setRencontreMessage(Rencontre paramRencontreMessage) {
		rencontreMessage = paramRencontreMessage;
	}


	public MessageRencontre getMessageEnvoye() {
		return messageEnvoye;
	}


	public void setMessageEnvoye(MessageRencontre paramMessageEnvoye) {
		messageEnvoye = paramMessageEnvoye;
	}

	public boolean isEstParticipant() {
		return estParticipant;
	}


	public void setEstParticipant(boolean paramEstParticipant) {
		estParticipant = paramEstParticipant;
	}

	public String getInfosRencontre() {
		return infosRencontre;
	}

	public void setInfosRencontre(String infosRencontre) {
		this.infosRencontre = infosRencontre;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Squad getSquad() {
		return squad;
	}

	public void setSquad(Squad squad) {
		this.squad = squad;
	}

	

}
