package PaqueteTaller;

import PaqueteTaller.view.*;
import PaqueteTaller.model.*;


import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        ClientesView clienteView = new ClientesView();
        CitasView citasView = new CitasView();
        CocheView cocheView = new CocheView();
        EmpleadoView emlpeadoView = new EmpleadoView();
        ReparacionesView reparacionView = new ReparacionesView();
        PagosView pagosView = new PagosView();


        int opcion;

        do{
            System.out.println("\n Menu Gestion Taller");
            System.out.println("1. Cliente");
            System.out.println("2. Coche");
            System.out.println("3. Citas");
            System.out.println("4. Empleado");
            System.out.println("5. Reparaciones");
            System.out.println("6. Pedidos");
            System.out.println("7. Inventario");
            System.out.println("8. Pagos");


            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1-> clienteView.menuCliente();
                case 2 -> cocheView.menuCoche();
                case 3 -> citasView.menuCitas();
                case 4 -> emlpeadoView.menuEmpleado();
                case 5 -> reparacionView.menuReparaciones();
                case 6 -> {}
                case 7 -> {}
                case 8 -> pagosView.menuPagos();
            }
        }while(opcion != 5);
    }
}
