package fr.afcepf.al31.mastermind;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MasterMind extends Application {
	public static final Color[] COULEURS_POSSIBLES =
		{Color.RED, Color.YELLOW, Color.GREEN,
		 Color.BLUE, Color.WHITE, Color.BLACK,
		 Color.BROWN, Color.VIOLET, Color.CYAN};
	public static final int NOMBRE_TOURS = 10;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new PanelJeu(), 400, 900);
		primaryStage.setTitle("MasterMind");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
