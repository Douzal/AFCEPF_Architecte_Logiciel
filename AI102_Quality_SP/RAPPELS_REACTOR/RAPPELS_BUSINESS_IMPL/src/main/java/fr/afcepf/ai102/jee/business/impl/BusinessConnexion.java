package fr.afcepf.ai102.jee.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.ai102.jee.business.api.IBusinessConnexion;
import fr.afcepf.ai102.jee.data.api.IDaoPersonne;
import fr.afcepf.ai102.jpa.entity.Conseiller;
import fr.afcepf.ai102.jpa.entity.Particulier;
import fr.afcepf.ai102.jpa.entity.Personne;
@Remote(IBusinessConnexion.class)
@Singleton
public class BusinessConnexion implements IBusinessConnexion {
    @EJB
    private IDaoPersonne proxyPersonne;
    @Override
    public Personne connexion(String paramMail, String paramMdp) {
        return proxyPersonne.connexion(paramMail, paramMdp);
    }
    @Override
    public Particulier inscription(Particulier paramParticulier) {
        Conseiller defaultConseil = new Conseiller();
        defaultConseil.setId(1);
        paramParticulier.setConseil(defaultConseil);
        return proxyPersonne.inscrire(paramParticulier);
    }
}
