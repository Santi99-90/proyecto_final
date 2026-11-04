/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Hplay
 */
public class Conexion {
    
    public static Connection conectar() throws SQLException {
        String usuario = "santiago";
        String contrasena = "#3Programacion3";
        String url = "jdbc:mysql://72.167.84.254:3306/banco";
        return DriverManager.getConnection(url, usuario, contrasena);
    }
    
}//fin de la clase
