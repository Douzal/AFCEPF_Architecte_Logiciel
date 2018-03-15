package fr.afcepf.squad.data.impl;


import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.squad.entity.Membre;
import fr.afecpf.squad.data.api.IDaoMembre;

@Remote(IDaoMembre.class)
@Stateless
public class DaoMembre implements IDaoMembre {

	@PersistenceContext(unitName = "CONNECTION_SQUAD")
	private EntityManager em;
	
	private static final String HQL_REQ_CONNEX = "SELECT m FROM Membre m WHERE m.email = :mail AND m.password= :mdp";
	private static final String HQL_REQ_CONNEXAUTH = "SELECT m FROM Membre m WHERE m.email = :mail";
	
	
	@Override
	public Membre ajouter(Membre nouveauMembre) {
		em.persist(nouveauMembre);
		return nouveauMembre;
	}

	@Override
	public Membre modifier(Membre membre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Membre connexion(String mail, String password) {
		Query query = em.createQuery(HQL_REQ_CONNEX);
		query.setParameter("mail", mail);
		query.setParameter("mdp", password);
		@SuppressWarnings("unchecked")
		List<Membre> result = query.getResultList();
		Membre memb = null;
		if(result.size()!=0){
			memb = result.get(0);
		}

		return memb;
	}

	@Override
	public Membre connexionAuth(String mail) {
		Query query = em.createQuery(HQL_REQ_CONNEXAUTH);
		query.setParameter("mail", mail);
		@SuppressWarnings("unchecked")
		List<Membre> result = query.getResultList();
		Membre memb = null;
		if(result.size()!=0){
			memb = result.get(0);
		}
		return memb;
	}

	
	public Membre getMemberById(Integer id){
		return em.find(Membre.class, id);
	}
}
