/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoColumna;
import Dao.DaoContextoNavegacion;
import Dao.DaoEsquema;
import Modelo.Columna;
import Modelo.ContextoNavegacion;
import Modelo.Esquema;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicol
 */
public class ServletContextoNavegacion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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
        
       ArrayList<ContextoNavegacion> lista = null;
        DaoContextoNavegacion de;

        try {
            de = new DaoContextoNavegacion();
            lista = de.getContextoNavegacion();

            request.setAttribute("ContextosNavegacion", lista);

            RequestDispatcher rd = request.getRequestDispatcher("ContextoNavegacion.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletColumna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletColumna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletColumna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletColumna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
              PrintWriter out = response.getWriter();
               String co = request.getParameter("contexto");
            
            
            DaoContextoNavegacion cn;
            
        try {
           
            cn = new DaoContextoNavegacion();
            ContextoNavegacion c= new ContextoNavegacion();
            
            c.setId_CN(cn.idgenerado());
            c.setName_CN(co);
            
            cn.insertar(c);
             RequestDispatcher rd = request.getRequestDispatcher("ContextoNavegacion.jsp");
            rd.forward(request, response);
        
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
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
