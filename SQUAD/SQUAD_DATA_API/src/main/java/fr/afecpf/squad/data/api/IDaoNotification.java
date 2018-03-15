package fr.afecpf.squad.data.api;

import java.util.List;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Notification;

public interface IDaoNotification {
	
	void sendNotification(Membre membre);
	Notification createNotification(Notification notification);
	void deleteNotification(Notification notification);
	List<Notification> getAllNotificationByMember(Membre membre);
}
