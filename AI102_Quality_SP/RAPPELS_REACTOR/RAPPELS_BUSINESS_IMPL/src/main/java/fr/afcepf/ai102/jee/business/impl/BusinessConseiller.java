package fr.afcepf.ai102.jee.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai102.jee.business.api.IBusinessConseiller;
import fr.afcepf.ai102.jee.data.api.IDaoPersonne;
import fr.afcepf.ai102.jpa.entity.Compte;
import fr.afcepf.ai102.jpa.entity.Conseiller;
import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;
@Remote(IBusinessConseiller.class)
@Stateless
public class BusinessConseiller implements IBusinessConseiller {
    @EJB
    private IDaoPersonne daoPersonne;
    @Override
    public Personne rechercherCompte(Personne paramPersonne) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Compte rechercherOperation(Compte paramCompte) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Personne> rechercher(String paramNom, Class<?> paramType) {
        Conseiller conseil = new Conseiller();
        conseil.setId(1);
        List<Personne> retour;
        if (paramType == Particulier.class) {
             retour = new ArrayList<Personne>();
             retour.addAll(
                    daoPersonne.rechercherParticulier(paramNom, conseil));
        } else {
            retour = new ArrayList<Personne>();
            retour.addAll(
                   daoPersonne.rechercherSociete(paramNom, conseil));
        }
        return retour;
    }
    
}
