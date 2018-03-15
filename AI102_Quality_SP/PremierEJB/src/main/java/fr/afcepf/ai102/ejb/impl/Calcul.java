package fr.afcepf.ai102.ejb.impl;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.ai102.ejb.api.ICalcul;
@Remote(ICalcul.class)
@Singleton
public class Calcul implements ICalcul {
    @Override
    public int add(int paramI, int paramJ) {
        return paramI + paramJ;
    }
    @Override
    public double pow(double paramA, double paramB) {
        return Math.pow(paramA, paramB);
    }

}
