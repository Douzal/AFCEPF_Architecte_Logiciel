package fr.afcepf.ai102.jpa.dao;

public interface IDao<T> {
    T ajouter(T t);
    boolean supprimer(T t);
    T modifier(T t);
    T rechercherParId(Object o);
}
