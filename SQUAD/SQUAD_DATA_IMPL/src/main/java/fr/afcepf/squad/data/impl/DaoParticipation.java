package fr.afcepf.squad.data.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.Rencontre;
import fr.afecpf.squad.data.api.IDaoParticipation;
@Remote(IDaoParticipation.class)
@Stateless
public class DaoParticipation implements IDaoParticipation {

    @PersistenceContext(unitName = "CONNECTION_SQUAD")
    private EntityManager em;
    private static final String HQL_REQ_GET_PARTICIPATIONS_FUTURES =
            "SELECT p FROM Participation p WHERE p.participant.id = :idMembre ORDER BY p.rencontre.dateDebut ";
    private static final String HQL_REQ_GET_DATES_PARTICIPATIONS_FUTURES =
            "SELECT p.rencontre.dateDebut FROM Participation p WHERE p.participant.id = :idMembre ORDER BY p.rencontre.dateDebut ";
    //private static final String HQL_REQ_GET_PARTICIPATION_RENCONTRE = "SELECT p From Rencontre r left join r.participations p WHERE r=:rencontre";
    
    
    @Override
    public List<Participation> getAllParticipationsFutures(int paramIdMembre) {
        Query query = em.createQuery(HQL_REQ_GET_PARTICIPATIONS_FUTURES);
        query.setParameter("idMembre", paramIdMembre);
        @SuppressWarnings("unchecked")
        List<Participation> result = query.getResultList();

        return result;
    }
    @Override
    public List<Date> getAllDatesParticipationsFutures(int paramIdMembre) {
        Query query = em.createQuery(HQL_REQ_GET_DATES_PARTICIPATIONS_FUTURES);
        query.setParameter("idMembre", paramIdMembre);
        @SuppressWarnings("unchecked")
        List<Date> result = query.getResultList();
        return result;
    }
	@Override
	public Participation ajouter(Participation participation) {
//		Query query = em.createQuery(HQL_REQ_GET_PARTICIPATION_RENCONTRE);
//		query.setParameter("rencontre", rencontre);
//		rencontre.setParticipations(query.getResultList());
//		rencontre.getParticipations().add(participation);
//		em.merge(rencontre);
		em.persist(participation);
		return participation;
	}
	@Override
	public void retirer(Participation participation) {
		
		participation = em.find(Participation.class, participation.getId());
		
		em.remove(participation);
	}
	@Override
	public Participation ajouterBasique(Participation participation) {
		em.persist(participation);
		return participation;
	}
	

   

}
