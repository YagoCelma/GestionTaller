package PaqueteTaller.view;
import PaqueteTaller.DAO.PagosDao;
import PaqueteTaller.DAO.ReparacionesDao;
import PaqueteTaller.model.PagoReparacion;
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
        do{
        System.out.println("Elige opción");
        System.out.println("1. Calcular pago por servicio");
        System.out.println("2. Ingresar pago a empleado");
        System.out.println("3. Ver pagos por servicio");
        System.out.println("4. Ver pagos a empleados");
        System.out.println("5. Salir");
        


        opcion = sc.nextInt();
        sc.nextLine();
        switch(opcion){
            case 1 ->{this.facturaServicio();}
            case 2 ->{this.facturaEmlpeado();}
            case 3 ->{pagosDao.verIngresos();}
            case 4 ->{pagosDao.verPagosEmpleados();}
            case 5 ->{System.out.println("Saliendo del menu de pagos");}
            default -> System.out.println("Opción no válida");
            }  
        }while(opcion != 5);
    }

    public void facturaServicio(){

        System.out.println("Introduce el ID de la reparación");
        int idReparacion = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Introduce el precio de la reparacion");
        double precioReparacion = sc.nextDouble();


            

        System.out.println("Introduce el concepto del pago");
        String concepto = sc.nextLine();

        
        pagoReparacion = new PagoReparacion(concepto, idReparacion, precioReparacion);
        pagosDao.insertarPago(pagoReparacion);
        
        
        
        




    }

    public void facturaEmlpeado(){

        System.out.println("Introduce el ID del empleado");
        String idEmpleado = sc.nextLine();
        
        
        System.out.println("Introduce el pago");
        double pagoEmpleado = sc.nextDouble();


            

        System.out.println("Introduce el concepto del pago");
        String concepto = sc.nextLine();

        
        pagosDao.insertarPagoEmpleado(idEmpleado, pagoEmpleado, concepto);
        
        

    }
}
