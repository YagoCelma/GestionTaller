
import java.util.*;

public class Taller {

    //Atributos especiales
    Scanner sc = new Scanner(System.in);

    //Atributos taller
    ArrayList<Coche> coches = new ArrayList<>();
    ArrayList<Citas> citas = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    /*Metodos de Clientes */
    public void menuCliente(){
        System.out.println("1. Añadir cliente");
        System.out.println("2. Borrar cliente");
        System.out.println("3. Modificar cliente");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch(opcion){
            case 1-> añadirCliente();
            case 2-> borrarCliente();
            case 3-> menuModificarCliente();
        }
    }

    public void añadirCliente(){
        String idCliente;
        boolean pasar;

        do{
            System.out.println("Introduzca el DNI del cliente");
            idCliente = sc.nextLine();
            pasar = false;

            for(Cliente cliente : this.clientes){
                if(cliente.getDNI().equals(idCliente)){
                    System.out.println("Ese DNI ya pertenece a un cliente");
                    pasar = true;
                    break;
                }
            }
        }while(pasar == true);

        System.out.println("Nombre del cliente:");
        String nombre = sc.nextLine();

        System.out.println("Apellido:");
        String apellido = sc.nextLine();

        System.out.println("Numero de telefono:");
        int telefono = sc.nextInt();
        sc.nextLine();

        System.out.println("Direccion del cliente:");
        String direccion = sc.nextLine();

        System.out.println("Cuenta Bancaria");
        int cuentaBancaria = sc.nextInt();
        sc.nextLine();

        clientes.add(new Cliente(idCliente, nombre, apellido, telefono, direccion, cuentaBancaria));
        System.out.println("El cliente a sido añadido con exito");
    }

    public void borrarCliente(){
        
        String idCliente;
        boolean seguir = true;

        do{
            System.out.println("DNI del cliente que quiere borrar");
            idCliente = sc.nextLine();

            for(Cliente cliente : this.clientes){
                if(idCliente.equals(cliente.getDNI())){
                    clientes.remove(cliente);
                    System.out.println("El cliente ha sido borrado con exito");
                    seguir = false;
                    return;
                }
            }
            System.out.println("El cliente no ha sido encontrado");
        }while(seguir = true);
    }

    public void menuModificarCliente(){

        if(!clientes.isEmpty()){
            Cliente cliente = encontrarCliente();

            System.out.println("Que quieres modificar del cliente");
            System.out.println("1. Cambio de direccion");
            System.out.println("2. Cambio de telefono");
            System.out.println("3. Cambio de cuenta bancaria");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1 -> {
                    System.out.println("Introduzca al nueva direccion:");
                    String direccion = sc.nextLine();
                    cliente.setDireccion(direccion);
                }
                case 2-> {
                    System.out.println("Introduzca el nuevo numero de telefono");
                    int nuevoNumero = sc.nextInt();
                    sc.nextLine();
                    cliente.setTelefono(nuevoNumero);
                }
                case 3-> {
                    System.out.println("Introduzca la nueva cuenta bancaria");
                    int nuevaCuenta = sc.nextInt();
                    sc.nextLine();
                    cliente.setCuentaBancaria(nuevaCuenta);
                }
            }

        }else{
            System.out.println("La lista de clientes esta vacia");
        }
    }

    public Cliente encontrarCliente(){
        String idCliente;
        boolean seguir = true;

        do{
            System.out.println("Introduce el DNI del cliente");
            idCliente = sc.nextLine();

            for(Cliente cliente : this.clientes){
                if(cliente.getDNI().equals(idCliente)){
                    return cliente;
                }
            }
        }while(seguir == true);
        return null;
    }
    /*Fin de metodos de clientes */
    /*------------------------------------------------------------------------------------------- */
    /*Metodos de coches */

    public void menuCoche(){

        int opcion;
        do{
            System.out.println("1. Añadir coche");
            System.out.println("2. Borrar coche");
            System.out.println("3. Modificar coche");
            opcion = sc.nextInt();
            sc.nextLine();
    
            switch(opcion){
                case 1-> añadirCoche();
                case 2-> borrarCoche();
                case 3-> menuModificarCoche();
            }
        }while(opcion != 5);
    }

    public void añadirCoche(){

        String matricula;
        boolean pasar;

        do{
            System.out.println("Matricula del vehiculo");
            matricula = sc.nextLine();
            pasar = false;

            for(Coche coche : coches){
                if(coche.getMatricula().equals(matricula)){
                    System.out.println("Esa matricula ya existe");
                    pasar = true;
                }
            }

        }while(pasar == true);

        System.out.println("Marca:");
        String marca = sc.nextLine();

        System.out.println("Modelo");
        String modelo = sc.nextLine();

        int año;
        boolean seguir;
        do{
            System.out.println("Año del vehiculo");
            año = sc.nextInt();
            sc.nextLine();
            seguir = false;
            if(año < 0){
                System.out.println("El año del vehiculo no puede ser negativo");
                seguir = true;
            }
        }while(seguir == true);

        String dniAsociado;
        do{
            System.out.println("DNI del cliente dueño del coche");
            dniAsociado = sc.nextLine();
            seguir = true;
            
            for(Cliente cliente : clientes){
                if(cliente.getDNI().equals(dniAsociado)){
                    seguir = false;
                }
            }
        }while(seguir == true);
    }



    //Metodos pedidos
    public void pedidos(){
        
    }


}   

