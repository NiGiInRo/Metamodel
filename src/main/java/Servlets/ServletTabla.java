
package Servlets;

import Dao.DaoEsquema;
import Dao.DaoTable;
import Modelo.Esquema;
import Modelo.Table;
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

public class ServletTabla extends HttpServlet {

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
            String tabla = request.getParameter("tabla");
            String nombre = request.getParameter("nombre");
            
            DaoTable dt;
            
        try {
            DaoEsquema d= new DaoEsquema();
            dt = new DaoTable();
            Table t= new Table();
            
            t.setIdTabla(dt.idgenerado());
            t.setName(tabla);
            Esquema s=new Esquema();
            t.setIdEsquema(d.objetoEsquema(nombre));
            dt.insertar(t);
             RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
            rd.forward(request, response);
        
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletTabla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletTabla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
