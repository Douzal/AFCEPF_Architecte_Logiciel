package fr.afcepf.al31.clapier.presentation;

import java.util.List;

import fr.afcepf.al31.clapier.business.api.IGestionClapier;
import fr.afcepf.al31.clapier.business.impl.GestionClapier;
import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ClapierPane extends BorderPane {
	private HBox etage0 = new HBox();
	private HBox etage1 = new HBox();
	private VBox etages = new VBox();
	private IGestionClapier gestionClapier = new GestionClapier();
	public ClapierPane() {
		init();
	}
	public void init() {
		if(getCenter() != null)
		((VBox)getCenter()).getChildren().clear();
		etage0 = new HBox();
		etage1 = new HBox();
		etages = new VBox();
		for(int j = 0 ; j < 2 ; j++) {
			for(int i = 0 ; i < 3 ; i++) {
				
				Clapier clapier = new Clapier();
				clapier.setId((j+1) * (i+1));
				List<Lapin> liste = gestionClapier.rechercher(clapier);
				int nbM = 0;
				int nbF = 0;
				int nbC = 0;
				for (Lapin lapin : liste) {
					if (lapin.getClass() == Lapin.class) {
						if(lapin.getSexe().equals("F")) {
							nbF++;
						} else {
							nbM++;
						}
					} else {
						nbC++;
					}
				}
				VBox affichageLapins = new VBox();
				Label affichageMale = new Label("nb H : " + nbM);
				Label affichageFemelle = new Label("nb F : " + nbF);
				Label affichageCretin = new Label("nb Cretin(s) : " + nbC);
				
				
				
				affichageLapins.getChildren().addAll(affichageMale,affichageFemelle, affichageCretin);
				if(j == 0) {
					etage0.getChildren().add(affichageLapins);
				} else {
					etage1.getChildren().add(affichageLapins);
				}
			}
		}
		etages.getChildren().addAll(etage0, etage1);
		setCenter(etages);
	}
}
