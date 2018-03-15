package fr.afcepf.ai102.ria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;
@WebServlet("/recherche-ajax.aspx")
public class RechercherServletAjax extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        doPost(paramReq, paramResp);
    }
    @Override
    public void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        String nom = paramReq.getParameter("nom");
        IGestionPersonne bu = new GestionPersonne();
        try {
            paramReq.setAttribute("liste", bu.rechercher(nom));
        } catch (QualitException e) {
            paramReq.setAttribute("message", e.getMessage());
        }
        paramReq.getRequestDispatcher("/WEB-INF/recherche-partial-view.jsp")
                .forward(paramReq, paramResp);
    }
}
