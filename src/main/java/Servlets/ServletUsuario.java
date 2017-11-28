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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicol
 */
public class ServletUsuario extends HttpServlet {

       private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Formulario.jsp";
    private static String LIST_USUARIO = "/index.jsp";
    private DAOUsuario dao;

    public ServletUsuario() {
        super();
        dao = new DAOUsuario();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int Doc_Usuario = Integer.parseInt(request.getParameter("Doc_Usuario"));
            dao.deleteUsuario(Doc_Usuario);
            forward = LIST_USUARIO;
            request.setAttribute("usuarios", dao.getAllUsuario());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int Doc_Usuarios = Integer.parseInt(request.getParameter("userId"));
            Usuario usuario = dao.getUsuariosbyId(Doc_Usuarios);
            request.setAttribute("usuario", usuario);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USUARIO;
            request.setAttribute("usuarios", dao.getAllUsuario());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre_us"));
        
        usuario.setContrasena(request.getParameter("contrasena"));
   
        usuario.setCedula(Integer.parseInt(request.getParameter("cedula")));
//        if(doc_abogado == null || doc_abogado.isEmpty())
//        {
            dao.addUsuario(usuario);
//        }
//        else
//        {
//            abogado.setDoc_Abogado(Integer.parseInt(doc_abogado));
//            dao.updateAbogado(abogado);
//        }
        
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_USUARIO);
        request.setAttribute("usuarios", dao.getAllUsuario());
        view.forward(request, response);
    }
}
