package fr.afcepf.ai102.ria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/premier-ajax.php", "/premier-ajax.aspx"})
public class PremiereServletAjax extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        doPost(paramReq, paramResp);
    }
    @Override
    public void doPost(HttpServletRequest paramReq, HttpServletResponse paramResp)
            throws ServletException, IOException {
        String pascal = paramReq.getParameter("pascal");
        String maximus = pascal.toUpperCase();
        paramReq.setAttribute("maximus", maximus);
        paramReq.getRequestDispatcher("/WEB-INF/partial-view.jsp")
                .forward(paramReq, paramResp);
    }
}
