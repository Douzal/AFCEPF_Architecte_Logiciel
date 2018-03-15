package fr.afcepf.ai102.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.data.DaoVille;
import fr.afcepf.ai102.qualimetrie.entity.Ville;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

/**
 * test de la methode getAllVille.
 * @author Formation
 *
 */
public class TestBusinessGetAllVille {
    /**
     * clé des villes. (la flemme des constantes).
     */
    private int index = 1;
    /**
     * villes attendues.
     */
    private Ville[] expectedVille = {
       new Ville(index++, "PARIS"),
       new Ville(index++, "LYON"),
       new Ville(index++, "MONTROUGE")
    };
    /**
     * classe contenant le service a tester.
     */
    private IGestionPersonne bu = new GestionPersonne();
    /**
     * Default constructor.
     */
    public TestBusinessGetAllVille() {
        try {
            Class<?> clazz = bu.getClass();
            Field fieldDaoVille = clazz.getDeclaredField("daoVille");
            fieldDaoVille.setAccessible(true);
            fieldDaoVille.set(bu, new DaoVille() {
                @Override
                public List<Ville> getAll() throws QualitException {
                    index = 0;
                    List<Ville> liste = new ArrayList<>();
                    liste.add(expectedVille[index++]);
                    liste.add(expectedVille[index++]);
                    liste.add(expectedVille[index++]);
                    return liste;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * test.
     * @throws QualitException .
     */
    @Test
    public void testGetAllVille() throws QualitException {
        List<Ville> retour = bu.getAllVille();
        for (int i = 0; i < retour.size(); i++) {
            VerificationObjetsPourTests.testVille(
                    expectedVille[i], retour.get(i));
        }
    }
}
