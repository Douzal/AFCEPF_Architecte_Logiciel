package fr.afcepf.squad.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.afcepf.squad.enumeration.Sexe;

@Entity
@Table(name="evenement")
public class Evenement extends Rencontre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="evenement", cascade=CascadeType.MERGE)
	private List<Equipe> equipes;

	@OneToMany(mappedBy="evenement", cascade={CascadeType.MERGE,CascadeType.PERSIST})
	private List<Confrontation> confrontations;



	public Evenement() {
		super();
	}



	public Evenement(Integer id, String libelle, String description, Date dateDebut, Date dateFin, Date dateCreation,
			Date dateAnnulation, Sexe sexe, Integer nbMaxPart, String nomLieu, String adresse, String codePostal,
			String ville, Double adresseLat, Double adresseLong, Sport sport, Membre organisateur, Squad squad) {
		super(id, libelle, description, dateDebut, dateFin, dateCreation, dateAnnulation, sexe, nbMaxPart, nomLieu,
				adresse, codePostal, ville, adresseLat, adresseLong, sport, organisateur, squad);
	}



	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Confrontation> getConfrontations() {
		return confrontations;
	}

	public void setConfrontations(List<Confrontation> confrontations) {
		this.confrontations = confrontations;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
