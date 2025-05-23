package PaqueteTaller.view;

import PaqueteTaller.model.*;
import PaqueteTaller.DAO.*;


import java.sql.Connection;
import java.util.Scanner;


public class CocheView {

    private Scanner sc = new Scanner(System.in);
    CocheDao cocheDAO = new CocheDao();
    private ConexionBD conexion = new ConexionBD();


    
    
    public void menuCoche(){

        int opcion;
        do{
            System.out.println("1. Añadir coche");
            System.out.println("2. Borrar coche");
            System.out.println("3. Modificar coche");
            System.out.println("4. Ver coches");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
    
            switch(opcion){
                case 1-> añadirCoche();
                case 2-> borrarCoche();
                case 3-> modificarCoche();
                case 4 -> verCoches();
                case 5 -> System.out.println("Saliendo del programa");
                default-> System.out.println("Opcion no válida, intentelo de nuevo");
            }
        }while(opcion != 5);
    }

    public void añadirCoche(){

        String matricula;
        boolean matriculaRepetida;

        do{
            System.out.println("Matricula del vehiculo");
            matricula = sc.nextLine();
            matriculaRepetida = cocheDAO.matriculaRepetida(matricula);
        }while(matriculaRepetida = false);


        System.out.println("Marca:");
        String marca = sc.nextLine();

        System.out.println("Modelo");
        String modelo = sc.nextLine();

        System.out.println("Año del vehiculo");
        int año = sc.nextInt();
        sc.nextLine();

        System.out.println("DNI del cliente dueño del coche");
        String dniAsociado = sc.nextLine();

        cocheDAO.añadirCoche(matricula, marca, modelo, año, dniAsociado);
        
    }

    public void modificarCoche(){

        boolean condicion = false;
        String matricula;
        boolean matriculaRepetida;
        int opcion;

        System.out.println("Introduzca la matricula del coche");

        do{
            matricula = sc.nextLine();
            matriculaRepetida = cocheDAO.matriculaRepetida(matricula);

            if(matriculaRepetida = true){
                condicion = true;
            }else{
                System.out.println("Error: Numero de matricula no encontrado");
            }
        }while(condicion == false);
        Coche coche = cocheDAO.cocheByMatricula(matricula);

        do{
            System.out.println("Que quieres modificar del coche?");
            System.out.println("1. Matricula");
            System.out.println("2. Marca");
            System.out.println("3. Modelo");
            System.out.println("4. Año");
            System.out.println("5. DNI del propietario del vehiculo");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1->{
                    System.out.println("Intrduzca una nueva matricula");
                    String nuevaMatricula = sc.nextLine();
                    coche.setMatricula(nuevaMatricula);
                }
                case 2->{
                    System.out.println("Introduzca la nueva marca");
                    String nuevaMarca = sc.nextLine();
                    coche.setMarca(nuevaMarca);
                }
                case 3->{
                    System.out.println("Introduzca el nuevo modelo");
                    String nuevoModelo = sc.nextLine();
                    coche.setModelo(nuevoModelo);
                }
                case 4->{
                    System.out.println("Introduzca el nuevo año");
                    int nuevoAño = sc.nextInt();
                    sc.nextLine();
                    coche.setAño(nuevoAño);
                }
                case 5->{
                    System.out.println("Introduzca el nuevo DNI del cliente");
                    String nuevoDNI = sc.nextLine();
                    coche.setDNI_Cliente(nuevoDNI);
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

    public void verCoches(){
        int opcion;
        System.out.println("Elige una opción:");
        System.out.println("1. Ver todos los coches");
        System.out.println("2. Ver coche por matricula");
        System.out.println("3. Ver coche por DNI del cliente");
        System.out.println("4. Ver coche por marca");
        System.out.println("5. Ver coche por modelo");
        System.out.println("6. Salir"); 
        opcion = sc.nextInt();
        sc.nextLine();
        switch(opcion){
            case 1 -> cocheDAO.verCoches();
            case 2 -> {
                System.out.println("Introduce la matricula");
                String matricula = sc.nextLine();
                cocheDAO.verCocheByMatricula(matricula);
            }
            case 3 -> {
                System.out.println("Introduce el DNI del cliente");
                String dni = sc.nextLine();
                cocheDAO.verCocheByDNI(dni);
            }
            case 4 -> {
                System.out.println("Introduce la marca");
                String marca = sc.nextLine();
                cocheDAO.verCocheByMarca(marca);
            }
            case 5 -> {
                System.out.println("Introduce el modelo");
                String modelo = sc.nextLine();
                cocheDAO.verCocheByModelo(modelo);
            }
            case 6 -> System.out.println("Saliendo del menú de coches.");
            default -> System.out.println("Opción no válida. Por favor, elige una opción del menu.");
        }

    }
    public void borrarCoche(){
        String matricula;
        boolean matriculaRepetida;
        boolean condicion = true;

        do{
            System.out.println("Matricula del coche a eliminar");
            matricula = sc.nextLine();
            matriculaRepetida = cocheDAO.matriculaRepetida(matricula);

            if(matriculaRepetida == true){
                cocheDAO.borrarCoche(matricula);
                System.out.println("Coche eliminado correctamente");
                condicion = false;
            }else{
                System.out.println("No se ha encontrado el coche");
            }
        }while(condicion == true);
    }
}