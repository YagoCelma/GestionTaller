package view;

import java.util.*;
import model.Inventario;
import dao.InventarioDAO;

public class InventarioView {

    private Scanner sc = new Scanner(System.in);
    private InventarioDAO inventarioDAO = new InventarioDAO();
    private Inventario inventario;


    public void menuInventario(){

        int opcion;

        do{
            System.out.println("Menu del inventario");
            System.out.println("1. Añadir al inventario productos mediante ID del pedido");
            System.out.println("2. Buscar producto");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Listar todo el inventario");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1->añadirProducto();
                case 2->{
                    int numeroProducto = validarEntradaProducto();
                    mostrarProducto(numeroProducto);
                }
                case 3-> modificarProducto();
                case 4-> borrarProducto();
                case 5-> inventarioDAO.listarInventario();
                case 6-> System.out.println("Saliendo del menú de modificación.");
                default-> System.out.println("No se ha seleccionado una opcion válida");
            }

        }while(opcion != 6);
    }

    public void añadirProducto(){

        int numeroProducto;
        boolean numeroRepetido;
        boolean condicion;

        do{
            System.out.println("Indique el numero de producto");
            numeroProducto = sc.nextInt();
            sc.nextLine();
            numeroRepetido = inventarioDAO.numeroRepetido(numeroProducto);

            if(numeroRepetido == true){
                System.out.println("El numero de producto ya existe");
                condicion = true;
            }else{
                condicion = false;
            }
        }while(condicion == true);

        System.out.println("Nombre del producto");
        String nombreProducto = sc.nextLine();

        System.out.println("Cantidad del producto");
        int cantidadProducto = sc.nextInt();
        sc.nextLine();

        System.out.println("Precio del producto");
        double precioProducto = sc.nextDouble();
        sc.nextLine();

        inventarioDAO.añadirProducto(numeroProducto, nombreProducto, cantidadProducto, precioProducto);

        System.out.println("Producto añadido con exito");
    }

    public void borrarProducto(){

        int numeroProducto;
        boolean productoEncontrado;
        boolean condicion;

        do{
            System.out.println("Indique el numero de producto");
            numeroProducto = sc.nextInt();
            sc.nextLine();
            productoEncontrado = inventarioDAO.numeroRepetido(numeroProducto);

            if(productoEncontrado == true){
                condicion = false;
            }else{
                condicion = true;
                System.out.println("No se ha encontrado el numero de producto");
            }
        }while(condicion == true);

        inventarioDAO.eliminarProducto(numeroProducto);
        System.out.println("Producto eliminado con exito");
    }
    public void modificarProducto(){

        boolean condicion = false;
        int numeroProducto;
        boolean numeroRepetido;
        int opcion;

        System.out.println("Introduzca el numero del producto");

        do{
            numeroProducto = sc.nextInt();
            sc.nextLine();
            numeroRepetido = inventarioDAO.numeroRepetido(numeroProducto);

            if(numeroRepetido = true){
                condicion = true;
            }else{
                System.out.println("Error: Numero de producto no encontrado");
            }
        }while(condicion == false);

        Inventario inventario = inventarioDAO.productoPorID(numeroProducto);

        do{
            System.out.println("Que quieres modificar?");
            System.out.println("1. ID");
            System.out.println("2. Nombre");
            System.out.println("3. Cantidad");
            System.out.println("4. Precio");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1->{
                    System.out.println("Indique el nuevo ID del producto");
                    int nuevoID = sc.nextInt();
                    sc.nextLine();
                    inventario.setNumeroProducto(nuevoID);
                    System.out.println("ID del producto modificado con exito");
                }
                case 2->{
                    System.out.println("Indique el nuevo nombre del producto");
                    String nuevoNombre = sc.nextLine();
                    inventario.setNombreObjeto(nuevoNombre);
                    System.out.println("Nombre del producto modificado con exito");
                }
                case 3->{
                    System.out.println("Indique la nueva cantidad del producto");
                    int nuevaCantidad = sc.nextInt();
                    sc.nextLine();
                    inventario.setCantidad(nuevaCantidad);
                    System.out.println("Cantidad del producto modificada con exito");
                }
                case 4->{
                    System.out.println("Indique el nuevo precio del producto");
                    double nuevoPrecio = sc.nextDouble();
                    sc.nextLine();
                    inventario.setPrecio(nuevoPrecio);
                    System.out.println("Precio del producto modificado con exito");
                }
                case 5-> System.out.println("Saliendo del menú de modificación.");
                default-> System.out.println("No se ha seleccionado una opcion válida");
            }
        }while(opcion != 5);

        
    }
    public void listarInventario(){
        inventarioDAO.listarInventario();
    }

    public int validarEntradaProducto() {

        int numeroProducto;
        boolean productoEncontrado;
    
        InventarioDAO inventarioDAO = new InventarioDAO();
    
        do {
            System.out.println("Indique el numero de producto");
            numeroProducto = sc.nextInt();
            sc.nextLine();
            productoEncontrado = inventarioDAO.numeroRepetido(numeroProducto);
    
            if (productoEncontrado == true) {
                return numeroProducto;
            } else {
                System.out.println("No se ha encontrado el numero de producto");
            }
        } while (true);
    }

    private void mostrarProducto(int numeroProducto) {
        Inventario inventario = inventarioDAO.productoPorID(numeroProducto);
        if (inventario != null) {
            System.out.println("Información del producto:");
            System.out.println("ID: " + inventario.getNumeroProducto());
            System.out.println("Nombre: " + inventario.getNombreObjeto());
            System.out.println("Precio: " + inventario.getPrecio());
            System.out.println("Cantidad en stock: " + inventario.getCantidad());
        } else {
            System.out.println("No se encontró ningún producto con el ID " + numeroProducto);
        }
    }
}
