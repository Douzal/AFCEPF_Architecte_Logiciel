package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afcepf.squad.key.ParticipationPK;

@Entity
@Table(name="participation")
public class Participation_old implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ParticipationPK id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @MapsId("idParticipant")
    private Membre participant;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @MapsId("idRencontre")
    private Rencontre rencontre;
    
    @Column(name="date_demande", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDemande;

    @Column(name="date_validation", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValidation;

    @Column(name="date_exclusion", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExclusion;
    
    @Column(name="est_staff", nullable=false, columnDefinition="TINYINT(1)")
    private boolean estStaff;

    public Participation_old() {
        super();
    }

    public Participation_old(ParticipationPK id, Membre participant, Rencontre rencontre, Date dateDemande,
            Date dateValidation, Date dateExclusion, boolean estStaff) {
        super();
        this.participant = participant;
        this.rencontre = rencontre;
        this.dateDemande = dateDemande;
        this.dateValidation = dateValidation;
        this.dateExclusion = dateExclusion;
        this.estStaff = estStaff;
        this.id = new ParticipationPK(participant.getId(), rencontre.getId());
    }

    public ParticipationPK getId() {
        return id;
    }

    public void setId(ParticipationPK id) {
        this.id = id;
    }

    public Membre getParticipant() {
        return participant;
    }

    public void setParticipant(Membre participant) {
        this.participant = participant;
    }

    public Rencontre getRencontre() {
        return rencontre;
    }

    public void setRencontre(Rencontre rencontre) {
        this.rencontre = rencontre;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public Date getDateExclusion() {
        return dateExclusion;
    }

    public void setDateExclusion(Date dateExclusion) {
        this.dateExclusion = dateExclusion;
    }

    public boolean isEstStaff() {
        return estStaff;
    }

    public void setEstStaff(boolean estStaff) {
        this.estStaff = estStaff;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    

}
