package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oussa
 */
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        
        Work work = new Work(request.getParameter("titre"));
        
        work.setGenre(request.getParameter("genre"));
        work.setMainArtist(new Artist(request.getParameter("artiste")));
        work.setRelease(Integer.parseInt(request.getParameter("annee"))) ;
                
        work.setSummary(request.getParameter("resume"));
        
        
        
        Catalogue.listeOfWorks.add(work);
                
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddWorkServlet</title>");            
            out.println("</head>");
            out.println("<body><h1>Le film a été ajouté</h1>");
            out.println("<a href=\"home\">Home page</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }


}
