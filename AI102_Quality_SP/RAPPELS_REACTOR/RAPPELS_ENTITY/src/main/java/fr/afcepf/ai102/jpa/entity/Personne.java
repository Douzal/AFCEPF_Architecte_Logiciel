package fr.afcepf.ai102.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "banque_personne")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personne_id")
    private Integer id;
    @Column(name = "personne_nom", nullable = false, length = 50)
    private String nom;
    @Column(name = "personne_mail", nullable = false, length = 150, unique = true)
    private String mail;
    @Column(name = "personne_mot_de_passe", nullable = false, length = 20)
    private String password;
    @Column(name = "personne_naissance", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    
    public Personne() {
        super();
    }
    public Personne(Integer paramId, String paramNom, String paramMail, String paramPassword, Date paramDob) {
        id = paramId;
        nom = paramNom;
        mail = paramMail;
        password = paramPassword;
        dob = paramDob;
    }
    public Integer getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getMail() {
        return mail;
    }
    public String getPassword() {
        return password;
    }
    public Date getDob() {
        return dob;
    }
    
    public void setId(Integer paramId) {
        id = paramId;
    }
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    public void setMail(String paramMail) {
        mail = paramMail;
    }
    public void setPassword(String paramPassword) {
        password = paramPassword;
    }
    public void setDob(Date paramDob) {
        dob = paramDob;
    }
    
    
}
