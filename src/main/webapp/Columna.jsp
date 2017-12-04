<%-- 
    Document   : Columa
    Created on : 17/10/2017, 09:51:47 PM
    Author     : Diseño
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Dao.DaoTable"%>
<%@page import="Modelo.Columna"%>
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
            ArrayList<Columna> col= (ArrayList<Columna>) request.getAttribute("columnas");
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
        <form method="POST" action='ServletColumna' name="frmAddUser">
        Nombre de la Columna: <input type="text" name="col"/> <br /> 
        <br /> 
        Tipo de dato: <input type="text" name="tipoDato"/> <br /> 
        <br /> 
        Nombre de la Tabla: <input type="text" name="tabla"/> <br /> 
        <br /> 
        
        <select class="form-control" name="tipoColumna">
            <option>PK</option>
            <option>FK</option>
            
        </select>
        
        <input type="submit" value="CREAR" />
    </form>
       <br />
        <br />
        <br />
        <form method="POST" action='ServletDeleteColumna' name="frmAddr">
        Nombre de la Columna: <input type="text" name="col"/> <br /> 
        <input type="submit" value="BORRAR" />
    </form>
            <br />
        <br />
        <br />
        <form method="POST" action='ServletActualizarColumna' name="frmAddr">
        Nombre de la Columna: <input type="text" name="col"/> <br /> 
        <br /> 
        Nuevo nombre de la Columna: <input type="text" name="col2"/> <br /> 
        Tipo de dato: <input type="text" name="tipoDato"/> <br /> 
        <br /> 
        <input type="submit" value="ACTUALIZAR" />
    </form>
        
        </form>
         <br />
         <br />
         <br />
         
        
 
  

         
         <form method="GET" action='ServletColumna' name="frr">
                        <font color="white"><h2>HISTORIAL</h2></font>
                        <br>
                       
                            <table  width="400" border="2" align="center">
                                <caption align="top">
                                </caption>
                                <tr>
                                    <th width="84" scope="col"><strong><font >ID Columna</font></strong></th>
                                    <th width="84" scope="col"><strong><font >Nombre Columna</font></strong></th>
                                    <th width="84" scope="col"><strong><font >Tipo Dato</font></strong></th>
                                    <th width="84" scope="col"><strong><font >Nombre Tabla</font></strong></th>
                                    <th width="84" scope="col"><strong><font >Tipo de Clave</font></strong></th>
                                </tr>
                                <%    if (request.getAttribute("columnas") != null) {
                                        ArrayList<Columna> esqq = (ArrayList<Columna>) request.getAttribute("columnas");
                                        DaoTable dt= new DaoTable();
                                       
                                        for (Columna e : esqq) {
                                            String g= dt.objetoTableID(e.getIdTabla()).getName();
                                %>
                                <tr>
                                    <td><%= e.getIdColumna() %></td>
                                    <td><%= e.getName() %></td>
                                    <td><%= e.getDataType() %></td>
                                    <td><%= e.getIdTabla() %></td>
                                    <td><%= e.getTipoClave() %></td>
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