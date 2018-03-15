package fr.afcepf.ai102.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

@ManagedBean (name="mbAjouter")
@SessionScoped
public class AjouterManagedBean {
    private Personne pers = new Personne();
    private String message;
    private IGestionPersonne bu = new GestionPersonne();
    
    public String valider(){
        return "/confirmation.xhtml?faces-redirect=true";
    }
    
    public String ajouterPersonne(){
        try {
            pers = bu.ajouter(pers);
            message = "Personne n° " + pers.getId() + " bien ajoutée.";
            pers = new Personne();
        } catch (QualitException e) {
            // TODO Auto-generated catch block
            message = "La personne n'a pas pu être ajoutée";
            e.printStackTrace();
        }
        return "/ajouter.xhtml?faces-redirect=true";
        
    }
    
    public String annuler(){
        pers = new Personne();
        return "/ajouter.xhtml?faces-redirect=true";
    }
    public Personne getPers() {
        return pers;
    }
    public void setPers(Personne paramPers) {
        pers = paramPers;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String paramMessage) {
        message = paramMessage;
    }

}
