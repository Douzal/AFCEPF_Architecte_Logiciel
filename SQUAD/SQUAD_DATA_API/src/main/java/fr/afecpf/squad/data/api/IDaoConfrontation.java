package fr.afecpf.squad.data.api;

import fr.afcepf.squad.entity.Confrontation;

public interface IDaoConfrontation {
	
	Confrontation ajouter(Confrontation confrontation);
	
	void supprimer(Confrontation confrontation);
	

}
