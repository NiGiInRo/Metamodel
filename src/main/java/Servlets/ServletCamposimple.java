/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoCampo;
import Dao.DaoSimple;
import Modelo.Campo;
import Modelo.CampoSimple;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class ServletCamposimple extends HttpServlet {

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            
            String campo = request.getParameter("nombrecampo");
            String edmask = request.getParameter("edmask");
            String value = request.getParameter("defaultvalue");
            String validation = request.getParameter("validationmessage");
            
            DaoSimple dt;
            try {
      
            DaoCampo d= new DaoCampo();
            dt = new DaoSimple();
            CampoSimple t= new CampoSimple();
            
            t.setIdsimple(dt.idgenerado());
                t.setEdmask(edmask);
                t.setDefaultvalue(value);
                t.setValidationmessage(validation);

                Campo s = new Campo();

                t.setIdcampo(d.objetoEsquema(campo));
                dt.insertar(t);
                RequestDispatcher rd = request.getRequestDispatcher("camposimple.jsp");
                rd.forward(request, response);
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletCamposimple.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletCamposimple.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletCamposimple.class.getName()).log(Level.SEVERE, null, ex);
            }
                
              
           
          
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletCamposimple.class.getName()).log(Level.SEVERE, null, ex);
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
