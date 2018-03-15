package fr.afcepf.ai102.qualimetrie.entity;

import java.util.Date;

/**
 * Entité representant une Personne dans le S.I.
 * @author Formation
 *
 */
public class Personne {
    /**
     * Identifiant de la personne.
     */
    private Integer id;
    /**
     * nom de la personne.
     */
    private String nom;
    /**
     * prenom de la personne.
     */
    private String prenom;
    /**
     * courriel de la personne.
     */
    private String mail;
    /**
     * Mot de passe de la personne.
     */
    private String mdp;
    /**
     * date de naissance.
     */
    private Date dob;
    /**
     * Adresse de la personne.
     */
    private Adresse adresse;
    /**
     * Default Constructor.
     */
    public Personne() {
        super();
    }
    /**
     * @param paramId the id to set.
     * @param paramNom the nom to set.
     * @param paramPrenom the prenom to set.
     * @param paramMail the mail to set.
     * @param paramMdp the mdp to set.
     * @param paramAdresse the adresse to set.
     * @param paramDob the dob to set.
     */
    public Personne(Integer paramId, String paramNom, String paramPrenom, String paramMail, String paramMdp,
            Adresse paramAdresse, Date paramDob) {
        super();
        id = paramId;
        nom = paramNom;
        prenom = paramPrenom;
        mail = paramMail;
        mdp = paramMdp;
        adresse = paramAdresse;
        dob = paramDob;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param paramNom the nom to set
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * @param paramPrenom the prenom to set
     */
    public void setPrenom(String paramPrenom) {
        prenom = paramPrenom;
    }
    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }
    /**
     * @param paramMail the mail to set
     */
    public void setMail(String paramMail) {
        mail = paramMail;
    }
    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }
    /**
     * @param paramMdp the mdp to set
     */
    public void setMdp(String paramMdp) {
        mdp = paramMdp;
    }
    /**
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }
    /**
     * @param paramAdresse the adresse to set
     */
    public void setAdresse(Adresse paramAdresse) {
        adresse = paramAdresse;
    }
    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }
    /**
     * @param paramDob the dob to set
     */
    public void setDob(Date paramDob) {
        dob = paramDob;
    }
}
