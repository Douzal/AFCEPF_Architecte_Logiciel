package fr.afcepf.al31.rappels.objet;

import org.apache.log4j.Logger;

public final class TestHeritage {
	private TestHeritage() {
	}
	private static Logger log = Logger.getLogger(TestHeritage.class);
	public static void main(String[] args) {
		Stagiaire s1 = new Stagiaire(1, "nom1", "prenom1");
		Personne s2 = new Stagiaire(2, "nom2", "prenom2");
		IManger s3 = new Stagiaire(3, "nom3", "prenom3");
		ITravailler s4 = new Stagiaire(4, "nom4", "prenom4");
		Object s5 = new Stagiaire(5, "nom5", "prenom5");
		Formateur f1 = new Formateur(6, "form1", "form1");
		Personne f2 = new Formateur(7, "form2", "form2");
		Stagiaire s6 = new Stagiaire() {
			@Override
			public boolean isMcDo() {
				return false;
			}
		};
		Formateur f3 = new Formateur() {
			@Override
			public double manger() {
				log.debug("va manger McDo");
				return super.manger();
			}
		};
		// ...
		IManger mangeurs[] = {s1, s2, s3, (IManger)s4, (IManger)s5, f1, f2, s6, f3};
		for (IManger iManger : mangeurs) {
			if(iManger instanceof Stagiaire) {
				if(((Stagiaire) iManger).isMcDo()) {
					log.fatal("McDo");
				}
			} else if (iManger.getClass() == Formateur.class) {
				log.debug("ne sais pas ou");
			}
			log.debug(iManger.manger());
		}
		Personne[] personne = 
			{s1, s2, (Personne)s3, (Personne)s4, (Personne)s5, f1, f2, s6, f3};
		for (Personne personne2 : personne) {
			log.debug(personne2.travailler());
			personne2.allerEnPause();
			log.debug(personne2.travailler());
			personne2.manger();
			log.debug(personne2.travailler());
			
		}
		Object[] personneObjet = 
			{s1, s2, s3, s4, s5, f1, f2, s6, f3};	
		for (Object object : personneObjet) {
			if(object instanceof Stagiaire) {
				if(((Stagiaire) object).isMcDo()) {
					log.fatal("McDo");
				}
			} else if (object.getClass() == Formateur.class) {
				log.debug("ne sais pas ou");
			}
			log.debug(((IManger)object).manger());
		}
	}
}
