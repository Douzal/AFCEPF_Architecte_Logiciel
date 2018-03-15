package fr.afcepf.squad.data.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Sport;
import fr.afecpf.squad.data.api.IDaoSport;

@Remote(IDaoSport.class)
@Stateless
public class DaoSport implements IDaoSport {
	
	@PersistenceContext(unitName = "CONNECTION_SQUAD")
	private EntityManager em;
	
	private static final String HQL_REQ_GET_ALL_SPORT= "SELECT s FROM Sport s";
	private static final String HQL_REQ_GET_SPORT_BY_ID = "SELECT s FROM Sport s WHERE s.id = :id_sport";
    private static final String HQL_REQ_GET_SPORT_BY_MEMBRE = "SELECT s FROM Sport s join fetch s.pratiquants p where p.id = :id_membre";
    private static final String HQL_REQ_GET_SPORT_RATE_BY_MEMBER ="SELECT p.rencontre.sport.libelle FROM Participation p WHERE p.participant.id = :id_membre";
	private static final String HQL_REQ_SEARCH_BY_SPORT = "SELECT s FROM Sport s WHERE s.libelle like :name";
    
    
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Sport> getAllSports() {
		Query query = em.createQuery(HQL_REQ_GET_ALL_SPORT);
		List<Sport> sports = new ArrayList<>();
		if(query.getResultList().size()!=0){
		    sports = query.getResultList();	
		}
		return sports;
	}

	@Override
	public Sport getSportById(int id) {
		Query query = em.createQuery(HQL_REQ_GET_SPORT_BY_ID);
		query.setParameter("id_sport", id);
		@SuppressWarnings("unchecked")
		List<Sport> result = query.getResultList();
		Sport s = null;
		if(result.size()!=0){
			s = result.get(0);
		}
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sport> getAllSportsByMember(Membre membre) {
	    int id_membre = membre.getId();
		Query query = em.createQuery(HQL_REQ_GET_SPORT_BY_MEMBRE);
		query.setParameter("id_membre", id_membre);
		List<Sport> sports = new ArrayList<>();
		if(query.getResultList().size()!=0){
		    sports = query.getResultList();	
		}
		return sports;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String,Double> sportRateByMember(Membre membre) {
		int id_membre = membre.getId();
		Query query = em.createQuery(HQL_REQ_GET_SPORT_RATE_BY_MEMBER);
		query.setParameter("id_membre", id_membre);
		List<String> sports = new ArrayList<>();
		HashMap<String,Double> occurrences = new HashMap<>();
		if(query.getResultList().size()!=0){
		sports = query.getResultList();	
		}			
		for (String sport : sports) {
			double occurrence =  Math.round((Collections.frequency(sports, sport)*100)/sports.size());
			occurrences.put(sport,occurrence);
			}
		return occurrences;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sport> searchSportByName(String recherche) {
	    Query query =em.createQuery(HQL_REQ_SEARCH_BY_SPORT).setParameter("name", '%' + recherche + '%' );
	return query.getResultList()  ;
	}
	
	

}
