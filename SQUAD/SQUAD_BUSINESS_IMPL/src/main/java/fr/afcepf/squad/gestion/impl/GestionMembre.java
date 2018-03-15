package fr.afcepf.squad.gestion.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.gestion.api.IGestionMembre;
import fr.afecpf.squad.data.api.IDaoMembre;

@Remote(IGestionMembre.class)
@Singleton
public class GestionMembre implements IGestionMembre{

	@EJB
    private IDaoMembre proxyMembre;
	
	@Override
	public Membre inscription(Membre nouveauMembre) {
		nouveauMembre.setDateInscription(new Date());
		return proxyMembre.ajouter(nouveauMembre);
	}

	@Override
	public Membre connexion(String mail, String password) {
		return proxyMembre.connexion(mail, password);
	}

	@Override
	public Membre connexionAuth(String mail) {
		return proxyMembre.connexionAuth(mail);
	}

	@Override
	public Membre getMemberById(Integer id) {
		
		return proxyMembre.getMemberById(id);
	}

}
