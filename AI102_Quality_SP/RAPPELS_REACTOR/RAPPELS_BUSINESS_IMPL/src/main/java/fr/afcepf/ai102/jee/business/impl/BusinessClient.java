package fr.afcepf.ai102.jee.business.impl;

import fr.afcepf.ai102.jee.business.api.IBusinessClient;
import fr.afcepf.ai102.jee.data.api.IDaoPersonne;
import fr.afcepf.ai102.jpa.entity.Compte;
import fr.afcepf.ai102.jpa.entity.Personne;

public class BusinessClient implements IBusinessClient {
    
    @Override
    public Personne rechercherCompte(Personne paramPersonne) {
        return null;
    }
    @Override
    public Compte rechercherOperation(Compte paramCompte) {
        return null;
    }
}
