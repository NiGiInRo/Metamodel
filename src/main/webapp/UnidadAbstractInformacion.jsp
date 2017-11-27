<%-- 
    Document   : UnidadAbstractInformacion
    Created on : 22/10/2017, 07:28:28 PM
    Author     : nicol
--%>

<%@page import="Modelo.UnidadAbstractaInformacion"%>
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
            ArrayList<UnidadAbstractaInformacion> esq= (ArrayList<UnidadAbstractaInformacion>) request.getAttribute("unidades");
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
       <form method="POST" action='ServletUnidadAbstractInformacion' name="frmAddUser">
        Nombre de la Unidad <input type="text" name="unabin"/> <br /> 
        <input type="submit" value="CREAR" />
    </form>
        <br />
        <br />
        <br />
        <form method="POST" action='ServletDelete' name="frmAddr">
        Nombre de la Unidad <input type="text" name="unabin"/> <br /> 
        <input type="submit" value="BORRAR" />
    </form>
        <br />
        <br />
        <br />
        <form method="POST" action='ServletActualizar' name="frddUser">
        Nombre de la Unidad: <input type="text" name="unabin"/> <br /> 
        Nuevo nombre de la Unidad: <input type="text" name="unabin2"/> <br />
        <input type="submit" VALUE ="ACTUALIZAR"/><br/> 
    </form>
         <br />
         <br />
         <br />
         <form method="GET" action='ServletUnidadAbstractInformacion' name="frr">
                        <font color="white"><h2>HISTORIAL</h2></font>
                        <br>
                       
                            <table  width="400" border="2" align="center">
                                <caption align="top">
                                </caption>
                                <tr>
                                    <th width="84" scope="col"><strong><font >ID Esquema</font></strong></th>
                                    <th width="84" scope="col"><strong><font >Nombre Esquema</font></strong></th>
                                    
                                </tr>
                                <%    if (request.getAttribute("unidades") != null) {
                                        ArrayList<UnidadAbstractaInformacion> esqq = (ArrayList<UnidadAbstractaInformacion>) request.getAttribute("unidades");
                                        for (UnidadAbstractaInformacion e : esqq) {
                                %>
                                <tr>
                                    <td><%= e.getId_UA()%></td>
                                    <td><%= e.getName_UA()%></td>
                                    
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

