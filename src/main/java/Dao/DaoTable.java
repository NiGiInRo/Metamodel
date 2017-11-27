
package Dao;

import Modelo.Table;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


public class DaoTable {
      private Connection conexion;

    public DaoTable()throws SQLException {
        Conexion db=Conexion.getConexion();
        this.conexion=db.getConnection();
    }     
    
    public boolean insertar(Table t) throws SQLException{
        boolean resultado=false;
    
        try{
        //!.Establecer la consulta
        String consulta="INSERT INTO TABLA VALUES(?,?,?)";
        //2.Crear el prepareStament
          PreparedStatement statement;
          statement=this.conexion.prepareStatement(consulta);
        
        //-------------------------------------------------
            statement.setInt(1, t.getIdTabla());
            statement.setString(2, t.getName());
            statement.setInt(3, t.getIdEsquema().getIdEsquema());
          //-----------------------------------------------

          
        //3.Hacer la ejecucion
        resultado=statement.execute();
        
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        System.out.println(resultado);
        return resultado;
}  
     public Table objetoTable(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Table t=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) conexion.createStatement();
        query = "SELECT * FROM Tabla WHERE nombre='" + nombre + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        DaoTable dt=new DaoTable();
        DaoEsquema de= new DaoEsquema();
        
        while (rs.next()) {
           t= new Table();
          t.setIdTabla(rs.getInt("idTabla"));
          t.setName(rs.getString("nombre"));
          t.setIdEsquema(de.objetoEsquema(rs.getString("nombre")));
          }
        
        return t;
    }
     public Table objetoTableID(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Table t=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) conexion.createStatement();
        query = "SELECT * FROM Tabla WHERE idTabla='" +id+ "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        DaoTable dt=new DaoTable();
        DaoEsquema de= new DaoEsquema();
        
        while (rs.next()) {
           t= new Table();
          t.setIdTabla(rs.getInt("idTabla"));
          t.setName(rs.getString("nombre"));
          t.setIdEsquema(de.objetoEsquema(rs.getString("nombre")));
          }
        
        return t;
    }
      public void deleteTable(int idTable) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
          
        String query;
        Table t=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) conexion.createStatement();
        query = "DELETE * FROM TABLE WHERE idTable=" + idTable+ ";";
        stmt.executeQuery(query);
       
    }
      
   
      public ArrayList<Table> getTablas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<Table> historial = new ArrayList<Table>();
            Statement stmt = (Statement) conexion.createStatement();
            String query = "SELECT * FROM Table;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
           Table tt= new Table();
           DaoTable dt= new DaoTable();
           
            while (rs.next()) {
                tt=new Table();
                tt.setIdTabla(rs.getInt("idTabla"));
                tt.setName(rs.getString("nombre"));
                Table obj=dt.objetoTable(rs.getString("nombre"));
                tt.setIdTabla(obj.getIdTabla());
                historial.add(tt);
                
            }
            return historial;
   
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
