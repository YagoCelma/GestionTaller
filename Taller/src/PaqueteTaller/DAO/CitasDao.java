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

    }

    //Modificar
    public void modificarCitaMatricula(int ID, String matricula){

    }
    public void modificarCitaDni(int ID, String dni){
        
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
