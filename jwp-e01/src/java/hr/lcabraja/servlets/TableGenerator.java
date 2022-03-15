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
@WebServlet(name = "TableGenerator", urlPatterns = {"/TableGenerator"})
public class TableGenerator extends HttpServlet {

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
            Integer rows = Integer.parseInt(request.getParameter("rows"));
            Integer columns = Integer.parseInt(request.getParameter("columns"));
            String backgroundcolor = request.getParameter("backgroundcolor");
            Integer frame = Integer.parseInt(request.getParameter("frame"));
            Integer cellgap = Integer.parseInt(request.getParameter("cellgap"));

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"https://code.jquery.com/jquery-3.6.0.slim.js\"></script>");
            out.println(String.format("<style>table, th, td{border: %dpx solid;padding: %dpx;background-color: %s}table{border-collapse: collapse;}</style>", frame, cellgap, backgroundcolor));
            out.println("<style>.highlight{background-color: red}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table class=\"tg\">");
            out.println("<tbody>");
            for (int i = 1; i <= rows; i++) {
                out.println("<tr>");
                for (int j = 1; j <= columns; j++) {
                    out.println(String.format("<td class=\"tg-0lax\">%d</td>", i * j));
                }
                out.println("</tr>");
            }
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
    // @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {
    //     processRequest(request, response);
    // }
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
