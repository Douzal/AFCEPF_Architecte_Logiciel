package fr.afecpf.squad.data.api;

import fr.afcepf.squad.entity.Message;

public interface IDaoMessage {
     Message ajouter(Message nouveauMessage);
     
     void retirer(Message message);
	
}

