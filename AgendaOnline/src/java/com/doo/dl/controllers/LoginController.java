/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doo.dl.controllers;

import com.doo.dl.models.Authenticate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.models.Authenticate;

/**
 *
 * @author moust
 */
public class LoginController extends HttpServlet {

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
        
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String txtUsername = request.getParameter("username");
        String txtPassword = request.getParameter("password");
        
        boolean isValid = Authenticate.isValid(txtUsername, txtPassword);
        if(action.equals("LoginMaestro")){   
            if (isValid == true){
                session.setAttribute("username", txtUsername);
                response.sendRedirect("ProfileMaestro.jsp");

            }else{           
                 RequestDispatcher rd = request.getRequestDispatcher("LoginMaestro.jsp");
                 rd.include(request, response);
                 out.print("<font color='red'><b>La usuario o password introducido es erroneo. Porfavor intente de nuevo</b></font>");

            }
        }
        if(action.equals("LoginAlumno"))
            if (isValid == true){
                session.setAttribute("username", txtUsername);
                response.sendRedirect("ProfileAlumno.jsp");

            }else{           
                 RequestDispatcher rd = request.getRequestDispatcher("LoginAlumno.jsp");
                 rd.include(request, response);
                 out.print("<font color='red'><b>La usuario o password introducido es erroneo. Porfavor intente de nuevo</b></font>");

            }

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
