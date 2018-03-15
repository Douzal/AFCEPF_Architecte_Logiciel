package fr.afcepf.ai102.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean (name = "mbPremier")
@RequestScoped
public class PremierManagedBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private String saisie;
    private String label;
    public String click(){
        label = saisie;
        String retour;
        switch (saisie) {
        case "nimp":
            retour = "/plop.xhtml?faces-redirect=true";
            break;
        case "hammer":
            retour = "/thor.xhtml?faces-redirect=true";
            break;
        default:
            retour = saisie;
            break;
        }
        return retour;
    }

    public String getSaisie() {
        return saisie;
    }
    public void setSaisie(String paramSaisie) {
        saisie = paramSaisie;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String paramLabel) {
        label = paramLabel;
    }



}
