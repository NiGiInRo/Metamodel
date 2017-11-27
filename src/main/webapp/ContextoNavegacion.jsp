<%-- 
    Document   : ContextoNavegacion
    Created on : 19/10/2017, 10:51:46 AM
    Author     : nicol
--%>

<%@page import="Modelo.ContextoNavegacion"%>
<%@page import="Modelo.Esquema"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
        
        <%
            ArrayList<ContextoNavegacion> esq= (ArrayList<ContextoNavegacion>) request.getAttribute("ContextoNavegacion");
            Integer vtotal = (Integer) request.getAttribute("total");
            int total = 0;
            if (vtotal == null) {
                total = 0;
            } else {
                total = vtotal.intValue();
            }

        %>
       <br />
       <br />
       <br />
       <br />
       <br />
       <br />
       <br />
       <form method="POST" action='ServletContextoNavegacion' name="frmAddUser">
        Nombre del Contexto: <input type="text" name="contexto"/> <br /> 
        <input type="submit" value="CREAR" />
    </form>
        <br />
        <br />
        <br />
        <form method="POST" action='ServletDeleteColumna' name="frmAddr">
        Nombre del Contexto: <input type="text" name="contexto"/> <br /> 
        <input type="submit" value="BORRAR" />
    </form>
        <br />
        <br />
        <br />
        <form method="POST" action='ServletActualizarContexto' name="frddUser">
        Nombre del Contexto: <input type="text" name="contexto"/> <br /> 
        Nuevo nombre del Contexto: <input type="text" name="contexto2"/> <br />
        <input type="submit" VALUE ="ACTUALIZAR"/><br/> 
    </form>
         <br />
         <br />
         <br />
         <form method="GET" action='ServletContextoNavegacion' name="frr">
                        <font color="white"><h2>HISTORIAL</h2></font>
                        <br>
                       
                            <table  width="400" border="2" align="center">
                                <caption align="top">
                                </caption>
                                <tr>
                                    <th width="84" scope="col"><strong><font >ID ContextoNavegacion</font></strong></th>
                                    <th width="84" scope="col"><strong><font >Nombre ContextoNavegacion</font></strong></th>
                                    
                                </tr>
                                <%    if (request.getAttribute("ContextosNavegacion") != null) {
                                        ArrayList<ContextoNavegacion> esqq = (ArrayList<ContextoNavegacion>) request.getAttribute("ContextosNavegacion");
                                        for (ContextoNavegacion e : esqq) {
                                %>
                                <tr>
                                    <td><%= e.getId_CN() %></td>
                                    <td><%= e.getName_CN() %></td>
                                    
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </table>
                                 <input type="submit" VALUE ="HISTORIAL"/><br/>  
                
         </form>
        
        <a href="index.html"> Volver </a><br/>
    </body>
</html>
