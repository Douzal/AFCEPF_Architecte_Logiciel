package fr.afcepf.squad.controller;

import java.io.IOException;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.squad.entity.Rencontre;
import fr.afcepf.squad.entity.Squad;

@ManagedBean(name="mbNav")
@ViewScoped
public class NavigationManagedBean {
	
	public void rediriger(String page) {
//		ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
//        page = "/"+ page +".xhtml?faces-redirect=true";
//		handler.performNavigation(page);
		
	}
	
	public void afficherRencontre(Rencontre rencontre) {
		try {
			if (rencontre.getClass() == Rencontre.class) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("detailRencontre.xhtml?idrencontre="+ rencontre.getId());
			}
			else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("detailsChampionnat.xhtml?idevenement="+ rencontre.getId());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("caca");
		}
	}
	
	public void afficherSquad(Squad squad) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("detailsSquad.xhtml?idsquad="+ squad.getId());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("caca");
		}
	}

	public NavigationManagedBean() {
		super();
	}
	
}
