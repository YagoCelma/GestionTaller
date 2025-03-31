
import model.Coche;
import dao.CocheDAO;
import dao.ClienteDAO;
import java.util.Scanner;

public class Coche {

    private Scanner sc = new Scanner(System.in);
    private CocheDAO cocheDAO = new CocheDAO();
    
    public void menuCoche(){

        int opcion;
        do{
            System.out.println("1. Añadir coche");
            System.out.println("2. Borrar coche");
            System.out.println("3. Modificar coche");
            opcion = sc.nextInt();
            sc.nextLine();
    
            switch(opcion){
                case 1-> añadirCoche();
                case 2-> borrarCoche();
                case 3-> //menuModificarCoche();
            }
        }while(opcion != 4);
    }

    public void borrarCoche(){
        
        System.out.println("Matricula del coche a eliminar");
        String matricula = sc.nextLine();
        cocheDAO.borrar(matricula);
    }

    public void añadirCoche(){

        String matricula;
        boolean matriculaRepetida;

        do{
            System.out.println("Matricula del vehiculo");
            matricula = sc.nextLine();
            matriculaRepetida = cocheDAO.matriculaRepetida(matricula);
        }while(matriculaRepetida = true);


        System.out.println("Marca:");
        String marca = sc.nextLine();

        System.out.println("Modelo");
        String modelo = sc.nextLine();

        System.out.println("Año del vehiculo");
        int año = sc.nextInt();
        sc.nextLine();

        System.out.println("DNI del cliente dueño del coche");
        String dniAsociado = sc.nextLine();

        Coche coche = new Coche(matricula, marca, modelo, año, dniAsociado);
        cocheDAO.añadirCoche(coche);
        System.out.println("El cliente ha sido añadido con exito");
    }

    public void modificarCoche(){

        boolean condicion = false;
        String matricula;
        boolean matriculaRepetida;
        int opcion;

        System.out.println("Introduzca la matricula del coche");

        while(condicion = false){
            matricula = sc.nextLine();
            matriculaRepetida = cocheDAO.matriculaRepetida(matricula);

            if(matriculaRepetida = true){
                condicion = true;
            }else{
                System.out.println("Error: Numero de matricula no encontrado");
            }
        }
        Coche coche = cocheDAO.cocheByMatricula(matricula);

        do{
            System.out.println("Que quieres modificar del coche?");
            System.out.println("1. Matricula");
            System.out.println("2. Marca");
            System.out.println("3. Modelo");
            System.out.println("4. Año");
            System.out.println("5. DNI del propietario del vehiculo");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1->{
                    System.out.println("Intrduzca una nueva matricula");
                    String nuevaMatricula = sc.nextLine();
                    Coche.setMatricula(nuevaMatricula);
                }
            }
        }
    }
}
