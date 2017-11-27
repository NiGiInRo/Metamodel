/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoColumna;
import Dao.DaoEsquema;
import Modelo.Columna;
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
public class ServletActualizarColumna extends HttpServlet {


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
            String col1 = request.getParameter("col");
            String col2 = request.getParameter("col2");
           
            
            DaoColumna de;
        try {
            de = new DaoColumna();
            Columna esq= new Columna();
            
            
            esq=de.objetoColumna(col1);
            de.updateColumna(esq, col2);
            
            RequestDispatcher rd = request.getRequestDispatcher("Columna.jsp");
            rd.forward(request, response);
        
        } catch (SQLException ex) {
            Logger.getLogger(ServletActualizarColumna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletActualizarColumna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletActualizarColumna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletActualizarColumna.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
