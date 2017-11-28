/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Modelo.ModeloNavegacion;
import Util.DbUtil;
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
public class DaoModeloNavegacion {
    
     private Connection connection;

    public DaoModeloNavegacion()throws SQLException {
         connection = DbUtil.getConnection();
    }     
    
    public boolean insertar(ModeloNavegacion MoNa) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO ModeloNavegacion VALUES(?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.connection.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, MoNa.getId_MDN());
            statement.setString(2, MoNa.getName_MDN());
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
}
    
      public ModeloNavegacion objetoModeloNavegacion(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        ModeloNavegacion MoNa=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM ModeloNavegacion WHERE Name_MDN='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            MoNa= new ModeloNavegacion();
            MoNa.setId_MDN(rs.getInt("Id_MDN"));
            MoNa.setName_MDN(rs.getString("Name_MDN"));
          }
        
        return MoNa;
    }
      
      public void deleteModeloNavegacion(int IdModelo) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
          
        try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from ModeloNavegacion where Id_MDN=?");
			// Parameters start with 1
			preparedStatement.setInt(1, IdModelo);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
      
   
      public ArrayList<ModeloNavegacion> getModeloNavegacion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<ModeloNavegacion> historial = new ArrayList<ModeloNavegacion>();
            Statement stmt = (Statement) connection.createStatement();
            String query = "SELECT * FROM ModeloNavegacion;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
          ModeloNavegacion MoNa= new ModeloNavegacion();
           
            while (rs.next()) {
                MoNa=new ModeloNavegacion();
                MoNa.setId_MDN(rs.getInt("Id_MDN"));
                MoNa.setName_MDN(rs.getString("Name_MDN"));
                historial.add(MoNa);
                
            }
            return historial;
   
    }
      
      public void updateModeloNavegacion(ModeloNavegacion q, String name) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update ModeloNavegacion set Name_MDN='"+name+"' "+"where Id_MDM="+q.getId_MDN()+";");
			
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
