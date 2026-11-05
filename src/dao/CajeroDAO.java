/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexion.Conexion;
import modelo.Cajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Hplay
 */
public class CajeroDAO {
    private Cajero crearCajero(ResultSet resultado)throws SQLException{
        return new Cajero(
                resultado.getInt("id"),
                resultado.getInt("ndiez"),
                resultado.getInt("nveinte"),
                resultado.getInt("ncincuenta"),
                resultado.getInt("ncien"),
                resultado.getInt("estado"));               
    }
    
    public ArrayList<Cajero> listar() throws SQLException{
        ArrayList<Cajero> lista = new ArrayList<>();
        Connection con = Conexion.conectar();
        String query = "SELECT * FROM cajeros";
        PreparedStatement preparar = con.prepareStatement(query);
        ResultSet resultado = preparar.executeQuery();
        while (resultado.next()) {            
            lista.add(crearCajero(resultado));
        }
        con.close();
        return lista;
    }
    
    public Cajero buscarPorId(int id)throws SQLException{
        Cajero cajero = null;
        Connection con = Conexion.conectar();
        String query = "SELECT * FROM cajeros WHERE id = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, id);
        ResultSet resultado = preparar.executeQuery();
        if (resultado.next()) {
            cajero = crearCajero(resultado);
        }
        con.close();
        return cajero;
    }
    
    public boolean agregar(Cajero c)throws SQLException{
        Connection con = Conexion.conectar();
        String query = "INSERT INTO cajeros (ndiez, nveinte, ncincuenta, ncien, estado) VALUES (?, ?, ?, ?, 0)";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, c.getNdiez());
        preparar.setInt(2, c.getNveinte());
        preparar.setInt(3, c.getNcincuenta());
        preparar.setInt(4, c.getNcien());
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
    
    public boolean actualizarBilletes(Cajero c)throws SQLException{
        Connection con = Conexion.conectar();
        String query = "UPDATE cajeros SET ndiez = ?, nveinte = ?, ncincuenta = ?, ncien = ? WHERE id = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, c.getNdiez());
        preparar.setInt(2, c.getNveinte());
        preparar.setInt(3, c.getNcincuenta());
        preparar.setInt(4, c.getNcien());
        preparar.setInt(5, c.getId());
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
    
    public boolean eliminar(int id)throws SQLException{
        Connection con = Conexion.conectar();
        String query = "DELETE FROM cajeros WHERE id = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, id);
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
    
    public boolean cambiarEstado(int id, int estado)throws SQLException{
        Connection con = Conexion.conectar();
        String query = "UPDATE cajeros SET estado = ? WHERE id = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, estado);
        preparar.setInt(2, id);
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
}//fin de la clase
