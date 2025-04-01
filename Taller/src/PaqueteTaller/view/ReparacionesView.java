package PaqueteTaller.view;

import PaqueteTaller.Reparaciones;
import java.util.LinkedList;
import java.util.Scanner;

public class ReparacionesView { 

    Scanner sc = new Scanner(System.in);
    CitasView citas= new CitasView();
    
    

    public void crearReparacion(){
        String nombreReparacion;
        double precio;
        int opcion;
        LinkedList <Integer> idEmpleados = new LinkedList<>();
        int idEmpleado;
        String asunto;
        int idCita;
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
        System.out.println("Precio");

        precio=sc.nextDouble();
        sc.nextLine();


        Reparaciones reparacion= new Reparaciones(nombreReparacion, precio, idEmpleados, asunto, idCita );

    }


}
