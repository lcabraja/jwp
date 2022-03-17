package hr.lcabraja.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GalleryGenerator", value = "/GalleryGenerator")
public class GalleryGenerator extends HttpServlet {

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
            //out.println("<style>table, th, td{border: 1px solid;border-collapse: collapse;}</style>");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
