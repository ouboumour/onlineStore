package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oussa
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "<meta charset=\"UTF-8\">\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "<title>Home page</title>\n" +
                        "<link rel=\"stylesheet\" href=\"styles.css\">\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<p>\n" +
                        "<h1>Bonjour "+session.getAttribute("identifiant")+"</h1>"+
                        "<h2>Gestion de la boutique</h2>\n" +
                        "<a href=\"catalogue\">Accès au catalogue des oeuvres</a><br>"+
                        "<a href=\"add-work-form.html\">Ajouter une œuvre au catalogue</a>"+                        
                        "</p>\n" +
                        "</body>\n" +
                        "</html>");
        }
    }


}
