<%-- 
    Document   : camposimple
    Created on : 3/12/2017, 09:25:55 PM
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
         <form method="POST" action='ServletCamposimple' name="frmAddUser">
        Edition mask <input type="text" name="edmask"/> <br /> 
        default value <input type="text" name="defaultvalue"/> <br /> 
        Validation message <input type="text" name="validationmessage"/> <br /> 
        nombre del Campo <input type="text" name="nombrecampo"/> <br /> 
        
        
        <input type="submit" value="CREAR" />
        
         </form>
        <a href="menu.jsp"> Volver </a><br/>
    </body>
</html>
