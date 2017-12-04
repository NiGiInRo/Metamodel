<%-- 
    Document   : form
    Created on : 3/12/2017, 08:02:12 PM
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
    <form method="POST" action='Servletform' name="frmAddUser">
        Nombre del formulario <input type="text" name="nameform"/> <br /> 
        <input type="submit" value="CREAR" />
    </form>
        <a href="menu.jsp"> Volver </a><br/>
    </body>
</html>
