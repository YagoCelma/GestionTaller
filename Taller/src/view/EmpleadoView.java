package view;
import java.util.Scanner;
import java.sql.Connection;
import dao.EmpleadoDAO;
import model.Empleado;

public class EmpleadoView {

    private Scanner sc = new Scanner(System.in);
    private Connection conexion;
    private EmpleadoDAO empleadoDAO;

    public void menuEmpleado(){

        int opcion;
        do{
            System.out.println("1. Añadir empleado");
            System.out.println("2. Borrar empleado");
            System.out.println("3. Modificar empleado");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
    
            switch(opcion){
                case 1-> añadirEmpleado();
                case 2-> borrarEmpleado();
                case 3-> modificarEmpleado();
            }
        }while(opcion != 4);
    }

    public void añadirEmpleado(){

        int id;
        boolean idRepetido;

       do{
        System.out.println("ID del empleado");
        /* A la hora de hacer los comandos habria que poner el auto-increment para el id del empleado */
        id = sc.nextInt();
        sc.nextLine();
        idRepetido = empleadoDAO.idRepetido(id);
       } while(idRepetido = true);

       System.out.println("Nombre del empleado");
       String nombre = sc.nextLine();

       System.out.println("Telefono del empleado");
       int telefono = sc.nextInt();
       sc.nextLine();

       System.out.println("Direccion del empleado");
       String direccion = sc.nextLine();

       System.out.println("Salario del empleado");
       Double salario = sc.nextDouble();
       sc.nextLine();

       Empleado empleado = new Empleado(id, nombre, telefono, direccion, salario);
       empleadoDAO.añadirEmpleado(empleado);

       System.out.println("El empleado ha sido añadido con exito");

    }

    public void borrarEmpleado(){
        int id;
        boolean encontrarId;
        boolean condicion = true;

        do{
            System.out.println("Indica el ID del empleado");
            id = sc.nextInt();
            sc.nextLine();
            encontrarId = empleadoDAO.idRepetido(id);
            if(encontrarId == true){
                empleadoDAO.borrarEmpleado(id);
                System.out.println("Se ha eliminado el empleado correctamente");
                condicion = false;
            }else{
                System.out.println("No se ha encontrado el empleado");
            }
        }while(condicion == true);
    }

    public void modificarEmpleado(){

        int id;
        boolean encontrarEmpleado = true;
        int opcion;
        boolean condicion;

        do{
            System.out.println("Indica el ID del empleado");
            id = sc.nextInt();
            sc.nextLine();
            encontrarEmpleado = empleadoDAO.idRepetido(id);

            if(encontrarEmpleado = false){
                condicion = false;
            }else{
                condicion = true;
                System.out.println("No se ha encontrado el ID del empleado");
            }
        }while(condicion == true);

        Empleado empleado = empleadoDAO.empleadoPorID(id);

        do{
            System.out.println("Que quieres modificar?");
            System.out.println("1. ID");
            System.out.println("2. Nombre");
            System.out.println("3. Telefono");
            System.out.println("4. Direccion");
            System.out.println("5. Salario");
            System.out.println("6. Salir");
            opcion = sc.nextInt();sc.nextLine();


        switch(opcion){
            case 1->{
                System.out.println("Que ID deseas poner?");
                int idNuevo = sc.nextInt();
                sc.nextLine();
                empleado.setID(idNuevo);
            }
            case 2->{
                System.out.println("Pon el nuevo nombre");
                String nuevoNombre = sc.nextLine();
                empleado.setNombre(nuevoNombre);
            }
            case 3->{
                System.out.println("Pon el nuevo numero de telefono");
                int nuevoTelefono = sc.nextInt();
                sc.nextLine();
                empleado.setTelefono(nuevoTelefono);
            }
            case 4->{
                System.out.println("Pon la nueva direccion");
                String nuevaDireccion = sc.nextLine();
                empleado.setDireccion(nuevaDireccion);
            }
            case 5->{
                System.out.println("Pon el nuevo salario");
                double nuevoSalario = sc.nextDouble();
                sc.nextLine();
                empleado.setSalario(nuevoSalario);
            }
            case 6->{
                System.out.println("Saliendo del menú de modificación.");
            }
            default -> {
                System.out.println("Opción no valida. Por favor, elige una opción del menu.");
            }
        }
    }while(opcion != 6);


    }
}
