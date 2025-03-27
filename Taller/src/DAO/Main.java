
import java.sql.*;

public class Main {
    public static void main(String[] args){

        System.out.println("Hola");
        Connection conexion = ConexionBD.conectar();
        System.out.println("2");
        if (conexion != null) {
            System.out.println("Conexión establecida correctamente.");
            } else {
            System.out.println("No se pudo establecer la conexión.");
            }


            if (conexion != null) {
                // Consulta SQL para obtener todos los clientes
                String query = "SELECT * FROM individual"; 
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
                
            
        
               


        System.out.println("Hola");
    }
}


