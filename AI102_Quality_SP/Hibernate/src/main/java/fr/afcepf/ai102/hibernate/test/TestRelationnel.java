package fr.afcepf.ai102.hibernate.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afcepf.ai102.hibernate.entity.Adresse;
import fr.afcepf.ai102.hibernate.entity.Personne;
import fr.afcepf.ai102.hibernate.util.HibernateUtil;

public class TestRelationnel {
    private static Logger log = Logger.getLogger(TestRelationnel.class); 
    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        
        try{
           session = HibernateUtil.getSession();
           tx = session.beginTransaction();
           
           Adresse adresse= (Adresse) session.get(Adresse.class, 1);
           
           Personne pers1 = new Personne(null, "toto", "toto", 
                   "toto@toto.to", "totototo", adresse, new Date());
           Personne pers2 = new Personne(null, "tata", "tata", 
                   "tata@tata.ta", "tatatatata", adresse, new Date());
           Personne pers3 = new Personne(null, "titi", "titi", 
                   "titi@titi.ti", "tititi", adresse, new Date());
//           session.save(pers1);
//           session.save(pers2);
//           session.save(pers3);
//           ou
           adresse.getPersonnes().add(pers1);
           adresse.getPersonnes().add(pers2);
           adresse.getPersonnes().add(pers3);
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
