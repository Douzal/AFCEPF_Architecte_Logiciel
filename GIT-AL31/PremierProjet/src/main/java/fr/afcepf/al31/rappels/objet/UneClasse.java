package fr.afcepf.al31.rappels.objet;

import org.apache.log4j.Logger;

public class UneClasse {
	private Logger log = Logger.getLogger(getClass());
	// visibilité (default) : package
	// type primitif : valeur par defaut car un primitif ne peut être null.
	int unEntier;
	// faux primitif : valeur par defaut null
	public String uneChaine;
	private double unDouble;
	protected boolean unBoolean;
	public static final int UNE_CONSTANTE = 5;
	public char unCaractere; // = '\0'
	public UneClasse() {
		log.debug(new StringBuilder("dans le constructeur de ")
					.append(this.getClass()));
	}
	// procedure : void
	public void uneMethode(int i) {
		log.debug(i);
	}
	// fonction : returne une valeur
	public String uneAutreMethode() {
		return new StringBuilder("coucou de ").append(this.getClass()).toString();
	}
}
