package fr.afcepf.al31;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class PremiereClasse {
	private static Logger log = Logger.getLogger(PremiereClasse.class);
	public static void main(String[] args) {
		System.out.println("Dernier Hello World !!! ");
		log.debug("Hello Java World");

		log.debug("()()");
		log.debug("(^^)");
		log.debug("(_()()");
		
		// Types primitifs :
		// D�claration d'une variable : 
		int i;
		// Affectation : dans la table de reference et la memoire
		i = 5;
		log.debug(i);
		int j = 15;
		log.debug(j);
		
		boolean unBoolean = true;
		boolean unAutreBoolean = false;
		log.debug(unBoolean);
		log.debug(unAutreBoolean);
		
		byte unByte = 127;
		byte unAutreByte = 1;
		
		int resultat = unByte + unAutreByte;
		log.debug(resultat);
		
		int unEntier = 2147483647;
		resultat = unEntier + unAutreByte;
		log.debug(resultat);
		
		float unDecimal = 12.5f;
		log.debug(unDecimal);
		double unAutreDecimal = 12.5;
		double encoreUnDecimal = 12.5d;

		log.debug(unAutreDecimal);
		log.debug(encoreUnDecimal);
		// un charact�re sur la machine est g�r� par les tables ASCII
		char unCharactere = 97;
		log.debug(unCharactere);
		char unAutreCharactere = '�'; // Alt + 0199
		log.debug(unAutreCharactere);
		
		String uneChaine = "une chaine de caract�res";
		log.debug(uneChaine);
		
		// Op�rateurs : 
		// calcul 
		int a = 5;
		int b = 10;
		double resultatCalcul = a / b; // 0.0
		log.debug(resultatCalcul);
		resultatCalcul = (double)a / b;
		log.debug(resultatCalcul);
		
		// incrementation post & pr�
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
		
		// Op�rateurs logique: 
		int h = 5;
		int f = 3;	
		log.debug(h | f); // 7
		log.debug(h & f); // 1
		log.debug(f ^ h); // 6  
		log.debug(6 ^ f); // f
		log.debug(6 ^ h); // h  
		
		// operateur logique informatique
		boolean m = false;
		boolean n = true;
		boolean o = m & n;
		log.debug(o);
		o = m | n;
		log.debug(o);
		if(m & n) {
			// 3 traitements
		}
		if(m && n) {
			// 1 traitement
		}
		// operateurs de comparaison
		boolean p = 5 < 2;
		log.debug(p); // false
		log.debug(5 == 2);
		
		String chaine = "coucou";
		String chaine2 = "coucou";
		log.debug(chaine == chaine2);
		log.debug(chaine == JOptionPane.showInputDialog("saisir coucou"));
		log.debug(chaine.equals(JOptionPane.showInputDialog("saisir coucou", "coucou")));
		
		String chaine3 = chaine == chaine2 ? "oui" : "non";
		log.debug(chaine3);
		String chaine4 = null;
		if (chaine == chaine2) {
			chaine4 = "oui";
		} else {
			chaine4 = "non";
		}
		log.debug(chaine4);
		chaine = JOptionPane.showInputDialog("saisir un truc");
		switch (chaine) {
		case "coucou":
			log.debug("chaine = coucou");
			break;
		case "coucou2":
		case "coucou3":
			log.debug("coucou2 ou coucou3");
			break;
		default:
			log.debug(chaine);
			break;
		}
		// boucles :
		// POUR 1 entier i allant de 0 à N par pas de 1 FAIRE :
		for(int q = 0 ; q < 5 ; q++) {
			 log.debug(q);
		}
		// FIN POUR
		int r = 0;
		for(;;) {
			r++;
			if(r == 2) {
				continue;
			}
			log.debug(r);
			if(r == 5) {
				break;
			}
		}
		int s = 0;
		// TANT QUE un entier i < 5 FAIRE :
		while(s < 5) {
			log.debug(s++);
		}
		// FIN TANT QUE
		int t = 0;
		// FAIRE
		do {
			log.debug(t++);
		} while(t < 5);
		// TANT QUE un entier i < 5 
		
		
		
		
		
		
		
		
		
		
	} 
} 
