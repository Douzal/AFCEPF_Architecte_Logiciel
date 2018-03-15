package fr.afcepf.squad.controller;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.gestion.api.IGestionMembre;

@ManagedBean(name="mbConnexion")
@SessionScoped
public class ConnexionManagedBean {
	public ConnexionManagedBean() {
		super();
	}
	private String mail;
	private String password;
	private Membre membre = new Membre();
	private static final String PAGE_INDEX = "/index.xhtml?faces-redirect=true";
	@EJB
	private IGestionMembre proxyConnexion;

	public String connecter() {
		membre = proxyConnexion.connexion(mail, password);
		String forward = PAGE_INDEX;
		//  System.out.println(membre.getNom());
		if(membre != null) {          
			forward = "/squad.xhtml?faces-redirect=true"; // pour tester la connexion ok ??  
		}      
		return forward;
	}
	public String deconnecter () {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return PAGE_INDEX;
		//   navTo(PAGE_INDEX);
	}
	//    private void navTo(String page) {
	//        ConfigurableNavigationHandler handler = 
	//                (ConfigurableNavigationHandler) FacesContext
	//                .getCurrentInstance().getApplication().getNavigationHandler();
	//        handler.performNavigation(page);
	//    }
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param paramMail the mail to set
	 */
	public void setMail(String paramMail) {
		mail = paramMail;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param paramPassword the password to set
	 */
	public void setPassword(String paramPassword) {
		password = paramPassword;
	}
	/**
	 * @return the membre
	 */
	public Membre getMembre() {
		return membre;
	}
	/**
	 * @param paramMembre the membre to set
	 */
	public void setMembre(Membre paramMembre) {
		membre = paramMembre;
	}
	/**
	 * @return the proxyConnexion
	 */
	public IGestionMembre getProxyConnexion() {
		return proxyConnexion;
	}
	/**
	 * @param paramProxyConnexion the proxyConnexion to set
	 */
	public void setProxyConnexion(IGestionMembre paramProxyConnexion) {
		proxyConnexion = paramProxyConnexion;
	}


}
