package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipe")
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_equipe")
    private Integer id;
    
    @Column(name="nom", nullable=true, length=50)
    private String nom;
    
    @Column(name="numero", nullable=true)
    private Integer numero;
    
    @ManyToOne()
    @JoinColumn(name="id_evenement", foreignKey=@ForeignKey(name="fk_equipe_evenement"))
    private Evenement evenement;
    
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name="membre_equipe",
    joinColumns=@JoinColumn(name="id_equipe"),
    inverseJoinColumns=@JoinColumn(name="id_membre"))
    private List<Membre> participants;
    
    @OneToMany(mappedBy="equipe")
    private List<ResultatConfrontation> resultats;

    public Equipe() {
        super();
    }

    public Equipe(Integer id, String nom, Integer numero, Evenement evenement) {
		super();
		this.id = id;
		this.nom = nom;
		this.numero = numero;
		this.evenement = evenement;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<Membre> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Membre> participants) {
        this.participants = participants;
    }

    public List<ResultatConfrontation> getResultats() {
        return resultats;
    }

    public void setResultats(List<ResultatConfrontation> resultats) {
        this.resultats = resultats;
    }

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
    
    
}

