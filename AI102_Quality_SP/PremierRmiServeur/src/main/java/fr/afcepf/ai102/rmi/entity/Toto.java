package fr.afcepf.ai102.rmi.entity;

import java.io.Serializable;

public class Toto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nom;
    private String prenom;
    public Toto() {
        super();
    }
    public Toto(int paramId, String paramNom, String paramPrenom) {
        super();
        id = paramId;
        nom = paramNom;
        prenom = paramPrenom;
    }
    public int getId() {
        return id;
    }
    public void setId(int paramId) {
        id = paramId;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String paramPrenom) {
        prenom = paramPrenom;
    }
}
