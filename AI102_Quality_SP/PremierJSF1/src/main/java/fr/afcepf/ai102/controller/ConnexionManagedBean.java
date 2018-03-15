package fr.afcepf.ai102.controller;

import java.io.Serializable;
import java.sql.SQLException;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

public class ConnexionManagedBean implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String login;
    private String password;
    private Personne personne;
    private IGestionPersonne bu = new GestionPersonne();
    
    public Personne connexion(){
        try {
            personne = bu.connexion(login, password);
        } catch (SQLException | QualitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return personne;
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
