package fr.afcepf.ai102.service.test;

import fr.afcepf.ai102.monservice.ICalcul;
import fr.afcepf.ai102.monservice.MonPremierService;
import fr.afcepf.ai102.service.dotnet.PremierServiceDotNet;
import fr.afcepf.ai102.service.dotnet.PremierServiceDotNetSoap;
import fr.afcepf.ai102.service.dotnet.Toto;

public class CallSW {
    public static void main(String[] args) {
//        CalculSW proxy = new CalculSWService().getCalculSW();
//        System.out.println(proxy.add(20, 22));
//        System.out.println(proxy.pow(2, 11));
        
        ICalcul proxy2 = new MonPremierService()
        					.getIMonInterfaceDeService();
        System.out.println(proxy2.ajouter(12, 32));
        System.out.println(proxy2.puissance(2, 10));
        
        PremierServiceDotNetSoap proxyDotNet =
        		new PremierServiceDotNet().getPremierServiceDotNetSoap();
        System.out.println(proxyDotNet.ajouter(12, 30));
        Toto toto = proxyDotNet.getToto();
        System.out.println(toto.getNom());
    }
}
