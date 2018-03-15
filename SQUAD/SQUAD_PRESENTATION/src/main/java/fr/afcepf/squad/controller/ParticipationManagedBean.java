package fr.afcepf.squad.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.gestion.api.IBusinessParticipation;

@ManagedBean(name="mbParticipation")
@SessionScoped
public class ParticipationManagedBean {

    @ManagedProperty(value="#{mbSession}")
    private SessionManagedBean sessionManagedBean;
    
    private Membre membreConnected;
    private List<Participation> participations;
    
    @EJB
    private IBusinessParticipation proxyParticipation;
    
    @PostConstruct
    public void init(){
        
        membreConnected = sessionManagedBean.getMembreConnecte();
        if(membreConnected != null) {
            participations = proxyParticipation.getAllParticipationsFutures(membreConnected.getId());
        }
        
    }
    
    public void afficherParticipationsFutures() {
        participations = proxyParticipation.getAllParticipationsFutures(membreConnected.getId());
    }
    
    public List<Date> afficherDatesParticipationsFutures() {
        return proxyParticipation.getAllDatesParticipationsFutures(membreConnected.getId());
    }

    /**
     * @return the sessionManagedBean
     */
    public SessionManagedBean getSessionManagedBean() {
        return sessionManagedBean;
    }

    /**
     * @param paramSessionManagedBean the sessionManagedBean to set
     */
    public void setSessionManagedBean(SessionManagedBean paramSessionManagedBean) {
        sessionManagedBean = paramSessionManagedBean;
    }

    /**
     * @return the membreConnected
     */
    public Membre getMembreConnected() {
        return membreConnected;
    }

    /**
     * @param paramMembreConnected the membreConnected to set
     */
    public void setMembreConnected(Membre paramMembreConnected) {
        membreConnected = paramMembreConnected;
    }

    /**
     * @return the proxyParticipation
     */
    public IBusinessParticipation getProxyParticipation() {
        return proxyParticipation;
    }
    
    /**
     * @param paramProxyParticipation the proxyParticipation to set
     */
    public void setProxyParticipation(IBusinessParticipation paramProxyParticipation) {
        proxyParticipation = paramProxyParticipation;
    }

    /**
     * @return the participations
     */
    public List<Participation> getParticipations() {
        return participations;
    }

    /**
     * @param paramParticipations the participations to set
     */
    public void setParticipations(List<Participation> paramParticipations) {
        participations = paramParticipations;
    }
    
    
}
