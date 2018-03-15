package fr.afcepf.squad.gestion.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Sport;
import fr.afcepf.squad.entity.Squad;

public interface IBusinessRencontre {
	Rencontre creation(Rencontre paramRencontre);
    
    Rencontre getById(Integer paramId);
    List<Participation> getRencontreByMembre(Membre membre);
    List<Participation> getAllParticipationByRencontre(Rencontre rencontre);
    List<Rencontre> getRencByDate(Date paramDate);
    List<Participation> getAllParticipationBySportVilleDate(Sport sport, String ville, Date date);
    Rencontre getMessageById(Integer id);
    Rencontre createRecontreComboInvitation(Rencontre rencontre, Squad squad);
    List<Participation> getAllParticipationByMembreSportVilleDate(Membre membre, Sport sport, String ville, Date date);
    List<Rencontre> getAllRencontreBySportVilleDate(String sport, String paramVille, Date date);

}
