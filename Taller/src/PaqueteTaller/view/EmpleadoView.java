package PaqueteTaller.view;
import java.util.Scanner;

import PaqueteTaller.DAO.*;
import PaqueteTaller.model.*;


import java.sql.Connection;
import java.time.LocalDate;


public class EmpleadoView {

    private Scanner sc = new Scanner(System.in);
    Connection conexion = ConexionBD.conectar();

    EmpleadoDao empleadoDAO = new EmpleadoDao();

    //public EmpleadoView() {
     //   this.empleadoDAO = new EmpleadoDAO();
    //}

    public void menuEmpleado(){

        int opcion;
        do{
            System.out.println("1. Añadir empleado");
            System.out.println("2. Borrar empleado");
            System.out.println("3. Modificar empleado");
            System.out.println("4. Ver empleados");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
    
            switch(opcion){
                case 1-> this.añadirEmpleado();
                case 2-> this.borrarEmpleado();
                case 3-> this.modificarEmpleado();
                case 4-> this.verEmpleados();
                case 5-> System.out.println("Saliendo del menú de empleados.");
                default -> System.out.println("Opción no válida");
            }
        }while(opcion != 5);
    }

    public void añadirEmpleado(){

        String id;
        boolean idRepetido;
        Double salario = 0.0;
        boolean valido;
        int año;
        int mes;
        int dia;
        LocalDate fechaContratacion;
       do{
        System.out.println("ID del empleado");
        /* A la hora de hacer los comandos habria que poner el auto-increment para el id del empleado */
        id = sc.nextLine();
        
        idRepetido = empleadoDAO.idRepetido(id);
       } while(idRepetido = false);

       System.out.println("Nombre y apellidos del empleado");
       String nombre = sc.nextLine();

       System.out.println("Telefono del empleado");
       String telefono = sc.nextLine();
       

       System.out.println("Direccion del empleado");
       String direccion = sc.nextLine();

       do {
        System.out.print("Salario ");
        try {
            salario = Double.parseDouble(sc.nextLine());
            valido = true;
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Debes introducir un número, no letras.");
            valido = false;
        }
    } while (!valido);

        System.out.println("Email del empleado");
        String email = sc.nextLine();
        System.out.println("Puesto del empleado");
        String puesto = sc.nextLine();
        System.out.println("Fecha de contratacion del empleado");
        System.out.println("Introduce el año de contratacion");
        año = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el mes de contratacion");
        mes = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el dia de contratacion");
        dia = sc.nextInt();
        sc.nextLine();
        fechaContratacion = LocalDate.of(año, mes, dia);

       Empleado empleado = new Empleado(id, nombre, telefono, direccion, salario, email, puesto, fechaContratacion);
       empleadoDAO.añadirEmpleado(empleado);

       System.out.println("El empleado ha sido añadido con exito");

    }

    public void borrarEmpleado(){
        String id;
        boolean encontrarId;
        boolean condicion = true;

        do{
            System.out.println("Indica el ID del empleado");
            id = sc.nextLine();
            
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

    public void verEmpleados (){
        int opcion;

        do{
            System.out.println("Elige una opción:");
            System.out.println("1. Ver todos los empleados");
            System.out.println("2. Ver empleado por ID");
            System.out.println("3. Ver empleado por nombre");
            System.out.println("4. Ver empleado por telefono");
            System.out.println("5. Ver empleado por direccion");
            System.out.println("6. Ver empleado por salario");
            System.out.println("7. Ver empleado por fecha de contratación descendente");
            System.out.println("8. Ver empleado por email");
            System.out.println("9. Ver empleado por puesto");

            System.out.println("10. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 -> empleadoDAO.verEmpleados();
                case 2 -> {
                    System.out.println("Introduce el ID del empleado");
                    String id = sc.nextLine();
                    empleadoDAO.verEmpleadoByID(id);
                }
                case 3 -> {
                    System.out.println("Introduce el nombre del empleado");
                    String nombre = sc.nextLine();
                    empleadoDAO.verEmpleadoByNombre(nombre);
                }
                case 4 -> {
                    System.out.println("Introduce el telefono del empleado");
                    String telefono = sc.nextLine();
                    
                    empleadoDAO.verEmpleadoByTelefono(telefono);
                }
                case 5 -> {
                    System.out.println("Introduce la direccion del empleado");
                    String direccion = sc.nextLine();
                    empleadoDAO.verEmpleadoByDireccion(direccion);
                }
                case 6 -> 

                {
                    System.out.println("Elige una opción:");
                    System.out.println("1. Mayor que");
                    System.out.println("2. Menor que");
                    System.out.println("3. Entre dos valores");
                    System.out.println("4. Igual que");

                    int opcionSalario = sc.nextInt();
                    sc.nextLine();
                    switch(opcionSalario){
                        case 1 -> {
                            System.out.println("Introduce el salario mayor que");
                            double salarioMayor = sc.nextDouble();
                            sc.nextLine();
                            empleadoDAO.verEmpleadoBySalarioMayorQue(salarioMayor);
                        }
                        case 2 -> {
                            System.out.println("Introduce el salario menor que");
                            double salarioMenor = sc.nextDouble();
                            sc.nextLine();
                            empleadoDAO.verEmpleadoBySalarioMenorQue(salarioMenor);
                        }
                        case 3 -> {
                            System.out.println("Introduce el salario menor que");
                            double salarioMenor = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el salario mayor que");
                            double salarioMayor = sc.nextDouble();
                            sc.nextLine();
                            empleadoDAO.verEmpleadoBySalarioEntre(salarioMenor, salarioMayor);
                        }
                        case 4 -> {
                            System.out.println("Introduce el salario igual que");
                            double salario = sc.nextDouble();
                            sc.nextLine();
                            empleadoDAO.verEmpleadoBySalario(salario);
                        }
                    }
                    System.out.println("Introduce el salario del empleado");
                    double salario = sc.nextDouble();
                    sc.nextLine();
                    empleadoDAO.verEmpleadoBySalario(salario);
                }
                case 7 -> empleadoDAO.verEmpleadosFechaContratacionDescendente();
            
                case 8 -> {
                    System.out.println("Introduce el email del empleado");
                    String email = sc.nextLine();
                    empleadoDAO.verEmpleadoByEmail(email);
                }
                case 9 -> {
                    System.out.println("Introduce el puesto del empleado");
                    String puesto = sc.nextLine();
                    empleadoDAO.verEmpleadoByPuesto(puesto);
                }   
                case 10 -> System.out.println("Saliendo del menú de empleados.");
            
                default -> System.out.println("Opción no válida. Por favor, elige una opción del menu.");
            }
        }while(opcion != 10);

    }
    public void modificarEmpleado(){

        String id;
        boolean encontrarEmpleado = true;
        int opcion;
        boolean condicion;
        int año;
        int mes;    
        int dia;
        LocalDate fechaContratacion;

        do{
            System.out.println("Indica el ID del empleado");
            id = sc.nextLine();
            
            encontrarEmpleado = empleadoDAO.idRepetido(id);
        }while(!encontrarEmpleado);

        

        Empleado empleado = empleadoDAO.empleadoPorID(id);

        do{
            System.out.println("Que quieres modificar?");
            System.out.println("1. ID");
            System.out.println("2. Nombre");
            System.out.println("3. Telefono");
            System.out.println("4. Direccion");
            System.out.println("5. Salario");
            System.out.println("6. Email");
            System.out.println("7. Puesto");
            System.out.println("8. Fecha de contratacion");
            System.out.println("9. Salir");
            
            opcion = sc.nextInt();sc.nextLine();


        switch(opcion){
            case 1->{
                System.out.println("Que ID deseas poner?");
                String idNuevo = sc.nextLine();
                
                empleado.setID(idNuevo);
                empleadoDAO.modificarEmpleado(id, empleado);
            }
            case 2->{
                System.out.println("Pon el nuevo nombre y apellidos");
                String nuevoNombre = sc.nextLine();
                empleado.setNombre(nuevoNombre);
                empleadoDAO.modificarEmpleado(id, empleado);
            }
            case 3->{
                System.out.println("Pon el nuevo numero de telefono");
                String nuevoTelefono = sc.nextLine();
                sc.nextLine();
                empleado.setTelefono(nuevoTelefono);
                empleadoDAO.modificarEmpleado(id, empleado);
            }
            case 4->{
                System.out.println("Pon la nueva direccion");
                String nuevaDireccion = sc.nextLine();
                empleado.setDireccion(nuevaDireccion);
                empleadoDAO.modificarEmpleado(id, empleado);
            }
            case 5->{
                System.out.println("Pon el nuevo salario");
                double nuevoSalario = sc.nextDouble();
                sc.nextLine();
                empleado.setSalario(nuevoSalario);
                empleadoDAO.modificarEmpleado(id, empleado);
            }
            
            case 6->{
                System.out.println("Pon el nuevo email");
                String nuevoEmail = sc.nextLine();
                empleado.setEmail(nuevoEmail);
                empleadoDAO.modificarEmpleado(id, empleado);
            }
            case 7->{
                System.out.println("Pon el nuevo puesto");
                String nuevoPuesto = sc.nextLine();
                empleado.setPuesto(nuevoPuesto);
                empleadoDAO.modificarEmpleado(id, empleado);
            }
            case 8->{
                System.out.println("Pon la nueva fecha de contratacion");
                System.out.println("Introduce el año de contratacion");
                año = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce el mes de contratacion");
                mes = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce el dia de contratacion");
                dia = sc.nextInt();
                sc.nextLine();
                fechaContratacion = LocalDate.of(año, mes, dia);
                empleado.setFechaContratacion(fechaContratacion);
                empleadoDAO.modificarEmpleado(id, empleado);
            }
            case 9->{
                System.out.println("Saliendo del menú de modificación.");
            }
            default -> {
                System.out.println("Opción no valida. Por favor, elige una opción del menu.");
            }
        }
    }while(opcion != 9);


    }
}