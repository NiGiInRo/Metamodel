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
public class ServletDelete extends HttpServlet {


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
       
            String esq = request.getParameter("esquema");
            
            DaoEsquema de;
        try {
            de = new DaoEsquema();
            Esquema esqu= new Esquema();
            
            esqu= de.objetoEsquema(esq);
            System.out.println(esqu.toString());
            de.deleteEsquema(esqu.getIdEsquema());
            RequestDispatcher rd = request.getRequestDispatcher("Esquema.jsp");
            rd.forward(request, response);
        
        } catch (SQLException ex) {
            Logger.getLogger(ServletDelete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDelete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletDelete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
