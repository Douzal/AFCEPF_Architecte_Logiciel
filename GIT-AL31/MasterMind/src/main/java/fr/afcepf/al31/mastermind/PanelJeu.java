package fr.afcepf.al31.mastermind;

import java.util.Random;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PanelJeu extends BorderPane {
	public Color[] solution = new Color[4];
	public PanelJeu() {
		Integer[] tmp = new Integer[4];
		int indice = 0;
		int nb = 0;
		while(indice <= 3) {
			nb = new Random().nextInt(6);
			boolean trouve = false;
			for(Integer i : tmp) {
				if (i != null && i == nb) {
					trouve = true;
				}
			}
			if(!trouve) {
				solution[indice] = MasterMind.COULEURS_POSSIBLES[nb];
				tmp[indice++] = nb;
			}
		}
		solution[--indice] = MasterMind.COULEURS_POSSIBLES[nb];
		//setTop(new PanelVerification(solution, this));
		setBottom(new PanelJoueur());
		setCenter(new VBox());
	}
	public Color[] getSolution() {
		return solution;
	}
}
