package fr.afecpf.squad.data.api;

import fr.afcepf.squad.entity.ResultatConfrontation;

public interface IDaoResultatsConfrontation {
	
	ResultatConfrontation ajouter(ResultatConfrontation res);
	
	void supprimer(ResultatConfrontation res);
	
	ResultatConfrontation modifier(ResultatConfrontation res);

}
