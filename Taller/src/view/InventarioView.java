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
                case 1->{

                    int numeroPedido;
                    boolean pedidoEncontrado;
                    boolean condicion;

                    do{
                        System.out.println("Indique el numero de pedido");
                        numeroPedido = sc.nextInt();
                        sc.nextLine();
                        pedidoEncontrado = inventarioDAO.encontrarPedido(numeroPedido);

                        if(pedidoEncontrado == true){
                            condicion = false;
                        }else{
                            condicion = true;
                            System.out.println("No se ha encontrado el numero de pedido");
                        }
                    }while(condicion == true);
                    inventarioDAO.añadirPedido(numeroPedido);
                }
                case 2->{
                    int numeroProducto = inventarioDAO.validarEntradaProducto();
                    inventarioDAO.mostrarProducto(numeroProducto);
                }
                case 3->{
                    int numeroProducto = inventarioDAO.validarEntradaProducto();
                    inventarioDAO.modificarProducto(numeroProducto);
                }
                case 4->{
                    int numeroProducto = inventarioDAO.validarEntradaProducto();
                    inventarioDAO.eliminarProducto(numeroProducto);
                }
                case 5-> inventarioDAO.listarInventario();
                case 6-> System.out.println("Saliendo del menú de modificación.");
                default-> System.out.println("No se ha seleccionado una opcion válida");
            }

        }while(opcion != 6);


    }

}
