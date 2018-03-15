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
import fr.afcepf.squad.entity.Sport;
import fr.afecpf.squad.data.api.IDaoRencontre;
@Remote(IDaoRencontre.class)
@Stateless
public class DaoRencontre implements IDaoRencontre {

    @PersistenceContext(unitName = "CONNECTION_SQUAD")

    private EntityManager em;
    private static final String HQL_REQ_GET_RENCONTRE = "Select r FROM Rencontre r left join fetch r.participations p left join fetch p.participant WHERE r.id = :id";
    
    private static final String HQL_REQ_GET_RENCONTRE_BY_MEMBRE = "Select p FROM Participation p inner join fetch p.rencontre WHERE p.participant = :membre";
    
    private static final String HQL_REQ_GET_PARTICIPATIONS_BY_RENCONTRE = "SELECT p FROM Participation p WHERE p.rencontre = :rencontre";
    

    private static final String HQL_REQ_GET_RENCONTRE_BY_DATE = "Select r FROM Rencontre r WHERE r.dateDebut >= :date ORDER BY r.dateDebut";

    
    private static final String HQL_REQ_GET_PARTICIPATION_BY_SPORT_VILLE_DATE = "Select p FROM Participation p WHERE (:sport is NULL or p.rencontre.sport = :sport) AND (:ville is NULL or p.rencontre.Ville = :ville) AND (:date is NULL or p.rencontre.dateDebut >=:date)";
    
    private static final String HQL_REQ_GET_RENCONTRE_MESSAGE ="Select r FROM Rencontre "
    		+ "r inner join fetch r.messages "
    		+ "WHERE r.id = :id";
    
    private static final String HQL_REQ_GET_ALL_PARTICIPATIONS_BY_MEMBRE_SPORT_VILLE_DATE = "Select p FROM Participation p INNER JOIN FETCH p.rencontre WHERE (p.participant = :membre) AND (:sport is NULL or p.rencontre.sport = :sport) AND (:ville is NULL or p.rencontre.Ville = :ville) AND (:date is NULL or p.rencontre.dateDebut >=:date) ORDER BY p.rencontre.dateDebut";
    
    private static final String HQL_REQ_GET_ALL_RENCONTRE_BYSPORTVILLEDATE = "SELECT DISTINCT r FROM Rencontre r inner join fetch r.sport s left join fetch r.participations WHERE (r.Ville = :ville OR :ville IS NULL) AND (r.sport.libelle like :sport) AND (r.dateDebut >= :date OR :date IS NULL) ORDER BY r.dateDebut";
    
    @Override
    public Rencontre creer(Rencontre paramRencontre) {
        em.persist(paramRencontre);
        return paramRencontre;
    }
	@Override
	public Rencontre getById(Integer paramId) {
        Query query = em.createQuery(HQL_REQ_GET_RENCONTRE);
        query.setParameter("id", paramId);
  		@SuppressWarnings("unchecked")
  		List<Rencontre> result = query.getResultList();
  		Rencontre renc = null;
  		if(result.size()!=0){
  			renc = result.get(0);
  		}
  		return renc;
	}
	@Override
	public List<Participation> getRencontreByMembre(Membre membre) {
		
		Query query = em.createQuery(HQL_REQ_GET_RENCONTRE_BY_MEMBRE);
		query.setParameter("membre", membre);		
		@SuppressWarnings("unchecked")
        List<Participation> result = query.getResultList();
		return result;
	}
	@Override
	public List<Participation> getAllParticipationByRencontre(Rencontre rencontre) {
		Query query = em.createQuery(HQL_REQ_GET_PARTICIPATIONS_BY_RENCONTRE);
		query.setParameter("rencontre", rencontre);		
		@SuppressWarnings("unchecked")
        List<Participation> result = query.getResultList();		
		return result;
	}
	@Override
	public List<Rencontre> getRencByDate(Date paramDate) {
		Query query = em.createQuery(HQL_REQ_GET_RENCONTRE_BY_DATE);
        query.setParameter("date", paramDate);
        @SuppressWarnings("unchecked")
        List<Rencontre> result = query.getResultList();   
        return result;

	}
	@Override
	public List<Participation> getAllParticipationBySportVilleDate(Sport sport, String ville, Date date) {
		Query query = em.createQuery(HQL_REQ_GET_PARTICIPATION_BY_SPORT_VILLE_DATE);
		query.setParameter("sport", sport);
		query.setParameter("ville", ville);
		query.setParameter("date", date);
		@SuppressWarnings("unchecked")
	    List<Participation> result = query.getResultList();
		return result;
	}
	@Override
	public Rencontre getMessageById(Integer id) {
		 Query query = em.createQuery(HQL_REQ_GET_RENCONTRE_MESSAGE);
	        query.setParameter("id", id);
	  		@SuppressWarnings("unchecked")
	  		List<Rencontre> result = query.getResultList();
	  		Rencontre renc = null;
	  		if(result.size()!=0){
	  			renc = result.get(0);
	  		}
	  		return renc;
	}
	@Override
	public List<Participation> getAllParticipationByMembreSportVilleDate(Membre membre, Sport sport, String ville,
			Date date) {
		Query query = em.createQuery(HQL_REQ_GET_ALL_PARTICIPATIONS_BY_MEMBRE_SPORT_VILLE_DATE);
		query.setParameter("membre", membre);
		query.setParameter("sport", sport);
		query.setParameter("ville", ville);
		query.setParameter("date", date);
		@SuppressWarnings("unchecked")
	    List<Participation> result = query.getResultList();
		return result;
		
	}
	@Override
	public List<Rencontre> getAllRencontreBySportVilleDate(String sport, String paramVille, Date date) {
		Query query = em.createQuery(HQL_REQ_GET_ALL_RENCONTRE_BYSPORTVILLEDATE);
		query.setParameter("sport", "%" + sport + "%");
		query.setParameter("ville", paramVille);
		query.setParameter("date", date);
		@SuppressWarnings("unchecked")
	    List<Rencontre> result = query.getResultList();
		return result;
	}
}