package fr.afcepf.ai102.jee.data.api;

import java.util.List;

import fr.afcepf.ai102.jpa.entity.Conseiller;
import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;
import fr.afcepf.ai102.jpa.entity.Societe;

public interface IDaoPersonne {
    Personne connexion(String mail, String mdp);
    List<Particulier> rechercherParticulier(String nom, Conseiller conseil);
    List<Societe> rechercherSociete(String nom, Conseiller conseil);
    Particulier inscrire(Particulier particulier);
}
