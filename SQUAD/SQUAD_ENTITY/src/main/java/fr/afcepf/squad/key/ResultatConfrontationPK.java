package fr.afcepf.squad.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import fr.afcepf.squad.entity.Confrontation;
import fr.afcepf.squad.entity.Equipe;

@Embeddable
public class ResultatConfrontationPK implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name="id_equipe")
    private Integer idEquipe;
    
    @Column(name="id_confrontation")
    private Integer idConfrontation;

    public ResultatConfrontationPK() {
        super();
    }

    public ResultatConfrontationPK(Integer idEquipe, Integer idConfrontation) {
        super();
        this.idEquipe = idEquipe;
        this.idConfrontation = idConfrontation;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Integer getIdConfrontation() {
        return idConfrontation;
    }

    public void setIdConfrontation(Integer idConfrontation) {
        this.idConfrontation = idConfrontation;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idConfrontation == null) ? 0 : idConfrontation.hashCode());
        result = prime * result + ((idEquipe == null) ? 0 : idEquipe.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResultatConfrontationPK other = (ResultatConfrontationPK) obj;
        if (idConfrontation == null) {
            if (other.idConfrontation != null)
                return false;
        } else if (!idConfrontation.equals(other.idConfrontation))
            return false;
        if (idEquipe == null) {
            if (other.idEquipe != null)
                return false;
        } else if (!idEquipe.equals(other.idEquipe))
            return false;
        return true;
    }

    
}
