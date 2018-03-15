package fr.afcepf.ai102.rmi.api;
import java.rmi.Remote;
import java.rmi.RemoteException;
import fr.afcepf.ai102.rmi.entity.Toto;
public interface ITestObjet extends Remote {
    Toto getToto() throws RemoteException;
}
