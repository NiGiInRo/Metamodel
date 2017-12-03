<%-- 
    Document   : Tabla
    Created on : 18/10/2017, 02:46:22 PM
    Author     : Diseño
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Usuario usuario = (Usuario)sesion.getAttribute("nombre_us");
    if( usuario == null){
      response.sendRedirect("index.jsp");
    }else{ 
     // if(usuario.getDoc_Abogado()==4567){
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form method="POST" action='ServletTabla' >
        Nombre de la Tabla: <input type="text" name="nombret"/> <br />
        <br/>
        Nombre del esquema: <input type="text" name="nombre"/> <br />
        <br/>
        <input type="submit" value="Submit" />
    </form>
        <a href="menu.jsp"> Volver </a><br/>
    </body>
</html>
<%}//else{
%>