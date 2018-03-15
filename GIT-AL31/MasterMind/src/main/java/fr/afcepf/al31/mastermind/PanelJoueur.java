package fr.afcepf.al31.mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PanelJoueur extends HBox implements EventHandler<MouseEvent>{
	private int indiceChoix1 = 0;
	private int indiceChoix2 = 1;
	private int indiceChoix3 = 2;
	private int indiceChoix4 = 3;
	private Label lblChoix1 = new Label();
	private Label lblChoix2 = new Label();
	private Label lblChoix3 = new Label();
	private Label lblChoix4 = new Label();
	public PanelJoueur() {
		Button valider = new Button("Valider");
		valider.setPrefSize(120, 50);
		valider.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				BorderPane principal = (BorderPane) getScene().getRoot();
				Color[] choix = {MasterMind.COULEURS_POSSIBLES[indiceChoix1],
								MasterMind.COULEURS_POSSIBLES[indiceChoix2],
								MasterMind.COULEURS_POSSIBLES[indiceChoix3],
								MasterMind.COULEURS_POSSIBLES[indiceChoix4]};
				((VBox)principal.getCenter()).getChildren()
					.add(new PanelVerification(choix, (PanelJeu) principal));
			}
		});
		setAlignment(Pos.CENTER);
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
				MasterMind.COULEURS_POSSIBLES[indiceChoix1], new CornerRadii(100), Insets.EMPTY)));
		getChildren().add(lblChoix1);
		
		lblChoix2.setPrefSize(45, 45);
		lblChoix2.setBackground(new Background(
				new BackgroundFill(
				MasterMind.COULEURS_POSSIBLES[indiceChoix2], new CornerRadii(100), Insets.EMPTY)));
		getChildren().add(lblChoix2);
		
		lblChoix3.setPrefSize(45, 45);
		lblChoix3.setBackground(new Background(
				new BackgroundFill(
				MasterMind.COULEURS_POSSIBLES[indiceChoix3], new CornerRadii(100), Insets.EMPTY)));
		getChildren().add(lblChoix3);
		
		lblChoix4.setPrefSize(45, 45);
		lblChoix4.setBackground(new Background(
				new BackgroundFill(
				MasterMind.COULEURS_POSSIBLES[indiceChoix4], new CornerRadii(100), Insets.EMPTY)));
		getChildren().add(lblChoix4);
		
		getChildren().add(valider);
		lblChoix1.setOnMouseClicked(this);
		lblChoix2.setOnMouseClicked(this);
		lblChoix3.setOnMouseClicked(this);
		lblChoix4.setOnMouseClicked(this);
	}
	@Override
	public void handle(MouseEvent event) {
		Label lbl = (Label) event.getSource();
		Color c = (Color) lbl.getBackground().getFills().get(0).getFill();
		int indice = findIndiceSuivant(c);
		if(lbl == lblChoix1) {
			indiceChoix1 = indice;
		}
		if(lbl == lblChoix2) {
			indiceChoix2 = indice;
		}
		if(lbl == lblChoix3) {
			indiceChoix3 = indice;
		}
		if(lbl == lblChoix4) {
			indiceChoix4 = indice;
		}
		lbl.setBackground(new Background(
				new BackgroundFill(
				MasterMind.COULEURS_POSSIBLES[indice], new CornerRadii(100), Insets.EMPTY)));
	}
	private int findIndiceSuivant(Color color) {
		int indice = 0;
		for(int i = 0 ; i < MasterMind.COULEURS_POSSIBLES.length ; i++) {
			if(color == MasterMind.COULEURS_POSSIBLES[i]) {
				indice = i;
			}
		}
		return indice == MasterMind.COULEURS_POSSIBLES.length - 1 ? 0 : (indice+1);
	}
}
