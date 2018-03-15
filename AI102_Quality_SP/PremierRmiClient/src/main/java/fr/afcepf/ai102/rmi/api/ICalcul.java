package fr.afcepf.ai102.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalcul extends Remote {
    int add(int i, int j) throws RemoteException;
    double pow(double a, double b) throws RemoteException;
}
