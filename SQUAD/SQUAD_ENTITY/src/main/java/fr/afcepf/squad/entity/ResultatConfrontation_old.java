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

import fr.afcepf.squad.key.ResultatConfrontationPK;

@Entity
@Table(name="resultat_confrontation")
public class ResultatConfrontation_old implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ResultatConfrontationPK id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("idEquipe")
    private Equipe equipe;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("idConfrontation")
    private Confrontation confrontation;
    
    //pas necessaire de distinguer score et temps je pense, why ?:
    //dans tous les cas on stockera un nombre: soit le nombre de point, soit un temps exprimé en nombre de secondes genre timestamp.
    @Column(name="score", nullable=false)
    private float score;

    public ResultatConfrontation_old() {
        super();
    }

    public ResultatConfrontation_old(ResultatConfrontationPK id, Equipe equipe, Confrontation confrontation, float score) {
        super();
        this.equipe = equipe;
        this.confrontation = confrontation;
        this.score = score;
        this.id = new ResultatConfrontationPK(equipe.getId(), confrontation.getId());
    }

    public ResultatConfrontationPK getId() {
        return id;
    }

    public void setId(ResultatConfrontationPK id) {
        this.id = id;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Confrontation getConfrontation() {
        return confrontation;
    }

    public void setConfrontation(Confrontation confrontation) {
        this.confrontation = confrontation;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    
    
}
