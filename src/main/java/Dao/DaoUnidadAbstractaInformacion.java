/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.UnidadAbstractaInformacion;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nicol
 */
public class DaoUnidadAbstractaInformacion {
    
     private Connection conexion;

    public DaoUnidadAbstractaInformacion()throws SQLException {
        Conexion db=Conexion.getConexion();
        this.conexion=db.getConnection();
    }     
    
    public boolean insertar(UnidadAbstractaInformacion UnAbIn) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO UnidadAbstracta VALUES(?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.conexion.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, UnAbIn.getId_UA());
            statement.setString(2, UnAbIn.getName_UA());
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
}
    
      public UnidadAbstractaInformacion objetoUnidadAbstractaInformacion(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        UnidadAbstractaInformacion UnAbIn=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) conexion.createStatement();
        query = "SELECT * FROM UnidadAbstracta WHERE Name_CN='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            UnAbIn= new UnidadAbstractaInformacion();
            UnAbIn.setId_UA(rs.getInt("Id_UA"));
            UnAbIn.setName_UA(rs.getString("Name_UA"));
          }
        
        return UnAbIn;
    }
      
      public void deleteUnidadAbstractaInformacion(int idUnAbIn) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
          
        try {
			PreparedStatement preparedStatement = conexion.prepareStatement("delete from UnidadAbstracta where Id_UA=?");
			// Parameters start with 1
			preparedStatement.setInt(1, idUnAbIn);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
      
   
      public ArrayList<UnidadAbstractaInformacion> getAbstractaInformacion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<UnidadAbstractaInformacion> historial = new ArrayList<UnidadAbstractaInformacion>();
            Statement stmt = (Statement) conexion.createStatement();
            String query = "SELECT * FROM UnidadAbstracta;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
          UnidadAbstractaInformacion UnAbIn= new UnidadAbstractaInformacion();
           
            while (rs.next()) {
                UnAbIn=new UnidadAbstractaInformacion();
                UnAbIn.setId_UA(rs.getInt("Id_UA"));
                UnAbIn.setName_UA(rs.getString("Name_UA"));
                historial.add(UnAbIn);
                
            }
            return historial;
   
    }
      
      public void updateUnidadAbstractaInformacion(UnidadAbstractaInformacion q, String name) {
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement("update UnidadAbstracta set Name_UA='"+name+"' "+"where Id_UA="+q.getId_UA()+";");
			
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
