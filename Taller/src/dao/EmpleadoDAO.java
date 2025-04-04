package dao;

import java.sql.*;

import model.Empleado;

public class EmpleadoDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public EmpleadoDAO() {
    }

    public boolean idRepetido(int id){
        //Que devuelva true si no lo encuentra
        if(conexion != null){
            String query = "SELECT * FROM empleado WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    return true; // ID repetido
                } else {
                    return false; // ID no repetido
                }
            } catch (SQLException e) {
                System.out.println("Error al comprobar el ID: " + e.getMessage());
            }

        }
        return false;

    }
    public void añadirEmpleado(Empleado empleado){//Cambiar lo de ID por auto-increment cuando se hagan las tablas
        if(conexion != null){
            String query = "INSERT INTO empleado (id, nombre, telefono, direccion, salario) VALUES (?, ?, ?, ?, ?)";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, empleado.getID());
                stmt.setString(2, empleado.getNombre());
                stmt.setInt(3, empleado.getTelefono());
                stmt.setString(4, empleado.getDireccion());
                stmt.setDouble(5, empleado.getSalario());
                stmt.executeUpdate();
                System.out.println("Empleado añadido correctamente a la base de datos.");
            } catch (SQLException e) {
                System.out.println("Error al añadir el empleado: " + e.getMessage());
            }
        }

    }
    public void borrarEmpleado(int id){

        if(conexion != null){
            String query = "DELETE FROM empleado WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, id);
                int filasAfectadas = stmt.executeUpdate();
                if(filasAfectadas > 0){
                    System.out.println("Empleado con ID " + id + " borrado correctamente.");
                } else {
                    System.out.println("Error: No se pudo borrar el empleado con ID " + id);
                }
            } catch (SQLException e) {
                System.out.println("Error al borrar el empleado: " + e.getMessage());
            }
        }
    }
    public Empleado empleadoPorID(int id){

        if(conexion != null){
            String query = "SELECT * FROM empleado WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    return new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getInt("telefono"), rs.getString("direccion"), rs.getDouble("salario"));
                } else {
                    System.out.println("No se ha encontrado el empleado con ID " + id);
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar el empleado: " + e.getMessage());
            }
        }
        return null;
    }
}
