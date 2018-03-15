package fr.afcepf.al31.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/une-servlet.al31")
public class UneServletpourFiltres extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(getClass());

    public void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        // TODO verifier le nom
        String saisie = paramReq.getParameter("form-saisie");
        log.debug("dans la servlet !");
        log.debug(saisie);
        String forward = "/toto.html";
        if(saisie.equals("toto")) {
            paramReq.getRequestDispatcher(forward).forward(paramReq, paramResp);
        } else {
            paramResp.sendRedirect(forward.substring(1));
        }
    }
    
    @Override
    public void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        doPost(paramReq, paramResp);
    }

}
