package fr.afcepf.al31.mastermind;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class PanelVerification extends HBox {
	private Label lblChoix1 = new Label();
	private Label lblChoix2 = new Label();
	private Label lblChoix3 = new Label();
	private Label lblChoix4 = new Label();
	public PanelVerification(Color[] colors, PanelJeu panel) {
		// Verification :
		int place = 0;
		int nonplace = 0;
		for (int i = 0; i < colors.length; i++) {
			Color color = colors[i];
			if(color == panel.getSolution()[i]) {
				place++;
			} else {
				for (Color color2 : panel.getSolution()) {
					if(color2 == color) {
						nonplace++;
					}
				}
			}
		}
		setAlignment(Pos.CENTER_LEFT);
		setSpacing(20);
		setBackground(new Background(new BackgroundFill(
				Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
		setBorder(
				new Border(new BorderStroke(
						Color.GRAY, BorderStrokeStyle.SOLID,
						CornerRadii.EMPTY, 
						new BorderWidths(1))));
		setPrefSize(400, 50);
		lblChoix1.setPrefSize(45, 45);
		lblChoix1.setBackground(new Background(
				new BackgroundFill(
				colors[0], new CornerRadii(100), Insets.EMPTY)));
		getChildren().add(lblChoix1);
		
		lblChoix2.setPrefSize(45, 45);
		lblChoix2.setBackground(new Background(
				new BackgroundFill(
						colors[1], new CornerRadii(100), Insets.EMPTY)));
		getChildren().add(lblChoix2);
		
		lblChoix3.setPrefSize(45, 45);
		lblChoix3.setBackground(new Background(
				new BackgroundFill(
						colors[2], new CornerRadii(100), Insets.EMPTY)));
		getChildren().add(lblChoix3);
		
		lblChoix4.setPrefSize(45, 45);
		lblChoix4.setBackground(new Background(
				new BackgroundFill(
						colors[3], new CornerRadii(100), Insets.EMPTY)));
		getChildren().add(lblChoix4);
		getChildren().add(new PanelResultat(place, nonplace));
		if(place == 4) {
			Label lbl = new Label("TROUVÉ");
			lbl.setStyle(
			"-fx-text-fill:red;-fx-font-weight:bold;"
			+ "-fx-font-size:30px");
			lbl.setPrefSize(400, 50);
			getChildren().add(lbl);
		}
		
	}
}
