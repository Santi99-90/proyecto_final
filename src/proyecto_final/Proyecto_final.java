/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;
import dao.ClienteDAO;
import modelo.Cliente;
import java.sql.SQLException;
/**
 *
 * @author Hplay
 */
public class Proyecto_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try (java.sql.Connection con = conexion.Conexion.conectar()) {
            System.out.println("Conexion correcta");
        } catch (java.sql.SQLException e) {
            System.out.println("Conexion incorrecta: " + e.getMessage());
        }
        
        
    }//fin del main
    
}//ifn del proyecto
