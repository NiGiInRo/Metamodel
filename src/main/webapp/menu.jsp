<%-- 
    Document   : Columa
    Created on : 17/10/2017, 09:51:47 PM
    Author     : Diseño
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Dao.DaoTable"%>
<%@page import="Modelo.Columna"%>
<%@page import="java.util.ArrayList"%>
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
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
       
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
       
            
            <a href="Esquema.jsp"> Esquema </a><br/> 
            <a href="Tabla.jsp"> Tabla</a><br/> 
            <a href="Columna.jsp"> Columna </a><br/> 
            <a href="ContextoNavegacion.jsp"> ContextoNavegacion </a><br/> 
            <a href="UnidadAbstractInformacion.jsp"> Unidad </a><br/> 
            <br>
      
           
    </body>
    
    
</html>


</html>
<%}//else{
%>