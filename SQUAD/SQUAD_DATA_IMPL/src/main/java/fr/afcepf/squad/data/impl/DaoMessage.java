package fr.afcepf.squad.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.squad.entity.Message;

import fr.afecpf.squad.data.api.IDaoMessage;

@Remote(IDaoMessage.class)
@Stateless
public class DaoMessage implements IDaoMessage {

    @PersistenceContext(unitName = "CONNECTION_SQUAD")
    private EntityManager em;
 
	@Override
	public Message ajouter(Message paramNouveauMessage) {
		em.persist(paramNouveauMessage);
		return paramNouveauMessage;
	}

	@Override
	public void retirer(Message message) {
		
		message = em.find(Message.class, message.getId());
		
		em.remove(message);
	}
 
    

}
