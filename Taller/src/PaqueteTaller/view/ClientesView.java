package PaqueteTaller.view;
import PaqueteTaller.model.Cliente;
import PaqueteTaller.DAO.ClienteDao;
import java.util.Scanner;


public class ClientesView {

    Scanner sc = new Scanner (System.in);

    ClienteDao clienteDao = new ClienteDao();

    
    
    public void menuCliente (){
    int opcion;
        do{
            System.out.println("1. Añadir cliente");
            System.out.println("2. Borrar cliente");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
        
            switch(opcion){
                case 1-> añadirCliente();
                case 2-> borrarCliente();
                case 3-> modificarCliente();      
            }

        }while (opcion!= 4);
    }

    private void añadirCliente(){
        String dniCliente;
        boolean dniRepetido;

        do{
            System.out.println("Introduzca el DNI del cliente");
            dniCliente = sc.nextLine();
            dniRepetido = clienteDao.dniRepetido(dniCliente);
            
        }while(dniRepetido == true);

        

        System.out.println("Nombre del cliente:");
        String nombre = sc.nextLine();

        System.out.println("Apellido:");
        String apellido = sc.nextLine();

        System.out.println("Numero de telefono:");
        int telefono = Integer.parseInt(sc.nextLine()); 

        System.out.println("Direccion del cliente:");
        String direccion = sc.nextLine();

        System.out.println("Cuenta Bancaria");
        String cuentaBancaria = sc.nextLine();
        System.out.println("Email");
        String email = sc.nextLine();
        

        Cliente cliente = new Cliente(dniCliente, nombre, apellido, telefono, direccion, cuentaBancaria, email);

        clienteDao.insertarCliente(cliente);
        
        //System.out.println("El cliente ha sido añadido con exito");
    }

    public void modificarCliente(){
        boolean condicion= false;
        boolean dniRepetido;
        String dniCliente=null;
        int opcion;
        int subOpcion;

        //Seria interesante pedir una contraseña (de una cuenta creada con antelacion), para mejorar la seguridad
        // ya que alguien con un dni falso podria suplantar la identidad
        // Se podria hacer un hashmap (dni, contraseña)

        System.out.println("Introduzca el DNI:");

        while(condicion=false){

            dniCliente= sc.nextLine();
            dniRepetido = clienteDao.dniRepetido(dniCliente);

            if (dniRepetido=true){
                condicion=true;
            } else{
                System.out.println("Error: DNI no encontrado, vuelva a introducirlo");
            }
        }   
        
        Cliente cliente = clienteDao.getClienteByDni(dniCliente);

        do{
            System.out.println("Escriba el número de lo que desea cambiar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Teléfono");
            System.out.println("4. Dirección");
            System.out.println("5. Cuenta bancaria");
            System.out.println("6. Salir");

            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduzca el nuevo nombre");
                    String nombre= sc.nextLine();
                    cliente.setNombre(nombre);
                }
                case 2 ->{
                    System.out.println("Introduzca el nuevo apellido");
                    String apellido= sc.nextLine();
                    cliente.setApellido(apellido);
                }
                case 3 ->{
                    System.out.println("Introduzca el nuevo teléfono");
                    int telefono= sc.nextInt();
                    sc.nextLine();
                    cliente.setTelefono(telefono);
                }
                case 4 ->{
                    System.out.println("Introduzca la nueva dirección");
                    String direccion= sc.nextLine();
                    cliente.setDireccion(direccion);
                }
                case 5 ->{
                    System.out.println("Introduzca la nueva cuenta bancaria");
                    String cuentaBancaria= sc.nextLine();
                    cliente.setCuentaBancaria(cuentaBancaria);
                }
                case 6 -> {
                    System.out.println("Desea guardar cambios?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");

                    subOpcion= sc.nextInt();
                    sc.nextLine();
                    switch (subOpcion) {
                     case 1 -> clienteDao.modificarCliente(cliente);
                     case 2 -> {} 
                    }

                    condicion= false;
                }
               
            }

        }while (condicion=false);
        
    }

    public void borrarCliente(){

        boolean condicion= false;
        boolean dniRepetido;
        String dniCliente ;
        
        System.out.println("Introduzca el DNI:");
        dniCliente= sc.nextLine();
        System.out.println("Check");
        dniRepetido = clienteDao.dniRepetido(dniCliente);
        if (dniRepetido=true){
            condicion=true;
        } else{
            do{
            System.out.println("Error: DNI no encontrado, vuelva a introducirlo");
            dniCliente= sc.nextLine();
            dniRepetido = clienteDao.dniRepetido(dniCliente);
            if (dniRepetido=true){
            condicion=true;
            }
        }while(condicion=false);
            
           
           
         
        clienteDao.eliminarCliente(dniCliente);
        System.out.println("Cliente eliminado");

        }
    }
}


