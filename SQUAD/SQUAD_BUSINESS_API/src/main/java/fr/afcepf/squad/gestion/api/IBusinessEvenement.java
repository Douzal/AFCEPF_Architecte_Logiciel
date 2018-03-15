package fr.afcepf.squad.gestion.api;

import java.util.List;

import fr.afcepf.squad.entity.Confrontation;
import fr.afcepf.squad.entity.Equipe;
import fr.afcepf.squad.entity.Evenement;
import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.entity.MessageRencontre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.ResultatConfrontation;

public interface IBusinessEvenement {
    Evenement creation(Evenement evenement);
    Evenement getEvenementFullPackById(Integer id);
    
    Equipe updateMembreEquipe(Equipe equipe);
    
    Evenement supprimerRencontre(Evenement evenement, Equipe equipe);
    
    Evenement refreshInstance(Evenement evenement);
    
    Evenement genererConfrontation(Evenement evenement);
    
    Confrontation updateScore(Confrontation confrontation);
    
    
    Evenement ajouterParticipation(Participation participation, Evenement evenement);
    
    Evenement retirerParticipation(Participation participation, Evenement evenement);
    
    Evenement ajouterEquipe(Equipe equipe, Evenement evenement);
    
    Evenement retirerEquipe(Equipe equipe, Evenement evenement);
    
    Evenement modifierEquipeAdd(Equipe equipe, Membre membre, Evenement evenement);
    
    Evenement modifierEquipeDel(Equipe equipe, Membre membre, Evenement evenement);
    
    Evenement placerLesGens(Evenement evenement, List<Membre> membres);
    
    Evenement ajouterMessage(Evenement evenement, Message message);
    
    Evenement retirerMessage(Evenement evenement, Message message);
}
