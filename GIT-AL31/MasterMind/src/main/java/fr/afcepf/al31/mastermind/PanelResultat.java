package fr.afcepf.al31.mastermind;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class PanelResultat extends HBox {
	public PanelResultat(int place, int nonplace) {
		setSpacing(3);
		for (int i = 0; i < place; i++) {
			getChildren().add(dessine(Color.BLACK));
		}
		for (int i = 0; i < nonplace; i++) {
			getChildren().add(dessine(Color.WHITE));
			
		}
		for (int i = 0; i < 4 - (place + nonplace); i++) {
			
		}
	}
	private Label dessine(Color color) {
		Label lbl = new Label();
		lbl.setPrefSize(15, 15);
		lbl.setBackground(new Background(
				new BackgroundFill(
				color, new CornerRadii(100), Insets.EMPTY)));
		return lbl;
	}
}
