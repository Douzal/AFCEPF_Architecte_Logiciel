package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="notification")
public class Notification implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_notification")
    private Integer id;
    
    @Column(name="titre", nullable=true, length=100)
    private String titre;
    @Column(name="message", nullable=false, length=200)
    private String message;
    
    @Column(name="date_notification", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dateNotif;
    
    @Column(name="lu", nullable=false, columnDefinition = "TINYINT(1)")
    private boolean estLu;
    
    @ManyToOne
    @JoinColumn(name="id_membre", foreignKey = @ForeignKey(name="fk_notification_membre"))
    private Membre membre;

    public Notification() {
        super();
    }

    public Notification(Integer id, String titre, String message, Date dateNotif, boolean estLu, Membre membre) {
        super();
        this.id = id;
        this.titre = titre;
        this.message = message;
        this.dateNotif = dateNotif;
        this.estLu = estLu;
        this.membre = membre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateNotif() {
        return dateNotif;
    }

    public void setDateNotif(Date dateNotif) {
        this.dateNotif = dateNotif;
    }

    public boolean isEstLu() {
        return estLu;
    }

    public void setEstLu(boolean estLu) {
        this.estLu = estLu;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
    
}
