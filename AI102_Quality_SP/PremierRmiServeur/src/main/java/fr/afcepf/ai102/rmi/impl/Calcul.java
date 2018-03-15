package fr.afcepf.ai102.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import fr.afcepf.ai102.rmi.api.ICalcul;

public class Calcul extends UnicastRemoteObject implements ICalcul {
    /**
     * pour la serialisation.
     */
    private static final long serialVersionUID = 1L;
    public Calcul() throws RemoteException {
    }
    @Override
    public int add(int paramI, int paramJ) throws RemoteException {
        try {
            System.out.println(getClientHost());
        } catch (ServerNotActiveException e) {
            e.printStackTrace();
        }
        return paramI + paramJ;
    }
    @Override
    public double pow(double paramA, double paramB) throws RemoteException {
        return Math.pow(paramA, paramB);
    }

}
