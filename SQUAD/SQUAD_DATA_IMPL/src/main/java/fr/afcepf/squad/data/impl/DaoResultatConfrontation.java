package fr.afcepf.squad.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.squad.entity.ResultatConfrontation;
import fr.afecpf.squad.data.api.IDaoParticipation;
import fr.afecpf.squad.data.api.IDaoResultatsConfrontation;

@Remote(IDaoResultatsConfrontation.class)
@Stateless
public class DaoResultatConfrontation implements IDaoResultatsConfrontation {
	
	@PersistenceContext(unitName = "CONNECTION_SQUAD")
	private EntityManager em;

	@Override
	public ResultatConfrontation ajouter(ResultatConfrontation res) {
		em.persist(res);
		return res;
	}

	@Override
	public void supprimer(ResultatConfrontation res) {
		em.remove(res);

	}

	@Override
	public ResultatConfrontation modifier(ResultatConfrontation res) {
		
		em.merge(res);
		
		return res;
	}

}
