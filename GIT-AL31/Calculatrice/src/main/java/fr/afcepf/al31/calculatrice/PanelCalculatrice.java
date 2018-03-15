package fr.afcepf.al31.calculatrice;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PanelCalculatrice extends BorderPane implements EventHandler<ActionEvent>{
	private String[][] btns =
		{{"1", "2", "3", "+"},	
		 {"4", "5", "6", "-"},	
		 {"7", "8", "9", "/"},	
		 {"+/-", "0", ".", "*"},	
		 {"(", ")", "="}};
	private TextField affichage = new TextField("0");
	private Button clear = new Button("C");
	public PanelCalculatrice() {
		initializeComponents();
	}
	private void initializeComponents() {
		HBox panelTop = new HBox();
		affichage.setPrefWidth(270.0);
		affichage.setPrefHeight(50);
		affichage.setFont(new Font("Tahoma",20));
		affichage.setAlignment(Pos.CENTER_RIGHT);
		clear.setPrefWidth(50.0);
		clear.setPrefHeight(50);
		clear.setFont(new Font("Tahoma",25));
		clear.setOnAction(this);
		panelTop.getChildren().addAll(affichage, clear);
		setTop(panelTop);
		VBox centre = new VBox();
		centre.setAlignment(Pos.CENTER);
		setCenter(centre);
		for (String[] ligne : btns) {
			HBox panelLigne = new HBox();
			for (String btn : ligne) {
				Button unBouton = new Button(btn);
				unBouton.setStyle("-fx-font-size:25px");
				unBouton.setPrefSize(80.0, 80.0);
				unBouton.setOnAction(this);
				panelLigne.getChildren().add(unBouton);
			}
			centre.getChildren().add(panelLigne);
		}
		HBox last = (HBox) centre.getChildren().get(centre.getChildren().size() - 1);
		Button egal = (Button) last.getChildren().get(last.getChildren().size() - 1);
		egal.setPrefWidth(160.0);
	}
	@Override
	public void handle(ActionEvent arg0) {
		Button qui = (Button) arg0.getSource();
		if (affichage.getText().equals("0")) {
			affichage.setText("");
		}
		switch (qui.getText()) {
		case "=":
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			try {
				affichage.setText(engine.eval(affichage.getText()).toString());
			} catch (ScriptException e) {
				e.printStackTrace();
			}
			break;
		case "C":
			affichage.setText("0");
			break;
		case "+/-":
			if(affichage.getText().indexOf('-') == 0) {
				affichage.setText(affichage.getText().substring(1));
			} else {
				affichage.setText("-" + affichage.getText());
			}
			break;
		default:
			affichage.setText(affichage.getText() + qui.getText());
			break;
		}
		
	}
}
