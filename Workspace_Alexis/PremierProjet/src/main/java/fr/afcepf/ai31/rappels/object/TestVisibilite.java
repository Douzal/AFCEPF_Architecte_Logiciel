package fr.afcepf.ai31.rappels.object;

import org.apache.log4j.Logger;

/**
 * Classe UTILITAIRE : qui ne definit que des elemetns static.
 * - ne peut être redefinie
 * - ne peut être instanciee
 * @author Alexis M
 *
 */
public class TestVisibilite {
	private TestVisibilite() {
	}
	
	private static Logger log = Logger.getLogger(TestVisibilite.class);
	public static void main(String[] args) {
		log.debug(UneClasse.UNE_CONSTANTE);
		// pas besoin d'instance d'une constantecar 
		// en effet tout ce qui est constante 
		// est chargé en memoire directement par la JRE
		// mise en pile de 'instance' (ref) et en tas un Object de type UneClasse
		UneClasse instance = new UneClasse();
		// acces protected (c'est moche mais marche)
		log.debug(instance.unBoolean);
		// acces default (pas mieux)
		log.debug(instance.unEntier);
		// pas mieux
		log.debug(instance.UNE_CONSTANTE);
		// acces public
		log.debug((int)instance.unCharactere);
	}
}
