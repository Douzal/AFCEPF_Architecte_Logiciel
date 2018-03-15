package fr.afcepf.al31.clapier.data.api;

import java.util.List;

import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;

public interface IDaoClapier {
	boolean ajouter(Lapin lapin, Clapier clapier);
	boolean enlever(Lapin lapin);
	List<Lapin> getLapins(Clapier clapier);
	List<Clapier> getAll();
}
