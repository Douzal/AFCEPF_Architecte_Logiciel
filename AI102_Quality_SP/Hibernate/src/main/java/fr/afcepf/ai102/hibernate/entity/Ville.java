package fr.afcepf.ai102.hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * entité representant une ville.
 * @author Formation
 *
 */
@Entity
@Table(name = "ville")
public class Ville {
    /**
     * Identifiant de la ville.
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * nom de la ville.
     */
    @Column(name="libelle", length=50)
    private String libelle;
    
    @OneToMany (mappedBy = "ville", cascade = CascadeType.ALL)
    private Set<Adresse> adresses;
    /**
     * Default Constructor.
     */
    public Ville() {
        super();
    }
    /**
     * @param paramId the id to set
     * @param paramLibelle the libelle to set
     */
    public Ville(Integer paramId, String paramLibelle) {
        super();
        id = paramId;
        libelle = paramLibelle;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    public Set<Adresse> getAdresses() {
        return adresses;
    }
    public void setAdresses(Set<Adresse> paramAdresses) {
        adresses = paramAdresses;
    }
}
