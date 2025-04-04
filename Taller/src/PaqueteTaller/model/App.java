package PaqueteTaller.model;
import PaqueteTaller.view.CitasView;
import PaqueteTaller.view.ClientesView;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        ClientesView clienteView = new ClientesView();
        CitasView citasView = new CitasView();

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

                case 3 -> citasView.menuCitas();
            }
        }while(opcion != 5);
    }
}
