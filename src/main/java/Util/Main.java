/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        Conexion conexion=Conexion.getConexion();
        if(conexion.getConnection()!=null){
            System.out.println("CONEXION EXITOSA");
           
        }else{
            System.out.println("PROBLEMAS EN CONEXION");
    }
        
    }
}
