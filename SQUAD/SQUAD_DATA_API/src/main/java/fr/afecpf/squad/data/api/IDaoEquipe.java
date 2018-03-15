package fr.afecpf.squad.data.api;

import fr.afcepf.squad.entity.Equipe;
import fr.afcepf.squad.entity.Membre;

public interface IDaoEquipe {
	
	Equipe ajouter(Equipe equipe);
	
	void supprimer(Equipe equipe);
	
	Equipe modifierCompoAdd(Equipe equipe, Membre membre);
	
	Equipe modifierCompoDel(Equipe equipe, Membre membre);

}
