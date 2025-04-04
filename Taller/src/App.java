import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Taller taller = new Taller();

        int opcion;

        do{
            System.out.println("\n Menu Gestion Taller");
            System.out.println("1. Cliente");
            System.out.println("2. Coche");
            System.out.println("3. Citas");
            System.out.println("4. Pedidos");
            System.out.println("5. Empleado");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1-> taller.menuCliente();
                case 3 -> 
                case 4-> taller.pedidos();
            }
        }while(opcion != 5);
    }
}
