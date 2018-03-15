package fr.afcepf.al31.rappels.objet;

import java.util.Calendar;
import java.util.Date;

public class Stagiaire extends Personne {
	public Stagiaire() {
		getLog().debug("dans constructeur de Stagiaire");
	}
	public Stagiaire(Integer id, String nom, String prenom) {
		super(id, nom, prenom);
		getLog().debug("dans constructeur surchargé de Stagiaire");
	}
	@Override
	public String travailler() {
		return new StringBuilder().append(getClass().getSimpleName())
				.append(" travaille dur ").toString();
	}
	@Override
	public double allerEnPause() {
		getLog().debug("le stagiaire va en pause tout de suite");
		return 0;
	}
	public boolean isMcDo() {
		// verifier si jeudi.
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY
				|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY;
	}
}
