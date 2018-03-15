package fr.afcepf.squad.gestion.api;

import fr.afcepf.squad.entity.Message;

public interface IBusinessMessage {
	
	Message ajouter(Message nouveauMessage);
    
}
