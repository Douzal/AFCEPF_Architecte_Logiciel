package fr.afcepf.al31.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TagBoucle extends BodyTagSupport {
	private int compteur = 0;
	private int nombre = 0;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print(" -- debut de la boucle --");
		} catch (IOException e) {
			e.printStackTrace();
		}
		compteur = 0;
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doAfterBody() throws JspException {
		if (compteur++ < nombre) {
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print(" -- fin de la boucle --");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
}
