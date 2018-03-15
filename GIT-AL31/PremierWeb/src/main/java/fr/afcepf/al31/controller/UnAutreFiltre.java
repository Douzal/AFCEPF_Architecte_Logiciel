package fr.afcepf.al31.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class UnAutreFiltre
 */
@WebFilter(urlPatterns = "/une-servlet.al31", filterName = "b")
public class UnAutreFiltre implements Filter {
	private Logger log = Logger.getLogger(getClass());
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.debug("dans autre filtre avant Servlet");
		chain.doFilter(request, response);
		log.debug("dans autre filtre après Servlet");
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
