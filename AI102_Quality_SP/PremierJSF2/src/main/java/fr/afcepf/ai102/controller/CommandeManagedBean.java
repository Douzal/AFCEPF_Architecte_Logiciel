package fr.afcepf.ai102.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai102.qualimetrie.entity.Personne;

@ManagedBean (name= "mbCommande")
@ViewScoped
public class CommandeManagedBean {

    private Personne persConnected;
    
    @ManagedProperty (value = "#{mbConnect}")
    private ConnexionManagedBean mbConnection;
    
    @PostConstruct
    public void init(){
        persConnected = mbConnection.getPersonne();
    }
    
    public Personne getPersConnected() {
        return persConnected;
    }

    public void setPersConnected(Personne paramPersConnected) {
        persConnected = paramPersConnected;
    }

    public ConnexionManagedBean getMbConnection() {
        return mbConnection;
    }

    public void setMbConnection(ConnexionManagedBean paramMbConnection) {
        mbConnection = paramMbConnection;
    }
}
