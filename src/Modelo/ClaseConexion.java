/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;

/**
 *
 * @author Estudiante
 */
public class ClaseConexion {
    
    

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO = "Mecanico";
    private static final String CONTRASENA = "Mecanico2";

    public static Connection getConexion() {
        try {
          
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            
            return conexion;
        } catch (SQLException e) {
            System.out.println("Este es el error" + e);
              return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("este es el error de la clase" + ex);
              return null;
        }
    }
    
}
