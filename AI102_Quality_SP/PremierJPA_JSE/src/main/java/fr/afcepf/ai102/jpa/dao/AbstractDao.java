package fr.afcepf.ai102.jpa.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDao<T> implements IDao<T> {
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(
                    "PremierJPA_JSE");
    @Override
    public T ajouter(T paramT) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(paramT);
        em.getTransaction().commit();
        return paramT;
    }
    @Override
    public boolean supprimer(T paramT) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(paramT);
        em.getTransaction().commit();
        return true;
    }
    @Override
    public T modifier(T paramT) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(paramT);
        em.getTransaction().commit();
        return paramT;
    }
    @Override
    public T rechercherParId(Object paramO) {
        T t = null;
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            String className = ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0].getTypeName();
            Class<?> clazz;
            clazz = Class.forName(className);
            t = (T) em.find(clazz, paramO);
            em.getTransaction().commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
}
