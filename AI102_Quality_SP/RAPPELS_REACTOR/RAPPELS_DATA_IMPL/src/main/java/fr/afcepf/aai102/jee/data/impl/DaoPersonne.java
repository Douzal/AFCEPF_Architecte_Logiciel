package fr.afcepf.aai102.jee.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai102.jee.data.api.IDaoPersonne;
import fr.afcepf.ai102.jpa.entity.Conseiller;
import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;
import fr.afcepf.ai102.jpa.entity.Societe;
@Remote(IDaoPersonne.class)
@Stateless
public class DaoPersonne implements IDaoPersonne {
    @PersistenceContext(unitName = "COMME_ON_VEUT")
    private EntityManager em;
    @Override
    public Personne connexion(String paramMail, String paramMdp) {
        try {
            return em.createQuery("SELECT p FROM Personne p "
                    + "WHERE p.mail = :pmail "
                    + "AND p.password = :pmdp", Personne.class)
                    .setParameter("pmail", paramMail)
                    .setParameter("pmdp", paramMdp)
                    .getSingleResult();
        } catch (Exception e) {
            // catch misère
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Particulier> rechercherParticulier(String paramNom, Conseiller paramConseil) {
        return em.createQuery("SELECT p FROM Particulier p WHERE p.nom like :pnom "
                + "AND p.conseil.id = :pid")
                .setParameter("pnom", "%" + paramNom + "%")
                .setParameter("pid", paramConseil.getId())
                .getResultList();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Societe> rechercherSociete(String paramNom, Conseiller paramConseil) {
        return em.createQuery("SELECT s FROM Societe s WHERE s.nom like :pnom "
                + "AND s.conseil.id = :pid")
                .setParameter("pnom", "%" + paramNom + "%")
                .setParameter("pid", paramConseil.getId())
                .getResultList();
    }
    @Override
    public Particulier inscrire(Particulier paramParticulier) {
        em.persist(paramParticulier);
        return paramParticulier;
    }

}
