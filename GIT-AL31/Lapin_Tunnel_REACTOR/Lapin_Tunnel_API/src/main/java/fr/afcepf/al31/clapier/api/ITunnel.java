package fr.afcepf.al31.clapier.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.afcepf.al31.clapier.entity.Lapin;

public interface ITunnel extends Remote {
	void envoyerDansLeTunnel(Lapin lapin) throws RemoteException;
	void seConnecterAuTunnel() throws RemoteException;
	void seDeconnecterDuTunnel() throws RemoteException;
}
