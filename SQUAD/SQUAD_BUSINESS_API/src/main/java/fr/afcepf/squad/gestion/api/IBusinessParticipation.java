package fr.afcepf.squad.gestion.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.Rencontre;

public interface IBusinessParticipation {

	List<Participation> getAllParticipationsFutures(int idMembre);
	List<Date> getAllDatesParticipationsFutures(int idMembre);

	Participation ajouter(Membre membre, Rencontre rencontre);
	
	void retirer(Participation participation);
	
	Participation ajouterBasique(Participation participation);
}
