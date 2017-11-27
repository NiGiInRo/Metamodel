/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.ContextoNavegacion;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


public class DaoContextoNavegacion {
    
     private Connection conexion;

    public DaoContextoNavegacion()throws SQLException {
        Conexion db=Conexion.getConexion();
        this.conexion=db.getConnection();
    }     
    
    public boolean insertar(ContextoNavegacion CoTe) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO contextonavegacion VALUES(?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.conexion.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, CoTe.getId_CN());
            statement.setString(2, CoTe.getName_CN());
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
}
    
      public ContextoNavegacion objetoContextoNavegacion(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        ContextoNavegacion CoTe=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) conexion.createStatement();
        query = "SELECT * FROM contextonavegacion WHERE Name_CN='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            CoTe= new ContextoNavegacion();
            CoTe.setId_CN(rs.getInt("Id_CN"));
            CoTe.setName_CN(rs.getString("Name_CN"));
          }
        
        return CoTe;
    }
      
      public void deleteContextoNavegacion(int idContexto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
          
        try {
			PreparedStatement preparedStatement = conexion.prepareStatement("delete from contextonavegacion where Id_CN=?");
			// Parameters start with 1
			preparedStatement.setInt(1, idContexto);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
      
   
      public ArrayList<ContextoNavegacion> getContextoNavegacion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<ContextoNavegacion> historial = new ArrayList<ContextoNavegacion>();
            Statement stmt = (Statement) conexion.createStatement();
            String query = "SELECT * FROM contextonavegacion;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
          ContextoNavegacion CoTe= new ContextoNavegacion();
           
            while (rs.next()) {
                CoTe=new ContextoNavegacion();
                CoTe.setId_CN(rs.getInt("Id_CN"));
                CoTe.setName_CN(rs.getString("Name_CN"));
                historial.add(CoTe);
                
            }
            return historial;
   
    }
      
      public void updateConextoNavegacion(ContextoNavegacion q, String name) {
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement("update contextonavegacion set Name_CN='"+name+"' "+"where Id_CN="+q.getId_CN()+";");
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
