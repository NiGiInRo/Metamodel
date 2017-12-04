<%-- 
    Document   : detalle
    Created on : 3/12/2017, 07:51:49 PM
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
       <form method="POST" action='Servletdetalle' name="frmAddUser">
        Nombre del detalle <input type="text" name="namedetalle"/> <br /> 
        <input type="submit" value="CREAR" />
    </form>
        <a href="menu.jsp"> Volver </a><br/>
    </body>
</html>
