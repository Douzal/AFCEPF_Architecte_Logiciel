package fr.afcepf.al31.test;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.business.api.IGestionClapier;
import fr.afcepf.al31.clapier.business.impl.GestionClapier;
import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;

public final class TestGestionClapier {
	private TestGestionClapier() {
	}
	private static Logger log = Logger.getLogger(TestGestionClapier.class);
	public static void main(String[] args) {
		IGestionClapier gestionnaireDeLapins = new GestionClapier();
		Clapier clapier = new Clapier();
		clapier.setId(5);
		List<Lapin> lapins = gestionnaireDeLapins.rechercher(clapier);
		for (Lapin lapin : lapins) {
			log.debug(lapin.getId() + "\t" + lapin.getCouleur() + ",\t" + lapin.getSexe() + ",\t" + lapin.getNbOreille() + ",\t" + lapin.getClass().getSimpleName());
		}
//		gestionnaireDeLapins.ajouter(
//				new Lapin(null, "nom", 2.0, "gris", new Date(), "F"), clapier);
//		lapins = gestionnaireDeLapins.rechercher(clapier);
//		for (Lapin lapin : lapins) {
//			log.debug(lapin.getCouleur() + ",\t" + lapin.getSexe() + ",\t" + lapin.getNbOreille() + ",\t" + lapin.getClass().getSimpleName());
//		}
	}
}
