package fr.afcepf.squad.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;


@ManagedBean(name="userSession")
@SessionScoped
public class ConnexionManagedBean {

	private static final String FACEBOOK_APP_KEY = "593474394328902";
	private static final String FACEBOOK_APP_SECRET = "ac06c696c415dd3bd850cc271b58d297";
	private SocialAuthManager manager;
	private String            originalURL;
	private String            providerID = "facebook";
	private Profile           profile;

	public ConnexionManagedBean() {
		super();
	}

	public ConnexionManagedBean(SocialAuthManager manager, String originalURL, String providerID, Profile profile) {
		super();
		this.manager = manager;
		this.originalURL = originalURL;
		this.providerID = providerID;
		this.profile = profile;
	}

	public void socialConnect() throws Exception {
		// Put your keys and secrets from the providers here 
		Properties props = System.getProperties();
		props.put("graph.facebook.com.consumer_key", FACEBOOK_APP_KEY);
		props.put("graph.facebook.com.consumer_secret", FACEBOOK_APP_SECRET);
		// Define your custom permission if needed
		props.put("graph.facebook.com.custom_permissions", "public_profile,email,user_birthday,user_location");

		// Initiate required components
		SocialAuthConfig config = SocialAuthConfig.getDefault();
		config.load(props);

		manager = new SocialAuthManager();
		manager.setSocialAuthConfig(config);
		
		// 'successURL' is the page you'll be redirected to on successful login
		ExternalContext externalContext   = FacesContext.getCurrentInstance().getExternalContext();
		String          successURL        = "http://localhost:18080/SQUAD/socialLoginSuccess.xhtml"; 
		System.out.println(successURL);
		String          authenticationURL = manager.getAuthenticationUrl(providerID, successURL);
		FacesContext.getCurrentInstance().getExternalContext().redirect(authenticationURL);
	}

	public void pullUserInfo() {
		try {
			// Pull user's data from the provider
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			Map<String,String> map = SocialAuthUtil.getRequestParametersMap(request);
			if (this.manager != null) {
				AuthProvider provider = manager.connect(map);
				this.profile          = provider.getUserProfile();

				// Do what you want with the data (e.g. persist to the database, etc.)
				System.out.println("User's Social profile: " + profile);

				// Redirect the user back to where they have been before logging in
				FacesContext.getCurrentInstance().getExternalContext().redirect(originalURL);

			} else FacesContext.getCurrentInstance().getExternalContext().redirect(externalContext.getRequestContextPath() + "home.xhtml");
		} catch (Exception ex) {
			System.out.println("UserSession - Exception: " + ex.toString());
		} 
	}

	public void logOut() {
		try {
			// Disconnect from the provider
			manager.disconnectProvider(providerID);

			// Invalidate session
			//			ExternalContext    externalContext = FacesContext.getCurrentInstance().getExternalContext();
			//			HttpServletRequest request         = (HttpServletRequest) externalContext.getRequest();
			//			this.invalidateSession(request);

			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

			// Redirect to home page
			FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "home.xhtml");
		} catch (IOException ex) {
			System.out.println("UserSessionBean - IOException: " + ex.toString());
		}
	}

	public SocialAuthManager getManager() {
		return manager;
	}

	public void setManager(SocialAuthManager manager) {
		this.manager = manager;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		System.out.println(originalURL + "**********************************************************");
		this.originalURL = originalURL;
	}

	public String getProviderID() {
		return providerID;
	}

	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}



}
