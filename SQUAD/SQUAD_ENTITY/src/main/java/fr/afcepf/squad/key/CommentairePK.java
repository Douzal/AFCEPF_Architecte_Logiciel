package fr.afcepf.squad.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Rencontre;

@Embeddable
public class CommentairePK implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name="id_membre")
    private Integer idMembre;
    
    @Column(name="id_rencontre")
    private Integer idRencontre;

    public CommentairePK() {
        super();
    }

    public CommentairePK(Integer idMembre, Integer idRencontre) {
        super();
        this.idMembre = idMembre;
        this.idRencontre = idRencontre;
    }

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
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
        result = prime * result + ((idMembre == null) ? 0 : idMembre.hashCode());
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
        CommentairePK other = (CommentairePK) obj;
        if (idMembre == null) {
            if (other.idMembre != null)
                return false;
        } else if (!idMembre.equals(other.idMembre))
            return false;
        if (idRencontre == null) {
            if (other.idRencontre != null)
                return false;
        } else if (!idRencontre.equals(other.idRencontre))
            return false;
        return true;
    }

    
}
