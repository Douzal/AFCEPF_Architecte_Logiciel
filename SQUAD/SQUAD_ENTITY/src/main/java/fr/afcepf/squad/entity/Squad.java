package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afcepf.squad.enumeration.Sexe;

@Entity
@Table(name="squad")
public class Squad implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_squad")
    private Integer id;
    
    @Column(name="nom", nullable=false, length=80)
    private String nom;
    
    @Column(name="description", nullable=true, length=400)
    private String description;
    
    @Column(name="photo",nullable=true, length=150)
    private String photo;
    
    @Enumerated(EnumType.ORDINAL)
    private Sexe sexe;
    
    @Column(name="date_creation", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @ManyToOne
    @JoinColumn(name = "id_sport", foreignKey = @ForeignKey(name="fk_squad_sport"), nullable=false)
    private Sport sport;
    
    //hihihi
    @ManyToOne
    @JoinColumn(name="id_leader", foreignKey=@ForeignKey(name="fk_squad_leader"), nullable=false)
    private Membre squadRogueLeader;
    
    @OneToMany(mappedBy="squad")
    private List<MembreSquad> membresSquad;
    
    @OneToMany(mappedBy="squad")
    private List<Rencontre> rencontres;
    
    @OneToMany(mappedBy="squad")
    private List<MessageSquad> messages;

    public Squad() {
        super();
    }

    public Squad(Integer id, String nom, String description, String photo, Sexe sexe, Date dateCreation, Sport sport,
            Membre squadRogueLeader) {
        super();
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.photo = photo;
        this.sexe = sexe;
        this.dateCreation = dateCreation;
        this.sport = sport;
        this.squadRogueLeader = squadRogueLeader;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Membre getSquadRogueLeader() {
        return squadRogueLeader;
    }

    public void setSquadRogueLeader(Membre squadRogueLeader) {
        this.squadRogueLeader = squadRogueLeader;
    }

    public List<MembreSquad> getMembresSquad() {
        return membresSquad;
    }

    public void setMembresSquad(List<MembreSquad> membresSquad) {
        this.membresSquad = membresSquad;
    }
    

    public List<MessageSquad> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageSquad> messages) {
        this.messages = messages;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

	public List<Rencontre> getRencontres() {
		return rencontres;
	}

	public void setRencontres(List<Rencontre> rencontres) {
		this.rencontres = rencontres;
	}
    
    

}
