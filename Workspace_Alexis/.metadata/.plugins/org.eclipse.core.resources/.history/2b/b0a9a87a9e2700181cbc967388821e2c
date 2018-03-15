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

import org.apache.log4j.Logger;

@WebFilter("/*")
public class UnFiltre implements Filter {
    private Logger log = Logger.getLogger(getClass());


    public UnFiltre() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    log.debug("Avant appel !");
	    
	    Map<String, String[]> params = request.getParameterMap();
	    for (String key : params.keySet()) {
	        for(String valeur : params.get(key)) {
	        log.debug(key + " => " + valeur);
	        }
	    }
	    
		chain.doFilter(request, response);
		log.debug("après appel.");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
