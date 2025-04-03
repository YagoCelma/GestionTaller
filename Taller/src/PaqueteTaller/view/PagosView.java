package PaqueteTaller.view;
import java.util.Scanner;

import PaqueteTaller.DAO.PagosDao;

import java.util.LinkedList;
public class PagosView {

    Scanner sc = new Scanner(System.in);
    PagosDao pagosDao = new PagosDao();

    public void menuPagos(){
        int opcion;
        System.out.println("Elige opción");
        System.out.println("1. Calcular pago por servicio");


        opcion = sc.nextInt();
        sc.nextLine();
        switch(opcion){
            case 1 ->{this.facturaServicio();}
        }
    }

    public void facturaServicio(){
        int idReparacion;
        int opcion;
        double total;
        LinkedList <Integer> idsReparacion = new LinkedList<>();
        do{
        System.out.println("Introduce el ID de la reparación");
        idReparacion = sc.nextInt();
        sc.nextLine();
        idsReparacion.add(idReparacion);
        System.out.println("¿Desea introducir otra reparación?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        opcion = sc.nextInt();
        sc.nextLine();
        }while(opcion!=2);

        for (int i, i < idsReparacion.lenght(), i++){

        }
        
        pagosDao.calculaPrecio(idsReparacion);




    }

}
