package fr.afcepf.al31.clapier.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import fr.afcepf.al31.clapier.business.api.IGestionClapier;
import fr.afcepf.al31.clapier.business.impl.GestionClapier;
import fr.afcepf.al31.clapier.entity.Clapier;

public class TagClapier extends TagSupport {
	private IGestionClapier gestionClapier = new GestionClapier();
	@Override
	public int doStartTag() throws JspException {
		List<Clapier> clapiers = gestionClapier.getAll();
		try {
			pageContext.getOut().print("<select name='selected-clapier'>");
			for (Clapier clapier : clapiers) {
				pageContext.getOut().print("<option value='");
				pageContext.getOut().print(clapier.getId());
				pageContext.getOut().print("'>clapier n°: ");
				pageContext.getOut().print(clapier.getNumero());
				pageContext.getOut().print("</option>");
			}
			pageContext.getOut().print("</select>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}
}
