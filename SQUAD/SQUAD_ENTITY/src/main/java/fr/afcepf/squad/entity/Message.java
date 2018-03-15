package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="message")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_message")
public class Message implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_message")
    private Integer id;
    
    @Column(name="titre", nullable=true, length=120)
    private String titre;
    
    @Column(name="message", nullable=false, length=300)
    private String message;
    
    @Column(name="date_message", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMessage;
    
    @Column(name="date_edit", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEdit;
    
    @ManyToOne
    @JoinColumn(name="id_membre", foreignKey = @ForeignKey(name="fk_message_membre"))
    private Membre auteur;

    public Message() {
        super();
    }

    public Message(Integer id, String titre, String message, Date dateMessage, Date dateEdit, Membre auteur) {
        super();
        this.id = id;
        this.titre = titre;
        this.message = message;
        this.dateMessage = dateMessage;
        this.dateEdit = dateEdit;
        this.auteur = auteur;
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

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    public Membre getAuteur() {
        return auteur;
    }

    public void setAuteur(Membre auteur) {
        this.auteur = auteur;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
    
}
