package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/login"})
public class AuthenticationServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        HashMap<String ,String> dic = new HashMap();
        
        dic.put("michel" , "123456");
        dic.put("caroline", "abcdef");
       
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthenticationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String l = request.getParameter("login");
            String p = request.getParameter("password");
            if(dic.containsKey(l) && dic.get(l).equals(p)) {
                   HttpSession session = request.getSession();
                   session.setAttribute("identifiant", l);
                   out.println("<a href=\"home\">Home page</a>");
            } 
            
            else{
                    out.println("login / mdp erroné<br>");
                    out.println("<a href=\"login.html\">Try agin</a>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }


}
