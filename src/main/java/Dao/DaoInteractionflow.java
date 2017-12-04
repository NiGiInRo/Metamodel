/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Interactionflow;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author nicol
 */
public class DaoInteractionflow {
    
     private Connection connection;

    public DaoInteractionflow()throws SQLException {
        connection = DbUtil.getConnection();
    }     
    
    public boolean insertar(Interactionflow esq) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO interactionflow VALUES(?,?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.connection.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, esq.getIdintetaction());
            statement.setString(2, esq.getNameinteraction());
            statement.setString(3, esq.getTipoelemento());
            
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
}
    
         public Interactionflow objetoInterationId(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Interactionflow t=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM interactionflow WHERE idinteraction='" +id+ "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
       
        
        while (rs.next()) {
           t= new Interactionflow();
          t.setIdintetaction(rs.getInt("idinteraction"));
          t.setNameinteraction(rs.getString("nameinteraction"));
          t.setTipoelemento(rs.getString("tipoelemento"));
          }
        
        return t;
    }
    
     public Interactionflow objetointeraction(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Interactionflow esq=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM interactionflow WHERE nameinteraction='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            esq = new Interactionflow();
            esq.setIdintetaction(rs.getInt("idinteraction"));
            esq.setNameinteraction(rs.getString("nameinteraction"));
            esq.setTipoelemento(rs.getString("tipoelemento"));
         
          }
        
        return esq;
    }
    
      public int idgenerado() {

        int max = 99999;
        int min = 00000;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        System.out.println(randomNum);
        return ((int)System.currentTimeMillis()) + randomNum;
    }
}
