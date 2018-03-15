package fr.afcepf.squad.data.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Notification;
import fr.afecpf.squad.data.api.IDaoNotification;


@Remote(IDaoNotification.class)
@Stateless
public class DaoNotification implements IDaoNotification {

	@PersistenceContext(unitName = "CONNECTION_SQUAD")
	private EntityManager em;
	private static final String HQL_REQ_GET_ALL_NOTIF = "SELECT m.notifications FROM Membre m WHERE m.id = :id_membre";
	
	
	
	@Override
	public void sendNotification(Membre membre) {
		

	}

	@Override
	public Notification createNotification(Notification notification) {
		em.persist(notification);
		return notification;
	}

	@Override
	public void deleteNotification(Notification notification) {
         em.remove(notification);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> getAllNotificationByMember(Membre membre) {
		Query query = em.createQuery(HQL_REQ_GET_ALL_NOTIF);
		query.setParameter("id_membre", membre.getId());
		List<Notification> notifs = new ArrayList<>();
		if(query.getResultList().size()!=0){
		    notifs = query.getResultList();	
		}
		return notifs;
	}

}
