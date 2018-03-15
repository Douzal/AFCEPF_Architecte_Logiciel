package fr.afcepf.ai102.jpa.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import fr.afcepf.ai102.jpa.entity.Compte;
import fr.afcepf.ai102.jpa.entity.CompteParticulier;
import fr.afcepf.ai102.jpa.entity.CompteSociete;
import fr.afcepf.ai102.jpa.entity.Conseiller;
import fr.afcepf.ai102.jpa.entity.Credit;
import fr.afcepf.ai102.jpa.entity.Debit;
import fr.afcepf.ai102.jpa.entity.Operation;
import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;
import fr.afcepf.ai102.jpa.entity.Societe;

public class TestHeritage {
    private static Logger log = Logger.getLogger(TestHeritage.class);
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "PremierJPA_JSE");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Conseiller conseil =
            new Conseiller(null, "conseil", "conseil@banque.fr", "conseil", new Date());
        Personne[] personnes = {
            conseil,
            new Societe(null, "afcepf", "afcepf@banque.fr", "afcepf", new Date(),
                    "000021511666", conseil),
            new Particulier(null, "particulier", "particulier@banque.fr", "particulier",
                    new Date(), false, conseil)
        };
        Compte[] comptes = {
                new CompteSociete(null, new Date(), (Societe) personnes[1]),
                new CompteSociete(null, new Date(), (Societe) personnes[1]),
                new CompteParticulier(null, new Date(), (Particulier) personnes[2])
        };
        List<Operation> ops = new ArrayList<>();
        for(int i = 0; i < 3 ; i++) {
            for(int j = 0 ; j < (int)(Math.random() * 10.0) ; j++) {
                ops.add(new Debit(null, new Date(),
                        ((Math.random() * 15000.0) / 100.0d), comptes[i]));
                ops.add(new Credit(null, new Date(),
                        ((Math.random() * 15000.0) / 100.0d), comptes[i]));
            }
        }
        for (Personne p : personnes) { em.persist(p);}
        for (Compte c : comptes) { em.persist(c);}
        for (Operation o : ops) { em.persist(o);}
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
