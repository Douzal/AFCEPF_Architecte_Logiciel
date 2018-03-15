package fr.afcepf.al31.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHelloWorld extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("Hello JSP Wolrd!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
}
