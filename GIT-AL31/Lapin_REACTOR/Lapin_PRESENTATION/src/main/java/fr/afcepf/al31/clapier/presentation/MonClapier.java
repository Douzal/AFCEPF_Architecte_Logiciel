package fr.afcepf.al31.clapier.presentation;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;

import fr.afcepf.al31.clapier.api.ITunnel;
import fr.afcepf.al31.clapier.business.api.IGestionClapier;
import fr.afcepf.al31.clapier.business.impl.GestionClapier;
import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;
import fr.afcepf.al31.clapier.exchange.ExchangeServer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MonClapier extends Application {
	private ITunnel tunnel;
	ClapierPane cp = new ClapierPane();
	Scene scene = new Scene(cp, 800, 600);
	@Override
	public void start(Stage primaryStage) throws Exception {
		// creation du serveur RMI pour se voir attribuer des Lapins
		new ExchangeServer();
		envoiDeLapin();
		
		Button btn = new Button("ENVOYER");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					envoiDeLapin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		cp.setTop(btn);
		cp.init();
		primaryStage.setTitle("Clapier autonome");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			try {
				tunnel.seDeconnecterDuTunnel();
			} catch (RemoteException e) {e.printStackTrace();}
			System.exit(0);
		});
	}
	private void envoiDeLapin() throws Exception {
		// creation du proxy pour que les Lapin passent dans le Tunnel
		tunnel = (ITunnel) Naming.lookup(
				"rmi://192.168.102.185:12345/tunnel");
		// s'identifier au tunel
		tunnel.seConnecterAuTunnel();
		// prendre un lapin au hazard : plouf . plouf . ce sera toi ....
		IGestionClapier gestionClapier = new GestionClapier();
		Clapier clapier = new Clapier();
		int rand = new Random().nextInt(6);
		clapier.setId(rand == 0 ? 1 : rand );
		List<Lapin> lapins = gestionClapier.rechercher(clapier);
		Lapin leLapin = lapins.get(new Random().nextInt(lapins.size()));
		// le supprimer de notre BDD
		gestionClapier.retirer(leLapin);
		// l'envoyer dans le tunnel
		tunnel.envoyerDansLeTunnel(leLapin);
		cp.init();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
