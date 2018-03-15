package fr.afcepf.squad.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.squad.entity.Equipe;
import fr.afcepf.squad.entity.Membre;
import fr.afecpf.squad.data.api.IDaoConfrontation;
import fr.afecpf.squad.data.api.IDaoEquipe;

@Remote(IDaoEquipe.class)
@Stateless
public class DaoEquipe implements IDaoEquipe {
	
	@PersistenceContext(unitName = "CONNECTION_SQUAD")
	private EntityManager em;
	
	private static final String HQL_GET_EQUIPE = "SELECT m From Membre m inner join fetch m.equipes WHERE m=:membre";
	private static final String HQL_GETEQUIPE_MEMBRE = "SELECT eq From Equipe eq left join fetch eq.participants WHERE eq.id=:id";
	
	@Override
	public Equipe ajouter(Equipe equipe) {
		em.persist(equipe);
		return equipe;
	}

	@Override
	public void supprimer(Equipe equipe) {
		equipe = em.find(Equipe.class, equipe.getId());
		em.remove(equipe);

	}

	@Override
	public Equipe modifierCompoAdd(Equipe equipe, Membre membre) {

		equipe.getParticipants().add(membre);
		
		em.merge(equipe);
		
		return equipe;
	}
	
	@Override
	public Equipe modifierCompoDel(Equipe equipe, Membre membre) {

		System.out.println("del membre equipe");
		
		equipe.getParticipants().remove(membre);

		em.merge(equipe);
		
		return equipe;
	}

}
