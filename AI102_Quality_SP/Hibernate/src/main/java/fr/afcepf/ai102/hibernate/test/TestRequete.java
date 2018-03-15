package fr.afcepf.ai102.hibernate.test;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import fr.afcepf.ai102.hibernate.entity.Adresse;
import fr.afcepf.ai102.hibernate.entity.Personne;
import fr.afcepf.ai102.hibernate.util.HibernateUtil;

public class TestRequete {
    private static Logger log = Logger.getLogger(TestRelationnel.class); 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        
        try{
           session = HibernateUtil.getSession();
           tx = session.beginTransaction();
           Query sqlQuery  = session.createSQLQuery("SELECT * FROM PeRsOnNe");
           @SuppressWarnings("unchecked")
        List<Object> result = sqlQuery.list();
           for (Object object : result) {
            log.info (object.toString());
        }
           Query queryHQL = session.
                   createQuery("SELECT  p FROM Personne p WHERE p.adresse.ville.libelle  = 'Paris'");
           List<Personne> personnes = queryHQL.list();
           for (Personne personne : personnes) {
            log.info(personne.getNom() + "\t");
        }
           Query queryHQLAvecParametre = session.
                   createQuery("SELECT  p FROM Personne p WHERE "
                           + "p.adresse.ville.libelle  = :paramNom");
               queryHQLAvecParametre.setParameter("paramNom", "Paris");
           List<Personne> personnes2 = queryHQLAvecParametre.list();
           for (Personne personne : personnes2) {
            log.info(personne.getNom() + "\t");
        }
           // SELECT p FROM Personne p
            Criteria crit = session.createCriteria(Personne.class);
            crit.add(Restrictions.like("nom", "t", MatchMode.ANYWHERE));
            crit.addOrder(Order.asc("nom"));
            List<Personne> personnesSeb = crit.list();
            for (Personne personne : personnesSeb) {
                log.fatal(personne.getNom());
            }
            tx.commit();
        }catch (Exception e) {
           tx.rollback();
           log.error(e.getMessage());
        }finally {
            session.close();
        }
            System.exit(0);
    }

}
