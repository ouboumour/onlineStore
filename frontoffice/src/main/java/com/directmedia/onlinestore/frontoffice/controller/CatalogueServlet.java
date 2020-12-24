package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Work;
import com.directmedia.onlinestore.core.entity.Catalogue;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oussa
 */
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(Catalogue.listeOfWorks.isEmpty()){
        Work work1 = new Work("work1");
        Work work2 = new Work("work2");
        Work work3 = new Work("work3");
    
        work1.setGenre("Sad");
        work1.setMainArtist(new Artist("artist 1"));
        work1.setRelease(1990);
        work1.setSummary("summary 1");
            
        work2.setGenre("Happy");
        work2.setMainArtist(new Artist("artist 2"));
        work2.setRelease(1999);
        work2.setSummary("summary 2");
            
        work3.setGenre("2018");
        work3.setMainArtist(new Artist("artist 3"));
        work3.setRelease(2016);
        work3.setSummary("summary 3");
        
        Catalogue.listeOfWorks.add(work1);
        Catalogue.listeOfWorks.add(work2);
        Catalogue.listeOfWorks.add(work3);


        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        out.println("<html><body><h1>Liste des oeuvres: </h1>");
        for (Work h : Catalogue.listeOfWorks) {
            out.println("<a href=\"work-details?id="+h.getId()+"\">"+h.getTitle()+"("+h.getRelease()+")</a><br>");
        }
        out.println("</body></html>");
        }
    }

 

}
