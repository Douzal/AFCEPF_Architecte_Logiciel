package fr.afcepf.ai102.test;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.ai102.qualimetrie.data.DaoPersonne;
import fr.afcepf.ai102.qualimetrie.data.IDaoPersonne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

/**
 * Classe pour tester la methode verifMail.
 * @author Formation
 *
 */
public class TestVerifMail {
    /**
     * Mail qui existe dans la BDD (de test).
     */
    private String mailExiste = "pers1@app.fr";
    /**
     * Mail qui existe pas dans la BDD (de test).
     */
    private String mailExistePas = "toto@afcepf.fr";
    /**
     * service contenant la methode a tester.
     */
    private IDaoPersonne dao = new DaoPersonne();
    /**
     * Test avec un mail qui existe.
     */
    @Test
    public void testVerifMailExiste() {
        try {
            Boolean retour = dao.verifMail(mailExiste);
            Assert.assertNotNull(retour);
            Assert.assertTrue(retour);
        } catch (QualitException e) {
            e.printStackTrace();
            Assert.fail("ca aurait du marcher");
        }
    }
    /**
     * Test avec un mail qui existe pas.
     */
    @Test
    public void testVerifMailExistePas() {
        try {
            Boolean retour = dao.verifMail(mailExistePas);
            Assert.assertNotNull(retour);
            Assert.assertFalse(retour);
        } catch (QualitException e) {
            e.printStackTrace();
            Assert.fail("ca aurait du marcher");
        }
    }
}
