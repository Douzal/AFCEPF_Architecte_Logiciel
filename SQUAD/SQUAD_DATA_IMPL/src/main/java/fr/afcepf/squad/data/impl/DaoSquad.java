package fr.afcepf.squad.data.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.MembreSquad;
import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.entity.MessageSquad;
import fr.afcepf.squad.entity.Notification;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.entity.Squad;
import fr.afecpf.squad.data.api.IDaoSquad;

@Remote(IDaoSquad.class)
@Stateless
public class DaoSquad implements IDaoSquad {

	@PersistenceContext(unitName = "CONNECTION_SQUAD")
	private EntityManager em;

	private static final String HQL_REQ_GET_ALL_SQUAD= "SELECT s FROM Squad s";
	private static final String HQL_REQ_GET_SQUAD_BY_SPORT = "SELECT s FROM Squad s WHERE s.sport.id = :id_sport";
	private static final String HQL_REQ_GET_SQUAD_BY_MEMBRE = "SELECT s from Squad s join fetch s.membresSquad ms WHERE ms.membre.id = :id_membre";
	private static final String HQL_REQ_GET_MEMBER_OF_SQUAD = "SELECT s from Squad s inner join fetch s.membresSquad ms inner join fetch ms.membre "
			+ "WHERE s.id = :id_squad  ";
	private static final String HQL_REQ_GET_SQUAD_BY_MEMBRE_SPORT = "select s from Squad s inner join fetch s.sport inner join fetch s.membresSquad ms WHERE ms.membre.id = :id_membre";
	private static final String HQL_REQ_GET_MEMBRE_SQUAD = "SELECT s From Squad s left join fetch s.membresSquad ms inner join fetch ms.membre inner join fetch s.squadRogueLeader WHERE s=:squad";
	private static final String HQL_REQ_GET_RENCONTRE_INVITE = "SELECT m From Rencontre r left join r.invites m WHERE r=:rencontre";
    
	private static final String HQL_REQ_GET_ALL_RENCONTRE_AVENIR_SQUAD = "SELECT r from Rencontre r WHERE (r.squad = :squad) AND (r.dateDebut > current_date) ORDER BY r.dateDebut ";
	
	private static final String HQL_REQ_GET_ALL_RENCONTRE_PASSE = "SELECT r from Rencontre r WHERE (r.squad = :squad) AND (r.dateDebut < current_date) ORDER BY r.dateDebut ";
	
	private static final String HQL_REQ_GET_SQUAD_MESSAGE ="Select s FROM Squad s inner join fetch s.messages ms WHERE (s.id = :id_squad) AND (ms.messageParent is NULL)";
	
	private static final String HQL_GET_REPONSE_MESSAGE = "Select ms.reponses FROM MessageSquad ms WHERE ms.messageParent = :message";
	
	private static final String HQL_GET_SQUAD_FROM_RENCONTRE ="SELECT r.squad FROM Rencontre r WHERE r.id = :id_rencontre";
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Squad> getAllSquad() {
		Query query = em.createQuery(HQL_REQ_GET_ALL_SQUAD);
		List<Squad> squads = new ArrayList<>();
		if(query.getResultList().size()!=0){
			squads = query.getResultList();	
		}
		return squads;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Squad> getSquadBySport(Sport s) {
		Query query = em.createQuery(HQL_REQ_GET_SQUAD_BY_SPORT);
		query.setParameter("id_sport", s.getId());
		List<Squad> squads = new ArrayList<>();
		if(query.getResultList().size()!=0){
			squads = query.getResultList();	
		}
		return squads;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Squad> getAllSquadByMember(Membre membre) {
		Query query = em.createQuery(HQL_REQ_GET_SQUAD_BY_MEMBRE_SPORT);
		query.setParameter("id_membre", membre.getId());
		List<Squad> squads = new ArrayList<>();
		if(query.getResultList().size()!=0){
			squads = query.getResultList();	
		}
		return squads;
	}

	public Squad getAllInfosSquad(int id_squad){

		Query query = em.createQuery(HQL_REQ_GET_MEMBER_OF_SQUAD);
		query.setParameter("id_squad", id_squad);
		@SuppressWarnings("unchecked")
		List<Squad> result = query.getResultList();
		Squad squa = null;
		if(result.size()!=0){
			squa = result.get(0);
		}
		return squa;
	}


	@Override
	public void balancerLesInvitations(Rencontre rencontre, Squad squad) {
		System.out.println("invitations !!!!......");

		Query query = em.createQuery(HQL_REQ_GET_MEMBRE_SQUAD);
		query.setParameter("squad", squad);
		squad = (Squad) query.getSingleResult();

//		Query queryRencontre = em.createQuery(HQL_REQ_GET_RENCONTRE_INVITE);
//		queryRencontre.setParameter("rencontre", rencontre);
//		rencontre.setInvites(queryRencontre.getResultList());

		for(MembreSquad ms : squad.getMembresSquad()) {
			if(ms.getMembre().getId() != rencontre.getOrganisateur().getId()) {
				Notification notif = new Notification();
				notif.setMembre(ms.getMembre());
				notif.setDateNotif(new Date());
				notif.setTitre("[INVITATION] Votre squad : "+squad.getNom()+" propose un championnat");
				
				if(rencontre.getClass().getSimpleName().equals("Evenement")) {
				notif.setMessage("detailsChampionnat.xhtml?idevenement="+rencontre.getId());
				}else{
					notif.setMessage("detailRencontre.xhtml?idrencontre="+rencontre.getId());
				}
				
				em.persist(notif);
			}
		}

		if(rencontre.getOrganisateur().getId() != squad.getSquadRogueLeader().getId() && !squad.getMembresSquad().contains(squad.getSquadRogueLeader())) {
			Notification notif = new Notification();
			notif.setMembre(squad.getSquadRogueLeader());
			notif.setDateNotif(new Date());
			notif.setTitre("[INVITATION] Votre squad : "+squad.getNom()+" propose un championnat");
			
			if(rencontre.getClass().getSimpleName().equals("Evenement")) {
			notif.setMessage("detailsChampionnat.xhtml?idevenement="+rencontre.getId());
			}else{
				notif.setMessage("detailRencontre.xhtml?idrencontre="+rencontre.getId());
			}
			
			em.persist(notif);
		}

		//em.merge(rencontre);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rencontre> getAllRencontreFromSquad(Squad squad) {
		Query query = em.createQuery(HQL_REQ_GET_ALL_RENCONTRE_AVENIR_SQUAD);
		query.setParameter("squad",squad);
		List<Rencontre> rencontres = new ArrayList<>();
		if(query.getResultList().size()!=0){
			rencontres = query.getResultList();	
		}
		return rencontres;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rencontre> getAllOldRencontreFromSquad(Squad squad){
		Query query = em.createQuery(HQL_REQ_GET_ALL_RENCONTRE_PASSE).setParameter("squad", squad);
		return query.getResultList()  ;
		
	}
	
	public MembreSquad addMemberToSquad(MembreSquad membreSquad){
		 em.persist(membreSquad);
		 return membreSquad;
	}

    public Squad getMessageOfSquad(Integer idSquad){
    	
    	 Query query = em.createQuery(HQL_REQ_GET_SQUAD_MESSAGE);
	        query.setParameter("id_squad", idSquad);
	  		@SuppressWarnings("unchecked")
	  		List<Squad> result = query.getResultList();
	  		Squad squad = null;
	  		if(result.size()!=0){
	  			squad = result.get(0);
	  		}
	  		return squad;
    }

    public Squad getSquadFromRencontre(Integer idRencontre){
    	
   	 Query query = em.createQuery(HQL_GET_SQUAD_FROM_RENCONTRE);
	        query.setParameter("id_rencontre", idRencontre);
	  		@SuppressWarnings("unchecked")
	  		List<Squad> result = query.getResultList();
	  		Squad squad = null;
	  		if(result.size()!=0){
	  			squad = result.get(0);
	  		}
	  		return squad;
   }

    public List<MessageSquad> getMessagesOfSquad(Integer idSquad){
    	List<MessageSquad> messageSquad = new ArrayList<>();
    	Squad squad = this.getMessageOfSquad(idSquad);
    	for(MessageSquad messages : squad.getMessages()){
          if(messages.getMessageParent().getId()!=null){
        	  
        	  messageSquad.add(messages);
          }
    		
    	}
    	return messageSquad;
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageSquad> getReponseOfMembre(MessageSquad message) {
	
		return  em.createQuery(HQL_GET_REPONSE_MESSAGE).setParameter("message",message).getResultList();
	}

	// COCHON ! 
	//	@Override
	//	public void balancerLesInvitations(Rencontre rencontre, Squad squad) {
	//		System.out.println("invitations !!!!......");
	//		
	//		Query query = em.createQuery(HQL_REQ_GET_MEMBRE_SQUAD);
	//		List<Membre> invites = new ArrayList<>();
	//		query.setParameter("squad", squad);
	//		squad = (Squad) query.getSingleResult();
	//		
	//		for(MembreSquad ms : squad.getMembresSquad()) {
	//			if(ms.getMembre().getId() != rencontre.getOrganisateur().getId()) {
	//				invites.add(ms.getMembre());
	//				List<Rencontre> invit = new ArrayList<>();
	//				invit.add(rencontre);
	//				ms.getMembre().setInvitations(invit);
	//				
	//				em.merge(ms.getMembre());
	//			}
	//		}
	//		
	//		if(rencontre.getOrganisateur().getId() != squad.getSquadRogueLeader().getId()) {
	//			invites.add(squad.getSquadRogueLeader());
	//		}
	//		
	//		System.out.println(invites.size() + " invités !!!!! ******************* //");
	//		
	//		rencontre.setInvites(invites);
	//		
	//		em.merge(rencontre);
	//	}

}
