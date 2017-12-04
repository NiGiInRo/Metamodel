/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.CampoSimple;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author nicol
 */
public class DaoSimple {
    
    private Connection connection;

    public DaoSimple()throws SQLException {
        connection = DbUtil.getConnection();
    }     
    
    public boolean insertar(CampoSimple esq) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO camposimple VALUES(?,?,?,?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.connection.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, esq.getIdsimple());
            statement.setString(2, esq.getEdmask());
            statement.setString(3, esq.getDefaultvalue());
            statement.setString(4, esq.getValidationmessage());
            statement.setInt(5, esq.getIdcampo().getIdcampo());
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
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
