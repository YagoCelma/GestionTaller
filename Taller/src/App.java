import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int opcion;
        
        do{
            System.out.println("Bienvenido al menu del taller");
            System.out.println("Que quiere hacer?");
            System.out.println("1. Clientes");
            System.out.println("2. Coches");
            System.out.println("3. Empleados");
            System.out.println("4. Citas");
            System.out.println("5. Inventario");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:{
                    //Clientes
                }
                case 2:{
                    view.CocheView cocheView = new view.CocheView();
                    cocheView.menuCoche();
                    break;
                }
                case 3:{
                    view.EmpleadoView empleadoView = new view.EmpleadoView();
                    empleadoView.menuEmpleado();
                    break;
                }
                case 4:{
                    //Citas
                }
                case 5:{
                    view.InventarioView inventarioView = new view.InventarioView();
                    inventarioView.menuInventario();
                    break;
                }
            }

        }while(opcion != 6);

    }
}
