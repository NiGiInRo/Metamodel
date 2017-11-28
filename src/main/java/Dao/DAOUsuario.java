/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuario;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class DAOUsuario {
    
    private Connection connection;

	public DAOUsuario() {
		connection = DbUtil.getConnection();
	}

	public void addUsuario(Usuario usuario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into usuario(cedula,nombre_us,contrasena) values (?, ?, ?)");
			// Parameters start with 1
                        System.out.println("insert into Abogado(Doc_Abogado,Nombre_Abogado,Apellido_Abogado,Actividad,Email,Contraseña,Ciudad,Tipo_Doc) values (?, ?, ?, ?, ?, ?, ?, ? )");
                        preparedStatement.setInt(1, usuario.getCedula());
                        preparedStatement.setString(2, usuario.getNombre());
			preparedStatement.setString(3, usuario.getContrasena());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteUsuario(int Doc_Usuario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Usuario where Doc_Usuario=?");
			// Parameters start with 1
			preparedStatement.setInt(1, Doc_Usuario);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
	/*
	public void updateAbogado(Abogado abogado) {
		try {
                    if(connection!=null){
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Abogado set Nombre_Abogado=?, Apellido_Abogado=?, Actividad=?, Email=?, Contraseña=?, Ciudad=?, Tipo_Doc=?" + 
							"where Doc_Abogado=?");
			// Parameters start with 1
			preparedStatement.setInt(1, abogado.getDoc_Abogado());
			preparedStatement.setString(2, abogado.getNombre_Abogado());
			preparedStatement.setString(3, abogado.getApellido_Abogado());
			preparedStatement.setString(4, abogado.isActividad());
			preparedStatement.setString(5, abogado.getEmail());
                        preparedStatement.setString(6, abogado.getContraseña());
                        preparedStatement.setString(7, abogado.getCiudad());
                        preparedStatement.setString(8, abogado.getTipo_Doc());
			preparedStatement.executeUpdate();
                    }
                    else{
                        System.out.println("No existe conexion");
                    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/
        /*
        public void UpdateAbogado(Usuario q, int cedula) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update usuario set Doc_Abogado='"+cedula+"' "+"where Doc_Abogado="+q.getCedula()+";");
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/
	public List<Usuario> getAllUsuario() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
                      System.out.println("LLegue hasta aca");
			Statement statement = connection.createStatement();
                        
                        
			ResultSet rs = statement.executeQuery("select * from Usuario");
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCedula(rs.getInt("cedula"));
				usuario.setNombre(rs.getString("nombre_us"));
				
                                usuario.setContrasena(rs.getString("contrasena"));
                                
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}
	public Usuario getUsuariosbyId(int Doc_Usuario) {
		Usuario usuario = new Usuario();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Usuario where Doc_Usuario=?");
			preparedStatement.setInt(1, Doc_Usuario);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				usuario.setCedula(rs.getInt("Doc_Usuario"));
				usuario.setNombre(rs.getString("Nombre_Usuario"));
				
                                usuario.setContrasena(rs.getString("Contrasena"));
                                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
        
         public Usuario objetoAbogado(int documento) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Usuario usuario=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM usuario WHERE cedula='" + documento + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            usuario= new Usuario();
            
            usuario.setCedula(rs.getInt("cedula"));
            /*abogado.setNombre_Abogado(rs.getString("Nombre_Abogado"));
            abogado.setApellido_Abogado(rs.getString("Apellido_Abogado"));
            abogado.setActividad(rs.getString("Actividad"));
            abogado.setEmail(rs.getString("Email"));
            abogado.setContraseña(rs.getString("Contraseña"));
            abogado.setCiudad(rs.getString("Ciudad"));
            abogado.setTipo_Doc(rs.getString("Tipo_Documento"));
           */
          }
        
        return usuario;
    }
     /*    
         public ArrayList<Abogado> getAbogados() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<Abogado> historial = new ArrayList<Abogado>();
            Statement stmt = (Statement) connection.createStatement();
            String query = "SELECT * FROM Abogado;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
           Abogado abo= new Abogado();
           
            while (rs.next()) {
                abo = new Abogado();
                abo.setDoc_Abogado(rs.getInt("Doc_Abogado"));
                abo.setNombre_Abogado(rs.getString("Nombre_Abogado"));
                abo.setApellido_Abogado(rs.getString("Apellido_Abogado"));
                abo.setActividad(rs.getString("Actividad"));
                abo.setEmail(rs.getString("Email"));                
                abo.setCiudad(rs.getString("Ciudad"));
                historial.add(abo);
                
            }
            return historial;
   
    }*/
    public Usuario validar(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = null;
            String consulta = "SELECT * FROM usuario WHERE nombre_us=? AND contrasena=?";
            
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, usuario.getNombre().trim());
            preparedStatement.setString(2, usuario.getContrasena().trim());
            System.out.println(usuario.getNombre());
            System.out.println(usuario.getContrasena());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("cedula");
                String login = rs.getString("nombre_us");
                String pass = rs.getString("contrasena");
                Usuario sesion = new Usuario();
                sesion.setNombre(login);
                sesion.setContrasena(pass);
                sesion.setCedula(id);
                System.out.println(sesion);
                return sesion;
            } else {
                //Luego realizaremos otro tipo de retorno 
                    System.out.println("sdfgsdg");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}