package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Coche; 

public class CocheDAO {
    /*Comprobar que la matricula no exiiste */
    /*Comprobar que el año del coche no sea negativo */
    Connection conexion = ConexionBD.conectar();

    public void añadirCoche(Coche coche){
        String query = "INSERT INTO coches (matricula, marca, modelo, año, dni_cliente) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, coche.getMatricula());
            pstmt.setString(2, coche.getMarca());
            pstmt.setString(3, coche.getModelo());
            pstmt.setInt(4, coche.getAño());
            pstmt.setString(5, coche.getDNI_Cliente());
            pstmt.executeUpdate();
            System.out.println("Coche añadido correctamente a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al añadir el coche: " + e.getMessage());
        }
    }

    public void borrarCoche(String matricula){
        
    }

    public boolean matriculaRepetida(String matricula){

    }

    public Coche cocheByMatricula(String matricula){
        
    }

}
