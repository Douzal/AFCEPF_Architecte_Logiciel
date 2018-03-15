package fr.afcepf.squad.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;

import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.enumeration.Sexe;
import fr.afcepf.squad.gestion.api.IGestionMembre;

@ManagedBean(name="mbSession")
@SessionScoped
public class SessionManagedBean {
	private Membre membreConnecte;
	private String dernierUrl;

	//Infos connexion FB
	private static final String FACEBOOK_APP_KEY = "593474394328902";
	private static final String FACEBOOK_APP_SECRET = "ac06c696c415dd3bd850cc271b58d297";
	private static final String FB_PROVIDER_ID = "facebook";

	private static final String PAGE_INDEX = "/accueil-gmap.xhtml?faces-redirect=true";
	private static final String PAGE_LOGIN = "/welcome.xhtml?faces-redirect=true";

	private SocialAuthManager manager;
	private Profile profile;

	private String mail;
	private String password;

	@EJB
	private IGestionMembre proxyMembre;

	private Logger log = Logger.getLogger(getClass());

	public void connexion() throws IOException {

		System.out.println(">>>> Connexion : " + mail + "....");

		membreConnecte = proxyMembre.connexion(mail, password);

		if(membreConnecte != null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect("accueil-gmap.xhtml");
			return;
		}

	}

	public void connexionAuth() throws Exception {
		Properties props = System.getProperties();
		props.put("graph.facebook.com.consumer_key", FACEBOOK_APP_KEY);
		props.put("graph.facebook.com.consumer_secret", FACEBOOK_APP_SECRET);
		props.put("graph.facebook.com.custom_permissions", "public_profile,email,user_birthday,user_location");
		SocialAuthConfig config = SocialAuthConfig.getDefault();
		config.load(props);


		manager = new SocialAuthManager();
		manager.setSocialAuthConfig(config);
		String authenticationURL = manager.getAuthenticationUrl(FB_PROVIDER_ID, "http://localhost:18080/SQUAD/fetchingInformations.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect(authenticationURL);
	}

	public void pullUserInfo() throws IOException {
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			Map<String,String> map = SocialAuthUtil.getRequestParametersMap(request);
			if (this.manager != null) {
				AuthProvider provider = manager.connect(map);
				this.profile = provider.getUserProfile();

				membreConnecte = proxyMembre.connexionAuth(profile.getEmail());

				//Si utilisateur non inscrit en BDD, alors on ajoute le membre.

				if(membreConnecte == null) {
					Membre nouveauMembre = new Membre();
					nouveauMembre.setNom(profile.getLastName());
					nouveauMembre.setPrenom(profile.getFirstName());
					nouveauMembre.setPseudo(profile.getFullName());
					nouveauMembre.setEmail(profile.getEmail());
					nouveauMembre.setPhoto(profile.getProfileImageURL());
					nouveauMembre.setPassword("PASS12345");

					//ça m'a pas l'air très pro! comme le reste remarque§/?****
					Calendar dob = Calendar.getInstance();
					dob.set(profile.getDob().getYear(),profile.getDob().getMonth(), profile.getDob().getDay());

					nouveauMembre.setDateNaissance(dob.getTime());

					switch (profile.getGender()) {
					case "male":
						nouveauMembre.setSexe(Sexe.HOMME);
						break;
					default:
						nouveauMembre.setSexe(Sexe.FEMME);
						break;
					}
					//****
					membreConnecte = proxyMembre.inscription(nouveauMembre);

				}

				//
				//				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				//				ec.redirect("http://localhost:18080/SQUAD/lvl-apprenti/loginTest.xhtml");

			} else {
				log.error("*************** je passe par ici***************");
				//FacesContext.getCurrentInstance().getExternalContext().redirect(externalContext.getRequestContextPath() + "/login.xhtml");
			}
		} catch (Exception ex) {
			log.error("UserSession - Exception: " + ex.toString());
		} 

		FacesContext.getCurrentInstance().getExternalContext().redirect(externalContext.getRequestContextPath() + "/accueil-gmap.xhtml");
	}


	public void saveDernierUrl() {
		HttpServletRequest request  = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		dernierUrl = request.getContextPath() + request.getQueryString();
	}

	public String deconnecter() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();

		return PAGE_LOGIN;
	}

	public SessionManagedBean() {
		super();
	}

	public SessionManagedBean(Membre membreConnecte, String dernierUrl, SocialAuthManager manager, Profile profile,
			String mail, String password, IGestionMembre proxyMembre) {
		super();
		this.membreConnecte = membreConnecte;
		this.dernierUrl = dernierUrl;
		this.manager = manager;
		this.profile = profile;
		this.mail = mail;
		this.password = password;
		this.proxyMembre = proxyMembre;
	}

	public Membre getMembreConnecte() {
		return membreConnecte;
	}


	public void setMembreConnecte(Membre membreConnecte) {
		this.membreConnecte = membreConnecte;
	}


	public String getDernierUrl() {
		return dernierUrl;
	}


	public void setDernierUrl(String dernierUrl) {
		this.dernierUrl = dernierUrl;
	}

	public SocialAuthManager getManager() {
		return manager;
	}

	public void setManager(SocialAuthManager manager) {
		this.manager = manager;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IGestionMembre getProxyMembre() {
		return proxyMembre;
	}

	public void setProxyMembre(IGestionMembre proxyMembre) {
		this.proxyMembre = proxyMembre;
	}



}
