
package Dao;

import Modelo.Columna;

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
 * @author Labin
 */
public class DaoColumna {
    
        private Connection connection;

    public DaoColumna()throws SQLException {
        connection = DbUtil.getConnection();
    }     
    
    public boolean insertar(Columna col) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO COLUMNA VALUES(?,?,?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.connection.prepareStatement(consulta);
        
        //-------------------------------------------------
            
            statement.setInt(1, col.getIdColumna());
            statement.setString(2, col.getName());
            statement.setInt(3, col.getIdTabla());
            statement.setString(4, col.getDataType()); 
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return resultado;
}
    
     public Columna objetoColumna(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Columna col=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM columna WHERE nombre='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        DaoTable dt= new DaoTable();
        
        while (rs.next()) {
            col= new Columna();
            col.setIdColumna(rs.getInt("idColumna"));
            col.setName(rs.getString("nombre"));
            col.setDataType(rs.getString("tipoDato"));
            col.setIdTabla(dt.objetoTableID(rs.getInt("idTabla")).getIdTabla());
          }
        
        return col;
    }
      
     public void deleteColumna(int idColumna) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
          
        try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Columna where idColumna=?");
			// Parameters start with 
			preparedStatement.setInt(1, idColumna);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }public ArrayList<Columna> getColumnas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<Columna> historial = new ArrayList<Columna>();
            Statement stmt = (Statement) connection.createStatement();
            String query = "SELECT * FROM Columna;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
           Columna col= new Columna();
           DaoTable dt= new DaoTable();
           
            while (rs.next()) {
                col=new Columna();
                col.setIdColumna(rs.getInt("idColumna"));
                col.setName(rs.getString("nombre"));
                col.setDataType(rs.getString("tipoDato"));
                col.setIdTabla(dt.objetoTableID(rs.getInt("idTabla")).getIdTabla());
                historial.add(col);
                
            }
            return historial;
   
    }
      public void updateColumna(Columna q, String name) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update columna set nombre='"+name+"' "+"where idColumna="+q.getIdColumna()+";");
			
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
