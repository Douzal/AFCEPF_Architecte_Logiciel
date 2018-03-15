package fr.afcepf.al31.rappels.objet;

import org.apache.log4j.Logger;
/**
 * Classe UTILITAIRE : qui ne definit que des elements static.
 * 	- ne peut etre redefinie
 *  - ne peut etre instanciée.
 */
public final class TestVisibilite {
	private TestVisibilite() {
	}
	private static Logger log = Logger.getLogger(TestVisibilite.class);
	public static void main(String[] args) {
		log.debug(UneClasse.UNE_CONSTANTE);
		// mise en pile de 'instance' (ref) et en tas un Object de type UneClasse
		UneClasse instance = new UneClasse();
		// acces protected (c'est pas beau mais ca marche)
		log.debug(instance.unBoolean);
		// acces default (pas mieux)
		log.debug(instance.unEntier);
		// toujours pas mieux
		log.debug(instance.UNE_CONSTANTE);
		// access public
		log.debug((int)instance.unCaractere);
		instance.unCaractere = 199;
		log.debug(instance.unCaractere);
		instance.uneMethode((int) instance.unCaractere);
		log.debug(instance.uneAutreMethode());
		log.debug(instance.hashCode());
		log.debug(instance.toString());
	}
}
