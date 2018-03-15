package fr.afcepf.ai102.jee.business.api;

import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;

public interface IBusinessConnexion {
    Personne connexion(String mail, String mdp);
    Particulier inscription(Particulier particulier);
}
