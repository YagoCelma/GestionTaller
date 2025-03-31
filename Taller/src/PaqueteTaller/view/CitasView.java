package PaqueteTaller.view;
import java.time.LocalDateTime;
import java.util.Scanner;
import PaqueteTaller.Citas;
import PaqueteTaller.DAO.CitasDao;

public class CitasView {

    Scanner sc = new Scanner(System.in);

    CitasDao citasDao= new CitasDao();


    public void menuCitas(){
        int opcion;
        

        do{
            System.out.println("Bienvenido al menú de citas, pulse:");
            System.out.println("1. Crear cita");
            System.out.println("2. Eliminar cita");
            System.out.println("3. Modificar cita");
            System.out.println("4. Ver citas");
            System.out.println("5. Salir");
            opcion=sc.nextInt();
            sc.nextLine();
            this.crearCita();
            this.eliminarCita();
            this.modificarCita();
            this.verCitas();
        }while(opcion!=5);
    }

    public void crearCita(){
        //el id de la cita se asignará automáticamente después en la BD
        String dniCliente;
        int año;
        int mes;
        int dia;
        int hora;
        int minuto;
        LocalDateTime fecha;
        String asunto;

        System.out.println("Introduce el DNI:");
        dniCliente=sc.nextLine();

        System.out.println("Introduce la fecha:");
        System.out.println("Año:");
        año=sc.nextInt();
        sc.nextLine();
        System.out.println("Mes:");
        mes=sc.nextInt();
        sc.nextLine();
        System.out.println("Día:");
        dia=sc.nextInt();
        sc.nextLine();
        System.out.println("Hora:");
        hora=sc.nextInt();
        sc.nextLine();
        System.out.println("Minuto:");
        minuto=sc.nextInt();
        sc.nextLine();
        fecha=LocalDateTime.of(año, mes, dia, hora, minuto);

        System.out.println("Escribe el asunto:");
        asunto=sc.nextLine();

        Citas cita= new Citas(fecha, dniCliente, asunto);

    }
    public void verCitas(){

        int opcion;

        System.out.println("Desea la opción para filtrar citas:");
        System.out.println("1. Por DNI");
        System.out.println("2. Por fecha");
        System.out.println("3. Por vehículo");
        System.out.println("4. Por ID");
        System.out.println("5. Salir");

        opcion=sc.nextInt();
        sc.nextLine();

        switch(opcion){
            case 1 ->{

            }
            case 2 ->{}
            case 3 ->{}
            case 4 ->{}
            case 5 ->{}



        }





    }

    public void verCitasDni(){
        String dni;
        System.out.println("Introduce el DNI");
        dni=sc.nextLine();
        citasDao.citasByDni(dni);

    }
    public void eliminarCita(){

        this.verCitas();
        


    }

}
