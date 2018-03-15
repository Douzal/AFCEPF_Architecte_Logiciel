package fr.afcepf.al31.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class PremiereServlet extends HttpServlet {
	private Logger log = Logger.getLogger(getClass());
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("dans doPost");
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("dans doGet");
	}
	@Override
	public void init() throws ServletException {
		log.debug("dans init");
	}
}
