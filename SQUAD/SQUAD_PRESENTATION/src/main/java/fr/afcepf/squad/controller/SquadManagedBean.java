package fr.afcepf.squad.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.MembreSquad;
import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.entity.MessageSquad;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Squad;
import fr.afcepf.squad.gestion.api.IBusinessMessage;
import fr.afcepf.squad.gestion.api.IBusinessSquad;

@ManagedBean(name="mbSquad")
@ViewScoped
public class SquadManagedBean {

	private Squad squad;
	@EJB 
	private IBusinessSquad proxySquad;
	private Integer id_squad;
	private List<Membre> membreSquad = new ArrayList<>();
	private List<Rencontre> rencontreSquad = new ArrayList<>();
	private Rencontre prochaineRencontre = new Rencontre();
	private List<Rencontre> autreRencontres = new ArrayList<>();
	private List<Rencontre> rencontresPasse = new ArrayList<>();
	@ManagedProperty(value="#{mbSession}")
	private SessionManagedBean sessionManagedBean;
	private boolean estMembreSquad; 
	private Membre membreConnected;
	private Squad squadMessage = new Squad();
	private MessageSquad message = new MessageSquad();
	private MessageSquad reponse = new MessageSquad();
	private String reponseMessage = new String();
	private List<MessageSquad> reponses = new ArrayList<>();
	private List<MessageSquad> messages = new ArrayList<>();
	@EJB
	private IBusinessMessage proxyMessage;
    private String contenuMessage;


	@PostConstruct
	public void init(){
		id_squad = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idsquad"));
		squad = proxySquad.getAllInfosSquad(id_squad);
		squadMessage = proxySquad.getMessageOfSquad(id_squad);
	//	messages = proxySquad.getMessagesOfSquad(id_squad);
		for (MembreSquad mb : squad.getMembresSquad()) {
			membreSquad.add(mb.getMembre());
		}

		membreConnected = sessionManagedBean.getMembreConnecte();
		estMembreSquad = EstMembreSquad();
		rencontreSquad = proxySquad.getAllRencontreFromSquad(squad);
		rencontresPasse = proxySquad.getAllOldRencontreFromSquad(squad);
		if(rencontreSquad.size()!=0){
			prochaineRencontre = rencontreSquad.get(0);

			for(int i=1;i<rencontreSquad.size();i++){
				autreRencontres.add(rencontreSquad.get(i));

			}
		}
	}
	public List<MessageSquad> getReponses() {
		return reponses;
	}
	public void setReponses(List<MessageSquad> reponses) {
		this.reponses = reponses;
	}
	public List<MessageSquad> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageSquad> messages) {
		this.messages = messages;
	}
	private boolean EstMembreSquad() {
		for(Membre memb : membreSquad ){
			if(memb.getId().equals(membreConnected.getId().intValue())){
				return true;
			}

		}
		return false;
	}

	public String AjouterReponse(MessageSquad messageArepondre){
		reponse.setMessage(reponseMessage);
		reponse.setAuteur(membreConnected);
		reponse.setSquad(squad);
		reponse.setMessageParent(messageArepondre);
		proxyMessage.ajouter(reponse);
		return "detailsSquad.xhtml?idsquad="+id_squad+"&faces-redirect=true";
	     
	}
	
//	public String afficherProfil(Integer id_profil){
//		
//		return "profile.xhtml?idmembre="+id_profil+"&faces-redirect=true";
//	}
//	
	public String redirectRencontre(){
       String redirect;
	   if(prochaineRencontre.getClass() == Rencontre.class){
		redirect ="detailRencontre.xhtml?idrencontre="+prochaineRencontre.getId()+"&faces-redirect=true";}
	   else{
		   redirect="detailsChampionnat.xhtml?idevenement="+prochaineRencontre.getId()+"&faces-redirect=true";}
	   return redirect;
	   }
	
	
	public List<MessageSquad> afficherReponse(MessageSquad message){
		
		reponses = proxySquad.getReponseOfMembre(message);
		if(reponses.size()!=0){
		System.out.println(reponses.get(0).getAuteur().getNom());}
		
		return reponses;
		
	}
	
	public String AjouterMembreSquad(){

		if(!estMembreSquad){
			proxySquad.addMemberToSquad(membreConnected, squad);

		}

		return "detailsSquad.xhtml?idsquad="+id_squad+"&faces-redirect=true";

	}

	public void ajouterMessage() throws IOException{
		message.setMessage(contenuMessage);
		message.setAuteur(membreConnected);
		message.setSquad(squad);
		proxyMessage.ajouter(message);
		squadMessage = proxySquad.getMessageOfSquad(id_squad);
		contenuMessage="";
//		return "detailsSquad.xhtml?idsquad="+id_squad+"&faces-redirect=true";

	}


	public Rencontre getProchaineRencontre() {
		return prochaineRencontre;
	}



	public void setProchaineRencontre(Rencontre prochaineRencontre) {
		this.prochaineRencontre = prochaineRencontre;
	}



	public Squad getSquad() {
		return squad;
	}

	public void setSquad(Squad squad) {
		this.squad = squad;
	}

	public Integer getId_squad() {
		return id_squad;
	}

	public void setId_squad(Integer id_squad) {
		this.id_squad = id_squad;
	}

	public List<Membre> getMembreSquad() {
		return membreSquad;
	}

	public void setMembreSquad(List<Membre> membreSquad) {
		this.membreSquad = membreSquad;
	}

	public SquadManagedBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Rencontre> getRencontreSquad() {
		return rencontreSquad;
	}

	public void setRencontreSquad(List<Rencontre> rencontreSquad) {
		this.rencontreSquad = rencontreSquad;
	}



	public List<Rencontre> getAutreRencontres() {
		return autreRencontres;
	}




	public List<Rencontre> getRencontresPasse() {
		return rencontresPasse;
	}



	public void setRencontresPasse(List<Rencontre> rencontresPasse) {
		this.rencontresPasse = rencontresPasse;
	}



	public void setAutreRencontres(List<Rencontre> autreRencontres) {
		this.autreRencontres = autreRencontres;
	}

	public boolean isEstMembreSquad() {
		return estMembreSquad;
	}

	public void setEstMembreSquad(boolean estMembreSquad) {
		this.estMembreSquad = estMembreSquad;
	}

	public SessionManagedBean getSessionManagedBean() {
		return sessionManagedBean;
	}

	public void setSessionManagedBean(SessionManagedBean sessionManagedBean) {
		this.sessionManagedBean = sessionManagedBean;
	}

	public Membre getMembreConnected() {
		return membreConnected;
	}

	public void setMembreConnected(Membre membreConnected) {
		this.membreConnected = membreConnected;
	}
	public Squad getSquadMessage() {
		return squadMessage;
	}
	public void setSquadMessage(Squad squadMessage) {
		this.squadMessage = squadMessage;
	}
	public MessageSquad getMessage() {
		return message;
	}
	public void setMessage(MessageSquad message) {
		this.message = message;
	}
	public MessageSquad getReponse() {
		return reponse;
	}
	public void setReponse(MessageSquad reponse) {
		this.reponse = reponse;
	}
	public String getReponseMessage() {
		return reponseMessage;
	}
	public void setReponseMessage(String reponseMessage) {
		this.reponseMessage = reponseMessage;
	}
	public String getContenuMessage() {
		return contenuMessage;
	}
	public void setContenuMessage(String contenuMessage) {
		this.contenuMessage = contenuMessage;
	}




}
