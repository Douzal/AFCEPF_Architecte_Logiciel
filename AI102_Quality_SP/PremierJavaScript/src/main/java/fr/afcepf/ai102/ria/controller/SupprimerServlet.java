package fr.afcepf.ai102.ria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Personne;

@WebServlet("/supprimer-personne.aspx")
public class SupprimerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        IGestionPersonne bu = new GestionPersonne();
        Personne pers = new Personne();
        pers.setId(Integer.parseInt(paramReq.getParameter("id-pers")));
        bu.deletePersonne(pers);
    }
    protected void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp) throws ServletException ,IOException {
        doPost(paramReq, paramResp);
    };
}
