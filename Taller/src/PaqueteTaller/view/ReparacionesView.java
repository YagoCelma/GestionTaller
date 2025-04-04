package PaqueteTaller.view;

import PaqueteTaller.DAO.ReparacionesDao;
import PaqueteTaller.Reparaciones;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ReparacionesView { 

    Scanner sc = new Scanner(System.in);
    CitasView citas= new CitasView();
    ReparacionesDao reparacionDao = new ReparacionesDao();
    
    public void menuReparaciones(){
        int opcion;
        do{
            System.out.println("Elige opción");
            System.out.println("1. Crear reparación");
            System.out.println("2. Eliminar reparación");
            System.out.println("3. Modificar reparación");
            System.out.println("4. Mostrar reparación");
            opcion=sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 ->{this.crearReparacion();}
                case 2 ->{this.eliminarReparacion();}
                case 3 ->{this.modificarReparacion();}
                case 4 ->{this.mostrarReparacionMenu();}
            }
        }while(opcion!=5);

    }

    public void crearReparacion(){
        String nombreReparacion;
        int opcion;
        //LinkedList <Integer> idEmpleados = new LinkedList<>();
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
        //reparacionDao.linkEmpleadosReparacion(idEmpleados);

        
        do{
            System.out.println("ID del empleado");
            idEmpleado= sc.nextInt();
            //idEmpleados.add(idEmpleado);
            System.out.println("Desea introducir otro empleado?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            opcion=sc.nextInt();
            sc.nextLine();
            reparacionDao.añadirEmpleado(reparacionDao.getIdReparacion(), idEmpleado);
        }while(opcion!=2);

        System.out.println("Desea añadir gasto de productos?");
        this.añadirGastoProductos();

    }

    public void eliminarReparacion(){
        System.out.println("Introduce el ID de reparación");
        int idReparacion=sc.nextInt();
        reparacionDao.eliminarReparacion(idReparacion);
    }

    public void mostrarReparacionMenu(){
        int opcion;
        do{
            System.out.println("¿Cómo desea ver la reparación?");
            System.out.println("1. Ver todas");
            System.out.println("2. Por ID");
            System.out.println("3. Por fecha de inicio");
            System.out.println("4. Por fecha final");
            System.out.println("5. Más recientes (a partir de una fecha)");
            System.out.println("6. Por empleado");
            System.out.println("7. Activas (todavía no terminadas)");
            System.out.println("8. Por vehículo");
            System.out.println("9. Salir");
            opcion=sc.nextInt();
            switch(opcion){
                case 1 ->{this.mostrarReparaciones();}
                case 2 -> {this.mostrarReparacionById();}
                case 3 -> {this.mostrarReparacionByFechaInicio();}
                case 4 -> {this.mostrarReparacionByFechaFinal();}
                case 5 -> {this.mostrarReparacionByMasRecientes();}
                case 6 -> {this.mostrarReparacionByEmpleado();}
                case 7 -> {this.mostrarReparacionActiva();}
                case 8 -> {this.mostrarReparacionByVehiculo();}
            }
        }while(opcion!=9);   
    }

    public void mostrarReparacionByVehiculo(){
        String matricula;
        System.out.println("Introduce la matrícula");
        matricula = sc.nextLine();
        reparacionDao.mostrarReparacionByMatricula(matricula);
    }

    public void mostrarReparaciones(){
        reparacionDao.mostrarReparaciones();
    }

    public void mostrarReparacionActiva(){
        reparacionDao.mostrarReparacionActiva();
    }

    public void mostrarReparacionByEmpleado(){
        int idEmpleado;
        System.out.println("Introduce el ID del trabajador");
        idEmpleado = sc.nextInt();
        sc.nextLine();
       
        
        reparacionDao.mostrarReparacionByTrabajador(idEmpleado);


    }

    public void mostrarReparacionById(){
        int idReparacion;
        System.out.println("Introduce el ID");
        idReparacion = sc.nextInt();
        sc.nextLine();
        reparacionDao.mostrarReparacionById(idReparacion);
    }
    public void mostrarReparacionByFechaInicio(){
        LocalDateTime fechaInicio;
        System.out.println("Introduce la fecha");
        fechaInicio = this.introducirFecha();
        sc.nextLine();
        reparacionDao.mostrarReparacionByFechaInicio(fechaInicio);
    }
    public void mostrarReparacionByFechaFinal(){
        LocalDateTime fechaFinal;
        System.out.println("Introduce la fecha");
        fechaFinal = this.introducirFecha();
        sc.nextLine();
        reparacionDao.mostrarReparacionByFechaFinal(fechaFinal);
    }
    public void mostrarReparacionByMasRecientes(){
        LocalDateTime fechaInicio;
        System.out.println("Introduce la fecha más reciente");
        fechaInicio = this.introducirFecha();
        sc.nextLine();
        reparacionDao.mostrarReparacionByFechaReciente(fechaInicio);
    }


    public void modificarReparacion(){
        String nombreReparacion;
        int opcion;
        int subOpcion;
        //LinkedList <Integer> idEmpleados = new LinkedList<>();
        int idEmpleado;
        String asunto;
        int idCita;
        LocalDateTime fechaInicio;
        LocalDateTime fechaFinal;
        boolean acabado;
        Double horas;
        int idReparacion;
        do{
        System.out.println("Escriba el ID de la reparación que desea modificar:");
        idReparacion=sc.nextInt();
        sc.nextLine();

        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre de la reparación");
        System.out.println("2. ID cita");
        System.out.println("3. Fecha de inicio");
        System.out.println("4. Fecha final");
        System.out.println("5. Estado (acabado o en proceso)");
        System.out.println("6. Horas empleadas");
        System.out.println("7. Asunto");
        System.out.println("8. Añadir o eliminar productos usados");
        System.out.println("9. Añadir empleado");
        System.out.println("10. Eliminar empleado");
        System.out.println("11. Salir");
        opcion=sc.nextInt();
        sc.nextLine();
        switch(opcion){
            case 1 -> {
                System.out.println("Nombre de la reparación");
                nombreReparacion = sc.nextLine();
                reparacionDao.setNombreReparacion(idReparacion, nombreReparacion);
            }
            case 2 -> {
                System.out.println("Introduce el ID de la cita");
                idCita=sc.nextInt();
                sc.nextLine();
                reparacionDao.setIdCita(idReparacion, idCita);
            }
            case 3 -> {
                System.out.println("Fecha de inicio");
                fechaInicio=this.introducirFecha();
                reparacionDao.setFechaInicio(idReparacion, fechaInicio);
            }
            case 4 -> {
                System.out.println("Fecha final");
                fechaFinal=this.introducirFecha();
                reparacionDao.setFechaFinal(idReparacion, fechaFinal);
            }
            case 5 -> {
                System.out.println("Está finalizado?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                subOpcion=sc.nextInt();
                if(subOpcion==1){
                    acabado=true;
                    reparacionDao.setAcabado(idReparacion, acabado);
                }else{
                    acabado=false;
                    reparacionDao.setAcabado(idReparacion, acabado);
                }
            }
            case 6 -> {
                System.out.println("Introduce horas");
                horas=sc.nextDouble();
                reparacionDao.setHoras(idReparacion, horas);
            }
            case 7 -> {
                System.out.println("Asunto");
                asunto=sc.nextLine();
                reparacionDao.setAsunto(idReparacion, asunto);
            }
            case 8 -> {

                this.añadirGastoProductos();
            }
            case 9 -> {
                
                do{
                    System.out.println("ID del empleado");
                    idEmpleado= sc.nextInt();
                    //idEmpleados.add(idEmpleado);
                    System.out.println("Desea introducir otro ID?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    subOpcion=sc.nextInt();
                    sc.nextLine();
                    reparacionDao.añadirEmpleado(idReparacion, idEmpleado);
                }while(opcion!=2);
            }
            case 10 -> {

                do{
                    System.out.println("ID del empleado");
                    idEmpleado= sc.nextInt();
                     //idEmpleados.add(idEmpleado);
                    System.out.println("Desea eliminar otro ID?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    subOpcion=sc.nextInt();
                    sc.nextLine();
                    reparacionDao.eliminarEmpleado(idReparacion, idEmpleado);
                }while(opcion!=2);

            }
        }
        }while(opcion!=11);


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
            reparacionDao.añadirProducto(producto, cantidad, precio, reparacionId);

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
