package fr.afcepf.ai102.controller;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

@ManagedBean (name = "mbConnect")
@SessionScoped
public class ConnexionManagedBean {
    private String login;
    private String password;
    private Personne personne;
    private IGestionPersonne bu = new GestionPersonne();
    
    public String connect() throws QualitException{
        String retour;
        try {
            personne = bu.connexion(login, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(personne != null){
            retour = "/commande.xhtml?faces-redirect=true";
        }else{
            retour = "/connexion.xhtml";
            FacesContext.getCurrentInstance().addMessage("form:login", 
                    new FacesMessage("login incorrect", "Error de connexion : le login est incorrect"));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ca marche pas", "Ca ne marche vraiment pas"));
        }
        return retour;
    }
        public String deconnexion(){
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.invalidate();
            return "/connexion.xhtml?faces-redirect=true";
        }
    public String getLogin() {
        return login;
    }
    public void setLogin(String paramLogin) {
        login = paramLogin;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String paramPassword) {
        password = paramPassword;
    }
    public Personne getPersonne() {
        return personne;
    }
    public void setPersonne(Personne paramPersonne) {
        personne = paramPersonne;
    }
    
    

}
