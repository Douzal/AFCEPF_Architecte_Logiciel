package fr.afcepf.squad.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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

import fr.afcepf.squad.key.MembreSquadPK;

@Entity
@Table(name="membre_squad")
public class MembreSquad implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_membre_squad")
    private Integer id;
    
    @ManyToOne()
    @JoinColumn(name="id_membre", foreignKey=@ForeignKey(name="fk_membresquad_membre"),nullable=false)
    private Membre membre;
 
    @ManyToOne()
    @JoinColumn(name="id_squad", foreignKey=@ForeignKey(name="fk_membresquad_squad"),nullable=false)
    private Squad squad;
    
    @Column(name="est_moderateur", nullable=false, columnDefinition="TINYINT(1)")
    private boolean estModerateur;

    public MembreSquad() {
        super();
    }
    
    public MembreSquad(Integer id, Membre membre, Squad squad, boolean estModerateur) {
		super();
		this.id = id;
		this.membre = membre;
		this.squad = squad;
		this.estModerateur = estModerateur;
	}



	public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public boolean isEstModerateur() {
        return estModerateur;
    }

    public void setEstModerateur(boolean estModerateur) {
        this.estModerateur = estModerateur;
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
