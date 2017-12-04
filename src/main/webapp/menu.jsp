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
            <a href="lista.jsp"> lista </a><br/>
            <a href="detalle.jsp"> detalle </a><br/> 
            <a href="form.jsp"> form </a><br/> 
            <a href="campo.jsp"> campo </a><br/> 
            <a href="camposimple.jsp"> campo simple </a><br/> 
            <a href="camposeleccion.jsp"> campo seleccion </a><br/> 
            <a href="interactionflow.jsp"> interaction flow </a><br/> 
            <a href="viewelement.jsp"> view element </a><br/> 
            <a href="viewconteiner.jsp"> view conteiner </a><br/> 
            <a href="viewcomponent.jsp"> view component (no funciona) </a><br/> 
           
            
            
            <br>
      
           
    </body>
    
    
</html>


</html>
<%}//else{
%>