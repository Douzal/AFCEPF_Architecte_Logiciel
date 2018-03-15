package fr.afcepf.squad.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Squad;

@Embeddable
public class MembreSquadPK implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name="id_membre")
    private Integer idMembre;
    
    @Column(name="id_squad")
    private Integer idSquad;

    public MembreSquadPK() {
        super();
    }

    public MembreSquadPK(Integer idMembre, Integer idSquad) {
        super();
        this.idMembre = idMembre;
        this.idSquad = idSquad;
    }

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
    }

    public Integer getIdSquad() {
        return idSquad;
    }

    public void setIdSquad(Integer idSquad) {
        this.idSquad = idSquad;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMembre == null) ? 0 : idMembre.hashCode());
        result = prime * result + ((idSquad == null) ? 0 : idSquad.hashCode());
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
        MembreSquadPK other = (MembreSquadPK) obj;
        if (idMembre == null) {
            if (other.idMembre != null)
                return false;
        } else if (!idMembre.equals(other.idMembre))
            return false;
        if (idSquad == null) {
            if (other.idSquad != null)
                return false;
        } else if (!idSquad.equals(other.idSquad))
            return false;
        return true;
    } 

}
