package fr.afcepf.ai102.jee.data.api;

import java.util.List;

import fr.afcepf.ai102.jpa.entity.Compte;
import fr.afcepf.ai102.jpa.entity.Personne;

public interface IDaoCompte {
    List<Compte> rechercherCompte(Personne personne);
}
