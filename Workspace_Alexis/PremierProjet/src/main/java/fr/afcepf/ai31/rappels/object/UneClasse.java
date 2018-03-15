package fr.afcepf.ai31.rappels.object;

import org.apache.log4j.Logger;

public class UneClasse {
	private Logger log = Logger.getLogger(getClass());
	
	//visibilité (default) : package
	// type primitif : valeur par defaut car un primitif ne peut être nul
	int unEntier;
	
	// faux primitif : valeur par defaut nulle
	public String uneChaine;
	private double unDouble;
	protected boolean unBoolean;
	public  static final int UNE_CONSTANTE = 5;
	public char unCharactere;
	
	public UneClasse() {
		// constructeur
		log.debug(new StringBuilder("dans le constructeur de ")
				.append(this.getClass()));
	}
	
	// prodedure : void
	public void uneMethode(int i) {
		log.debug(i);
	}
	
	// fonctino : retourne une valeur
	public String uneAutreMethode() {
		return new StringBuilder("Coucou de ").append(this.getClass()).toString();
	}
	
	
}
