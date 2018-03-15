package fr.afecpf.squad.data.api;

import java.util.List;

import fr.afcepf.squad.entity.Confrontation;
import fr.afcepf.squad.entity.Equipe;
import fr.afcepf.squad.entity.Evenement;
import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.ResultatConfrontation;

public interface IDaoEvenement {
    Evenement creer(Evenement evenement);
    Evenement getEvenementFullPackById(Integer id);
    //Evenement ajouterEquipe(Evenement evenement);
    
    Equipe ajouterEquipe(Equipe equipe);
    
    Equipe updateMembreEquipe(Equipe equipe);
    
    Evenement supprimerEquipe(Evenement evenement, Equipe equipe);
    
    Evenement refreshInstance(Evenement evenement);
    
    ResultatConfrontation ajouterRes(ResultatConfrontation rc);
    
    Confrontation ajouterConf(Confrontation conf);
    
    Confrontation getConfrontationById(Integer id);
    
    Confrontation updateAjoutRes(Confrontation conf);
    
    //methodes saines****************************************
    
    Evenement refreshEquipe(Evenement evenement);
    
    Evenement refreshMessage(Evenement evenement);
    
    Evenement refreshParticipant(Evenement evenement);
    
    Evenement refreshConfrontation(Evenement evenement);
    
    Evenement placerLesGens(Evenement evenement, List<Membre> membres);
    
}


