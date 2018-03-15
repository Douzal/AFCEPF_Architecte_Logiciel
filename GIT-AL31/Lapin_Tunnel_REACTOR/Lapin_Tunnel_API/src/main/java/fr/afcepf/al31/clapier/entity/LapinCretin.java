package fr.afcepf.al31.clapier.entity;

import java.util.Date;

public class LapinCretin extends Lapin {

	public LapinCretin() {
		super();
	}

	public LapinCretin(Integer id, String nom, Double nbOreille, String couleur, Date naissance, String sexe) {
		super(id, nom, nbOreille, couleur, naissance, sexe);
	}
	
}
