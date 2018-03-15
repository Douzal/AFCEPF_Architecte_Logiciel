package fr.afcepf.ai102.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.afcepf.ai102.rmi.api.ITestObjet;
import fr.afcepf.ai102.rmi.entity.Toto;

public class TestObjet extends UnicastRemoteObject 
                       implements ITestObjet {
    public TestObjet() throws RemoteException {
    }
    @Override
    public Toto getToto() throws RemoteException {
        return new Toto(1, "toto", "toto");
    }
}
