<%-- 
    Document   : Esquema
    Created on : 18/10/2017, 02:44:22 PM
    Author     : Diseño
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Esquema"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Usuario usuario = (Usuario)sesion.getAttribute("nombre_us");
    if( usuario == null){
      response.sendRedirect("index.jsp");
    }else{ 
     // if(usuario.getDoc_Abogado()==4567){
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
        
        <%
            ArrayList<Esquema> esq= (ArrayList<Esquema>) request.getAttribute("esquemas");
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
       <form method="POST" action='Servlet' name="frmAddUser">
        Nombre del Esquema: <input type="text" name="esquema"/> <br /> 
        <input type="submit" value="CREAR" />
    </form>
        <br />
        <br />
        <br />
        <form method="POST" action='ServletDelete' name="frmAddr">
        Nombre del Esquema: <input type="text" name="esquema"/> <br /> 
        <input type="submit" value="BORRAR" />
    </form>
        <br />
        <br />
        <br />
        <form method="POST" action='ServletActualizar' name="frddUser">
        Nombre del Esquema: <input type="text" name="esquema"/> <br /> 
        Nuevo nombre del Esquema: <input type="text" name="esquema2"/> <br />
        <input type="submit" VALUE ="ACTUALIZAR"/><br/> 
    </form>
         <br />
         <br />
         <br />
         <form method="GET" action='ServletEsquemas' name="frr">
                        <font color="white"><h2>HISTORIAL</h2></font>
                        <br>
                       
                            <table  width="400" border="2" align="center">
                                <caption align="top">
                                </caption>
                                <tr>
                                    <th width="84" scope="col"><strong><font >ID Esquema</font></strong></th>
                                    <th width="84" scope="col"><strong><font >Nombre Esquema</font></strong></th>
                                    
                                </tr>
                                <%    if (request.getAttribute("esquemas") != null) {
                                        ArrayList<Esquema> esqq = (ArrayList<Esquema>) request.getAttribute("esquemas");
                                        for (Esquema e : esqq) {
                                %>
                                <tr>
                                    <td><%= e.getIdEsquema() %></td>
                                    <td><%= e.getName() %></td>
                                    
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </table>
                                 <input type="submit" VALUE ="HISTORIAL"/><br/>  
                
         </form>
        
        <a href="menu.jsp"> Volver </a><br/>
    </body>
</html>
<%}//else{
%>