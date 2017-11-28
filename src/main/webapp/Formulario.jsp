<%-- 
    Document   : Columa
    Created on : 17/10/2017, 09:51:47 PM
    Author     : Diseño
--%>

<%@page import="Dao.DaoTable"%>
<%@page import="Modelo.Columna"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
    
    <form action="ServletUsuario" method="POST">
    cedula:
    <input type="text" name="cedula">
    nombre:
    <input type="text" name="nombre_us">
    contrasena:
    <input type="text" name="contrasena">
    
    <input type="submit" value="Submit">
    </form>
    </body>
</html>
