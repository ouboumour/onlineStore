package com.directmedia.onlinestore.frontoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.directmedia.onlinestore.core.entity.Work;
import com.directmedia.onlinestore.core.entity.Catalogue;


/**
 *
 * @author oussa
 */
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WorkDetailsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Work details</h1>");
            
            String id = request.getParameter("id");
            
            for (Work w : Catalogue.listeOfWorks) {
                if(w.getId() == Long.parseLong(id)) {
                  out.println("<ul><li>id: "+id+"</li><br>");
                  out.println("<li>Title: "+w.getTitle()+"</li><br>");
                  out.println("<li>Genre: "+w.getGenre()+"</li><br>");
                  out.println("<li>Date sortie: "+w.getRelease()+"</li><br>");
                  out.println("<li>Summary: "+w.getSummary()+"</li><br>");
                  out.println("<li>Artist name: "+w.getMainArtist().getName()+"</li></ul>");
                  break;
                }
            }
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
