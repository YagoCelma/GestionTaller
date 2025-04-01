package PaqueteTaller.view;
import PaqueteTaller.Citas;
import PaqueteTaller.DAO.CitasDao;
import java.time.LocalDateTime;
import java.util.Scanner;
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
        String matricula;
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

        System.out.println("Introduce la matrícula:");
        matricula=sc.nextLine();

        Citas cita= new Citas(fecha, dniCliente, asunto, matricula);

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
            case 1 ->{this.verCitasDni();}
            case 2 ->{this.verCitasFecha();}
            case 3 ->{this.verCitasMatricula();}
            case 4 ->{this.verCitasId();}
        

        }

    }

    public void verCitasDni(){
        String dni;
        System.out.println("Introduce el DNI");
        dni=sc.nextLine();
        citasDao.verCitasDni(dni);

    }
    public void verCitasMatricula(){
        String matricula;
        System.out.println("Introduce la matrícula");
        matricula=sc.nextLine();
        citasDao.verCitasMatricula(matricula);

    }
    public void verCitasId(){
        int id;
        System.out.println("Introduce el ID");
        id=sc.nextInt();
        sc.nextLine();
        citasDao.verCitasId(id);
    }
    public void verCitasFecha(){
        int opcion;
        int año;
        int mes;
        int dia;
        int hora;
        int minuto;
        LocalDateTime fecha;
        System.out.println("Escribe la nueva fecha");
        System.out.println("Si quieres evitar un dato, escribe 0");
        System.out.println("Por ejemplo: si solo quieres ver los pedidos de un mes, introduce 0 en los demás datos expecto en el del mes");
       
       /* 
        System.out.println("Filtra por:");
        System.out.println("1. Año");
        System.out.println("2. Mes");
        System.out.println("3. Día");
        System.out.println("4. Hora");
        System.out.println("5. Minuto");


        opcion=sc.nextInt();
        sc.nextLine();
        switch (opcion){
            case 1 ->{
                System.out.println("Año:");
                año=sc.nextInt();
                sc.nextLine();
                fecha=(año, null, null, null, null);
            }
        }
        */
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

        
        citasDao.verCitasFecha(fecha);

    }
    
    public void eliminarCita(){
        int id;
        int opcion;

        this.verCitasDni();
        System.out.println("Escribe el ID de la cita que desea eliminar");
        id=sc.nextInt();
        sc.nextLine();
        citasDao.eliminarCita(id); 
    }

    public void modificarCita(){
        int opcion;
        int id;
        int subopcion;
        String matricula;
        LocalDateTime fecha;
        String dni;
        String asunto;
        int año;
        int mes;
        int dia;
        int hora;
        int minuto;

        
        this.verCitas();
        do{
        System.out.println("Escribe el ID de la cita que desea modificar");
        id=sc.nextInt();
        sc.nextLine();
        
        
            do{
                System.out.println("Elige que desea modificar:");
                System.out.println("1. Vehículo");
                System.out.println("2. Fecha");
                System.out.println("3. DNI");
                System.out.println("4. Asunto");
                System.out.println("5. Salir");

                opcion=sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1 -> {
                        System.out.println("Escribe la nueva matricula");
                        matricula=sc.nextLine();
                        citasDao.modificarCitaMatricula(id, matricula);
                        System.out.println("¡Modificado!");
                    }
                    case 2 -> {
                        System.out.println("Escribe la nueva fecha");
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
                        
                        citasDao.modificarCitaFecha(id, fecha);
                        System.out.println("¡Modificado!");
                    }
                    case 3 -> {
                        System.out.println("Escribe el nuevo DNI");
                        dni=sc.nextLine();
                        citasDao.modificarCitaDni(id, dni);
                        System.out.println("¡Modificado!");
                    }
                    case 4 -> {
                        System.out.println("Escribe el nuevo asunto");
                        asunto=sc.nextLine();
                        citasDao.modificarCitaAsunto(id, asunto);
                        System.out.println("¡Modificado!");
                    }

                }

            }while (opcion!=5);

            System.out.println("¿Desea modificar otra cita?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            subopcion=sc.nextInt();



        }while(subopcion!=2);




    }


}
