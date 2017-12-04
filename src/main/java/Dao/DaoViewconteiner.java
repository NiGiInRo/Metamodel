/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Viewconteiner;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author nicol
 */
public class DaoViewconteiner {
    
    private Connection connection;

    public DaoViewconteiner()throws SQLException {
        connection = DbUtil.getConnection();
    }     
    
    public boolean insertar(Viewconteiner esq) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO viewconteiner VALUES(?,?,?,?,?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.connection.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, esq.getIdconteiner());
            statement.setString(2, esq.getNameconteiner());
            statement.setString(3, esq.getIsdefault());
            statement.setString(4, esq.getIsxor());
            statement.setString(5, esq.getProtectedd());
            statement.setString(6, esq.getLandmark());
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
