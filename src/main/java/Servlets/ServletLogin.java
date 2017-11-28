/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DAOUsuario;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicol
 */
public class ServletLogin extends HttpServlet {

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
       HttpSession sesionUsuario = request.getSession();
        Usuario _sesionUsuario = (Usuario)sesionUsuario.getAttribute("Email");
        if(_sesionUsuario!=null){
          sesionUsuario.invalidate();
          response.sendRedirect("index.jsp");
        }
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
         String login = request.getParameter("Email");
        String pass = request.getParameter("Contrasena");
        
        
        Usuario datosUsuario = new Usuario();
        datosUsuario.setNombre(login);
        datosUsuario.setContrasena(pass);
        System.out.println(datosUsuario);
        
        //Validaciones
        DAOUsuario userDao = new DAOUsuario();
        Usuario sesion = userDao.validar(datosUsuario);
        HttpSession sesionUsuario = request.getSession();
        Usuario _sesionUsuario = (Usuario)sesionUsuario.getAttribute("nombre_us");
        if(_sesionUsuario==null){
         //El usuario no a creado la sesion
          if(sesion != null){
            sesionUsuario.setAttribute("nombre_us", sesion);
            sesionUsuario.setMaxInactiveInterval(20);
              System.out.println("ola");
            response.sendRedirect("menu.jsp");
          }else{
             response.sendRedirect("index.jsp");
              System.out.println("aqui");
          }
         
        }else{
          response.sendRedirect("menu.jsp");
            System.out.println("aqui2");
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
