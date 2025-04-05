package PaqueteTaller.DAO;
//import java.io.IOException;
import java.sql.*;

import PaqueteTaller.model.Cliente;

public class ClienteDao{

    Connection conexion = ConexionBD.conectar();

    public void insertarCliente(Cliente cliente) {
        String query = "INSERT INTO clientes (DNI, Nombre, Apellido, Telefono, Direccion, Email, Cuenta_bancaria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            // Usar los valores del objeto cliente
            pstmt.setString(1, cliente.getDNI());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getApellido());
            pstmt.setInt(4, cliente.getTelefono());
            pstmt.setString(5, cliente.getDireccion());
            pstmt.setString(6, cliente.getEmail());
            pstmt.setString(7, cliente.getCuentaBancaria());
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Éxito al añadir cliente"); 

            System.out.println(rowsAffected + " fila(s) insertada(s)");
        } catch (SQLException e) {
            System.out.println("Error al añadir cliente"); 
            e.printStackTrace();
        }
        // La conexión se cierra automáticamente al salir del try
    }


    public void eliminarCliente (String DNI)  {
        String query = "DELETE FROM Clientes WHERE DNI = ?";
        
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(query))  {
            
            pstmt.setString(1, DNI);
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas == 0) {
                System.out.println("No se encontró un cliente con DNI: " + DNI);
            }
            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }


    }



    public void modificarCliente (Cliente cliente){

    }



    public boolean dniRepetido (String dni){
        String query = "SELECT COUNT(*) FROM clientes WHERE dni = ?";
        
        try (Connection conn = ConexionBD.conectar();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, dni); // Asignamos el DNI como parámetro
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Si count > 0, existe el DNI (true), sino false
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // En producción, considera lanzar una excepción personalizada o manejarla mejor
        }
        
        return false; // Si hay error, asumimos que no existe
    }

    
        
    public Cliente getClienteByDni(String dni){
       // Cliente cliente = new Cliente();
        
        //hacer los selects
        return null;
    }

}
