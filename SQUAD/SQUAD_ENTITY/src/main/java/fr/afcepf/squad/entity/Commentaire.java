package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afcepf.squad.key.CommentairePK;

@Entity
@Table(name="commentaire")
public class Commentaire implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private CommentairePK id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMembre")
    private Membre membre;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRencontre")
    private Rencontre rencontre;
    
    @Column(name="titre", nullable=true, length=100)
    private String titre;
    
    @Column(name="commentaire", nullable=false, length=200)
    private String commentaire;
    
    @Column(name="date_commentaire", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommentaire;
    
    @Column(name="date_edit", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEdit;
    
    @Column(name="note")
    private Integer note;

    
    public Commentaire() {
        super();
    }


    public Commentaire(Membre membre, Rencontre rencontre, String titre, String commentaire, Date dateCommentaire,
            Date dateEdit, Integer note) {
        super();
        this.membre = membre;
        this.rencontre = rencontre;
        this.titre = titre;
        this.commentaire = commentaire;
        this.dateCommentaire = dateCommentaire;
        this.dateEdit = dateEdit;
        this.note = note;
        this.id = new CommentairePK(membre.getId(),rencontre.getId());
    }


    public CommentairePK getId() {
        return id;
    }


    public void setId(CommentairePK id) {
        this.id = id;
    }


    public Membre getMembre() {
        return membre;
    }


    public void setMembre(Membre membre) {
        this.membre = membre;
    }


    public Rencontre getRencontre() {
        return rencontre;
    }


    public void setRencontre(Rencontre rencontre) {
        this.rencontre = rencontre;
    }


    public String getTitre() {
        return titre;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }


    public String getCommentaire() {
        return commentaire;
    }


    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


    public Date getDateCommentaire() {
        return dateCommentaire;
    }


    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }


    public Date getDateEdit() {
        return dateEdit;
    }


    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }


    public Integer getNote() {
        return note;
    }


    public void setNote(Integer note) {
        this.note = note;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    

}
