package fr.afcepf.ai102.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

@ManagedBean(name= "mbRecherche")
@ViewScoped
public class RechercherManagedBean implements Serializable{
    private String saisie;
    private List<Personne> personnes;
    private IGestionPersonne bu = new GestionPersonne();
    public String getSaisie() {
        return saisie;
    }
    public void rechercherPersonne (){
        try {
            personnes = bu.rechercher(saisie);
        } catch (QualitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void setSaisie(String paramSaisie) {
        saisie = paramSaisie;
    }
    public List<Personne> getPersonnes() {
        return personnes;
    }
    public void setPersonnes(List<Personne> paramPersonnes) {
        personnes = paramPersonnes;
    }
    
    
    
}
