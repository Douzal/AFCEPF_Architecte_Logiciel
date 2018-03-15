package fr.afcepf.al31.clapier.exchange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.api.IClapier;
import fr.afcepf.al31.clapier.business.impl.GestionClapier;
import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;

public class EchangeService extends UnicastRemoteObject implements IClapier {
	private static Logger log = Logger.getLogger(EchangeService.class);
	
	public EchangeService() throws RemoteException {
		super();
	}

	public void envoyerDansClapier(Lapin lapin, int numeroClapier) throws RemoteException {
		log.debug("reception de lapin");
		log.debug(lapin.getNom());
		// TODO creation de lapin dans BDD : use Business
		Clapier clapier = new Clapier();
		clapier.setId(numeroClapier == 0 ? 1 : numeroClapier);
		new GestionClapier().ajouter(lapin, clapier);
	}

}
