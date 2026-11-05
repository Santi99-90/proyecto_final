/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;
import dao.ClienteDAO;
import modelo.Cliente;
import java.sql.SQLException;
import dao.CajeroDAO;
import modelo.Cajero;
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
        try {
            CajeroDAO cajeroDAO = new CajeroDAO();
            for (Cajero c : cajeroDAO.listar()) {
                System.out.println("Cajero " + c.getId() + " | 10k: " + c.getNdiez()
                    + " | 20k: " + c.getNveinte() + " | 50k: " + c.getNcincuenta()
                    + " | 100k: " + c.getNcien() + " | Estado: " + c.getEstado());

            }
        } catch (SQLException e) {
            System.out.println("Error en el sql: " + e.getMessage());
        }
        
        
    }//fin del main
    
}//ifn del proyecto
