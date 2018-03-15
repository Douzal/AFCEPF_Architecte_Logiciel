package fr.afcepf.squad.gestion.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.entity.Squad;
import fr.afcepf.squad.gestion.api.IBusinessRencontre;
import fr.afecpf.squad.data.api.IDaoRencontre;
import fr.afecpf.squad.data.api.IDaoSquad;
@Remote(IBusinessRencontre.class)
@Singleton
public class BusinessRencontre implements IBusinessRencontre {

    @EJB
    private IDaoRencontre proxyRencontre;
    
    @EJB
    private IDaoSquad proxySquad;
    
    @Override
    public Rencontre creation(Rencontre paramRencontre) {
        paramRencontre.setDateCreation(new Date());
        //ajouter id_org = connected user
        return proxyRencontre.creer(paramRencontre);
    }
	@Override
	public Rencontre getById(Integer paramId) {
		
		return proxyRencontre.getById(paramId);
	}
	@Override
	public List<Participation> getRencontreByMembre(Membre membre) {
		return proxyRencontre.getRencontreByMembre(membre);
	}
	@Override
	public List<Participation> getAllParticipationByRencontre(Rencontre rencontre) {

		return proxyRencontre.getAllParticipationByRencontre(rencontre);
	}
	@Override
	public List<Rencontre> getRencByDate(Date paramDate) {
		return proxyRencontre.getRencByDate(paramDate);
	}
	@Override
	public List<Participation> getAllParticipationBySportVilleDate(Sport sport, String ville, Date date) {
		
		return proxyRencontre.getAllParticipationBySportVilleDate(sport,ville,date);
	}
	@Override
	public Rencontre getMessageById(Integer id) {
		// TODO Auto-generated method stub
		return proxyRencontre.getMessageById(id);
	}
	@Override
	public Rencontre createRecontreComboInvitation(Rencontre rencontre, Squad squad) {
		rencontre = proxyRencontre.creer(rencontre);
		
		if(squad != null) {
		proxySquad.balancerLesInvitations(rencontre, squad);
		}
		
		return rencontre;
	}

	public List<Participation> getAllParticipationByMembreSportVilleDate(Membre membre, Sport sport, String ville, Date date) {
		return proxyRencontre.getAllParticipationByMembreSportVilleDate(membre, sport, ville, date);
	}
	@Override
	public List<Rencontre> getAllRencontreBySportVilleDate(String sport, String paramVille, Date date) {
		return proxyRencontre.getAllRencontreBySportVilleDate(sport, paramVille, date);
	}
}
