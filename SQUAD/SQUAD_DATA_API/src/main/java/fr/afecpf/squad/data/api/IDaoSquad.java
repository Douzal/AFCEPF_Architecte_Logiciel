package fr.afecpf.squad.data.api;

import java.util.List;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.MembreSquad;
import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.entity.MessageSquad;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.entity.Squad;

public interface IDaoSquad {
	
	List<Squad> getAllSquad();
	List<Squad> getAllSquadByMember(Membre membre);
	List<Squad> getSquadBySport(Sport s);
	Squad getAllInfosSquad(int  id_squad);
	void balancerLesInvitations(Rencontre rencontre, Squad squad);
	List<Rencontre> getAllRencontreFromSquad(Squad squad);
	List<Rencontre> getAllOldRencontreFromSquad(Squad squad);
	MembreSquad addMemberToSquad(MembreSquad membreSquad);
	Squad getMessageOfSquad(Integer idSquad);
	List<MessageSquad> getReponseOfMembre(MessageSquad message);
	List<MessageSquad> getMessagesOfSquad(Integer idSquad);
	Squad getSquadFromRencontre(Integer idRencontre);

}
