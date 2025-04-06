package PaqueteTaller.DAO;
import PaqueteTaller.model.Reparaciones;

import java.sql.*;
import java.time.*;

public class ReparacionesDao {


    Connection conexion = ConexionBD.conectar();

    public void crearReparacion(Reparaciones reparacion){

        if(conexion != null){
            String query = "INSERT INTO Reparaciones ( Nombre_reparacion, Fecha_inicio, Fecha_final, Asunto, Horas, ID_cita, Acabado   ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                
                stmt.setString(1, reparacion.getNombreReparacion());
                stmt.setObject(2, reparacion.getFechaInicio(), java.sql.Types.TIMESTAMP);
                stmt.setObject(3, reparacion.getFechaFinal(), java.sql.Types.TIMESTAMP);
                stmt.setString(4, reparacion.getAsunto());
                stmt.setDouble(5, reparacion.getHoras());
                stmt.setInt(6, reparacion.getIdCita());
                stmt.setBoolean(7, reparacion.getAcabado());
                
                

                int rowsAffected = stmt.executeUpdate();
                //System.out.println("Éxito al añadir la reparación");
            } catch (Exception e) {
                System.out.println("Error al añadir la reparación " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void eliminarReparacion(int idReparacion){

        if(conexion != null){
            String query = "DELETE FROM reparaciones WHERE ID = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, idReparacion);
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Éxito al eliminar la reparación");
            } catch (Exception e) {
                System.out.println("Error al eliminar la reparación " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }

    }
    
    public void mostrarReparacionById(int idReparacion){

        if(conexion != null){
            String query = "SELECT * FROM reparaciones WHERE idReparacion = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, idReparacion);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID Reparación: " + rs.getInt("idReparacion"));
                    System.out.println("Nombre Reparación: " + rs.getString("nombreReparacion"));
                    System.out.println("ID Cita: " + rs.getInt("idCita"));
                    System.out.println("Fecha Inicio: " + rs.getTimestamp("fechaInicio"));
                    System.out.println("Fecha Final: " + rs.getTimestamp("fechaFinal"));
                    System.out.println("Acabado: " + rs.getBoolean("acabado"));
                    System.out.println("Horas: " + rs.getDouble("horas"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar la reparación " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }

    }

    public boolean comprobarReparacion(int idReparacion){

        boolean existe = false;
        if(conexion != null){
            String query = "SELECT * FROM reparaciones WHERE idReparacion = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, idReparacion);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    existe = true; // La reparación existe
                    System.out.println("La reparación existe en la base de datos.");
                }else{
                    existe = false;
                }
            } catch (Exception e) {
                System.out.println("Error al comprobar la reparación " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
        return existe;
    }

    //sets

    public void setNombreReparacion(int idReparacion, String nombreReparacion){

        if (conexion != null){
            String query = "UPDATE reparaciones SET nombreReparacion = ? WHERE idReparacion = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, nombreReparacion);
                stmt.setInt(2, idReparacion);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Nombre de la reparación actualizado correctamente.");
                } else {
                    System.out.println("No se encontró la reparación con el ID especificado.");
                }
            } catch (Exception e) {
                System.out.println("Error al actualizar el nombre de la reparación: " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }
    public void setIdCita(int idReparacion,int idCita){

        if (conexion != null){
            String query = "UPDATE reparaciones SET idCita = ? WHERE idReparacion = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, idCita);
                stmt.setInt(2, idReparacion);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("ID de la cita actualizado correctamente.");
                } else {
                    System.out.println("No se encontró la reparación con el ID especificado.");
                }
            } catch (Exception e) {
                System.out.println("Error al actualizar el ID de la cita: " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }

    }
    public void setFechaInicio(int idReparacion,LocalDateTime fechaInicio){
        
        if (conexion != null){
            String query = "UPDATE reparaciones SET fechaInicio = ? WHERE idReparacion = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setObject(1, fechaInicio, java.sql.Types.TIMESTAMP);
                stmt.setInt(2, idReparacion);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Fecha de inicio actualizada correctamente.");
                } else {
                    System.out.println("No se encontró la reparación con el ID especificado.");
                }
            } catch (Exception e) {
                System.out.println("Error al actualizar la fecha de inicio: " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }
    public void setFechaFinal(int idReparacion,LocalDateTime fechaFinal){
        
        if (conexion != null){
            String query = "UPDATE reparaciones SET fechaFinal = ? WHERE idReparacion = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setObject(1, fechaFinal, java.sql.Types.TIMESTAMP);
                stmt.setInt(2, idReparacion);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Fecha final actualizada correctamente.");
                } else {
                    System.out.println("No se encontró la reparación con el ID especificado.");
                }
            } catch (Exception e) {
                System.out.println("Error al actualizar la fecha final: " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }
    public void setAcabado(int idReparacion,boolean acabado){
        
            if (conexion != null){
                String query = "UPDATE reparaciones SET acabado = ? WHERE idReparacion = ?";
                try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                    stmt.setBoolean(1, acabado);
                    stmt.setInt(2, idReparacion);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Estado de acabado actualizado correctamente.");
                    } else {
                        System.out.println("No se encontró la reparación con el ID especificado.");
                    }
                } catch (Exception e) {
                    System.out.println("Error al actualizar el estado de acabado: " + e.getMessage());
                }
            }else{
                System.out.println("Error al conectar a la base de datos");
            }
    }
    public void setHoras(int idReparacion,Double horas){
        
            if (conexion != null){
                String query = "UPDATE reparaciones SET horas = ? WHERE idReparacion = ?";
                try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                    stmt.setDouble(1, horas);
                    stmt.setInt(2, idReparacion);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Horas actualizadas correctamente.");
                    } else {
                        System.out.println("No se encontró la reparación con el ID especificado.");
                    }
                } catch (Exception e) {
                    System.out.println("Error al actualizar las horas: " + e.getMessage());
                }
            }else{
                System.out.println("Error al conectar a la base de datos");
            }
    }
    public void setAsunto(int idReparacion,String asunto){
        
        if (conexion != null){
            String query = "UPDATE reparaciones SET asunto = ? WHERE idReparacion = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, asunto);
                stmt.setInt(2, idReparacion);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Asunto actualizado correctamente.");
                } else {
                    System.out.println("No se encontró la reparación con el ID especificado.");
                }
            } catch (Exception e) {
                System.out.println("Error al actualizar el asunto: " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }

    //este metodo enlaza en una tabla auxiliar los id de empleados y su id de reparacion
    public void añadirEmpleado(int idReparacion,String idEmpleados){
            
            if (conexion != null){
                String query = "INSERT INTO Empleados_Reparaciones (ID_empleado, ID_reparacion) VALUES (?, ?)";
                try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                    stmt.setString(1, idEmpleados);
                    stmt.setInt(2, idReparacion);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Empleado añadido correctamente.");
                    } else {
                        System.out.println("No se encontró la reparación con el ID especificado.");
                    }
                } catch (Exception e) {
                    System.out.println("Error al añadir el empleado: " + e.getMessage());
                }
            }else{
                System.out.println("Error al conectar a la base de datos");
            }
        
    }
    public void eliminarEmpleado(int idReparacion,String idEmpleados){

    }


    public void añadirProducto(String producto, int cantidad, Double precio, int reparacionId){

    }

    public void mostrarReparaciones(){

        if(conexion != null){
            String query = "SELECT * FROM Reparaciones";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID Reparación: " + rs.getInt("ID"));
                    System.out.println("Nombre Reparación: " + rs.getString("Nombre_reparacion"));
                    System.out.println("ID_cita: " + rs.getInt("ID_Cita"));
                    System.out.println("Fecha Inicio: " + rs.getTimestamp("Fecha_inicio"));
                    System.out.println("Fecha Final: " + rs.getTimestamp("Fecha_final"));
                    System.out.println("Acabado: " + rs.getBoolean("acabado"));
                    System.out.println("Horas: " + rs.getDouble("horas"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                    
                    System.out.println("-------------------------");
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar las reparaciones " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void mostrarReparacionByEmpleado(String idEmpleado){

        if(conexion != null){
            String query = "SELECT e.ID, e.nombre, e.puesto, r.ID AS reparacion_id, r.Nombre_reparacion, " +
              "r.Fecha_inicio, r.Fecha_final, r.Acabado " +
              "FROM Empleados e " +
              "INNER JOIN Empleados_Reparaciones er ON e.ID = er.ID_empleado " +
              "INNER JOIN Reparaciones r ON er.ID_reparacion = r.ID " +
              "WHERE er.ID_empleado = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, idEmpleado);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID Empleado: " + rs.getString("ID_empleado"));
                    System.out.println("Nombre Empleado: " + rs.getString("nombre"));
                    System.out.println("Puesto: " + rs.getString("puesto"));
                    System.out.println("ID Reparacion " + rs.getString("ID_reparacion"));
                    System.out.println("Nombre Reparación: " + rs.getString("Nombre_reparacion"));
                    
                    
                    System.out.println("Fecha Inicio: " + rs.getTimestamp("fechaInicio"));
                    System.out.println("Fecha Final: " + rs.getTimestamp("fechaFinal"));
                    
                    
                    
                    
                    System.out.println("Acabado: " + rs.getBoolean("acabado"));
                    System.out.println("Horas: " + rs.getDouble("horas"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar las reparaciones por trabajador " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void mostrarReparacionActiva(){
        if(conexion != null){
            String query = "SELECT * FROM reparaciones WHERE acabado = false";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID Reparación: " + rs.getInt("ID"));
                    System.out.println("Nombre Reparación: " + rs.getString("Nombre_reparacion"));
                    System.out.println("ID Cita: " + rs.getInt("ID_cita"));
                    System.out.println("Fecha Inicio: " + rs.getTimestamp("Fecha_inicio"));
                    System.out.println("Fecha Final: " + rs.getTimestamp("Fecha_final"));
                    System.out.println("Acabado: " + rs.getBoolean("acabado"));
                    System.out.println("Horas: " + rs.getDouble("horas"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar las reparaciones activas " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void mostrarReparacionByFechaInicio(LocalDateTime fechaInicio){
        
        if(conexion != null){
            String query = "SELECT * FROM reparaciones WHERE Fecha_inicio = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setObject(1, fechaInicio, java.sql.Types.TIMESTAMP);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID Reparación: " + rs.getInt("ID"));
                    System.out.println("Nombre Reparación: " + rs.getString("Nombre_reparacion"));
                    System.out.println("ID Cita: " + rs.getInt("ID_cita"));
                    System.out.println("Fecha Inicio: " + rs.getTimestamp("Fecha_inicio"));
                    System.out.println("Fecha Final: " + rs.getTimestamp("Fecha_final"));
                    System.out.println("Acabado: " + rs.getBoolean("acabado"));
                    System.out.println("Horas: " + rs.getDouble("horas"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar las reparaciones por fecha de inicio " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void mostrarReparacionByFechaFinal(LocalDateTime fechaFinal){
        if(conexion != null){
            String query = "SELECT * FROM reparaciones WHERE Fecha_final = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setObject(1, fechaFinal, java.sql.Types.TIMESTAMP);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID Reparación: " + rs.getInt("ID"));
                    System.out.println("Nombre Reparación: " + rs.getString("Nombre_reparacion"));
                    System.out.println("ID Cita: " + rs.getInt("ID_cita"));
                    System.out.println("Fecha Inicio: " + rs.getTimestamp("Fecha_inicio"));
                    System.out.println("Fecha Final: " + rs.getTimestamp("Fecha_final"));
                    System.out.println("Acabado: " + rs.getBoolean("acabado"));
                    System.out.println("Horas: " + rs.getDouble("horas"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar las reparaciones por fecha final " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void mostrarReparacionByFechaReciente(LocalDateTime fechaReciente){
        
        if(conexion != null){
            String query = "SELECT * FROM reparaciones WHERE Fecha_inicio >= ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setObject(1, fechaReciente, java.sql.Types.TIMESTAMP);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID Reparación: " + rs.getInt("ID"));
                    System.out.println("Nombre Reparación: " + rs.getString("Nombre_reparacion"));
                    System.out.println("ID Cita: " + rs.getInt("ID_cita"));
                    System.out.println("Fecha Inicio: " + rs.getTimestamp("Fecha_inicio"));
                    System.out.println("Fecha Final: " + rs.getTimestamp("Fecha_final"));
                    System.out.println("Acabado: " + rs.getBoolean("acabado"));
                    System.out.println("Horas: " + rs.getDouble("horas"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar las reparaciones por fecha reciente " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void mostrarReparacionByMatricula(String matricula){
        
        if(conexion != null){
            String query = "SELECT * FROM reparaciones WHERE matricula = ?";
            // Cambia "matricula" por el nombre correcto de la columna en tu tabla de reparaciones)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, matricula);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("ID Reparación: " + rs.getInt("ID"));
                    System.out.println("Nombre Reparación: " + rs.getString("Nombre_reparacion"));
                    System.out.println("ID Cita: " + rs.getInt("ID_cita"));
                    System.out.println("Fecha Inicio: " + rs.getTimestamp("Fecha_inicio"));
                    System.out.println("Fecha Final: " + rs.getTimestamp("Fecha_final"));
                    System.out.println("Acabado: " + rs.getBoolean("acabado"));
                    System.out.println("Horas: " + rs.getDouble("horas"));
                    System.out.println("Asunto: " + rs.getString("asunto"));
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar las reparaciones por matrícula " + e.getMessage());
            }
        }else{
            System.out.println("Error al conectar a la base de datos");
        }
    }


    //gets
    public int getIdReparacion(){
        int idReparacion=0;
        return idReparacion;
    }

    public LocalDateTime getFechaInicioReparacion(int idReparacion){
        LocalDateTime fecha = null;
        return fecha;
    }

    public LocalDateTime getFechaFinalReparacion(int idReparacion){
        LocalDateTime fecha = null;
        return fecha;
    }

    public Double getHoras(int idReparacion){
        Double horas=null;
        return horas;
    }

    public String getNombreReparacion(int idReparacion){
        String nombreReparacion = "nombre";
        return nombreReparacion;

    }
}
