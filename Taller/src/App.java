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
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1-> taller.menuCliente();
            }
        }while(opcion != 5);
    }
}
