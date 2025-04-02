package dao;

import java.sql.*;
import model.Coche;

public class CocheDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public CocheDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void añadirCoche(String matricula, String marca, String modelo, int año, String dni_cliente) {
        if (conexion != null) {
            if (matriculaRepetida(matricula)) {
                System.out.println("Error: Ya existe un coche con esa matrícula " + matricula);
                return;
            }

            String query = "INSERT INTO coches (matricula, marca, modelo, año, dni_cliente) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, matricula);
                stmt.setString(2, marca);
                stmt.setString(3, modelo);
                stmt.setInt(4, año);
                stmt.setString(5, dni_cliente);
                stmt.executeUpdate();
                System.out.println("Coche añadido correctamente a la base de datos.");
            } catch (SQLException e) {
                System.err.println("Error al añadir el coche: " + e.getMessage());
            }
        }
    }

    public void borrarCoche(String matricula) {
        if (conexion != null) {
            if (!matriculaRepetida(matricula)) {
                System.out.println("Error: La matrícula " + matricula + " no pertenece a ningún coche.");
                return;
            }
            String query = "DELETE FROM coches WHERE matricula = ?";

            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, matricula);
                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Coche con matrícula " + matricula + " borrado correctamente.");
                } else {
                    System.out.println("Error: No se pudo borrar el coche con matrícula " + matricula);
                }
            } catch (SQLException e) {
                System.out.println("Error al borrar el coche: " + e.getMessage());
            }
        }
    }

    public boolean matriculaRepetida(String matricula) {
        String query = "SELECT COUNT(*) FROM coches WHERE matricula = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al comprobar la matrícula: " + e.getMessage());
        }
        return false;
    }

    public Coche cocheByMatricula(String matricula) {
        Coche coche = null;
        if (conexion != null) {
            String query = "SELECT matricula, marca, modelo, año, dni_cliente FROM coches WHERE matricula = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, matricula);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    coche = new Coche(
                            rs.getString("matricula"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getInt("año"),
                            rs.getString("dni_cliente")
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al buscar el coche por matrícula: " + e.getMessage());
            }
        }
        return coche;
    }
}
