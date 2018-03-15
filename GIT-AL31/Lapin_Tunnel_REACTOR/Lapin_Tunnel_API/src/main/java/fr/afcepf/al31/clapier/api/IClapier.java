package fr.afcepf.al31.clapier.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.afcepf.al31.clapier.entity.Lapin;

public interface IClapier extends Remote {
	void envoyerDansClapier(Lapin lapin, int numeroClapier) throws RemoteException;
}
