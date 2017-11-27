/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoEsquema;
import Modelo.Esquema;
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
 * @author Diseño
 */
public class ServletActualizar extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            PrintWriter out = response.getWriter();
            String esquema1 = request.getParameter("esquema");
            String esquema2 = request.getParameter("esquema2");
            
            DaoEsquema de;
        try {
            de = new DaoEsquema();
            Esquema esq= new Esquema();
            
            esq=de.objetoEsquema(esquema1);
            de.updateEsquema(esq, esquema2);
            
            RequestDispatcher rd = request.getRequestDispatcher("Esquema.jsp");
            rd.forward(request, response);
        
        } catch (SQLException ex) {
            Logger.getLogger(ServletActualizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletActualizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletActualizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletActualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
