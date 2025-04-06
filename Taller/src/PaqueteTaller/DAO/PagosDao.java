package PaqueteTaller.DAO;

import java.sql.*;

import PaqueteTaller.model.PagoReparacion;

public class PagosDao {

    Connection conexion = ConexionBD.conectar();

    public void insertarPago(PagoReparacion pagoReparacion) {
        //conexion a la base de datos
        String sql = "INSERT INTO Pagos (ID_reparacion, Precio, Concepto) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, pagoReparacion.getIdReparacion());
            stmt.setDouble(2, pagoReparacion.getPrecio());
            stmt.setString(3, pagoReparacion.getConcepto());
            stmt.executeUpdate();
            System.out.println("Pago insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el pago: " + e.getMessage());
        }
    }

    public void insertarPagoEmpleado(String idEmpleado, double precio, String concepto) {
        //conexion a la base de datos
        String sql = "INSERT INTO Gastos (ID_empleado, Precio, Concepto) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, idEmpleado);
            stmt.setDouble(2, precio);
            stmt.setString(3, concepto);
            stmt.executeUpdate();
            System.out.println("Pago insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el pago: " + e.getMessage());
        }
    }

    public void verIngresos() {
        //conexion a la base de datos
        String sql = "SELECT * FROM Pagos ORDER BY fecha_registro DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_reparacion") + ", Precio: " + rs.getDouble("Precio") + ", Concepto: " + rs.getString("Concepto") + ", Fecha: " + rs.getTimestamp("fecha_registro"));
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los ingresos: " + e.getMessage());
        }
    }

    public void verPagosEmpleados() {
        //conexion a la base de datos
        String sql = "SELECT * FROM Gastos ORDER BY fecha_registro DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("ID_empleado") + ", Precio: " + rs.getDouble("Precio") + ", Concepto: " + rs.getString("Concepto") + ", Fecha: " + rs.getTimestamp("fecha_registro"));
            System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los pagos de empleados: " + e.getMessage());
        }
    }
}
