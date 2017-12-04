<%-- 
    Document   : camposeleccion
    Created on : 4/12/2017, 09:42:25 AM
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
        
        <form method="POST" action='ServletCampoSeleccion' name="frmAddUser">
         es multi-Select?
         <select class="form-control" name="ismultiselect">
            <option>True</option>
            <option>False</option>
            
        </select> <br/>
        
        nombre del Campo <input type="text" name="nombrecampo"/> <br /> 
        
        
        <input type="submit" value="CREAR" />
        
         </form>
        <a href="menu.jsp"> Volver </a><br/>
        
    </body>
</html>
