/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Campo;
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
public class DaoCampo {
    
     private Connection connection;

    public DaoCampo()throws SQLException {
        connection = DbUtil.getConnection();
    }     
    
    public boolean insertar(Campo esq) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO campo VALUES(?,?,?,?,?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.connection.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, esq.getIdcampo());
            statement.setString(2, esq.getNombrecampo());
            statement.setString(3, esq.getTipo());
            statement.setString(4, esq.getMensajeayuda());
            statement.setString(5, esq.getComentario());
            statement.setString(6, esq.getValorinicial());
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
}
    
     public Campo objetoEsquema(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Campo esq=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM campo WHERE nombrecampo='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            esq = new Campo();
            esq.setIdcampo(rs.getInt("idcampo"));
            esq.setNombrecampo(rs.getString("nombrecampo"));
            esq.setTipo(rs.getString("tipo"));
            esq.setMensajeayuda(rs.getString("mensajeayuda"));
            esq.setComentario(rs.getString("comentario"));
            esq.setValorinicial(rs.getString("valorinicial"));
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
