package PaqueteTaller.view;
import PaqueteTaller.DAO.PagosDao;
import PaqueteTaller.DAO.ReparacionesDao;
import PaqueteTaller.PagoReparacion;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

public class PagosView {

    Scanner sc = new Scanner(System.in);
    PagosDao pagosDao = new PagosDao();
    ReparacionesDao reparacionDao= new ReparacionesDao();
    PagoReparacion pagoReparacion;

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
        Double precioSubtotal = 0.0;
        Double precioTotal = 0.0;
        Double precioReparacion = null;
        Double precioProductos  = null;
        Double precioHora  = null;
        LocalDateTime fechaInicio;
        LocalDateTime fechaFinal;
        String nombreReparacion;
        Double horas;
        LinkedList <Integer> idsReparacion = new LinkedList<>();
        LinkedList <PagoReparacion> pagoReparacion = new LinkedList<>();

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

        for (int i=0; i < idsReparacion.size(); i++){
            System.out.println("Para:" + reparacionDao.getNombreReparacion(idsReparacion.get(idReparacion)) );

            System.out.println("Introduce el precio total o precio por hora:");
            System.out.println("1. Precio total");
            System.out.println("2. Precio por hora");
            opcion = sc.nextInt();
            sc.nextLine();

            if(opcion==1){
                System.out.println("Introduce el precio total");
                precioReparacion = sc.nextDouble();


            }else{
                System.out.println("Introduce el precio por hora");
                precioHora = sc.nextDouble();
            }

            nombreReparacion = reparacionDao.getNombreReparacion(idReparacion);
            fechaInicio = reparacionDao.getFechaInicioReparacion(idReparacion);
            fechaFinal = reparacionDao.getFechaFinalReparacion(idReparacion);
            horas = reparacionDao.getHoras(idReparacion);




            pagoReparacion.add(new PagoReparacion(nombreReparacion,fechaInicio, fechaFinal, horas, precioHora, precioReparacion,precioProductos));

            
            //pagosDao.precioHoras(idsReparacion.get(idReparacion));
            //pagosDao.precioProductos(idsReparacion.get(idReparacion));



        }

        for (int i=0; i < pagoReparacion.size(); i++){
            PagoReparacion pagoTotal = pagoReparacion.get(i);
            pagoTotal.toString();
            precioSubtotal = precioSubtotal + pagoTotal.getTotal();

        }


        precioTotal = precioSubtotal * 1.21;
        System.out.println("Total sin IVA = " + precioSubtotal);
        System.out.println("El total con IVA = " + precioTotal);

        
        
        
        
        
        




    }

}
