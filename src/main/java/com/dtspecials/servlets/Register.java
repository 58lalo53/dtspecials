/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dtspecials.servlets;

import com.dtspecials.mavendtspecials.User;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author root
 */
@WebServlet(name="Register", urlPatterns={"/register"})
public class Register extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String destination = register(request);
        
        if (destination.equals("home")){
            response.sendRedirect("home");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        
    } 
    
    private String register(HttpServletRequest request){
        String destination = "/WEB-INF/register.jsp";
        
        if (request.getMethod().equals("GET")){
            return destination;
        }
        
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String phone = request.getParameter("phone");
        
        if(!password.equals(password2)){
            request.setAttribute("flash", "password does not match");
            return destination;
        }
        
        User user = new User(fname, lname, email, username, password, phone);
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("specialsPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.merge(user);
            em.persist(user);
            em.getTransaction().commit();
            
            request.getSession().setAttribute("user", user);
            
            return "home";
        } catch(Exception e){
            request.setAttribute("flash", e.getMessage());
        }
        return destination;
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
