package fr.afcepf.al31.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class FormulaireServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(getClass());
    
    @Override
    public void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/form.html").forward(paramReq, paramResp);
        log.debug("Dans le doPost du form !");
        
        StringBuilder sb = new StringBuilder(System.lineSeparator());
        sb = sb.append("");
        
//        doPost(paramReq, paramResp);
    }
    
    @Override
    public void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        // ligne à ajouter pour que tomcat comprenne les accents)
        paramReq.setCharacterEncoding("UTF-8");
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/form.html").forward(paramReq, paramResp);
        log.debug("Dans le doGET du form !");
        
        
        
//        doGet(paramReq, paramResp);
    }
  
}