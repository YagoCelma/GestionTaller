import java.util.Scanner;
import view.CocheView;
import view.EmpleadoView;
import view.InventarioView;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        CocheView cocheView = new CocheView();
        EmpleadoView empleadoView = new EmpleadoView();
        InventarioView inventarioView = new InventarioView();

        int opcion;
        
        do{
            System.out.println("Bienvenido al menu del taller");
            System.out.println("Que quiere hacer?");
            System.out.println("1. Clientes");
            System.out.println("2. Coches");
            System.out.println("3. Empleados");
            System.out.println("4. Citas");
            System.out.println("5. Inventario");
            System.out.println("6. Reparciones");
            System.out.println("7. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:{
                    //Clientes
                }
                case 2:{
                    cocheView.menuCoche();
                    break;
                }
                case 3:{
                    empleadoView.menuEmpleado();
                    break;
                }
                case 4:{
                    //Citas
                }
                case 5:{
                    inventarioView.menuInventario();
                    break;
                }
                case 6:{
                    
                }
            }

        }while(opcion != 6);

    }
}
