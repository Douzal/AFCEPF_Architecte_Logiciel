package fr.afcepf.ai102.jpa.test;

import java.util.Date;

import fr.afcepf.ai102.jpa.dao.DaoPersonne;
import fr.afcepf.ai102.jpa.dao.IDao;
import fr.afcepf.ai102.jpa.entity.Conseiller;
import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;

public class TestGeneric {
    public static void main(String[] args) {
        IDao<Personne> daoPersonne = new DaoPersonne();
        Conseiller conseil = new Conseiller();
        conseil = (Conseiller) daoPersonne.rechercherParId(1);
        Particulier pers = new Particulier(
                null, "dao", "dao", "dao", new Date(), false, conseil);
        daoPersonne.ajouter(pers);
    }
}
