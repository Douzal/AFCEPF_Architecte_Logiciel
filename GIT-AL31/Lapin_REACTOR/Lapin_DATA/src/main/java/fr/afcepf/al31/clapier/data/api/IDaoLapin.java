package fr.afcepf.al31.clapier.data.api;

import fr.afcepf.al31.clapier.entity.Lapin;

public interface IDaoLapin {
	Lapin ajouter(Lapin lapin);
	boolean supprimer(Lapin lapin);
}
