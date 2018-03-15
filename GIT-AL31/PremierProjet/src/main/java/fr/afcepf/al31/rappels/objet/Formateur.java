package fr.afcepf.al31.rappels.objet;

public class Formateur extends Personne {
	
	public Formateur() {
		getLog().debug("dans constructeur de Formateur");
	}
	public Formateur(Integer id, String nom, String prenom) {
		super(id, nom, prenom);
		getLog().debug("dans constructeur surchargé de Formateur");
	}
	@Override
	public String travailler() {
		return new StringBuilder().append(getClass().getSimpleName())
				.append(" travaille dur ").toString();
	}
	@Override
	public double allerEnPause() {
		getLog().debug("le formateur va en pause tout de suite");
		return 0;
	}
	@Override
	public double manger() {
		getLog().debug(new StringBuilder().append(this.getClass().getSimpleName())
				 .append(" mange à l'heure qu'il veut"));
		return 0;
	}
}
