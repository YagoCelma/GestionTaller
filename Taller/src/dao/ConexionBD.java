package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // URL de conexión a la base de datos MySQL
    public static final String URL = 
   "jdbc:mysql://localhost:3306/gestiontaller"; // Cambia el nombre de la base de datos
   
    public static final String USUARIO = "yago"; // Nombre de usuario de MySQL
   
    public  static final String CONTRASENA = "52534019y"; //  Contraseña del usuario de MySQL

    public static Connection conectar() {
    try {
    // Establecer la conexión con la base de datos
    return DriverManager.getConnection(ConexionBD.URL, ConexionBD.USUARIO, ConexionBD.CONTRASENA);
    } catch (SQLException e) {
    System.out.println("Error al conectar a la base de datos: " + e.getMessage());
    return null;
    }
}
   
}
