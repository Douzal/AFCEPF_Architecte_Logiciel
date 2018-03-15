package fr.afcepf.squad.gestion.impl;

import java.util.Date;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.gestion.api.IBusinessMessage;
import fr.afecpf.squad.data.api.IDaoMessage;

@Remote(IBusinessMessage.class)
@Singleton
public class BusinessMessage implements IBusinessMessage {

    @EJB
    private IDaoMessage proxyMessage;

	@Override
	public Message ajouter(Message paramNouveauMessage) {
	     paramNouveauMessage.setDateMessage(new Date());
		return proxyMessage.ajouter(paramNouveauMessage);
	}
    

}
