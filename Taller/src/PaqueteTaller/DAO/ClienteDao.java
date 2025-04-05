package PaqueteTaller.DAO;
//import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            pstmt.setString(4, cliente.getTelefono());
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



        public void modificarCliente(Cliente cliente) {
        StringBuilder query = new StringBuilder("UPDATE clientes SET ");
        List<Object> params = new ArrayList<>();
        
        if (cliente.getNombre() != null) {
            query.append("Nombre = ?, ");
            params.add(cliente.getNombre());
        }
        if (cliente.getApellido() != null) {
            query.append("Apellido = ?, ");
            params.add(cliente.getApellido());
        }
        if (cliente.getTelefono() != null) {
            query.append("Telefono = ?, ");
            params.add(cliente.getTelefono());
        }
        if (cliente.getDireccion() != null) {
            query.append("Direccion = ?, ");
            params.add(cliente.getDireccion());
        }
        if (cliente.getEmail() != null) {
            query.append("Email = ?, ");
            params.add(cliente.getEmail());
        }
        if (cliente.getCuentaBancaria() != null) {
            query.append("Cuenta_bancaria = ?, ");
            params.add(cliente.getCuentaBancaria());
        }
        
        // Sirve para eliminar la ultima coma y espacio
        query.delete(query.length() - 2, query.length());
        
        query.append(" WHERE DNI = ?");
        params.add(cliente.getDNI());
        
        try (Connection conn = ConexionBD.conectar();
            PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " fila(s) actualizada(s)");
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente");
            e.printStackTrace();
        }
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

    
        
    public void verClienteByDni(String dni){
       
            String query = "SELECT * FROM clientes WHERE DNI = ?";
            
            try (Connection conn = ConexionBD.conectar();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                
                pstmt.setString(1, dni);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    System.out.println("\nDATOS DEL CLIENTE:\n");
                    System.out.println("DNI: " + rs.getString("DNI"));
                    System.out.println("Nombre: " + rs.getString("Nombre"));
                    System.out.println("Apellido: " + rs.getString("Apellido"));
                    System.out.println("Teléfono: " + rs.getString("Telefono"));
                    System.out.println("Dirección: " + rs.getString("Direccion"));
                    System.out.println("Email: " + rs.getString("Email"));
                    System.out.println("Cuenta Bancaria: " + rs.getString("Cuenta_bancaria"));
                    System.out.println("-------------------------\n");
                } else {
                    System.out.println("Error: No se encontró ningún cliente con ese DNI" );
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar cliente");
                e.printStackTrace();
            }
        
    }

}
