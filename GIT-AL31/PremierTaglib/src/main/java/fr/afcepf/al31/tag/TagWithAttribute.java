package fr.afcepf.al31.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagWithAttribute extends TagSupport {
	private String nom;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("Bonjour : ");
			pageContext.getOut().print(nom);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print(" -- fin -- ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
