package fr.afcepf.al31.clapier.entity;

import java.io.Serializable;
import java.util.Date;

public class Lapin implements Serializable {
	/**
	 *  ()()
	 *  (^^) Love Java!!!
	 * °(_()()
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private Double nbOreille;
	private String couleur;
	private Date naissance;
	private String sexe;
	
	public Lapin() {
		super();
	}

	public Lapin(Integer id, String nom, Double nbOreille, String couleur, Date naissance, String sexe) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbOreille = nbOreille;
		this.couleur = couleur;
		this.naissance = naissance;
		this.sexe = sexe;
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

	public Double getNbOreille() {
		return nbOreille;
	}

	public void setNbOreille(Double nbOreille) {
		this.nbOreille = nbOreille;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	 
}
