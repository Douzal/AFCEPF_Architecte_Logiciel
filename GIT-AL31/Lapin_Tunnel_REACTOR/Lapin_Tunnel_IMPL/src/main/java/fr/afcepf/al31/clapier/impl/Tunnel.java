package fr.afcepf.al31.clapier.impl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.api.IClapier;
import fr.afcepf.al31.clapier.api.ITunnel;
import fr.afcepf.al31.clapier.entity.Lapin;

public class Tunnel extends UnicastRemoteObject implements ITunnel {
	private List<String> clapiers = new ArrayList<>();
	private static Logger log = Logger.getLogger(Tunnel.class);
	
	public Tunnel() throws RemoteException {
		super();
	}

	@Override
	public void envoyerDansLeTunnel(Lapin lapin) throws RemoteException {
		log.debug("dans l'envoi de lapin");
		log.debug(clapiers);
		int indiceClapier = new Random().nextInt(clapiers.size());
		log.debug(indiceClapier);
		try {
			IClapier clapier = (IClapier) Naming.lookup(
					"rmi://" + clapiers.get(indiceClapier) + ":12346/clapier");
			clapier.envoyerDansClapier(lapin, new Random().nextInt(6));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void seConnecterAuTunnel() throws RemoteException {
		try {
			log.debug("se connecter " + getClientHost());
			if(!clapiers.contains(getClientHost())) {
				clapiers.add(getClientHost());
			}
		} catch (ServerNotActiveException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void seDeconnecterDuTunnel() throws RemoteException {
		try {
			log.debug("se deconnecter " + getClientHost());
			clapiers.remove(getClientHost());
		} catch (ServerNotActiveException e) {
			e.printStackTrace();
		}
	}

}
