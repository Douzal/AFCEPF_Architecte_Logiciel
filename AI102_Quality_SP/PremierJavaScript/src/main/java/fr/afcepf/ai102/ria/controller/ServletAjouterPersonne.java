package fr.afcepf.ai102.ria.controller;

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
@WebServlet("/ajouter-personne.aspx")
public class ServletAjouterPersonne extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        doGet(paramReq, paramResp);
    }
    @Override
    protected void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        paramReq.setCharacterEncoding("UTF-8");
        Personne pers = new Personne();
        pers.setNom(paramReq.getParameter("nom"));
        pers.setPrenom(paramReq.getParameter("prenom"));
        pers.setMdp(paramReq.getParameter("password"));
        pers.setMail(paramReq.getParameter("mail"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        IGestionPersonne bu = new GestionPersonne();
        String message = "";
        try {
            pers.setDob(sdf.parse(paramReq.getParameter("naissance")));
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
        paramResp.setCharacterEncoding("UTF-8");
        paramResp.getWriter().write(message);
    }
}
