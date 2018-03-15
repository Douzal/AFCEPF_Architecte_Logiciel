package fr.afcepf.ai102.ejb.impl;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.ai102.ejb.api.ITestObjet;
import fr.afcepf.ai102.ejb.entity.Toto;
@Remote(ITestObjet.class)
@Singleton
public class TestObjet implements ITestObjet {
    @Override
    public Toto Toto(Toto toto) {
        toto.setNom(toto.getNom().toUpperCase());
        return toto;
    }

}
