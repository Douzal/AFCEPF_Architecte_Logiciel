package fr.afcepf.ai102.jpa.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import fr.afcepf.ai102.jpa.entity.Personne;

public class PremierTestJPA {
    private static Logger log = Logger.getLogger(PremierTestJPA.class);
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(
                "PremierJPA_JSE");
        EntityManager em = emf.createEntityManager();
        log.info(" -- Test JPA --");
        em.getTransaction().begin();
        Personne pers = new Personne(
                null, "pers3", "pers3@mail.fr", "pers3", new Date());
//        em.persist(pers);
        log.info(pers.getId());
        Personne pers1 = em.find(Personne.class, 1);
        log.info(pers1.getMail());
        pers1.setNom("NOUVEAU NOM");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
