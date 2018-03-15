package fr.afcepf.squad.gestion.api;

import java.util.List;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.MembreSquad;
import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.entity.MessageSquad;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.entity.Squad;

public interface IBusinessSquad {
	
	List<Squad> getAllSquad();
	List<Squad> getAllSquadByMember(Membre membre);
	List<Squad> getSquadBySport(Sport s);
	Squad getAllInfosSquad(int id_squad);
	List<Rencontre> getAllRencontreFromSquad(Squad squad);
	List<Rencontre> getAllOldRencontreFromSquad(Squad squad);
	MembreSquad addMemberToSquad(Membre membre,Squad squad);
	Squad getMessageOfSquad(Integer idSquad);
	List<MessageSquad> getMessagesOfSquad(Integer idSquad);
	List<MessageSquad> getReponseOfMembre(MessageSquad message);
	Squad getSquadFromRencontre(Integer idRencontre);
}
