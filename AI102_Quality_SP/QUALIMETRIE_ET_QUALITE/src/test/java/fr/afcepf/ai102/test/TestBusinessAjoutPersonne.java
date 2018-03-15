package fr.afcepf.ai102.test;

import java.lang.reflect.Field;
import java.util.Date;

import org.junit.Test;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.data.DaoAdresse;
import fr.afcepf.ai102.qualimetrie.data.DaoPersonne;
import fr.afcepf.ai102.qualimetrie.data.IDaoAdresse;
import fr.afcepf.ai102.qualimetrie.data.IDaoPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Adresse;
import fr.afcepf.ai102.qualimetrie.entity.CP;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.entity.Ville;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;
import org.junit.Assert;

/**
 * Test de la methode ajouter de la couche metier.
 * @author Formation
 *
 */
public class TestBusinessAjoutPersonne {
    /**
     * classe contenant la methode a tester.
     */
    private IGestionPersonne bu = new GestionPersonne();
    /**
     * naissance pour l'ajout.
     */
    private Date naissanceNominale = new Date();
    /**
     * adresse de la personne ajoutée.
     */
    private Adresse adresseNominale =
            new Adresse(null, "num nominal", "rue nominale",
                    new Ville(1, "PARIS"), new CP(1, "75005"));
    /**
     * dernier id de l'adresse ajoutée.
     */
    private static final int LAST_ID_ADR = 3;
    /**
     * personne pour l'ajout nominal.
     */
    private Personne persNominale = new Personne(
            null, "business nominal", "business nominal", "business nominal",
            "business nominal", adresseNominale, naissanceNominale);
    /**
     * identifiant de la personne ajoutée.
     */
    private static final int LAST_ID = 4;
    /**
     * what did you expect?
     */
    private Personne persNominaleExpected =
            new Personne(LAST_ID, persNominale.getNom(),
                    persNominale.getPrenom(), persNominale.getMail(),
                    persNominale.getMdp(), persNominale.getAdresse(),
                    persNominale.getDob());
    /**
     * personne avec un mail qui existe.
     */
    private Personne persEchecMail = new Personne(
            null, "business echec mail", "business echec mail",
                "pers1@app.fr", "business echec mdp", adresseNominale,
                naissanceNominale);
    /**
     * Default Constructor.
     */
    public TestBusinessAjoutPersonne() {
        // on ne se Mock pas!
        IDaoAdresse daoAdresse = new DaoAdresse() {
            @Override
            public Adresse ajouter(Adresse paramAdresse) throws QualitException {
                System.out.println("dans le mock daoAdresse");
                adresseNominale.setId(LAST_ID_ADR);
                return adresseNominale;
            }
        };
        IDaoPersonne daoPersonne = new DaoPersonne() {
            @Override
            public Personne ajouter(Personne paramPersonne) throws QualitException {
                paramPersonne.setId(LAST_ID);
                return paramPersonne;
            }
            @Override
            public Boolean verifMail(String paramMail) throws QualitException {
                return paramMail == persEchecMail.getMail();
            }
        };
        // TODO Mock Injection ... indice : use 'Reflection' for IOC.
                            //  ()()
                            //  (^^) Love java.lang.reflect
                            // °(_()()
        try {
            Class<?> clazz = bu.getClass();
            Field fieldDaoAdresse = clazz.getDeclaredField("daoAdresse");
            fieldDaoAdresse.setAccessible(true);
            fieldDaoAdresse.set(bu, daoAdresse);
            fieldDaoAdresse.setAccessible(false);

            Field fieldDaoPersonne = clazz.getDeclaredField("daoPersonne");
            fieldDaoPersonne.setAccessible(true);
            fieldDaoPersonne.set(bu, daoPersonne);
            fieldDaoPersonne.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * test nominal.
     */
    @Test
    public void testNominal() {
        try {
            Personne retour = bu.ajouter(persNominale);
            Assert.assertNotNull(retour);
            VerificationObjetsPourTests.testPersonne(
                    persNominaleExpected, retour);
            VerificationObjetsPourTests.testAdresse(
                    persNominaleExpected.getAdresse(),
                    retour.getAdresse());
           } catch (QualitException e) {
            e.printStackTrace();
        }
    }
    /**
     * test echec.
     * @throws QualitException .
     */
    @Test(expected = QualitException.class)
    public void testEchecMail() throws QualitException {
        bu.ajouter(persEchecMail);
    }
}
