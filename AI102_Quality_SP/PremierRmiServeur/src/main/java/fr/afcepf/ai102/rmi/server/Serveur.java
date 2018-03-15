package fr.afcepf.ai102.rmi.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import fr.afcepf.ai102.rmi.api.ICalcul;
import fr.afcepf.ai102.rmi.api.ITestObjet;
import fr.afcepf.ai102.rmi.impl.Calcul;
import fr.afcepf.ai102.rmi.impl.TestObjet;

public class Serveur {
    public static void main(String[] args) {
        // ecoute d'un port
        try {
            LocateRegistry.createRegistry(12345);
            ICalcul objDistant = new Calcul();
            ITestObjet ibjDistant2 = new TestObjet();
            Naming.bind("rmi://192.168.102.151:12345/toto", objDistant);
            System.out.println("objet bindé sur : rmi://192.168.102.151/toto");
            Naming.bind("rmi://192.168.102.151:12345/titi", ibjDistant2);
            System.out.println("objet bindé sur : rmi://192.168.102.151/titi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
