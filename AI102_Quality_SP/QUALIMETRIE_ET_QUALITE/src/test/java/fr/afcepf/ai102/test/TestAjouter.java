package fr.afcepf.ai102.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.ai102.qualimetrie.data.DaoPersonne;
import fr.afcepf.ai102.qualimetrie.data.IDaoPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Adresse;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitEnum;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

/**
 * test de la méthode ajouter du DaoPersonne.
 * @author Formation
 *
 */
public class TestAjouter {
    /**
     * classe contenant la methode a tester.
     */
    private IDaoPersonne dao = new DaoPersonne();
    /**
     * Adresse pour l'ajout nominal de la personne.
     */
    private Adresse adrNominal = new Adresse();
    /**
     * Personne nominale.
     */
    private Personne persNominal = new Personne();
    /**
     * what did you expect?
     */
    private Personne persNominalExpected = new Personne();
    /**
     * Personne cas echec champ 'null'.
     */
    private Personne persEchecNull = new Personne();
    /**
     * Personne cas echec 'data too long'.
     */
    private Personne persEchecTooLong = new Personne();
    /**
     * Adresse qui existe pas!
     */
    private Adresse adrEchec = new Adresse();
    /**
     * Personne echec avec adresse qui existe pas.
     */
    private Personne persEchecConstraint = new Personne();
    /**
     * Identifiant d'une adresse qui existe dans la BDD.
     */
    private static final Integer ID_ADR_EXISTE = 1;
    /**
     * Identifiant d'une adresse qui existe pas dans la BDD.
     */
    private static final Integer ID_ADR_EXISTE_PAS = 1001;
    /**
     * Dernier identifiant attendu.
     */
    private static final Integer LAST_ID_PERS = 4;
    /**
     * Default constructor.
     * Initialisation des variables de test.
     */
    public TestAjouter() {
        String nom = "personne test";
        String prenom = "personne test";
        String mail = "personne@test.fr";
        String password = "@FCEQL1";
        Date naissance = new Date();
        // init personne nominale
        persNominal.setNom(nom);
        persNominal.setMail(mail);
        persNominal.setMdp(password);
        persNominal.setPrenom(prenom);
        persNominal.setDob(naissance);
        persNominal.setAdresse(adrNominal);
        persNominal.getAdresse().setId(ID_ADR_EXISTE);
        // init personne expected
        persNominalExpected.setId(LAST_ID_PERS);
        persNominalExpected.setNom(nom);
        persNominalExpected.setMail(mail);
        persNominalExpected.setMdp(password);
        persNominalExpected.setPrenom(prenom);
        persNominalExpected.setDob(naissance);
        persNominalExpected.setAdresse(adrNominal);
        persNominalExpected.getAdresse().setId(ID_ADR_EXISTE);
        // init personne nom null
        persEchecNull.setNom(null);
        persEchecNull.setMail(mail);
        persEchecNull.setMdp(password);
        persEchecNull.setPrenom(prenom);
        persEchecNull.setDob(naissance);
        persEchecNull.setAdresse(adrNominal);
        persEchecNull.getAdresse().setId(ID_ADR_EXISTE);
        // init personne echec adresse
        persEchecConstraint.setNom(nom);
        persEchecConstraint.setMail(mail);
        persEchecConstraint.setMdp(password);
        persEchecConstraint.setPrenom(prenom);
        persEchecConstraint.setDob(naissance);
        persEchecConstraint.setAdresse(adrEchec);
        persEchecConstraint.getAdresse().setId(ID_ADR_EXISTE_PAS);
        // init personne nom trop long
        for (int i = 0; i < LAST_ID_PERS; i++) {
            nom += nom;
        }
        persEchecTooLong.setNom(nom);
        persEchecTooLong.setMail(mail);
        persEchecTooLong.setMdp(password);
        persEchecTooLong.setPrenom(prenom);
        persEchecTooLong.setDob(naissance);
        persEchecTooLong.setAdresse(adrNominal);
        persEchecTooLong.getAdresse().setId(ID_ADR_EXISTE);
    }
    /**
     * Avant chaque test.
     * generation de la BDD.
     */
    @Before
    public void setUp() {
        String path = Thread.currentThread()
                .getContextClassLoader()
                .getResource("crebase.bat")
                .getPath();
        try {
            Process proc = Runtime.getRuntime().exec(path);
            proc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Test qui doit pas ajouter.
     * @throws QualitException l'exception attendue.
     */
    @Test(expected = QualitException.class)
    public void testEchecNomTropLong() throws QualitException {
        dao.ajouter(persEchecTooLong);
    }
    /**
     * Test qui doit pas ajouter.
     */
    @Test
    public void testEchecNomNull() {
        try {
            dao.ajouter(persEchecNull);
            Assert.fail("ca ne doit pas marcher");
        } catch (QualitException e) {
            e.printStackTrace();
            Assert.assertEquals(
                    QualitEnum.DATA_VIOLATION_CONTRAINTE_DONNEES_NULL,
                    e.getCodeErreur());
        }
    }
    /**
     * Test qui doit pas ajouter.
     */
    @Test
    public void testEchecAdresseExistePas() {
        try {
            dao.ajouter(persEchecConstraint);
            Assert.fail("ca ne doit pas marcher");
        } catch (QualitException e) {
            e.printStackTrace();
            Assert.assertEquals(
                    QualitEnum.DATA_VIOLATION_CONTRAINTE_INTEGRITE,
                    e.getCodeErreur());
        }
    }
    /**
     * Test d'ajout nominal.
     * @throws QualitException bla bla bla.
     */
    @Test
    public void testAjoutNominal() throws QualitException {
        Personne retour = dao.ajouter(persNominal);
        VerificationObjetsPourTests.testPersonne(persNominalExpected, retour);
    }
}
