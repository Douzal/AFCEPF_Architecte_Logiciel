package fr.afcepf.squad.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import fr.afcepf.squad.key.MembreSquadPK;

@Entity
@Table(name="membre_squad")
public class MembreSquad_old implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private MembreSquadPK id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMembre")
    private Membre membre;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSquad")
    private Squad squad;
    
    @Column(name="est_moderateur", nullable=false, columnDefinition="TINYINT(1)")
    private boolean estModerateur;

    public MembreSquad_old() {
        super();
    }

    public MembreSquad_old(MembreSquadPK id, Membre membre, Squad squad, boolean estModerateur) {
        super();
        this.membre = membre;
        this.squad = squad;
        this.estModerateur = estModerateur;
        this.id = new MembreSquadPK(membre.getId(),squad.getId());
    }

    public MembreSquadPK getId() {
        return id;
    }

    public void setId(MembreSquadPK id) {
        this.id = id;
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

    
    
}
