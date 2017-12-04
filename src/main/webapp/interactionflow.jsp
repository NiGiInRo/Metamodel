<%-- 
    Document   : interactionflow
    Created on : 4/12/2017, 10:32:35 AM
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
        <form method="POST" action='Servletinteractionflow' name="frmAddUser">
            
         nombre del flujo de interaccion <input type="text" name="nameinteraction"/> <br /> 
            
            
         que tipo?
         <select class="form-control" name="tipoelemento">
            <option>tipo 1</option>
            <option>tipo 2</option>
            <option>tipo 3</option>
            
        </select> <br/>
        
        
        
        
        <input type="submit" value="CREAR" />
        
         </form>
        <a href="menu.jsp"> Volver </a><br/>
        
    </body>
</html>
