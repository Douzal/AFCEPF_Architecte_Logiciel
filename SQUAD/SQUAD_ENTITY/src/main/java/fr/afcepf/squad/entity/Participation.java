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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="participation")
public class Participation implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="id_participant", foreignKey=@ForeignKey(name="fk_partipation_membre"),nullable=false)
    private Membre participant;
    
    @ManyToOne()
    @JoinColumn(name="id_rencontre", foreignKey=@ForeignKey(name="fk_partipation_rencontre"),nullable=false)
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

    public Participation() {
		super();
	}

	public Participation(Integer id, Membre participant, Rencontre rencontre, Date dateDemande, Date dateValidation,
			Date dateExclusion, boolean estStaff) {
		super();
		this.id = id;
		this.participant = participant;
		this.rencontre = rencontre;
		this.dateDemande = dateDemande;
		this.dateValidation = dateValidation;
		this.dateExclusion = dateExclusion;
		this.estStaff = estStaff;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
