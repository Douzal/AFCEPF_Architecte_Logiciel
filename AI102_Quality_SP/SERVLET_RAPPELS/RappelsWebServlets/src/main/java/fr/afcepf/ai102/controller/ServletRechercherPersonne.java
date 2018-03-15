package fr.afcepf.ai102.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

@SuppressWarnings("serial")
@WebServlet("/rechercher.aspx")
public class ServletRechercherPersonne extends HttpServlet {
    private Logger log = Logger.getLogger(getClass());
    @Override
    protected void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        paramResp.sendRedirect("rechercher-personne.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        IGestionPersonne bu = new GestionPersonne();
        try {
            paramReq.setAttribute("liste",
                    bu.rechercher(paramReq.getParameter("recherche-nom")));
        } catch (QualitException e) {
            log.debug(e.getMessage(), e.getCause());
            paramReq.setAttribute("error-message", e.getMessage());
        }
        paramReq.getRequestDispatcher("/rechercher-personne.jsp")
                .forward(paramReq, paramResp);
    }
}
