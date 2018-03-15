package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.afcepf.squad.enumeration.TypeSportResultat;

/**
 * @author Ghislain
 *
 */
@Entity
@Table(name="sport")
public class Sport implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_sport")
    private Integer id;
    
    @Column(name="libelle", nullable=false, length=50)
    private String libelle;
    
    @Enumerated(EnumType.ORDINAL)
    private TypeSportResultat typeSport;
    
    
    //SUGAR!
    @ManyToMany(mappedBy="sports")
    private List<Membre> pratiquants;
    
    @OneToMany(mappedBy="sport")
    private List<Rencontre> rencontres;
    
    @OneToMany(mappedBy="sport")
    private List<Squad> squads;
    
    @Column(name="couleur")
    private String couleur;
    
    @Column(name="icone")
    private String icone;

    public Sport() {
        super();
    }

    public Sport(Integer id, String libelle, TypeSportResultat typeSport) {
        super();
        this.id = id;
        this.libelle = libelle;
        this.typeSport = typeSport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TypeSportResultat getTypeSport() {
        return typeSport;
    }

    public void setTypeSport(TypeSportResultat typeSport) {
        this.typeSport = typeSport;
    }

    public List<Membre> getPratiquants() {
        return pratiquants;
    }

    public void setPratiquants(List<Membre> pratiquants) {
        this.pratiquants = pratiquants;
    }

    public List<Rencontre> getRencontres() {
        return rencontres;
    }

    public void setRencontres(List<Rencontre> rencontres) {
        this.rencontres = rencontres;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}
    
}
