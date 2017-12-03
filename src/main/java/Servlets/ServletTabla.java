
package Servlets;

import Dao.DaoEsquema;
import Dao.DaoTable;
import Modelo.Esquema;
import Modelo.Table;
import Modelo.Usuario;
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
import javax.servlet.http.HttpSession;

public class ServletTabla extends HttpServlet {

    private DaoTable dao;
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
        
        try {
            PrintWriter out = response.getWriter();
            Table table = new Table();
            HttpSession sesionUsuario = request.getSession();
            
            
            
            table.setName(request.getParameter("nombret"));
            
            
            table.setIdEsquema((table.getIdEsquema()));
            

              dao.insertar(table);
        } catch (SQLException ex) {
            Logger.getLogger(ServletTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
