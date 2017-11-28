
package Dao;

import Modelo.Esquema;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


public class DaoEsquema {
        
    private Connection connection;

    public DaoEsquema()throws SQLException {
        connection = DbUtil.getConnection();
    }     
    
    public boolean insertar(Esquema esq) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO ESQUEMA VALUES(?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.connection.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, esq.getIdEsquema());
            statement.setString(2, esq.getName());
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
}
    
      public Esquema objetoEsquema(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Esquema esq=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM ESQUEMA WHERE nombre='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            esq= new Esquema();
            esq.setIdEsquema(rs.getInt("idEsquema"));
            esq.setName(rs.getString("nombre"));
          }
        
        return esq;
    }
      
      public void deleteEsquema(int idEsquema) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
          
        try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Esquema where idEsquema=?");
			// Parameters start with 1
			preparedStatement.setInt(1, idEsquema);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
      
   
      public ArrayList<Esquema> getEsquemas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<Esquema> historial = new ArrayList<Esquema>();
            Statement stmt = (Statement) connection.createStatement();
            String query = "SELECT * FROM Esquema;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
           Esquema esq= new Esquema();
           
            while (rs.next()) {
                esq=new Esquema();
                esq.setIdEsquema(rs.getInt("idEsquema"));
                esq.setName(rs.getString("nombre"));
                historial.add(esq);
                
            }
            return historial;
   
    }
      
      public void updateEsquema(Esquema q, String name) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update esquema set nombre='"+name+"' "+"where idEsquema="+q.getIdEsquema()+";");
			
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
