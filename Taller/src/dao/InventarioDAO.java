package dao;

import java.util.*;
import dao.InventarioDAO;

public class InventarioDAO {

    Scanner sc = new Scanner(System.in);

    public void añadirPedido(int idPedido){

    }

    public boolean encontrarPedido(int idPedido){
        //Si lo ha encontrado que devuelva true
    }

    public boolean productoEncontrado(int idProducto){
        //Si lo ha encontrado que devuelva true
    }
    public void mostrarProducto(int idPedido){

    }
    public int validarEntradaProducto() {

        int numeroProducto;
        boolean productoEncontrado;
    
        InventarioDAO inventarioDAO = new InventarioDAO();
    
        do {
            System.out.println("Indique el numero de producto");
            numeroProducto = sc.nextInt();
            sc.nextLine();
            productoEncontrado = inventarioDAO.productoEncontrado(numeroProducto);
    
            if (productoEncontrado == true) {
                return numeroProducto;
            } else {
                System.out.println("No se ha encontrado el numero de producto");
            }
        } while (true);
    }

    public void modificarProducto(int numeroProducto){

    }

    public void eliminarProducto(int numeroProducto){

    }
    public void listarInventario(){
        
    }
}
