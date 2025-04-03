package dao;

import java.sql.*;
import java.util.*;
import dao.InventarioDAO;
import model.Inventario;

public class InventarioDAO {

    Scanner sc = new Scanner(System.in);
        private Connection conexion;

    // Constructor que recibe la conexión
    public InventarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

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

    }

    public boolean productoEncontrado(int idProducto){
        //Si lo ha encontrado que devuelva true
    }
    public boolean encontrarPedido(int idPedido){
    }
    public Inventario productoPorID(int idProducto){
        //Devuelve el producto por ID
    }


    public void modificarProducto(int numeroProducto){

    }

    public void eliminarProducto(int numeroProducto){

    }
    public void listarInventario(){
        
    }
}
