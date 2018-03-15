package fr.afcepf.ai102.pattern.newSystem;

import java.util.*;

/**
 * 
 */
public class Personne {

    /**
     * Default constructor
     */
    public Personne() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String courriel;

    /**
     * 
     */
    private String mdp;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCourriel() {
        return courriel;
    }

    public String getMdp() {
        return mdp;
    }

    public void setId(int paramId) {
        id = paramId;
    }

    public void setNom(String paramNom) {
        nom = paramNom;
    }

    public void setCourriel(String paramCourriel) {
        courriel = paramCourriel;
    }

    public void setMdp(String paramMdp) {
        mdp = paramMdp;
    }

    public Personne(int paramId, String paramNom, String paramCourriel, String paramMdp) {
        super();
        id = paramId;
        nom = paramNom;
        courriel = paramCourriel;
        mdp = paramMdp;
    }

}