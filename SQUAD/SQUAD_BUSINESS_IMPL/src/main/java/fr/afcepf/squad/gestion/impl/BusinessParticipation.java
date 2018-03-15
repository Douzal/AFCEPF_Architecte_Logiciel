package fr.afcepf.squad.gestion.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.gestion.api.IBusinessParticipation;
import fr.afcepf.squad.key.ParticipationPK;
import fr.afecpf.squad.data.api.IDaoParticipation;
@Remote(IBusinessParticipation.class)
@Singleton
public class BusinessParticipation implements IBusinessParticipation {

	@EJB
	private IDaoParticipation proxyPartcipation;

	@Override
	public List<Participation> getAllParticipationsFutures(int paramIdMembre) {

		return proxyPartcipation.getAllParticipationsFutures(paramIdMembre);
	}

	@Override
	public List<Date> getAllDatesParticipationsFutures(int paramIdMembre) {

		return proxyPartcipation.getAllDatesParticipationsFutures(paramIdMembre);
	}

	@Override
	public Participation ajouter(Membre membre, Rencontre rencontre) {
		Participation participation = new Participation(null,membre,rencontre,new Date(),new Date(),null,true);
		return proxyPartcipation.ajouter(participation);
	}

	@Override
	public void retirer(Participation participation) {
		proxyPartcipation.retirer(participation);
	}

	@Override
	public Participation ajouterBasique(Participation participation) {
		return proxyPartcipation.ajouterBasique(participation);
	}



}
