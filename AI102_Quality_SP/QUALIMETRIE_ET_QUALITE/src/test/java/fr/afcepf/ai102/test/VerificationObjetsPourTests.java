package fr.afcepf.ai102.test;

import org.junit.Assert;

import fr.afcepf.ai102.qualimetrie.entity.Adresse;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.entity.Ville;

/**
 * factorisation des comparaisons des objets pour les tests.
 * @author Formation
 *
 */
public final class VerificationObjetsPourTests {
    /**
     * Default private constructor for utility classes.
     */
    private VerificationObjetsPourTests() {
    }
    /**
     * validation de la personne.
     * @param expected what did you expect?
     * @param toTest pers to test.
     */
    public static void testPersonne(Personne expected, Personne toTest) {
        Assert.assertNotNull(toTest.getMail());
        Assert.assertNotNull(toTest.getMdp());
        Assert.assertNotNull(toTest.getNom());
        Assert.assertNotNull(toTest.getPrenom());
        Assert.assertNotNull(toTest.getDob());
        Assert.assertNotNull(toTest.getId());
        Assert.assertNotNull(toTest.getAdresse());
        Assert.assertEquals(expected.getId(), toTest.getId());
        Assert.assertEquals(expected.getNom(), toTest.getNom());
        Assert.assertEquals(expected.getPrenom(), toTest.getPrenom());
        Assert.assertEquals(expected.getMail(), toTest.getMail());
        Assert.assertEquals(expected.getMdp(), toTest.getMdp());
        Assert.assertEquals(expected.getDob(), toTest.getDob());
        Assert.assertEquals(expected.getAdresse().getId(),
                            toTest.getAdresse().getId());
    }
    /**
     * verif adresse.
     * @param expected .
     * @param toTest .
     */
    public static void testAdresse(Adresse expected, Adresse toTest) {
        Assert.assertEquals(expected.getId(), toTest.getId());
        Assert.assertEquals(expected.getNum(), toTest.getNum());
        Assert.assertEquals(expected.getRue(), toTest.getRue());
        Assert.assertEquals(expected.getVille().getId(),
                            toTest.getVille().getId());
        Assert.assertEquals(expected.getCp().getId(),
                            toTest.getCp().getId());
    }
    /**
     * verif adresse.
     * @param expected .
     * @param toTest .
     */
    public static void testVille(Ville expected, Ville toTest) {
        Assert.assertEquals(expected.getId(), toTest.getId());
        Assert.assertEquals(expected.getLibelle(), toTest.getLibelle());
    }
}
