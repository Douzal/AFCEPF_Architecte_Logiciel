package fr.afcepf.squad.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.squad.entity.Confrontation;
import fr.afecpf.squad.data.api.IDaoConfrontation;
import fr.afecpf.squad.data.api.IDaoMembre;

@Remote(IDaoConfrontation.class)
@Stateless
public class DaoConfrontation implements IDaoConfrontation {
	
	@PersistenceContext(unitName = "CONNECTION_SQUAD")
	private EntityManager em;

	@Override
	public Confrontation ajouter(Confrontation confrontation) {
		em.persist(confrontation);
		return confrontation;
	}

	@Override
	public void supprimer(Confrontation confrontation) {
		em.remove(confrontation);

	}

}
