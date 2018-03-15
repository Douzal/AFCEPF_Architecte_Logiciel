package fr.afcepf.squad.gestion.impl;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.gestion.api.IBusinessSport;
import fr.afecpf.squad.data.api.IDaoSport;


@Remote(IBusinessSport.class)
@Singleton
public class BusinessSport implements IBusinessSport {

	@EJB
    private IDaoSport proxySport;
	
	@Override
	public List<Sport> getAllSports() {
		return proxySport.getAllSports();
	}

	@Override
	public Sport getSportById(int id) {
		return proxySport.getSportById(id);
	}

	@Override
	public List<Sport> getAllSportsByMember(Membre membre) {
		return proxySport.getAllSportsByMember(membre);
	}

	@Override
	public HashMap<String,Double> sportRateByMember(Membre membre) {
		return proxySport.sportRateByMember(membre);
	}

	@Override
	public List<Sport> searchSportByName(String recherche) {
		return proxySport.searchSportByName(recherche);
	}

}
