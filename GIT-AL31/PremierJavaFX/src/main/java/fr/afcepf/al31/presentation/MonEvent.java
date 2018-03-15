package fr.afcepf.al31.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MonEvent implements EventHandler<ActionEvent> {
	private Scene qui;
	public MonEvent(Scene qui) {
		super();
		this.qui = qui;
	}
	@Override
	public void handle(ActionEvent event) {
		Button btn = (Button) event.getSource();
		BorderPane panel = (BorderPane) qui.getRoot();
		Label leLabel = (Label)panel.getTop();
		leLabel.setText("click du : " + btn.getText());
	}

}
