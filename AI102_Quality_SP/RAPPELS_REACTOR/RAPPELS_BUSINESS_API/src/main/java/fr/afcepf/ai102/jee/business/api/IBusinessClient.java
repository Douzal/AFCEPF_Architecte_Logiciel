package fr.afcepf.ai102.jee.business.api;

import fr.afcepf.ai102.jpa.entity.Compte;
import fr.afcepf.ai102.jpa.entity.Personne;

public interface IBusinessClient {
    Personne rechercherCompte(Personne personne);
    Compte rechercherOperation(Compte compte);
}
