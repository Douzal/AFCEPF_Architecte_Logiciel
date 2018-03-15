package fr.afcepf.al31.clapier.business.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.business.api.IGestionClapier;
import fr.afcepf.al31.clapier.data.api.IDaoClapier;
import fr.afcepf.al31.clapier.data.api.IDaoLapin;
import fr.afcepf.al31.clapier.data.impl.DaoClapier;
import fr.afcepf.al31.clapier.data.impl.DaoLapin;
import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;
import fr.afcepf.al31.clapier.entity.LapinCretin;

public class GestionClapier implements IGestionClapier {
	private IDaoLapin daoLapin = new DaoLapin();
	private IDaoClapier daoClapier = new DaoClapier();
	private String[] couleurs = {"blanc", "gris", "noir", "marron", "vert", "bleu"};
	private Logger log = Logger.getLogger(getClass());
	@Override
	public List<Lapin> ajouter(Lapin lapin, Clapier clapier) {
		List<Lapin> lapins = daoClapier.getLapins(clapier);
		int nbM = 0;
		int nbF = 0;
		int nbC = 0;
		for (Lapin lapin2 : lapins) {
			if (lapin2.getSexe().equals("H") && !isCretin(lapin2.getNbOreille())) {
				nbM++;
			} else if(lapin2.getSexe().equals("F") && !isCretin(lapin2.getNbOreille())){
				nbF++;
			} else {
				nbC++;
			}
		}
		lapin = daoLapin.ajouter(lapin);
		daoClapier.ajouter(lapin, clapier);
		log.debug(lapin.getClass());
		log.debug(lapin.getSexe());
		log.debug(lapin.getClass() != LapinCretin.class 
				&& ((nbM > 0 && lapin.getSexe().equals("F")) 
					|| (nbF > 0 && lapin.getSexe().equals("H"))));
		if (lapin.getClass() != LapinCretin.class 
				&& ((nbM > 0 && lapin.getSexe().equals("F")) 
					|| (nbF > 0 && lapin.getSexe().equals("H")))) {
			int nbEnfant = new Random().nextInt(6);
			for (int i = 0; i < nbEnfant; i++) {
				double nbOreille = 
						((int)(new Random().nextDouble() * 10000)) / 100.0;
				String sexe = new Random().nextInt(100) > 50 ? "H" : "F";
				String couleur = couleurs[new Random().nextInt(couleurs.length)];
				String nom = lapin.getNom();
				Lapin newLapin = null;
				if (!isCretin(nbOreille)) {
					newLapin = new Lapin(null, nom, nbOreille, couleur, new Date(), sexe);
				} else {
					newLapin = new LapinCretin(null, nom, nbOreille, couleur, new Date(), sexe);
				}
				newLapin = daoLapin.ajouter(newLapin);
				daoClapier.ajouter(newLapin, clapier);
				lapins.add(newLapin);
			}
		}
		return lapins;
	}

	@Override
	public boolean retirer(Lapin lapin) {
		if (daoClapier.enlever(lapin) & daoLapin.supprimer(lapin)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Lapin> rechercher(Clapier clapier) {
		List<Lapin> lapins = daoClapier.getLapins(clapier);
		for(int i = 0 ; i < lapins.size() ; i++) {
			Lapin lapin = lapins.get(i);
			if (isCretin(lapin.getNbOreille())) {
				lapins.add(i, new LapinCretin(lapin.getId(), lapin.getNom(), lapin.getNbOreille(), lapin.getCouleur(), lapin.getNaissance(), lapin.getSexe()));
				lapins.remove((i+1));
			}
		}
		return lapins;
	}
	private boolean isCretin(double oreille) {
		return oreille < 1 || oreille > 2;
	}

	@Override
	public List<Clapier> getAll() {
		return daoClapier.getAll();
	}
}
