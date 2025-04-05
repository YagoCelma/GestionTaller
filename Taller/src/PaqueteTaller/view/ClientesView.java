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
            System.out.println("4. Ver clientes");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
        
            switch(opcion){
                case 1-> añadirCliente();
                case 2-> borrarCliente();
                case 3-> modificarCliente();  
                case 4-> verClientes();
                default -> System.out.println("Opción no válida");    
            }

        }while (opcion!= 5);
    }

    private void añadirCliente(){
        String dniCliente;
        boolean dniRepetido;
        clienteDao = new ClienteDao();

        do{
            System.out.println("Introduzca el DNI del cliente");
            dniCliente = sc.nextLine();
            dniRepetido = clienteDao.dniRepetido(dniCliente);
            
        }while(dniRepetido == true);

        

        System.out.println("Nombre del cliente:");
        String nombre = sc.nextLine();

        System.out.println("Apellido:");
        String apellido = sc.nextLine();

        String telefono = validarTelefono();

        System.out.println("Direccion del cliente:");
        String direccion = sc.nextLine();

        String cuentaBancaria = validarCuentaBancaria();
        System.out.println("Email");
        String email = sc.nextLine();
        

        Cliente cliente = new Cliente(dniCliente, nombre, apellido, telefono, direccion, cuentaBancaria, email);

        clienteDao.insertarCliente(cliente);
        
        //System.out.println("El cliente ha sido añadido con exito");
    }

    public void modificarCliente(){
        
        boolean condicion= false;
        boolean condicion2= true;
        boolean dniRepetido;
        String dniCliente;
        int opcion;
        int subOpcion;
        int opcion2;
        
        String nombre;
        String apellido;
        String telefono;
        String direccion;

        String cuentaBancaria;


    



        //Seria interesante pedir una contraseña (de una cuenta creada con antelacion), para mejorar la seguridad
        // ya que alguien con un dni falso podria suplantar la identidad
        // Se podria hacer un hashmap (dni, contraseña)

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

        }
        
        Cliente cliente = new Cliente(dniCliente, null, null, null, null, null, null);

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
                     nombre= sc.nextLine();
                    cliente.setNombre(nombre);
                }
                case 2 ->{
                    System.out.println("Introduzca el nuevo apellido");
                    apellido= sc.nextLine();
                    cliente.setApellido(apellido);
                }
                case 3 ->{
                    telefono= validarTelefono();
                    cliente.setTelefono(telefono);
                }
                case 4 ->{
                    System.out.println("Introduzca la nueva dirección");
                    direccion= sc.nextLine();
                    cliente.setDireccion(direccion);
                }
                case 5 ->{
                    cuentaBancaria= validarCuentaBancaria();
                    cliente.setCuentaBancaria(cuentaBancaria);
                }
                case 6 -> {
                    System.out.println("Desea guardar cambios?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");

                    subOpcion= sc.nextInt();
                    sc.nextLine();
                    switch (subOpcion) {
                     case 1 -> {
                        clienteDao.modificarCliente(cliente);
                        condicion2= false;}
                     case 2 -> {condicion2= false;} 
                    }

                    
                }
                default -> System.out.println("Opción no válida");
               
            }
            
        }while (condicion2);
        
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

        }
        clienteDao.eliminarCliente(dniCliente);
        System.out.println("Cliente eliminado");
    }

    public void verClientes(){
        String dniCliente;
        System.out.println("Introduzca el DNI:");
        dniCliente= sc.nextLine();
        clienteDao.verClienteByDni(dniCliente);
  
    }

    public String validarTelefono(){
        String telefono;
        boolean valido;

        do {
            System.out.println("Número de teléfono");
            telefono = sc.nextLine().trim(); // Eliminamos espacios

            //Validamos los requisitos
            valido = telefono.matches("^[+]?[0-9\\-\\s]+$");

            if (!valido) {
                System.out.println("Error: Introduce números, guiones (-), signo de suma (+) o espacios");
            }
        } while (!valido);

        return telefono;
    }

    public String validarCuentaBancaria(){
    
        String cuentaBancaria;
        boolean valido;

        do {
            System.out.println("Escriba el IBAN de la cuenta bancaria");
            cuentaBancaria = sc.nextLine().trim(); // Eliminamos espacios

            //Validamos los requisitos
            valido = cuentaBancaria.matches("^[A-Z]{2}\\d{2}[A-Z0-9]{1,30}$");

            if (!valido) {
                System.out.println("Error: Introduce dos letras mayúsculas, seguidas de los correspondientes números");
            }
        } while (!valido);

        return cuentaBancaria;
    }
}



