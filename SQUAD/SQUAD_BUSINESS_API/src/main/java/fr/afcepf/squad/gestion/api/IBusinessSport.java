package fr.afcepf.squad.gestion.api;

import java.util.HashMap;
import java.util.List;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Sport;


public interface IBusinessSport {

	List<Sport> getAllSports();
	Sport getSportById(int id);
	List<Sport> getAllSportsByMember(Membre membre);
	HashMap<String,Double> sportRateByMember(Membre membre);
	List<Sport> searchSportByName(String recherche);
}
