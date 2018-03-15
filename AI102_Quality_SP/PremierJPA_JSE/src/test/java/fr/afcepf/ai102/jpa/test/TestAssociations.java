package fr.afcepf.ai102.jpa.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.ai102.jpa.entity.CompteSociete;

public class TestAssociations {
    private static Logger log = Logger.getLogger(TestAssociations.class);
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "PremierJPA_JSE");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // Je veux la somme de tous les crédit des societés du conseiller#1
        String SQL = "SELECT SUM(credit.operation_montant) FROM banque_credit credit "
                + "inner join banque_compte compte on "
                + "compte.compte_numero = credit.id_compte "
                + "inner join banque_societe societe on "
                + "societe.personne_id = compte.id_societe "
                + "WHERE societe.id_conseiller = 1 ";
        Query querySql = em.createNativeQuery(SQL);
        BigDecimal big = (BigDecimal) querySql.getSingleResult();
        log.info(big.doubleValue());
        String HQL = "SELECT SUM(c.montant) From Credit c "
                + "WHERE c.compte.societe.conseil.id = 1";
        Query query = em.createQuery(HQL);
        Double resultat = (Double) query.getSingleResult();
        String HQL2 = "SELECT compte FROM CompteSociete compte "
                + "WHERE compte.societe.id = 2";
        String HQL3 = "SELECT societe.comptes FROM Societe societe "
                + "WHERE societe.id = 2";
        query = em.createQuery(HQL2);
        List<CompteSociete> comptes = query.getResultList();
        for (CompteSociete compteSociete : comptes) {
            log.info(compteSociete.getNumero());
        }
        query = em.createQuery(HQL3);
        comptes = query.getResultList();
        for (CompteSociete compteSociete : comptes) {
            log.info(compteSociete.getNumero());
        }
        log.info(resultat);
        em.close();
        emf.close();
    }
}
