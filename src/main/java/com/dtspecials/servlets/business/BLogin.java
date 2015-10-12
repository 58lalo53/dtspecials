/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtspecials.servlets.business;

import com.dtspecials.mavendtspecials.Business;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
@WebServlet(name = "BLogin", urlPatterns = {"/blogin"})
public class BLogin extends HttpServlet {

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
        String destination = "/WEB-INF/business/blogin.jsp";
        
        if(request.getMethod().equals("GET")){
            request.getRequestDispatcher(destination).forward(request, response);
            return;
        }
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("specialsPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Business buss = (Business)em.createNamedQuery("Business.findByUsername")
                    .setParameter("username", username)
                    .getSingleResult();
            
            if(!buss.getPassword().equals(password)){
                request.setAttribute("flash", "Your username and password don't match!");
                request.getRequestDispatcher(destination).forward(request, response);
                return;
            }
            
            request.getSession().setAttribute("buss", buss);
            
            response.sendRedirect("home");
            
            
        }catch(Exception e){
            request.setAttribute("flash", e.getMessage());
            request.getRequestDispatcher(password).forward(request, response);
        }
        
    }
}
