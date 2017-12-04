/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoColumna;
import Dao.DaoEsquema;
import Dao.DaoTable;
import Modelo.Columna;
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
 * @author Diseño
 */
public class ServletColumna extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Columna> lista = null;
        DaoColumna de;

        try {
            de = new DaoColumna();
            lista = de.getColumnas();

            request.setAttribute("columnas", lista);

            RequestDispatcher rd = request.getRequestDispatcher("Columna.jsp");
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
        String nombre = request.getParameter("col");
        String tipoDato = request.getParameter("tipoDato");
        String tabla = request.getParameter("tabla");
          String tipo = request.getParameter("tipoColumna");
        
        DaoColumna dc;
        DaoTable dt;
        try {
            dt= new DaoTable();
            dc = new DaoColumna();
            Columna cc= new Columna();
            cc.setIdColumna(dc.idgenerado());
            cc.setDataType(tipoDato);
            cc.setIdTabla(dt.objetoTable(tabla).getIdTabla());
            cc.setName(nombre);
            cc.setTipoClave(tipo);
            dc.insertar(cc);
            
             RequestDispatcher rd = request.getRequestDispatcher("Columna.jsp");
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
