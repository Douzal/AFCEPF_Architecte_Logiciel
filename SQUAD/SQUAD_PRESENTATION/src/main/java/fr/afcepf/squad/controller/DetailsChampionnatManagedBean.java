package fr.afcepf.squad.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.squad.entity.Confrontation;
import fr.afcepf.squad.entity.Equipe;
import fr.afcepf.squad.entity.Evenement;
import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.entity.MessageRencontre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.gestion.api.IBusinessEvenement;

@ManagedBean(name="mbDetailsChampionnat")
@ViewScoped
public class DetailsChampionnatManagedBean {

	@ManagedProperty(value="#{mbSession}")
	private SessionManagedBean sessionManagedBean;

	private Membre membreConnecte;
	private Evenement evenement;
	private boolean estOrga;
	private boolean estParticipant;
	private boolean estSansEquipe;
	private String inputEquipe;
	private String message;
	private String url;
	private Confrontation confrontationSelectionnee;


	private Integer idEvenement;

	@EJB
	private IBusinessEvenement proxyEvenement;

	@PostConstruct
	public void init() {

		idEvenement = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idevenement"));
		membreConnecte = sessionManagedBean.getMembreConnecte();

		evenement = proxyEvenement.getEvenementFullPackById(idEvenement);

		estOrga = checkEstOrga();

		estParticipant = checkestParticipant();

		if(estParticipant) {
			estSansEquipe = checkEstSansEquipe();
		}

		if(evenement.getConfrontations().size() > 0) {
			confrontationSelectionnee = evenement.getConfrontations().get(0);
		}

		url = "detailsChampionnat.xhtml?idevenement="+idEvenement;

	}

	public boolean checkestParticipant() {

		for(Participation p : evenement.getParticipations()) {
			
			if(p.getParticipant().getId().equals(membreConnecte.getId().intValue())) {
				return true;
			}
		}
		
		System.out.println(membreConnecte.getId() + "*****connecte*******");
		
		return false;
	}

	public boolean checkEstSansEquipe() {

		for(Equipe e : evenement.getEquipes()) {
			for(Membre m : e.getParticipants()) {
				if(m.getId() == membreConnecte.getId()) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean checkEstOrga() {
		return (evenement.getOrganisateur().getId().equals(membreConnecte.getId().intValue()));
	}

	public void updateScore() {

		confrontationSelectionnee = proxyEvenement.updateScore(confrontationSelectionnee);
	}

	public void ajouterEquipe() {
		Equipe equipe = new Equipe();
		equipe.setEvenement(evenement);
		equipe.setParticipants(new ArrayList<Membre>());
		equipe.setNom(inputEquipe);

		evenement = proxyEvenement.ajouterEquipe(equipe, evenement);

		inputEquipe = "";
	}

	public void supprimerEquipe(Equipe equipe) {
		evenement = proxyEvenement.retirerEquipe(equipe, evenement);
		
		estSansEquipe = true;
	}

	public void rejoindreEquipe(Equipe equipe) {

		evenement  = proxyEvenement.modifierEquipeAdd(equipe, membreConnecte, evenement);

		estSansEquipe = false;

	}

	public void quitterEquipe(Equipe equipe, Membre membre) {
		
		equipe.getParticipants().remove(membre);
		
		equipe = proxyEvenement.updateMembreEquipe(equipe);
		
		//evenement = proxyEvenement.modifierEquipeDel(equipe, membreConnecte, evenement);
		
		estSansEquipe = true;
	}

	public void retirerParticipant(Participation p) throws IOException {

		evenement = proxyEvenement.retirerParticipation(p, evenement);

	}

	public void saveMessage() {
		MessageRencontre mr = new MessageRencontre();
		mr.setAuteur(membreConnecte);
		mr.setDateMessage(new Date());
		mr.setRencontre(evenement);
		mr.setMessage(message);

		evenement = proxyEvenement.ajouterMessage(evenement, mr);

		message = "";

	}
	
	public void retirerMessage(Message msg) {

		evenement = proxyEvenement.retirerMessage(evenement, msg);

	}

	public void placerAutomatiquementParticipantsSansEq() {
		
		evenement = proxyEvenement.placerLesGens(evenement, membreSansEquipe());
		
		estSansEquipe = false;
	}

	public HashMap<String,Integer> fromTheBottomToTheTop() {

		HashMap<String,Integer> resultats = new HashMap<>();

		for(Equipe e : evenement.getEquipes()) {
			resultats.put(e.getNom(), 0);
		}

		for(Confrontation c : evenement.getConfrontations()) {

			if(c.getResultats().get(0).getScore() != null || c.getResultats().get(1).getScore() != null )
			{
				if(c.getResultats().get(0).getScore() > c.getResultats().get(1).getScore() ) {

					int pointsGagnant = resultats.get(c.getResultats().get(0).getEquipe().getNom());

					resultats.put(c.getResultats().get(0).getEquipe().getNom(), pointsGagnant + 3);


				} else if (c.getResultats().get(0).getScore() < c.getResultats().get(1).getScore() )  {

					int pointsGagnant = resultats.get(c.getResultats().get(1).getEquipe().getNom());

					resultats.put(c.getResultats().get(1).getEquipe().getNom(), pointsGagnant + 3);

				}else {

					int pointsEq0 =  resultats.get(c.getResultats().get(0).getEquipe().getNom());
					int pointsEq1 =  resultats.get(c.getResultats().get(1).getEquipe().getNom());


					resultats.put(c.getResultats().get(0).getEquipe().getNom(), pointsEq0 + 1);
					resultats.put(c.getResultats().get(1).getEquipe().getNom(), pointsEq1 + 1);
				}
			}
		}

		return resultats;
	}

	public List<Membre> membreSansEquipe() {

		List<Membre> memSansEquipe = new ArrayList<>();
		boolean checkSansEquipe;

		for(Participation p : evenement.getParticipations()) {

			checkSansEquipe = true;

			for(Equipe eq : evenement.getEquipes()) {
				for(Membre m: eq.getParticipants()) {
					if(p.getParticipant().getId() == m.getId()) {
						checkSansEquipe = false;
					}
				}
			}

			if(checkSansEquipe) {
				memSansEquipe.add(p.getParticipant());
			}
		}

		return memSansEquipe;
	}

	public List<List<Confrontation>> confrontationParRound() {

		List<List<Confrontation>> rounds = new ArrayList<>();


		int nbRound = evenement.getEquipes().size()-1;
		
		if(evenement.getEquipes().size() % 2 !=0) {
			nbRound++;
		}

		for(int i = 1; i<=nbRound; i++) {

			List<Confrontation> confrontations = new ArrayList<>();

			for(Confrontation c : evenement.getConfrontations()) {

				if(c.getRound() == i) {

					confrontations.add(c);
					
					
				}
			}

			rounds.add(confrontations);
		}

		return rounds;
	}

	public void participer() throws IOException{

		Participation participation = new Participation();
		participation.setDateDemande(new Date());
		participation.setDateValidation(new Date());
		participation.setParticipant(membreConnecte);
		participation.setRencontre(evenement);

		evenement = proxyEvenement.ajouterParticipation(participation, evenement);

		estParticipant = true;
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(url);

	}

	public void retirerParticipation() throws IOException {

		Participation participation = new Participation();

		for(Participation p : evenement.getParticipations()) {
			if(p.getParticipant().getId().equals(membreConnecte.getId().intValue())) {

				participation = p;
			}
		}

		evenement = proxyEvenement.retirerParticipation(participation, evenement);

		estParticipant = false;
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(url);

	}

	public void confrontationPourRes(Confrontation conf) {
		confrontationSelectionnee = conf;
	}
	
	


	public void genererConfrontation() throws IOException {		
		evenement = proxyEvenement.genererConfrontation(evenement);

		FacesContext.getCurrentInstance().getExternalContext().redirect(url);


	}

	public DetailsChampionnatManagedBean() {
		super();
	}

	public DetailsChampionnatManagedBean(SessionManagedBean sessionManagedBean, Membre membreConnecte,
			Evenement evenement, boolean estOrga, boolean estParticipant, boolean estSansEquipe, String inputEquipe,
			String message, Confrontation confrontationSelectionnee, Integer idEvenement,
			IBusinessEvenement proxyEvenement) {
		super();
		this.sessionManagedBean = sessionManagedBean;
		this.membreConnecte = membreConnecte;
		this.evenement = evenement;
		this.estOrga = estOrga;
		this.estParticipant = estParticipant;
		this.estSansEquipe = estSansEquipe;
		this.inputEquipe = inputEquipe;
		this.message = message;
		this.confrontationSelectionnee = confrontationSelectionnee;
		this.idEvenement = idEvenement;
		this.proxyEvenement = proxyEvenement;
	}

	public SessionManagedBean getSessionManagedBean() {
		return sessionManagedBean;
	}

	public void setSessionManagedBean(SessionManagedBean sessionManagedBean) {
		this.sessionManagedBean = sessionManagedBean;
	}

	public Membre getMembreConnecte() {
		return membreConnecte;
	}

	public void setMembreConnecte(Membre membreConnecte) {
		this.membreConnecte = membreConnecte;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public boolean isEstOrga() {
		return estOrga;
	}

	public void setEstOrga(boolean estOrga) {
		this.estOrga = estOrga;
	}

	public boolean isEstSansEquipe() {
		return estSansEquipe;
	}

	public void setEstSansEquipe(boolean estSansEquipe) {
		this.estSansEquipe = estSansEquipe;
	}

	public Integer getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Integer idEvenement) {
		this.idEvenement = idEvenement;
	}

	public IBusinessEvenement getProxyEvenement() {
		return proxyEvenement;
	}

	public void setProxyEvenement(IBusinessEvenement proxyEvenement) {
		this.proxyEvenement = proxyEvenement;
	}

	public boolean isEstParticipant() {
		return estParticipant;
	}

	public void setEstParticipant(boolean estParticipant) {
		this.estParticipant = estParticipant;
	}

	public String getInputEquipe() {
		return inputEquipe;
	}

	public void setInputEquipe(String inputEquipe) {
		this.inputEquipe = inputEquipe;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Confrontation getConfrontationSelectionnee() {
		return confrontationSelectionnee;
	}

	public void setConfrontationSelectionnee(Confrontation confrontationSelectionnee) {
		this.confrontationSelectionnee = confrontationSelectionnee;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
