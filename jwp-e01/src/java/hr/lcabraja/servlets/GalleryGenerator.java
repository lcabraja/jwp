/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.lcabraja.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author doss
 */
@WebServlet(name = "GalleryGenerator", urlPatterns = {"/GalleryGenerator"})
public class GalleryGenerator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String pic1 = request.getParameter("pic1");
            String pic2 = request.getParameter("pic2");
            String pic3 = request.getParameter("pic3");
            String pic4 = request.getParameter("pic4");
            String pic5 = request.getParameter("pic5");
            String pic6 = request.getParameter("pic6");
            String pic7 = request.getParameter("pic7");
            String pic8 = request.getParameter("pic8");
            String pic9 = request.getParameter("pic9");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
//            out.println("<style>table, th, td{border: 1px solid;border-collapse: collapse;}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table class=\"tg\">");
            out.println("<tbody>");
            out.println("<tr>");
            out.println(String.format("<tr><td><image src=\"%s\"/></td><td><image src=\"%s\"/></td><td><image src=\"%s\"/></td></tr>", pic1, pic2, pic3));
            out.println(String.format("<tr><td><image src=\"%s\"/></td><td><image src=\"%s\"/></td><td><image src=\"%s\"/></td></tr>", pic4, pic5, pic6));
            out.println(String.format("<tr><td><image src=\"%s\"/></td><td><image src=\"%s\"/></td><td><image src=\"%s\"/></td></tr>", pic7, pic8, pic9));
            out.println("</tbody>");
            out.println("</table>");
            out.println("<script>$(\"tr\").click(function(e) {$(\"tr\").removeClass(\"highlight\");$(this).addClass(\"highlight\");});</script>");
            out.println("<a href=\"/jwp-e01\">Index</a>");
            out.println("</body>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
