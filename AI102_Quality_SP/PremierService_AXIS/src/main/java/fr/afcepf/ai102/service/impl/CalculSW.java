package fr.afcepf.ai102.service.impl;

import fr.afcepf.ai102.service.api.ICalcul;

public class CalculSW implements ICalcul {
    @Override
    public int add(int paramI, int paramJ) {
        return paramI + paramJ;
    }
    @Override
    public double pow(double paramA, double paramB) {
        return Math.pow(paramA, paramB);
    }

}
