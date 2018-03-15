package fr.afcepf.ai102.rmi.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import fr.afcepf.ai102.rmi.api.ICalcul;
import fr.afcepf.ai102.rmi.api.ITestObjet;
import fr.afcepf.ai102.rmi.entity.Toto;

public class CallRmi {
    public static void main(String[] args) {
        String JNDI = "rmi://192.168.102.151:12345/toto";
        String JNDI2 = "rmi://192.168.102.151:12345/titi";
        try {
            ICalcul proxy = (ICalcul) Naming.lookup(JNDI);
            System.out.println(proxy.add(10, 32));
            System.out.println(proxy.pow(2, 10));
            ITestObjet proxy2 = (ITestObjet) Naming.lookup(JNDI2);
            Toto toto = proxy2.getToto();
            System.out.println(toto.getId());
            System.out.println(toto.getNom());
            System.out.println(toto.getPrenom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
