package fr.afcepf.al31.presentation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class PremiereFenetre extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Creation de la scene principale
		Scene principale = new Scene(new BorderPane(), 800, 600);
		
		BorderPane panelPrincipal = (BorderPane) principale.getRoot();
		Label labelTop = new Label("premier label");
		labelTop.setStyle(
			"-fx-background-color:blue;-fx-text-fill:red;-fx-font-weight:bold;"
			+ "-fx-font-size:50px");
		labelTop.setPrefHeight(50);
		labelTop.setPrefWidth(800);
		labelTop.setAlignment(Pos.CENTER);
		
		Label labelCentre = new Label("label de centre");
		labelCentre.setTextFill(Color.YELLOWGREEN);
		labelCentre.setPrefHeight(250);
		labelCentre.setPrefWidth(450);
		labelCentre.setAlignment(Pos.CENTER);
		labelCentre.setBackground(new Background(
				new BackgroundFill(
						Color.OLIVE, new CornerRadii(15), Insets.EMPTY)));
		labelCentre.setBorder(
				new Border(new BorderStroke(
						Color.FUCHSIA, BorderStrokeStyle.DOTTED,
						CornerRadii.EMPTY, 
						new BorderWidths(20))));
		labelCentre.setFont(new Font("Comic sans ms", 55));
		panelPrincipal.setTop(labelTop);
		panelPrincipal.setCenter(labelCentre);
		// Affectation de la scene au Stage
		primaryStage.setScene(principale);
		// définition du titre de la fenetre
		primaryStage.setTitle("Premiere Fenetre");
		// affichage de la fenetre
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
