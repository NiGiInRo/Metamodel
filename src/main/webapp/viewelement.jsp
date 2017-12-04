<%-- 
    Document   : viewelement
    Created on : 4/12/2017, 10:58:34 AM
    Author     : nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method="POST" action='Servletviewelement' name="frmAddUser">
        nombre del elemento <input type="text" name="nameelement"/> <br /> 
        nombre de la interaccion <input type="text" name="nameinteraction"/> <br /> 
        
        
        
        <input type="submit" value="CREAR" />
        
         </form>
        <a href="menu.jsp"> Volver </a><br/>
    </body>
</html>
