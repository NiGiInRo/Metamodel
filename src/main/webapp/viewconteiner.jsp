<%-- 
    Document   : viewconteiner
    Created on : 4/12/2017, 11:29:08 AM
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
        
        <form method="POST" action='Servlerviewconteiner' name="frmAddUser">
        Nombre <input type="text" name="nameconteiner"/> <br /> 
        
        is default?
        <select class="form-control" name="isdefault">
            <option>True</option>
            <option>False</option>
            
            
        </select> <br/>
        is XOR? 
        <select class="form-control" name="isxor">
            <option>True</option>
            <option>False</option>
            
            
        </select> <br/>
        protected?
        <select class="form-control" name="protected">
            <option>True</option>
            <option>False</option>
            
           
        </select> <br/>
         is landMark?
         <select class="form-control" name="landmark">
            <option>True</option>
            <option>False</option>
            
            
        </select> <br/>
        
        
        <input type="submit" value="CREAR" />
    </form>
        <a href="menu.jsp"> Volver </a><br/>
        
    </body>
</html>
