package fr.afcepf.al31.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class PremierServlet extends HttpServlet {
    private Logger log = Logger.getLogger(getClass());
    private Logger log = Logger.getLogger(getClass());
    
    @Override
    protected void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        log.debug("dans le doPost");
    }
    
    @Override
    protected void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        log.debug("dans le doGet !");
    }
    
    @Override
    public void init() throws ServletException {
        log.debug("dans init !");
    }
    
}
