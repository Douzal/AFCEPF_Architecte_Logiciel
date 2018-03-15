package fr.afcepf.ai102.jee.controller;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai102.jee.business.api.IBusinessConnexion;
import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;

@ManagedBean(name = "mbCnx")
@SessionScoped
public class ConnectionManagedBean {
    private static final String PAGE_INDEX = "/index.xhtml?faces-redirect=true";
    private String mail;
    private String pwd;
    private Personne connected;
    private String message;
    @EJB
    private IBusinessConnexion buCnx;
    public void connect() {
        connected = buCnx.connexion(mail, pwd);
        if (connected != null) {
            String forward = PAGE_INDEX;
            switch (connected.getClass().getSimpleName()) {
            case "Particulier":
                forward = "/particulier.xhtml?faces-redirect=true";
                break;
            case "Conseiller":
                forward = "/conseiller.xhtml?faces-redirect=true";
                break;
            case "Societe":
                forward = "/societe.xhtml?faces-redirect=true";   
                break;
            }
            navTo(forward);
        } else {
            message = "mauvais login / password";
        }
    }
    public void disparition() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            message = "";
        }
    }
    public void deconnection() {
        HttpSession session =
                (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        session.invalidate();
        navTo(PAGE_INDEX);
    }
    public void securePage(String userType) {
        if (connected == null ||
            !connected.getClass().getSimpleName().equals(userType)) {
            navTo(PAGE_INDEX);
        }
    }
    private void navTo(String page) {
        ConfigurableNavigationHandler handler =
                (ConfigurableNavigationHandler)
                FacesContext.getCurrentInstance().getApplication()
                .getNavigationHandler();
        handler.performNavigation(page);
    }
    public Personne getConnected() {
        return connected;
    }
    public IBusinessConnexion getBuCnx() {
        return buCnx;
    }
    public void setConnected(Personne paramConnected) {
        connected = paramConnected;
    }
    public void setBuCnx(IBusinessConnexion paramBuCnx) {
        buCnx = paramBuCnx;
    }
    public String getMail() {
        return mail;
    }
    public String getPwd() {
        return pwd;
    }
    public void setMail(String paramMail) {
        mail = paramMail;
    }
    public void setPwd(String paramPwd) {
        pwd = paramPwd;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String paramMessage) {
        message = paramMessage;
    }
    
}
