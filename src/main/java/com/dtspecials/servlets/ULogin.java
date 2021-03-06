/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dtspecials.servlets;

import com.dtspecials.mavendtspecials.Business;
import com.dtspecials.mavendtspecials.User;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name="ULogin", urlPatterns={"/ulogin"})
public class ULogin extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            
        String destination = "/WEB-INF/login.jsp";
        
        if(request.getMethod().equals("GET")){
            request.getRequestDispatcher(destination).forward(request, response);
            return;
        }
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("specialsPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            
            User user = (User)em.createNamedQuery("User.findByUsername")
                    .setParameter("username", username)
                    .getSingleResult();
            
            if(!user.getPassword().equals(password)){
                request.setAttribute("flash", "Username and password do not match");
                request.getRequestDispatcher(destination).forward(request, response);
                return;
            }

            request.getSession().setAttribute("user", user);
            
            response.sendRedirect("home");
            
        
        }catch(Exception e){
            request.setAttribute("flash", e.getMessage());
            request.getRequestDispatcher(destination).forward(request, response);
        }
            
            
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
