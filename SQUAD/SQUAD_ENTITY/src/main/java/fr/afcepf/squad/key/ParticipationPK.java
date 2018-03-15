package fr.afcepf.squad.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Rencontre;

@Embeddable
public class ParticipationPK implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name="id_participant")
    private Integer idParticipant;
    
    @Column(name="id_rencontre")
    private Integer idRencontre;

    public ParticipationPK() {
        super();
    }

    public ParticipationPK(Integer idParticipant, Integer idRencontre) {
        super();
        this.idParticipant = idParticipant;
        this.idRencontre = idRencontre;
    }

    public Integer getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(Integer idParticipant) {
        this.idParticipant = idParticipant;
    }

    public Integer getIdRencontre() {
        return idRencontre;
    }

    public void setIdRencontre(Integer idRencontre) {
        this.idRencontre = idRencontre;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idParticipant == null) ? 0 : idParticipant.hashCode());
        result = prime * result + ((idRencontre == null) ? 0 : idRencontre.hashCode());
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
        ParticipationPK other = (ParticipationPK) obj;
        if (idParticipant == null) {
            if (other.idParticipant != null)
                return false;
        } else if (!idParticipant.equals(other.idParticipant))
            return false;
        if (idRencontre == null) {
            if (other.idRencontre != null)
                return false;
        } else if (!idRencontre.equals(other.idRencontre))
            return false;
        return true;
    }

    
    
}
