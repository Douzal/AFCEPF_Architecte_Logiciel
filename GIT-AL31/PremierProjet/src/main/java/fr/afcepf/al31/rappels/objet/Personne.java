package fr.afcepf.al31.rappels.objet;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public abstract class Personne implements IManger, ITravailler, Comparable<Personne> {
	private Logger log = Logger.getLogger(getClass());
	private Integer id;
	private String nom;
	private String prenom;
	public abstract double allerEnPause();
	// Default Constructor.
	public Personne() {
		log.debug("dans constructeur de Personne");
	}
	// Surcharge
	public Personne(Integer id, String nom, String prenom) {
		log.debug("dans constructeur surchargé de Personne");
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	// realisation 
	@Override
	public double manger() {
		log.debug(new StringBuilder().append(this.getClass().getSimpleName())
									 .append(" mange à ")
									 .append(IManger.HEURE_DE_PAUSE)
									 .append(" heures"));
		// calcul des minutes ...
		Calendar calNow = Calendar.getInstance();
		calNow.setTime(new Date());
		Calendar heureMiam = Calendar.getInstance();
		heureMiam.setTime(new Date());
		heureMiam.set(Calendar.HOUR_OF_DAY, IManger.HEURE_DE_PAUSE);
		heureMiam.set(Calendar.MINUTE, 0);
		long tempsMs = heureMiam.getTimeInMillis() - calNow.getTimeInMillis();
		return tempsMs / 1000 / 60;
	}
	// Properties
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	@Override
	public int compareTo(Personne o) {
		if (nom.compareToIgnoreCase(o.getNom()) == 0) {
			return prenom.compareToIgnoreCase(o.getPrenom());
		} else {
			return nom.compareToIgnoreCase(o.getNom());
		}
	}
	@Override
	public String toString() {
		return new StringBuilder("Personne [id=").append(id)
				.append(", nom=").append(nom)
				.append(", prenom=").append(prenom)
				.append("]").toString();
	}
	
}
