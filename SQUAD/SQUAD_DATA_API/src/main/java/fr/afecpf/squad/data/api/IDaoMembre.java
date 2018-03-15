package fr.afecpf.squad.data.api;

import fr.afcepf.squad.entity.Membre;

public interface IDaoMembre {
	
	Membre ajouter(Membre nouveauMembre);
	Membre modifier(Membre membre);
	Membre connexion(String mail, String password);
	Membre connexionAuth(String mail);
	Membre getMemberById(Integer id);

}
