package fr.afcepf.squad.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.afcepf.squad.entity.Confrontation;
import fr.afcepf.squad.entity.Equipe;
import fr.afcepf.squad.entity.Evenement;
import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.MessageRencontre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.ResultatConfrontation;
import fr.afecpf.squad.data.api.IDaoEvenement;

@Remote(IDaoEvenement.class)
@Stateless
public class DaoEvenement implements IDaoEvenement {

    @PersistenceContext(unitName = "CONNECTION_SQUAD")
    private EntityManager em;
    
    private static final String HQL_FULLEVENTBYID = "SELECT e FROM Evenement e inner join fetch e.sport left join fetch e.participations part inner join fetch part.participant WHERE e.id = :idEvenement";
    private static final String HQL_GETEQUIPEBYEVT = "SELECT DISTINCT eq FROM Equipe eq left join fetch eq.participants WHERE eq.evenement.id=:idEvenement";
    private static final String HQL_GET_CONF_BYID = "SELECT c FROM Confrontation c left join fetch c.resultats WHERE c.id=:id";
    private static final String HQL_GET_FULL_CONF = "SELECT DISTINCT conf FROM Confrontation conf left join fetch conf.resultats WHERE conf.evenement.id=:idEvenement";
    private static final String HQL_GET_MESSAGE_EVENT = "SELECT DISTINCT mr FROM MessageRencontre mr WHERE mr.rencontre.id = :idEvenement and mr.messageParent is NULL";
    private static final String HQL_GETALL_PARTICIPANT = "SELECT p From Participation p inner join fetch p.participant WHERE p.rencontre.id=:idEvenement";
    
    @Override
    public Evenement creer(Evenement paramEvenement) {
        em.persist(paramEvenement.getEquipes().get(paramEvenement.getEquipes().size()-1));
        return paramEvenement;
    }

	@Override
	public Evenement getEvenementFullPackById(Integer id) {
		System.out.println(">>> get full infos event ******");
		Query query = em.createQuery(HQL_FULLEVENTBYID);
        query.setParameter("idEvenement", id);
        @SuppressWarnings("unchecked")
        Evenement evenement = (Evenement) query.getSingleResult();
        
        	if(evenement != null) {
        		
        		refreshConfrontation(evenement);
        		
        		refreshEquipe(evenement);
        		
        		refreshMessage(evenement);
        		
        		refreshParticipant(evenement);
		
        	}
        	
        return evenement;
	}

	@Override
	public Equipe ajouterEquipe(Equipe equipe) {
		em.persist(equipe);
		return equipe;
	}

	@Override
	public Equipe updateMembreEquipe(Equipe equipe) {
		equipe = em.merge(equipe);
		return equipe;
	}

	@Override
	public Evenement supprimerEquipe(Evenement evenement, Equipe equipe) {
		evenement.getEquipes().remove(equipe);
		em.merge(evenement);
		equipe = em.merge(equipe);
		em.remove(equipe);
		return evenement;
	}

	@Override
	public Evenement refreshInstance(Evenement evenement) {
		em.merge(evenement);
		return evenement;
	}

	@Override
	public ResultatConfrontation ajouterRes(ResultatConfrontation rc) {
		em.persist(rc);
		return rc;
	}

	@Override
	public Confrontation ajouterConf(Confrontation conf) {
		em.persist(conf);
		
//		for(ResultatConfrontation rs : conf.getResultats()) {
//			em.persist(rs);
//		}
		
		return conf;
	}

	@Override
	public Confrontation getConfrontationById(Integer id) {
		Query query = em.createQuery(HQL_GET_CONF_BYID);
		query.setParameter("id", id);
		
		Confrontation conf = (Confrontation) query.getSingleResult();
		
		return conf;
	}

	@Override
	public Confrontation updateAjoutRes(Confrontation conf) {
		System.out.println("update scores****");
		Confrontation confrontation = em.find(Confrontation.class, conf.getId());
		
		confrontation.getResultats().get(0).setScore(conf.getResultats().get(0).getScore());
		confrontation.getResultats().get(1).setScore(conf.getResultats().get(1).getScore());
		
		conf = em.merge(confrontation);
		return conf;
	}

	@Override
	public Evenement refreshEquipe(Evenement evenement) {
		Query queryEquipe = em.createQuery(HQL_GETEQUIPEBYEVT);
		queryEquipe.setParameter("idEvenement", evenement.getId());
		List<Equipe> equipes = (List<Equipe>) queryEquipe.getResultList();
		evenement.setEquipes(equipes);
		return evenement;
	}

	@Override
	public Evenement refreshMessage(Evenement evenement) {
		Query queryMessage = em.createQuery(HQL_GET_MESSAGE_EVENT);
		queryMessage.setParameter("idEvenement", evenement.getId());
		List<MessageRencontre> messages = queryMessage.getResultList();
		evenement.setMessages(messages);
		return evenement;
	}

	@Override
	public Evenement refreshParticipant(Evenement evenement) {
		Query queryParticipant = em.createQuery(HQL_GETALL_PARTICIPANT);
		queryParticipant.setParameter("idEvenement", evenement.getId());
		List<Participation> participants = queryParticipant.getResultList();
		evenement.setParticipations(participants);
		return evenement;
	}

	@Override
	public Evenement refreshConfrontation(Evenement evenement) {
		Query queryConf = em.createQuery(HQL_GET_FULL_CONF);
		queryConf.setParameter("idEvenement", evenement.getId());
		List<Confrontation> confrontations = queryConf.getResultList();
		evenement.setConfrontations(confrontations);
		return evenement;
	}

	@Override
	public Evenement placerLesGens(Evenement evenement, List<Membre> membres) {

		Query query = em.createNativeQuery("INSERT INTO membre_equipe (id_membre,id_equipe) VALUES (?,?)");
		
		boolean estPlace = false;
		int tailleMiniEquipe = 0;
		int count = 0;
		
		for(Membre m : membres) {

			estPlace = false;
			
			while(!estPlace) {
				
				if(evenement.getEquipes().get(count).getParticipants().size() == tailleMiniEquipe) {
					
					evenement.getEquipes().get(count).getParticipants().add(m);
					query.setParameter(1, m);
					query.setParameter(2, evenement.getEquipes().get(count));
					query.executeUpdate();
					
					estPlace = true;
	
				}else{
					
					count++;
					
					if(count == evenement.getEquipes().size() ) {
						
						count = 0;
						tailleMiniEquipe++;
					}
				}
			}
			
			
		}
		
		return evenement;
	}

}
