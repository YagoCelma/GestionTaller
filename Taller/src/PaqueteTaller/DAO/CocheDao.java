package PaqueteTaller.DAO;

import java.sql.*;
import PaqueteTaller.model.Coche;

public class CocheDao {

    Connection conexion = ConexionBD.conectar();

    // Constructor que recibe la conexión
    public CocheDao() {
    }

    public void añadirCoche(String matricula, String marca, String modelo, int año, String dni_cliente) {
        if (conexion != null) {
            if (matriculaRepetida(matricula)) {
                System.out.println("Error: Ya existe un coche con esa matrícula " + matricula);
                return;
            }

            String query = "INSERT INTO Coches (matricula, marca, modelo, año, dni_cliente) VALUES (?, ?, ?, ?, ?)";

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
        if (conexion == null) {
            System.err.println("Error: No hay conexión a la base de datos.");
            return false;
        }
    
        // Usar try-with-resources para auto-cerrar recursos
        try (PreparedStatement stmt = conexion.prepareStatement(
                "SELECT 1 FROM coches WHERE matricula = ? LIMIT 1")) {
            
            stmt.setString(1, matricula);
            
            try (ResultSet rs = stmt.executeQuery()) {
                // Si hay al menos un resultado, la matrícula existe
                return rs.next();
            }
            
        } catch (SQLException e) {
            System.err.println("Error al comprobar la matrícula: " + e.getMessage());
            return false;
        }

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

    public void verCoches() {
        if (conexion != null) {
            String query = "SELECT * FROM coches";
            try (Statement stmt = conexion.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println("Matrícula: " + rs.getString("matricula") +
                            ", Marca: " + rs.getString("marca") +
                            ", Modelo: " + rs.getString("modelo") +
                            ", Año: " + rs.getInt("año") +
                            ", DNI Cliente: " + rs.getString("dni_cliente"));
                }
            } catch (SQLException e) {
                System.err.println("Error al mostrar los coches: " + e.getMessage());
            }
        }
    }

    public void verCocheByDNI(String dni_cliente) {
        if (conexion != null) {
            String query = "SELECT * FROM coches WHERE dni_cliente = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, dni_cliente);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Matrícula: " + rs.getString("matricula") +
                            ", Marca: " + rs.getString("marca") +
                            ", Modelo: " + rs.getString("modelo") +
                            ", Año: " + rs.getInt("año"));
                }
            } catch (SQLException e) {
                System.err.println("Error al mostrar los coches por DNI: " + e.getMessage());
            }
        }
    }
    public void verCocheByMatricula(String matricula) {
        if (conexion != null) {
            String query = "SELECT * FROM coches WHERE matricula = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, matricula);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Matrícula: " + rs.getString("matricula") +
                            ", Marca: " + rs.getString("marca") +
                            ", Modelo: " + rs.getString("modelo") +
                            ", Año: " + rs.getInt("año") +
                            ", DNI Cliente: " + rs.getString("dni_cliente"));
                } else {
                    System.out.println("No se encontró el coche con matrícula: " + matricula);
                }
            } catch (SQLException e) {
                System.err.println("Error al mostrar el coche por matrícula: " + e.getMessage());
            }
        }
    }
    public void verCocheByMarca(String marca) {
        if (conexion != null) {
            String query = "SELECT * FROM coches WHERE marca = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, marca);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Matrícula: " + rs.getString("matricula") +
                            ", Marca: " + rs.getString("marca") +
                            ", Modelo: " + rs.getString("modelo") +
                            ", Año: " + rs.getInt("año") +
                            ", DNI Cliente: " + rs.getString("dni_cliente"));
                }
            } catch (SQLException e) {
                System.err.println("Error al mostrar los coches por marca: " + e.getMessage());
            }
        }
    }
    public void verCocheByModelo(String modelo) {
        if (conexion != null) {
            String query = "SELECT * FROM coches WHERE modelo = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, modelo);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Matrícula: " + rs.getString("matricula") +
                            ", Marca: " + rs.getString("marca") +
                            ", Modelo: " + rs.getString("modelo") +
                            ", Año: " + rs.getInt("año") +
                            ", DNI Cliente: " + rs.getString("dni_cliente"));
                }
            } catch (SQLException e) {
                System.err.println("Error al mostrar los coches por modelo: " + e.getMessage());
            }
        }
    }
}