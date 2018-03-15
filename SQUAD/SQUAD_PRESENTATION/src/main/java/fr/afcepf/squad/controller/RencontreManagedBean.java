package fr.afcepf.squad.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.gestion.api.IBusinessRencontre;

@ManagedBean(name = "mbRencontre")
@ViewScoped
public class RencontreManagedBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Rencontre rencontre = new Rencontre();
    private String message; //ou juste un redirect sur la page du rdv?
    @EJB
    private IBusinessRencontre proxyRencontre;
    
    public void creer() {
        rencontre = proxyRencontre.creation(rencontre);
        message = "Votre rendez-vous a bien été créé!";
        rencontre = new Rencontre();
    }
    
    /**
     * @return the rencontre
     */
    public Rencontre getRencontre() {
        return rencontre;
    }

    /**
     * @param paramRencontre the rencontre to set
     */
    public void setRencontre(Rencontre paramRencontre) {
        rencontre = paramRencontre;
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
     * @param paramProxyRencontre the proxyRencontre to set
     */
    public void setProxyRencontre(IBusinessRencontre paramProxyRencontre) {
        proxyRencontre = paramProxyRencontre;
    }
    
    
    
}
