package fr.afcepf.ai102.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.afcepf.ai102.service.api.ICalcul;
import fr.afcepf.ai102.service.entity.Foo;
@Stateless
@Local
@WebService(endpointInterface = "fr.afcepf.ai102.service.api.ICalcul",
targetNamespace = "http://monservice.ai102.afcepf.fr",
serviceName = "MonPremierService",
portName = "IMonInterfaceDeService")
public class CalculSW implements ICalcul {
    @Override
    public int add(int paramI, int paramJ) {
        return paramI + paramJ;
    }
    @Override
    public double pow(double paramA, double paramB) {
        return Math.pow(paramA, paramB);
    }
    @Override
    public Foo getFoo() {
        return 
            new Foo(1, "toto", "titi");
    }

}
