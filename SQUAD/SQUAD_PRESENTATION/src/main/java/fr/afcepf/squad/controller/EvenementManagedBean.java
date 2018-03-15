package fr.afcepf.squad.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.squad.entity.Evenement;
import fr.afcepf.squad.gestion.api.IBusinessEvenement;

@ManagedBean(name = "mbEvenement")
@ViewScoped
public class EvenementManagedBean {

    private Evenement event = new Evenement();
    private String message; //ou juste un redirect sur la page de l'event?
    @EJB
    private IBusinessEvenement proxyEvenement;
    
    public void creer() {
        event = proxyEvenement.creation(event);
        message = "Votre événement a bien été créé!";
        event = new Evenement();
    }

    /**
     * @return the event
     */
    public Evenement getEvent() {
        return event;
    }

    /**
     * @param paramEvent the event to set
     */
    public void setEvent(Evenement paramEvent) {
        event = paramEvent;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param paramMessage the message to set
     */
    public void setMessage(String paramMessage) {
        message = paramMessage;
    }

    /**
     * @param paramProxyEvenement the proxyEvenement to set
     */
    public void setProxyEvenement(IBusinessEvenement paramProxyEvenement) {
        proxyEvenement = paramProxyEvenement;
    }
    
    
}
