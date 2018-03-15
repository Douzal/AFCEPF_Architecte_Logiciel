package fr.afcepf.al31.clapier.business.api;

import java.util.List;

import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;

public interface IGestionClapier {
	List<Lapin> ajouter(Lapin lapin, Clapier clapier);
	boolean retirer(Lapin lapin);
	List<Lapin> rechercher(Clapier clapier);
	List<Clapier> getAll();
}
