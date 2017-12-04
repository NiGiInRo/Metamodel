<%-- 
    Document   : campo
    Created on : 3/12/2017, 08:17:56 PM
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
      <form method="POST" action='ServletCampo' name="frmAddUser">
        Nombre del campo <input type="text" name="nombrecampo"/> <br /> 
        Tipo <input type="text" name="tipo"/> <br /> 
        Mensaje de ayuda <input type="text" name="mensajeayuda"/> <br /> 
        Comentario <input type="text" name="comentario"/> <br /> 
        Valor inicial <input type="text" name="valorinicial"/> <br /> 
        
        <input type="submit" value="CREAR" />
    </form>
        <a href="menu.jsp"> Volver </a><br/>
    </body>
</html>
