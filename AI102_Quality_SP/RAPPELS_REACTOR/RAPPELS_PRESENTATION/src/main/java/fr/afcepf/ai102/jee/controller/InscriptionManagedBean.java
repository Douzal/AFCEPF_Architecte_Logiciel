package fr.afcepf.ai102.jee.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai102.jee.business.api.IBusinessConnexion;
import fr.afcepf.ai102.jpa.entity.Particulier;

@ManagedBean(name = "mbInscription")
@ViewScoped
public class InscriptionManagedBean {
    private Particulier part = new Particulier();
    private String message;
    @EJB
    private IBusinessConnexion proxyConnexion;
    public void ajouter() {
        part = proxyConnexion.inscription(part);
        message = "Personne bien ajoutée : " + part.getId();
        part = new Particulier();
    }
    
    public Particulier getPart() {
        return part;
    }
    public String getMessage() {
        return message;
    }
    public void setPart(Particulier paramPart) {
        part = paramPart;
    }
    public void setMessage(String paramMessage) {
        message = paramMessage;
    }

    public void setProxyConnexion(IBusinessConnexion paramProxyConnexion) {
        proxyConnexion = paramProxyConnexion;
    }

    public IBusinessConnexion getProxyConnexion() {
        return proxyConnexion;
    }
    
}
