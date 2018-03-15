package fr.afcepf.ai102.jee.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai102.jee.business.api.IBusinessConseiller;
import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;
import fr.afcepf.ai102.jpa.entity.Societe;

@ManagedBean(name = "mbConseil")
@ViewScoped
public class ConseillerManagedBean {
    @EJB
    private IBusinessConseiller buConseil;
    private String nom;
    private List<Personne> liste;
    public void rechercherParticuliers() {
        liste = buConseil.rechercher(nom, Particulier.class);
    }
    public void rechercherSocietes() {
        liste = buConseil.rechercher(nom, Societe.class);
    }
    public IBusinessConseiller getBuConseil() {
        return buConseil;
    }
    public String getNom() {
        return nom;
    }
    public List<Personne> getListe() {
        return liste;
    }
    public void setBuConseil(IBusinessConseiller paramBuConseil) {
        buConseil = paramBuConseil;
    }
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    public void setListe(List<Personne> paramListe) {
        liste = paramListe;
    }
}
