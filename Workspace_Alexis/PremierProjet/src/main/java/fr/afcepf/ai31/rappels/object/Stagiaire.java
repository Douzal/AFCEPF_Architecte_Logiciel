package fr.afcepf.ai31.rappels.object;

import java.util.Calendar;
import java.util.Date;

public class Stagiaire extends Personne {

//	private boolean mcDo;
	
	public Stagiaire() {
		getLog().debug("dans constructeur par defaut de Stagiaire");
	}
	
	public Stagiaire(Integer id, String nom, String prenom) {
		super(id, nom, prenom);
		getLog().debug("dans constructeur surchargé de Stagiaire");
	}

	@Override
	public String travailler() {
		return new StringBuilder().append(getClass().getSimpleName())
				.append(" travaille dur !").toString();
	}

	@Override
	public double allerEnPause() {
		getLog().debug("le stagiaire va en pause immédiatement.");
		return 0;
	}
	
	public boolean isMcDo() {
		// verifier si jeudi
		Calendar cal = Calendar.getInstance(); // instance du calendrier
		cal.setTime(new Date()); // ... a laquelle on associe date du jour
		return cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY;
	}

}
