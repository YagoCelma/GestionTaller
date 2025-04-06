package PaqueteTaller.DAO;

import java.sql.*;
import java.time.LocalDate;

import PaqueteTaller.model.Empleado;

public class EmpleadoDao {

    Connection conexion = ConexionBD.conectar();

    Empleado empleado;

    // Constructor que recibe la conexión
    public EmpleadoDao() {
    }

    public void verEmpleados() {
        if (conexion != null) {
            String query = "SELECT * FROM empleados";
            try (Statement stmt = conexion.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String direccion = rs.getString("direccion");
                    double salario = rs.getDouble("salario");
                    String email = rs.getString("email");
                    String puesto = rs.getString("puesto");
                    String fechaContratacion = rs.getObject("fecha_contratacion", LocalDate.class).toString();

                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Telefono: " + telefono + ", Direccion: " + direccion + ", Salario: " + salario);
                    
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados: " + e.getMessage());
            }
        }
    }

    public void verEmpleadoByDireccion(String direccion) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE direccion = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, direccion);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por dirección: " + e.getMessage());
            }
        }
        
    }

    public void verEmpleadoByID(String id) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE id = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                } else {
                    System.out.println("No se encontró el empleado con ID: " + id);
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener el empleado por ID: " + e.getMessage());
            }
        }
    }

    public void verEmpleadoByNombre(String nombre) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE nombre = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, nombre);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por nombre: " + e.getMessage());
            }
        }
    }
   
    public void verEmpleadoByTelefono(String telefono) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE telefono = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, telefono);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por teléfono: " + e.getMessage());
            }
        }
    }
   
    public void verEmpleadoBySalario(double salario) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE salario = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setDouble(1, salario);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por salario: " + e.getMessage());
            }
        }
    }
   
    public void verEmpleadoBySalarioMayorQue(double salario) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE salario > ? ORDER BY salario DESC";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setDouble(1, salario);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por salario mayor a: " + salario + e.getMessage());
            }
        }
    }
    
    public void verEmpleadoBySalarioMenorQue(double salario) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE salario < ? ORDER BY salario ASC";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setDouble(1, salario);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por salario menor a: " + salario + e.getMessage());
            }
        }
    }

    public void verEmpleadoBySalarioEntre(double salario1, double salario2) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE salario BETWEEN ? AND ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setDouble(1, salario1);
                stmt.setDouble(2, salario2);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario3 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario3 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por salario entre: " + e.getMessage());
            }
        }
    }
   
    public void verEmpleadoByPuesto(String puesto) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE puesto = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, puesto);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por puesto: " + e.getMessage());
            }
        }
    }
   
    public void verEmpleadosFechaContratacionDescendente() {
        if (conexion != null) {
            String query = "SELECT * FROM empleados ORDER BY fecha_contratacion DESC";
            try (Statement stmt = conexion.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por fecha de contratación descendente: " + e.getMessage());
            }
        }
    }

    public void verEmpleadoByEmail(String email) {
        if (conexion != null) {
            String query = "SELECT * FROM empleados WHERE email = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String id2 = rs.getString("id");
                    String nombre2 = rs.getString("nombre");
                    String telefono2 = rs.getString("telefono");
                    String direccion2 = rs.getString("direccion");
                    double salario2 = rs.getDouble("salario");
                    String puesto2 = rs.getString("puesto");
                    String email2 = rs.getString("email");
                    LocalDate fechaContratacion2 = rs.getObject("fecha_contratacion", LocalDate.class);
                    System.out.println("ID: " + id2 + ", Nombre: " + nombre2 + ", Telefono: " + telefono2 + ", Direccion: " +
                     direccion2 + ", Salario: " + salario2 + ", Puesto: " + puesto2 + ", Fecha de Contratación: " + fechaContratacion2); 
                    System.out.println("-------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por email: " + e.getMessage());
            }
        }
    }





    public boolean idRepetido(String id){
        //Que devuelva true si no lo encuentra
        if(conexion != null){
            String query = "SELECT * FROM empleados WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    return true; // ID repetido
                } else {
                    return false; // ID no repetido
                }
            } catch (SQLException e) {
                System.out.println("DNI correcto: no está repetido");
            }

        }
        return false;

    }
    
    
    
    public void añadirEmpleado(Empleado empleado){//Cambiar lo de ID por auto-increment cuando se hagan las tablas
        if(conexion != null){
            String query = "INSERT INTO empleados (id, nombre, telefono, direccion, email, puesto, fecha_contratacion, salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, empleado.getID());
                stmt.setString(2, empleado.getNombre());
                stmt.setString(3, empleado.getTelefono());
                stmt.setString(4, empleado.getDireccion());
                stmt.setString(5, empleado.getEmail());
                stmt.setString(6, empleado.getPuesto());
                stmt.setObject(7, empleado.getFechaContratacion(), java.sql.Types.DATE);
                stmt.setDouble(8, empleado.getSalario());

                int filasAfectadas = stmt.executeUpdate();
                if(filasAfectadas > 0){
                    System.out.println("Empleado añadido correctamente.");
                } else {
                    System.out.println("Error: No se pudo añadir el empleado.");
                }
            } catch (SQLException e) {
                System.out.println("Error al añadir el empleado: " + e.getMessage());
            }
        }

    }
    
    
    public void borrarEmpleado(String id){

        if(conexion != null){
            String query = "DELETE FROM empleados WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, id);
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
    
    
    public Empleado empleadoPorID(String id){

        if(conexion != null){
            String query = "SELECT * FROM empleados WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    empleado = new Empleado(rs.getString("id"), rs.getString("nombre"), 
                    rs.getString("telefono"), rs.getString("direccion"), rs.getDouble("salario"), rs.getString("email"),
                    rs.getString("puesto"), rs.getObject("fecha_contratacion", LocalDate.class));
                    return empleado;
                } else {
                    System.out.println("No se ha encontrado el empleado con ID " + id);
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar el empleado: " + e.getMessage());
            }
        }
        return null;
    }


    public void modificarEmpleado(String id, Empleado empleado){
        if(conexion != null){
            String query = "UPDATE empleados SET nombre = ?, telefono = ?, direccion = ?, salario = ?, email = ?, puesto = ?, fecha_contratacion = ?, id = ? WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, empleado.getNombre());
                stmt.setString(2, empleado.getTelefono());
                stmt.setString(3, empleado.getDireccion());
                stmt.setDouble(4, empleado.getSalario());
                stmt.setString(5, empleado.getEmail());
                stmt.setString(6, empleado.getPuesto());
                stmt.setObject(7, empleado.getFechaContratacion(), java.sql.Types.DATE);
                stmt.setString(8, empleado.getID());
                stmt.setString(9, id);
                

                int filasAfectadas = stmt.executeUpdate();
                if(filasAfectadas > 0){
                    System.out.println("Empleado con ID " + id + " modificado correctamente.");
                } else {
                    System.out.println("Error: No se pudo modificar el empleado con ID " + id);
                }
            } catch (SQLException e) {
                System.out.println("Error al modificar el empleado: " + e.getMessage());
            }
        }

    }
}
