package fr.afcepf.squad.gestion.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.MembreSquad;
import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.entity.MessageSquad;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.entity.Squad;
import fr.afcepf.squad.gestion.api.IBusinessSquad;
import fr.afecpf.squad.data.api.IDaoSquad;

@Remote(IBusinessSquad.class)
@Singleton
public class BusinessSquad implements IBusinessSquad {

	@EJB
    private IDaoSquad proxySquad;
	
	@Override
	public List<Squad> getAllSquad() {
		return proxySquad.getAllSquad() ;
	}

	@Override
	public List<Squad> getAllSquadByMember(Membre membre) {
		return proxySquad.getAllSquadByMember(membre);
	}

	@Override
	public List<Squad> getSquadBySport(Sport s) {
		return proxySquad.getSquadBySport(s);
	}

	@Override
	public Squad getAllInfosSquad(int id_squad) {
		return proxySquad.getAllInfosSquad(id_squad);
	}

	@Override
	public List<Rencontre> getAllRencontreFromSquad(Squad squad) {
		return proxySquad.getAllRencontreFromSquad(squad);
	}

	@Override
	public List<Rencontre> getAllOldRencontreFromSquad(Squad squad) {
		return proxySquad.getAllOldRencontreFromSquad(squad);
	}

	@Override
	public MembreSquad addMemberToSquad(Membre membre, Squad squad) {
		MembreSquad membreSquad = new MembreSquad(null,membre,squad,false);
		return proxySquad.addMemberToSquad(membreSquad);
	}

	@Override
	public Squad getMessageOfSquad(Integer idSquad) {
		return proxySquad.getMessageOfSquad(idSquad);
	}

	@Override
	public List<MessageSquad> getMessagesOfSquad(Integer idSquad) {
		return proxySquad.getMessagesOfSquad(idSquad);
	}

	@Override
	public List<MessageSquad> getReponseOfMembre(MessageSquad message) {
		return proxySquad.getReponseOfMembre(message);
	}

	@Override
	public Squad getSquadFromRencontre(Integer idRencontre) {
		return proxySquad.getSquadFromRencontre(idRencontre);
	}

	

}
