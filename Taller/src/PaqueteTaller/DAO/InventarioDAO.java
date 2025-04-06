package PaqueteTaller.DAO;

import java.sql.*;
import java.util.*;
import PaqueteTaller.DAO.InventarioDAO;
import PaqueteTaller.model.Inventario;

public class InventarioDAO {

    Scanner sc = new Scanner(System.in);
    Connection conexion = ConexionBD.conectar();


    public void añadirProducto(int numeroProducto, String nombreProducto, int cantidadProducto, double precioProducto){
        //Poner el auto-increment en el id del producto
        if(conexion != null){
           if(encontrarPedido(numeroProducto)){
            System.out.println("Error: Ya existe un producto con ese ID " + numeroProducto);
           }
            String query = "INSERT INTO inventario (id, nombre, cantidad, precio) VALUES (?, ?, ?, ?)";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, numeroProducto);
                stmt.setString(2, nombreProducto);
                stmt.setInt(3, cantidadProducto);
                stmt.setDouble(4, precioProducto);
                stmt.executeUpdate();
                System.out.println("Producto añadido correctamente a la base de datos.");
            } catch (SQLException e) {
                System.out.println("Error al añadir el producto: " + e.getMessage());
            }
        }
    }

    public void añadirPedido(int idPedido){

    }

    public boolean numeroRepetido(int idPedido){
        //Si lo ha encontrado que devuelva true
        if(conexion != null){
            String query = "SELECT * FROM inventario WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, idPedido);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    return true; // ID repetido
                } else {
                    return false; // ID no repetido
                }
            } catch (SQLException e) {
                System.out.println("Error al comprobar el ID: " + e.getMessage());
            }
        }else{
            System.out.println("Error: No hay conexión a la base de datos.");
        }
        return false;
    }

    public boolean encontrarPedido(int idPedido){
        //Que devuelva true si no lo encuentra
        if(conexion != null){
            String query = "SELECT * FROM inventario WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, idPedido);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    return true; // ID repetido
                } else {
                    return false; // ID no repetido
                }
            } catch (SQLException e) {
                System.out.println("Exito: numero no repetido");
            }
        }
        return false;
    }
    public Inventario productoPorID(int idProducto){
        //Devuelve el producto por ID
        if(conexion != null){
            String query = "SELECT * FROM inventario WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, idProducto);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    Inventario inventario = new Inventario();
                    inventario.setNumeroProducto(rs.getInt("id"));
                    inventario.setNombreObjeto(rs.getString("nombre"));
                    inventario.setCantidad(rs.getInt("cantidad"));
                    inventario.setPrecio(rs.getDouble("precio"));
                    return inventario;
                } else {
                    System.out.println("No se ha encontrado el producto con ID " + idProducto);
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar el producto: " + e.getMessage());
            }
        }
        return null;
    }

    public void eliminarProducto(int numeroProducto){

        if(conexion != null){
            String query = "DELETE FROM inventario WHERE id = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, numeroProducto);
                int filasAfectadas = stmt.executeUpdate();
                if(filasAfectadas > 0){
                    System.out.println("Producto con ID " + numeroProducto + " borrado correctamente.");
                } else {
                    System.out.println("Error: No se pudo borrar el producto con ID " + numeroProducto);
                }
            } catch (SQLException e) {
                System.out.println("Error al borrar el producto: " + e.getMessage());
            }
        }
    }
    public void listarInventario(){
        
        if(conexion != null){
            String query = "SELECT * FROM inventario";
            try(Statement stmt = conexion.createStatement()){
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Cantidad: " + rs.getInt("cantidad"));
                    System.out.println("Precio: " + rs.getDouble("precio"));
                    System.out.println("----------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al listar el inventario: " + e.getMessage());
            }
        }
        else{
            System.out.println("Error: No hay conexión a la base de datos.");
        }
    }
}