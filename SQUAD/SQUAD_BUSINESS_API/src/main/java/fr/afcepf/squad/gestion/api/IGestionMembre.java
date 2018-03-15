package fr.afcepf.squad.gestion.api;

import fr.afcepf.squad.entity.Membre;

public interface IGestionMembre {
	
	Membre inscription(Membre nouveauMembre);
	
	Membre connexion(String mail, String password);
	
	Membre connexionAuth(String mail);
	
	Membre getMemberById(Integer id);
}
