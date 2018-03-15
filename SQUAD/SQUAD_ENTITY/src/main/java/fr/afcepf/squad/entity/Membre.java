package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import fr.afcepf.squad.enumeration.Sexe;


@Entity
@Table(name="membre")
@Inheritance(strategy=InheritanceType.JOINED)
public class Membre implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_membre")
    private Integer id;

    @Column(name="pseudo",nullable=true,length=50,unique=true)
    private String pseudo;

    @Column(name="nom", nullable=false,length=50)
    private String nom;

    @Column(name="prenom", nullable=false,length=50)
    private String prenom;

    @Column(name="email", nullable=false, length=120, unique=true)
    private String email;

    @Column(name="password", nullable=false, length=50)
    private String password;
    
    @Column(name="photo", nullable=true, length=200)
    private String photo;

    @Column(name="date_naissance", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;

    @Enumerated(EnumType.ORDINAL)
    private Sexe sexe;

    @Column(name="adresse", nullable=true, length=150)
    private String adresse;

    @Column(name="codePostal", nullable=true, length=5)
    private String codePostal;

    @Column(name="ville", nullable=true, length=50)
    private String ville;

    @Column(name="adresse_lat", nullable=true)
    private Double adresseLat;

    @Column(name="adresse_long", nullable=true)
    private Double adresseLong;

    @Column(name="date_inscription", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @ManyToMany
    @JoinTable(name="membre_sport",
    joinColumns = @JoinColumn(name="id_membre"),
    inverseJoinColumns = @JoinColumn(name="id_sport")
    )
    private List<Sport> sports;
    
    
    //m'a l'air foireux: au depart j'etais parti sur une entité invitation avec embeddedid & attributeOverride
    //voir https://blog.axopen.com/2013/11/les-cles-primaires-composees-avec-hibernate-4/ 
    //plus sérieux mais plus complexe pour pas grd chose, on verra si mon bricolage suffit.
    
    
    //regarde plutot ca en fait : https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
    
    @ManyToMany(mappedBy="invites", cascade = CascadeType.MERGE)
    private List<Rencontre> invitations;
    
    @OneToMany(mappedBy="membre")
    private List<Notification> notifications;
    
    @OneToMany(mappedBy="membre")
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy="membre")
    private List<MembreSquad> membreSquads;

    @OneToMany(mappedBy="squadRogueLeader")
    private List<Squad> squadsGeres;
    
    @OneToMany(mappedBy="participant")
    private List<Participation> participations;

    @OneToMany(mappedBy="organisateur")
    private List<Rencontre> rencontresOrga;
    
    @Transient
    private String prenomNomTronque;
    @Transient
    private Integer age;
    
    @Column(name="description")
    private String description;
    
    public Membre() {
        super();
    }

    public Membre(Integer id, String pseudo, String nom, String prenom, String email, String password,
            Date dateNaissance, Sexe sexe, String adresse, String codePostal, String ville, Double adresseLat,
            Double adresseLong, Date dateInscription, String photo) {
        super();
        this.id = id;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.adresseLat = adresseLat;
        this.adresseLong = adresseLong;
        this.dateInscription = dateInscription;
        this.photo = photo;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
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
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public List<Rencontre> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Rencontre> invitations) {
        this.invitations = invitations;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<MembreSquad> getMembreSquads() {
        return membreSquads;
    }

    public void setMembreSquads(List<MembreSquad> membreSquads) {
        this.membreSquads = membreSquads;
    }

    public List<Squad> getSquadsGeres() {
        return squadsGeres;
    }

    public void setSquadsGeres(List<Squad> squadsGeres) {
        this.squadsGeres = squadsGeres;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public List<Rencontre> getRencontresOrga() {
        return rencontresOrga;
    }

    public void setRencontresOrga(List<Rencontre> rencontresOrga) {
        this.rencontresOrga = rencontresOrga;
    }
    

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public static long getSerialversionuid() {
        return serialVersionUID;
    }

	public String getPrenomNomTronque() {
		return prenomNomTronque  = this.prenom +" "+ this.nom.substring(0,1)+".";
	}

	public void setPrenomNomTronque(String prenomNomTronque) {
		this.prenomNomTronque = prenomNomTronque;
	}

	@Transient
	public Integer getAge() {
//		LocalDate today = LocalDate.now();
//		String[] date = this.dateNaissance.toString().replaceAll(" 00:00:00.0", "").split("-");
//    	LocalDate birthday = LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]) ,Integer.parseInt(date[2]));
//    	Period intervalPeriod = Period.between(birthday,today);
//		return age = intervalPeriod.getYears();
		
		Calendar today = Calendar.getInstance();
	    Calendar birthDate = Calendar.getInstance();

	    int age = 0;

	    birthDate.setTime(dateNaissance);
	    if (birthDate.after(today)) {
	        throw new IllegalArgumentException("Can't be born in the future");
	    }

	    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

	    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year   
	    if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
	            (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
	        age--;

	     // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
	    }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
	              (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
	        age--;
	    }

	    return age;
		
	}
	
	@Transient
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Membre other = (Membre) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	
    
}
