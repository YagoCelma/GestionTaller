package PaqueteTaller.view;

import PaqueteTaller.DAO.ReparacionesDao;
import PaqueteTaller.Reparaciones;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

public class ReparacionesView { 

    Scanner sc = new Scanner(System.in);
    CitasView citas= new CitasView();
    ReparacionesDao reparacionDao = new ReparacionesDao();
    

    public void crearReparacion(){
        String nombreReparacion;
        int opcion;
        LinkedList <Integer> idEmpleados = new LinkedList<>();
        int idEmpleado;
        String asunto;
        int idCita;
        LocalDateTime fechaInicio;
        LocalDateTime fechaFinal= null;
        boolean acabado= false;
        Double horas= null;

        System.out.println("Introduce los siguientes datos");
        System.out.println("Nombre de la reparación");
        nombreReparacion = sc.nextLine();

        do{
            System.out.println("ID del empleado");
            idEmpleado= sc.nextInt();
            idEmpleados.add(idEmpleado);
            System.out.println("Desea introducir otro ID?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            opcion=sc.nextInt();
            sc.nextLine();
        }while(opcion!=2);

        sc.nextLine();
        System.out.println("Citas filtradas por matrícula, elige el ID de la indicada e introdúcelo");
        citas.verCitasMatricula();
        idCita=sc.nextInt();
        sc.nextLine();
        System.out.println("Asunto");
        asunto=sc.nextLine();
        
        System.out.println("Desea añadir horas?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        opcion=sc.nextInt();
        if(opcion==1){
            System.out.println("Introduce horas");
            horas=sc.nextDouble();
            sc.nextLine();
        }

        
        System.out.println("Fecha de inicio");
        fechaInicio=this.introducirFecha();
        System.out.println("Está finalizado?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        opcion=sc.nextInt();
        sc.nextLine();
        if(opcion==1){
            acabado=true;
        }else{
            acabado=false;
        }
        if (acabado){
            System.out.println("Fecha final");
            fechaFinal=this.introducirFecha();
            System.out.println("Horas empleadas");
            horas=sc.nextDouble();
        }


        Reparaciones reparacion= new Reparaciones(nombreReparacion, fechaInicio, fechaFinal, asunto, acabado, horas, idCita );

        reparacionDao.crearReparacion(reparacion);

        //metemos en una tabla auxiliar el id del empleado y la reparacion(si la reparacion esta completada, booleano de true)
        reparacionDao.linkEmpleadosReparacion(idEmpleados);

        System.out.println("Desea añadir gasto de productos?");
        this.añadirGastoProductos();

    }

    public void eliminarReparacion(){
        System.out.println("Introduce el ID de reparación");
        int idReparacion=sc.nextInt();
        reparacionDao.eliminarReparacion(idReparacion);
    }
    public void añadirGastoProductos(){
        String producto;
        int cantidad;
        Double precio;
        int reparacionId;
        int opcion;
        boolean seguir=true;
        while(seguir){
            System.out.println("Nombre del producto:");
            producto=sc.nextLine();
            System.out.println("Cantidad");
            cantidad=sc.nextInt();
            sc.nextLine();
            System.out.println("Precio");
            precio=sc.nextDouble();
            System.out.println("Id de reparación");
            reparacionId=sc.nextInt();
            sc.nextLine();

            System.out.println("Desea seguir?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            opcion=sc.nextInt();
            if (opcion==2){
                seguir=false;
            }

        }

    }

    public LocalDateTime introducirFecha(){
        int año;
        int mes;
        int dia;
        int hora;
        int minuto;
        LocalDateTime fecha;
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
        return fecha;
    }
}
