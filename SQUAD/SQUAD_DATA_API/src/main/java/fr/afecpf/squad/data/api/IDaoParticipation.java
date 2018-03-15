package fr.afecpf.squad.data.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.Rencontre;

public interface IDaoParticipation {
    
    public List<Participation> getAllParticipationsFutures(int idMembre);
    public List<Date> getAllDatesParticipationsFutures(int idMembre);
    
    
    Participation ajouter(Participation participation);
    
    void retirer(Participation participation);
	
	Participation ajouterBasique(Participation participation);

}
