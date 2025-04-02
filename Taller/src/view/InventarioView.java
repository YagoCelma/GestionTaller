package view;

import java.util.*;

import dao.InventarioDAO;

public class InventarioView {

    private Scanner sc = new Scanner(System.in);
    private InventarioDAO inventarioDAO = new InventarioDAO();

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
                case 3->{
                    int numeroProducto = validarEntradaProducto();
                    inventarioDAO.modificarProducto(numeroProducto);
                }
                case 4->{
                    int numeroProducto = validarEntradaProducto();
                    inventarioDAO.eliminarProducto(numeroProducto);
                }
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
            productoEncontrado = inventarioDAO.productoEncontrado(numeroProducto);

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
    public void modificarProducto(){ //Hay que terminarlo, falta poner le menu de lo que quieres modificar y el switch

        int opcion;

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
            productoEncontrado = inventarioDAO.productoEncontrado(numeroProducto);
    
            if (productoEncontrado == true) {
                return numeroProducto;
            } else {
                System.out.println("No se ha encontrado el numero de producto");
            }
        } while (true);
    }

    public void mostrarProducto(int numeroProducto){
        
    }
}
