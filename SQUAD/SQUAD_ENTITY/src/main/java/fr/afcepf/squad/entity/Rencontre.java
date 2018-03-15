package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afcepf.squad.enumeration.Sexe;

@Entity
@Table(name="rencontre")
@Inheritance(strategy=InheritanceType.JOINED)
public class Rencontre implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_rencontre")
    private Integer id;
    
    @Column(name="libelle", nullable=false, length=120)
    private String libelle;
    
    @Column(name="description", nullable=false, length=400)
    private String description;
    
    @Column(name="date_debut", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    
    @Column(name="date_fin", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    
    @Column(name="date_creation", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @Column(name="date_annulation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAnnulation;
    
    @Enumerated(EnumType.ORDINAL)
    private Sexe sexe;
    
    @Column(name="nb_max_participant", nullable=true)
    private Integer nbMaxPart;
    
    @Column(name="nom_lieu", nullable=true, length=120)
    private String nomLieu;
    
    @Column(name="adresse", nullable=true, length=150)
    private String adresse;
    
    @Column(name="code_postal", nullable=true, length=5)
    private String codePostal;
    
    @Column(name="ville", nullable=true, length=50)
    private String Ville;
    
    @Column(name="adresse_lat", nullable=true)
    private Double adresseLat;
    
    @Column(name="adresse_long", nullable=true)
    private Double adresseLong;
    
    @ManyToOne
    @JoinColumn(name = "id_sport", foreignKey = @ForeignKey(name="fk_rencontre_sport"),nullable=false)
    private Sport sport;
    
    @ManyToOne
    @JoinColumn(name="id_organisateur", foreignKey=@ForeignKey(name="fk_rencontre_organisateur"),nullable=false)
    private Membre organisateur;
    
    @OneToMany(mappedBy="rencontre")
    private List<MessageRencontre> messages;
    
    @OneToMany(mappedBy="rencontre")
    private List<Participation> participations;
    
    @OneToMany(mappedBy="rencontre")
    private List<Commentaire> commentaires;
    
    @ManyToOne
    @JoinColumn(name="id_squad", foreignKey=@ForeignKey(name="fk_rencontre_squad"),nullable=true)
    private Squad squad;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="invitation",
    joinColumns = @JoinColumn(name="id_rencontre"),
    inverseJoinColumns = @JoinColumn(name="id_membre"))
    private List<Membre> invites;
    
    private String adresseComplete;
    
    public Rencontre() {
        super();
    }

    
    public Rencontre(Integer id, String libelle, String description, Date dateDebut, Date dateFin, Date dateCreation,
			Date dateAnnulation, Sexe sexe, Integer nbMaxPart, String nomLieu, String adresse, String codePostal,
			String ville, Double adresseLat, Double adresseLong, Sport sport, Membre organisateur, Squad squad) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateCreation = dateCreation;
		this.dateAnnulation = dateAnnulation;
		this.sexe = sexe;
		this.nbMaxPart = nbMaxPart;
		this.nomLieu = nomLieu;
		this.adresse = adresse;
		this.codePostal = codePostal;
		Ville = ville;
		this.adresseLat = adresseLat;
		this.adresseLong = adresseLong;
		this.sport = sport;
		this.organisateur = organisateur;
		this.squad = squad;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateAnnulation() {
        return dateAnnulation;
    }

    public void setDateAnnulation(Date dateAnnulation) {
        this.dateAnnulation = dateAnnulation;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Integer getNbMaxPart() {
        return nbMaxPart;
    }

    public void setNbMaxPart(Integer nbMaxPart) {
        this.nbMaxPart = nbMaxPart;
    }

    public String getNomLieu() {
        return nomLieu;
    }

    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public Double getAdresseLat() {
        return adresseLat;
    }

    public void setAdresseLat(Double adresseLat) {
        this.adresseLat = adresseLat;
    }

    public Double getAdresseLong() {
        return adresseLong;
    }

    public void setAdresseLong(Double adresseLong) {
        this.adresseLong = adresseLong;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Membre getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Membre organisateur) {
        this.organisateur = organisateur;
    }

    public List<MessageRencontre> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageRencontre> messages) {
        this.messages = messages;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
    

    public List<Membre> getInvites() {
        return invites;
    }

    public void setInvites(List<Membre> invites) {
        this.invites = invites;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

	public Squad getSquad() {
		return squad;
	}

	public void setSquad(Squad squad) {
		this.squad = squad;
	}


	public String getAdresseComplete() {
		return adresseComplete=this.adresse +", "+this.codePostal+"."+this.Ville;
	}


	public void setAdresseComplete(String adresseComplete) {
		this.adresseComplete = adresseComplete;
	}
    
    

}
