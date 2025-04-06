package PaqueteTaller.DAO;
import PaqueteTaller.model.Citas;
import java.sql.*;
import java.time.*;


public class CitasDao {


    Connection conexion = ConexionBD.conectar();

    public void crearCita(Citas cita) {
        //el id de la cita se asignará automáticamente después en la BD
        String query = "INSERT INTO citas (DNI, Asunto, Fecha, Matricula) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            
            stmt.setString(1, cita.getDNI_Cliente());
            stmt.setString(2, cita.getAsunto());
            stmt.setTimestamp(3, Timestamp.valueOf(cita.getFechaCita()));
            stmt.setString(4, cita.getMatricula());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cita creada correctamente.");
            } else {
                System.out.println("Error al crear la cita.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la cita: " + e.getMessage());
        }

        
    }
    

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
            String query = "UPDATE citas SET DNI = ? WHERE ID = ?";
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
        if(conexion != null){
            String query = "UPDATE citas SET fecha = ? WHERE ID = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setTimestamp(1, Timestamp.valueOf(fecha));
                stmt.setInt(2, ID);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cita modificada correctamente.");
                } else {
                    System.out.println("No se encontró ninguna cita con el ID proporcionado.");
                }
            }catch (SQLException e){
                System.out.println("Error al modificar la cita: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }
        
    }
    public void modificarCitaAsunto(int ID, String asunto){
        if(conexion != null){
            String query = "UPDATE citas SET asunto = ? WHERE ID = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, asunto);
                stmt.setInt(2, ID);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cita modificada correctamente.");
                } else {
                    System.out.println("No se encontró ninguna cita con el ID proporcionado.");
                }
            }catch (SQLException e){
                System.out.println("Error al modificar la cita: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }
        
    }



    //ver
    public void verTodasCitas(){
        if (conexion != null){
            String query = "SELECT * FROM citas ORDER BY fecha DESC";
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID"));
                    System.out.println("Fecha Cita: " + rs.getTimestamp("fecha"));
                    System.out.println("DNI Cliente: " + rs.getString("DNI"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    System.out.println("Matricula: " + rs.getString("matricula"));
                    System.out.println("----------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }

    }
    public void verCitasDni(String dni){
        if (conexion != null){
            String query = "SELECT * FROM citas WHERE DNI = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, dni);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID"));
                    System.out.println("Fecha Cita: " + rs.getTimestamp("fecha"));
                    System.out.println("DNI Cliente: " + rs.getString("DNI"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    System.out.println("Matricula: " + rs.getString("matricula"));
                    System.out.println("----------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }

    }
    public void verCitasMatricula(String matricula){
        if (conexion != null){
            String query = "SELECT * FROM citas WHERE matricula = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, matricula);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID"));
                    System.out.println("Fecha Cita: " + rs.getTimestamp("fecha"));
                    System.out.println("DNI Cliente: " + rs.getString("DNI"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    System.out.println("Matricula: " + rs.getString("matricula"));
                    System.out.println("----------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }

    }
    public void verCitasFechaDia(int año, int mes, int dia){
        if (conexion != null){
            String query = "SELECT * FROM citas WHERE YEAR(fecha) = ? AND MONTH(fecha) = ? AND DAY(fecha) = ? ORDER BY fecha DESC";  
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, año);
                stmt.setInt(2, mes);
                stmt.setInt(3, dia);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID"));
                    System.out.println("Fecha Cita: " + rs.getTimestamp("fecha"));
                    System.out.println("DNI Cliente: " + rs.getString("DNI"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    System.out.println("Matricula: " + rs.getString("matricula"));
                    System.out.println("----------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }

    }
    public void verCitasFechaAño(int año){
        if (conexion != null){
            String query = "SELECT * FROM citas WHERE YEAR(fecha) = ? ORDER BY fecha DESC";  
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, año);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID"));
                    System.out.println("Fecha Cita: " + rs.getTimestamp("fecha"));
                    System.out.println("DNI Cliente: " + rs.getString("DNI"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    System.out.println("Matricula: " + rs.getString("matricula"));
                    System.out.println("----------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }

    }

    public void verCitasFechaMes(int mes){
        if (conexion != null){
            String query = "SELECT * FROM citas WHERE MONTH(fecha) = ? ORDER BY fecha DESC";
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, mes);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID"));
                    System.out.println("Fecha Cita: " + rs.getTimestamp("fecha"));
                    System.out.println("DNI Cliente: " + rs.getString("DNI"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    System.out.println("Matricula: " + rs.getString("matricula"));
                    System.out.println("----------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }

    }

    public void verCitasAsunto(String asunto){
        if (conexion != null){
            String query = "SELECT * FROM citas WHERE asunto = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, asunto);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID"));
                    System.out.println("Fecha Cita: " + rs.getTimestamp("fecha"));
                    System.out.println("DNI Cliente: " + rs.getString("DNI"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    System.out.println("Matricula: " + rs.getString("matricula"));
                    System.out.println("----------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }

    }
    public void verCitasId(int ID){
        if (conexion != null){
            String query = "SELECT * FROM citas WHERE ID = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, ID);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID"));
                    System.out.println("Fecha Cita: " + rs.getTimestamp("fecha"));
                    System.out.println("DNI Cliente: " + rs.getString("DNI"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    System.out.println("Matricula: " + rs.getString("matricula"));
                    System.out.println("----------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }
    }

}

    
    

