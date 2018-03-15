package fr.afcepf.al31.presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GestionEvenements extends Application implements EventHandler<ActionEvent> {
	Label label = new Label("log des clicks des boutons ci dessous");
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane panelPrincipal = new BorderPane();
		Scene scene = new Scene(panelPrincipal, 500, 160);
		label.setPrefHeight(10);
		Button btn1 = new Button("Bouton 1");
		btn1.setPrefHeight(150);
		btn1.setPrefWidth(150);
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Button btn = (Button) event.getSource();
				label.setText("click du : " + btn.getText());
			}
		});
		Button btn2 = new Button("Bouton 2");
		btn2.setPrefHeight(150);
		btn2.setPrefWidth(150);
		btn2.setOnAction(this);
		Button btn3 = new Button("Bouton 3");
		btn3.setPrefHeight(150);
		btn3.setPrefWidth(150);
		btn3.setOnAction(new MonEvent(scene));
		panelPrincipal.setTop(label);
		panelPrincipal.setLeft(btn1);
		panelPrincipal.setCenter(btn2);
		panelPrincipal.setRight(btn3);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tests des evenements");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void handle(ActionEvent event) {
		Button btn = (Button) event.getSource();
		label.setText("click du : " + btn.getText());
	}
}
