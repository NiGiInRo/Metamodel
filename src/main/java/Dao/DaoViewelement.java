/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Viewelement;
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
public class DaoViewelement {
    
    private Connection connection;

    public DaoViewelement()throws SQLException {
        connection = DbUtil.getConnection();
    }     
    
    public boolean insertar(Viewelement esq) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO viewElement VALUES(?,?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.connection.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, esq.getIdelement());
            statement.setString(2, esq.getNameelement());
            statement.setInt(3, esq.getIdinteraction().getIdintetaction());
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
}
    
    
    /*
        public Viewelement objetoEsquema(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Viewelement esq=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM campo WHERE nombrecampo='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        DaoInteractionflow it = new DaoInteractionflow();
        while (rs.next()) {
            esq = new Viewelement();
            esq.setIdelement(rs.getInt("idcampo"));
            esq.setNameelement(rs.getString("nombrecampo"));
            esq.setIdinteraction(it.objetoInterationId(rs.getInt("")).get);
            
          }
        
        return esq;
    }
    */
    
      public int idgenerado() {

        int max = 99999;
        int min = 00000;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        System.out.println(randomNum);
        return ((int)System.currentTimeMillis()) + randomNum;
    }
    
    
}
