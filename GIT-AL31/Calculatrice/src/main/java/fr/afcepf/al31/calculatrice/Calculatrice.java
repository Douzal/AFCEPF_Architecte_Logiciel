package fr.afcepf.al31.calculatrice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculatrice extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(
				new Scene(new PanelCalculatrice(), 300, 440));
		stage.setResizable(false);
		stage.setTitle("Calculatrice Basique");
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
