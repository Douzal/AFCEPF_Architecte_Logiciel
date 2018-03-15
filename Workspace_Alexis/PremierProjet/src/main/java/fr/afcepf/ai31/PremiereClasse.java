package fr.afcepf.ai31;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class PremiereClasse {

	private static Logger log = Logger.getLogger(PremiereClasse.class);
	
	public static void main(String[] args) {
//		System.out.println("coucou patron");
//		JOptionPane.showMessageDialog(null, "Coucou patron !!");
		
		log.debug("Voila mes couilles pour ton front.");
		
		//Types primitifs :
		// declaration d'une variable
		int i;
		// affectation : dans la table de référence et la memoire
		i = 5;
		log.debug(i);
		int j = 15; 
		log.debug(j);
		
			boolean unBool = true;
			log.debug(unBool);
		
		float unDecimal = 12.5f;
		log.debug(unDecimal);
		
//		un caractère : gere sur la machine par :
		char unCharactere = 97;
		log.debug(unCharactere); // renvoie a, code ASCII 97
		// les quotes sont pour les caractères seuls !
		char unAutreCharactere = 'Ç'; // Alt + 0199
		
		String uneChaine = "une chaine de caracteres";
		log.debug(uneChaine);
		
		// incrementation post & pré
		int c = 5;
		int d = c++;
		
		log.debug(d); // 5
		log.debug(c); // 6
		int e = ++c;
		log.debug(e); // 7
		e = e++;
		log.debug(e); // 7
		e++;
		log.debug(e); // 8
		
		// operateurs logiques
		int f = 3;
		int h = 5;
		
		log.debug(h | f); // 7
		log.debug(h & f); // 1
		log.debug(h ^ f); // 6
		log.debug(6 ^ f); // f
		log.debug(6 ^ h); // c
		
		// operateurs logiques informatique
		boolean m =false;
		boolean n = true;
		boolean o = m & n; 
		log.debug(o); // false
		o = m | n;
		log.debug(o); // true
		
		if(m & n) {
			// 3 traitements envoyes
		}
		
		if(m && n) {
			// un traitement
		}
		
		// operateurs de comparaison
		boolean p = 5 < 2;
		log.debug(p); // false
		
		log.debug(5==2); //teste les références pour les objets complexes, pour les primitifs la valeur.
		// pour les chaines, attention
		String ch1 = "coucou";
		String ch2 = "coucou";
		log.debug(ch1 == ch2); //true
		
		String chaine3 = JOptionPane.showInputDialog("Choix chaine 3", "coucou");
		String chaine4 = JOptionPane.showInputDialog("Choix chaine 4", "coucou");
		
		log.debug(ch1==chaine3); // false
		log.debug(ch1.equals(chaine4)); // true
		
		String ch3 = ch1 == ch2 ? "oui" : "non";
		log.debug(ch3);
		String ch4 = null;
		if (ch1 == ch2) {
			ch4 ="oui";
		} else {
			ch4 = "non";
		}
		
		log.debug(ch4);
		ch1 = JOptionPane.showInputDialog("Saisire truc", "truc");
		switch (ch1) {
		case "coucou":
			log.debug("chaine = coucou");
			break;
		case "coucou2":
		case "coucou3":
			log.debug("coucou 2 ou coucou 3");
			break;
		default:
			log.debug(ch1);
			break;
		}

		
	}

}
