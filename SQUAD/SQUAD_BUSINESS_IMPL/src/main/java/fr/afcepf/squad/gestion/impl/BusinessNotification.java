package fr.afcepf.squad.gestion.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Notification;
import fr.afcepf.squad.gestion.api.IBusinessNotification;
import fr.afecpf.squad.data.api.IDaoNotification;

@Remote(IBusinessNotification.class)
@Singleton
public class BusinessNotification implements IBusinessNotification {
	
	@EJB
	private IDaoNotification proxyNotif;
	
	@Override
	public void sendNotification(Membre membre) {
	}

	@Override
	public Notification createNotification(Notification notification) {
		return null;
	}

	@Override
	public void deleteNotification(Notification notification) {
	}

	@Override
	public List<Notification> getAllNotificationByMember(Membre membre) {
		return proxyNotif.getAllNotificationByMember(membre);
	}
}
