/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexion.Conexion;
import modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Hplay
 */
public class ClienteDAO {
    //Convierte la fila actual del resultado en un objeto Cliente
    private Cliente crearCliente(ResultSet resultado) throws SQLException {
        return new Cliente(
                resultado.getInt("id"),
                resultado.getString("nombre"),
                resultado.getString("apellido"),
                resultado.getString("telefono"),
                resultado.getString("ciudad"),
                resultado.getInt("ncuenta"),
                resultado.getDouble("saldo"),
                resultado.getInt("estado")
        );
    }
    
    public ArrayList<Cliente> listar() throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection con = Conexion.conectar();
        String query = "SELECT * FROM clientes";
        PreparedStatement preparar = con.prepareStatement(query);
        ResultSet resultado = preparar.executeQuery();
        while (resultado.next()) {
            lista.add(crearCliente(resultado));
        }
        con.close();
        return lista;
    }
    
    public ArrayList<Cliente> buscarPorNombre(String nombre) throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection con = Conexion.conectar();
        String query = "SELECT * FROM clientes WHERE nombre LIKE ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setString(1, "%" + nombre + "%");
        ResultSet resultado = preparar.executeQuery();
        while (resultado.next()) {
            lista.add(crearCliente(resultado));
        }
        con.close();
        return lista;
    }
    
    public Cliente buscarPorId(int id) throws SQLException {
        Cliente cliente = null;                                    
        Connection con = Conexion.conectar();
        String query = "SELECT * FROM clientes WHERE id = ?";      
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, id);                                    
        ResultSet resultado = preparar.executeQuery();
        if (resultado.next()) {                                    
            cliente = crearCliente(resultado);
        }
        con.close();
        return cliente;                                           
    }
    
    public Cliente buscarPorCuenta(int ncuenta) throws SQLException {
        Cliente cliente = null;
        Connection con = Conexion.conectar();
        String query = "SELECT * FROM clientes WHERE ncuenta = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, ncuenta);
        ResultSet resultado = preparar.executeQuery();
        if (resultado.next()) {
            cliente = crearCliente(resultado);
        }
        con.close();
        return cliente;
    }
    
    public boolean agregar(Cliente c) throws SQLException {
        Connection con = Conexion.conectar();
        String query = "INSERT INTO clientes (nombre, apellido, telefono, ciudad, ncuenta, saldo, estado) VALUES (?, ?, ?, ?, ?, ?, 0)";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setString(1, c.getNombre());
        preparar.setString(2, c.getApellido());
        preparar.setString(3, c.getTelefono());
        preparar.setString(4, c.getCiudad());
        preparar.setInt(5, c.getNcuenta());
        preparar.setDouble(6, c.getSaldo());
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
    
    public boolean editar(Cliente c) throws SQLException {
        Connection con = Conexion.conectar();
        String query = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, ciudad = ?, ncuenta = ? WHERE id = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setString(1, c.getNombre());
        preparar.setString(2, c.getApellido());
        preparar.setString(3, c.getTelefono());
        preparar.setString(4, c.getCiudad());
        preparar.setInt(5, c.getNcuenta());
        preparar.setInt(6, c.getId());
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
    
    public boolean eliminar(int id) throws SQLException {
        Connection con = Conexion.conectar();
        String query = "DELETE FROM clientes WHERE id = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, id);
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
    
    public boolean actualizarSaldo(int id, double nuevoSaldo) throws SQLException {
        Connection con = Conexion.conectar();
        String query = "UPDATE clientes SET saldo = ? WHERE id = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setDouble(1, nuevoSaldo);
        preparar.setInt(2, id);
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
    
    public boolean cambiarEstado(int id, int estado) throws SQLException {
        Connection con = Conexion.conectar();
        String query = "UPDATE clientes SET estado = ? WHERE id = ?";
        PreparedStatement preparar = con.prepareStatement(query);
        preparar.setInt(1, estado);
        preparar.setInt(2, id);
        int filas = preparar.executeUpdate();
        con.close();
        return filas > 0;
    }
    
    public int contarClientes() throws SQLException {
        int total = 0;
        Connection con = Conexion.conectar();
        String query = "SELECT COUNT(*) AS total FROM clientes";
        PreparedStatement preparar = con.prepareStatement(query);
        ResultSet resultado = preparar.executeQuery();
        if (resultado.next()) {
            total = resultado.getInt("total");
        }
        con.close();
        return total;
    }
    
    public double promedioSaldo() throws SQLException {
        double promedio = 0;
        Connection con = Conexion.conectar();
        String query = "SELECT AVG(saldo) AS promedio FROM clientes";
        PreparedStatement preparar = con.prepareStatement(query);
        ResultSet resultado = preparar.executeQuery();
        if (resultado.next()) {
            promedio = resultado.getDouble("promedio");
        }
        con.close();
        return promedio;
    }
}//fin de la clase
