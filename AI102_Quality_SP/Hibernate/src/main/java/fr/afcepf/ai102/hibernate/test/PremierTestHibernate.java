package fr.afcepf.ai102.hibernate.test;

import java.util.Date;

import javax.swing.text.Utilities;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afcepf.ai102.hibernate.entity.Personne;
import fr.afcepf.ai102.hibernate.util.HibernateUtil;

public class PremierTestHibernate {
    private static Logger log = Logger.getLogger(PremierTestHibernate.class);
    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSession();
            log.info("Session hibernate ok");
            tx = session.beginTransaction();
            //Insert d'une personne:
            Personne pers = new Personne(null, "hib", "ernate", "hib@rnate.fr", "hibernate", null, new Date());
            session.save(pers);
            pers.setNom("TATA");
            log.info("Tentative de Select en Hibernate");
            //Recherche d'une personne:
            Personne pers2 = (Personne) session.get(Personne.class, 1);
            if(pers2 != null){
                log.info("Personne récupérer: " + pers2.getNom() + " " 
            + pers2.getPrenom());
                pers2.setNom("TOTO");
                session.delete(pers2);
            }
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
        }
        System.exit(0);
    }

}
