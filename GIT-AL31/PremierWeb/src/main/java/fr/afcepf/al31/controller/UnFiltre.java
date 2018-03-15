package fr.afcepf.al31.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class UnFiltre
 */
@WebFilter(urlPatterns = "/*", filterName = "a")
public class UnFiltre implements Filter {
	private Logger log = Logger.getLogger(getClass());
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.debug("avant appel");
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> params = request.getParameterMap();
		for(String key : params.keySet()) {
			for(String valeur : params.get(key)) {
				log.debug(key + " => " + valeur);
			}
		}
		log.debug(request.getParameter("form-saisie"));
		if(request.getParameter("form-saisie") != null 
				&& request.getParameter("form-saisie").equals("titi")) {
			((HttpServletResponse)response).sendRedirect("index.html");
		} else {
			
			chain.doFilter(request, response); // call next
		}
		log.debug("après appel");
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
