/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Labing
 */
public class Conexion {
 private static Conexion conexion=null;
 //Gestiona la conexion con la base de Datos
 private Connection connection=null;
 
 private Conexion() throws SQLException{
     
     try{
         //1.Cargar el driver
         Class.forName("com.mysql.jdbc.Driver"); 
         
     }catch(ClassNotFoundException e){
         
         
     }
     try{
         //2.Obtener la conexion                                               //nombre base de datos
        this.connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/metamodel","root","root");
         
     }catch(SQLException e){
         
         
     }
  
 }
 
 public static Conexion getConexion() throws SQLException{
     if (conexion==null) {
         conexion= new Conexion();
         
     }
     return conexion;
 }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
 
}
