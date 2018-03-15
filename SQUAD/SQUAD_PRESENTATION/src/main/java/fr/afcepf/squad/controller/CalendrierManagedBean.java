package fr.afcepf.squad.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.gestion.api.IBusinessRencontre;

@ManagedBean(name="mbCalendrier")
@ViewScoped
public class CalendrierManagedBean {

    private Date date; 
    private List<Rencontre> rencontres = new ArrayList<>();
    @EJB
    private IBusinessRencontre proxyRencontre;

    public CalendrierManagedBean() {
        super();  
    }
    
    @PostConstruct
    public void init(){
        date = new Date();
        rencontres = proxyRencontre.getRencByDate(date);
        for (Rencontre rencontre : rencontres) {
            String rencMod = rencontre.getVille().substring(0,1).toUpperCase()
                    +
            rencontre.getVille().substring(1,rencontre.getVille().length()).toLowerCase();
            rencontre.setVille(rencMod);
        }   
    }
    public void afficheRencByDate() {
        rencontres = proxyRencontre.getRencByDate(date);
        for (Rencontre rencontre : rencontres) {
            String rencMod = rencontre.getVille().substring(0,1).toUpperCase()
                    +
            rencontre.getVille().substring(1,rencontre.getVille().length()).toLowerCase();
            rencontre.setVille(rencMod);
        }
    } 
    
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param paramDate the date to set
     */
    public void setDate(Date paramDate) {
        date = paramDate;
    }

    /**
     * @return the rencontres
     */
    public List<Rencontre> getRencontres() {
        return rencontres;
    }

    /**
     * @param paramRencontres the rencontres to set
     */
    public void setRencontres(List<Rencontre> paramRencontres) {
        rencontres = paramRencontres;
    }

    /**
     * @return the proxyRencontre
     */
    public IBusinessRencontre getProxyRencontre() {
        return proxyRencontre;
    }

    /**
     * @param paramProxyRencontre the proxyRencontre to set
     */
    public void setProxyRencontre(IBusinessRencontre paramProxyRencontre) {
        proxyRencontre = paramProxyRencontre;
    }

}
