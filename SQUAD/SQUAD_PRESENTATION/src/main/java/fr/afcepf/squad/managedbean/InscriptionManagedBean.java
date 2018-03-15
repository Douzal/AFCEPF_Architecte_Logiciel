package fr.afcepf.squad.managedbean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.brickred.socialauth.provider.FacebookImpl;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.enumeration.Sexe;
import fr.afcepf.squad.gestion.api.IGestionMembre;

@ManagedBean(name="mbInscription")
@RequestScoped
public class InscriptionManagedBean {
	
	private Membre nouveauMembre = new Membre();
	
	@EJB
    private IGestionMembre proxyGestionMembre;
	
	public void test() throws Exception {
		System.out.println("h" + Sexe.HOMME + ", f:" + Sexe.FEMME + "***********************");
		FacesContext.getCurrentInstance().getExternalContext().redirect("/mescouilles.html");
	}
	
	public void validerInscription() {
		System.out.println("plop ********");
		proxyGestionMembre.inscription(nouveauMembre);
	}
	
	public InscriptionManagedBean() {
		super();
	}

	public InscriptionManagedBean(Membre nouveauMembre, IGestionMembre proxyGestionMembre) {
		super();
		this.nouveauMembre = nouveauMembre;
		this.proxyGestionMembre = proxyGestionMembre;
	}

	public Membre getNouveauMembre() {
		return nouveauMembre;
	}

	public void setNouveauMembre(Membre nouveauMembre) {
		this.nouveauMembre = nouveauMembre;
	}

	public IGestionMembre getProxyGestionMembre() {
		return proxyGestionMembre;
	}

	public void setProxyGestionMembre(IGestionMembre proxyGestionMembre) {
		this.proxyGestionMembre = proxyGestionMembre;
	}
	
}
