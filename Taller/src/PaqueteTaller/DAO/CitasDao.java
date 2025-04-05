package PaqueteTaller.DAO;
import java.sql.*;
import java.time.LocalDateTime;


public class CitasDao {


    Connection conexion = ConexionBD.conectar();
    

    //sobra
    public void citasByDni(String dni){
        if (conexion != null) {
                // Consulta SQL para obtener todos los clientes
                String query = "SELECT * FROM individual WHERE DNI = " + dni ; 
                System.out.println("Conexion establecida otra vez");
                try (Statement stmt = conexion.createStatement(); 
               ResultSet rs = stmt.executeQuery(query)) {
                // Iterar sobre los resultados
                while (rs.next()) {
                System.out.println("ID: " + 
               rs.getInt("cust_id"));
                System.out.println("Nombre: " + 
               rs.getString("fname"));
                System.out.println("Apellido: " + 
               rs.getString("lname"));
                System.out.println("Fecha de Nacimiento: " + 
                rs.getDate("birth_date"));
                System.out.println("----------------------");
                }
                } catch (SQLException e) {
                System.out.println("Error al realizar la consulta: " 
               + e.getMessage());
                }
                }
    }

    public void eliminarCita(int ID){

        if (conexion != null) {
            String query = "DELETE FROM citas WHERE ID = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, ID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cita eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna cita con el ID proporcionado.");
            }
            } catch (SQLException e) {
            System.out.println("Error al eliminar la cita: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }
    }

    //Modificar
    public void modificarCitaMatricula(int ID, String matricula){

        if (conexion != null) {
            String query = "UPDATE citas SET matricula = ? WHERE ID = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, matricula);
                stmt.setInt(2, ID);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cita modificada correctamente.");
                } else {
                    System.out.println("No se encontró ninguna cita con el ID proporcionado.");
                }
            } catch (SQLException e) {
                System.out.println("Error al modificar la cita: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }
    }
    public void modificarCitaDni(int ID, String dni){
        
        if(conexion != null){
            String query = "UPDATE citas SET DNI_Cliente = ? WHERE ID = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, dni);
                stmt.setInt(2, ID);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cita modificada correctamente.");
                } else {
                    System.out.println("No se encontró ninguna cita con el ID proporcionado.");
                }
            } catch (SQLException e) {
                System.out.println("Error al modificar la cita: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }
    }
    public void modificarCitaFecha(int ID, LocalDateTime fecha){
        
        
    }
    public void modificarCitaAsunto(int ID, String asunto){
        
    }



    //ver
    public void verCitasDni(String dni){

    }
    public void verCitasMatricula(String matricula){

    }
    public void verCitasFecha(LocalDateTime fecha){

    }
    public void verCitasAsunto(String asunto){

    }
    public void verCitasId(int ID){

    }

    
    
}
