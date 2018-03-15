package fr.afcepf.ai102.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;
@SuppressWarnings("serial")
@WebServlet("/ajouter.aspx")
public class ServletAjouterPersonne extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        paramResp.sendRedirect("ajouter-personne.jsp");
    }
    @Override
    public void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        doPerform(paramReq, paramResp);
    }
    private void doPerform(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        Personne pers = new Personne();
        pers.setNom(paramReq.getParameter("personne-nom"));
        pers.setPrenom(paramReq.getParameter("personne-prenom"));
        pers.setMdp(paramReq.getParameter("personne-pwd"));
        pers.setMail(paramReq.getParameter("personne-email"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        IGestionPersonne bu = new GestionPersonne();
        String message = "";
        try {
            pers.setDob(sdf.parse(paramReq.getParameter("personne-dob")));
            pers = bu.ajouter(pers);
            message = new StringBuilder().append("Personne n°")
                      .append(pers.getId()).append(" bien ajoutée")
                      .toString();
        } catch (QualitException e) {
            e.printStackTrace();
            message = new StringBuilder().append("ca marche pas : ")
                          .append(e.getCodeErreur()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            message = "saisir la date au format : yyyy-mm-dd";
        }
        paramReq.setAttribute("unMessage", message);
        paramReq.getRequestDispatcher("/ajouter-personne.jsp")
                .forward(paramReq, paramResp);
    }
}
