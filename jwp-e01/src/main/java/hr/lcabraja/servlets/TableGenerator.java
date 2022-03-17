package hr.lcabraja.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TableGenerator", value = "/TableGenerator")
public class TableGenerator extends HttpServlet {

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
