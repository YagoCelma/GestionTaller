
import java.util.*;

public class Taller {

    //Atributos especiales
    Scanner sc = new Scanner(System.in);

    //Atributos taller
    ArrayList<Coche> coches = new ArrayList<>();
    ArrayList<CitasView> citas = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Empleado> empleados = new ArrayList<>();

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
                case 3-> //menuModificarCoche();
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

        coches.add(new Coche(matricula, marca, modelo, año, dniAsociado));
    }

    public void borrarCoche(){
        
        boolean seguir = true;
        if(!this.coches.isEmpty()){
            do{
                System.out.println("Introduzca la matricula del coche");
                String matricula = sc.nextLine();
    
                for(Coche coche : this.coches){
                    if(coche.getMatricula().equals(matricula)){
                        coches.remove(coche);
                        System.out.println("El coche ha sido eliminado con exito");
                        return;
                    }
                }
                System.out.println("No se ha encontrado el coche");
            }while(seguir);
        }else{
            System.out.println("La lista de coches esta vacia, no puedes borrar nada");
        }

    }

    public void menuModificarCoche(){
        System.out.println("Que quieres modificar del coche?");
        System.out.println("1. Matricula");

    }

    /*Fin de coches */
    /*------------------------------------------------------------------------------------------ */
    /*Empleados */

    public void menuEmpleado(){
        int opcion;

        do{
            System.out.println("Menu de empleados");
            System.out.println("1. Añadir");
            System.out.println("2. Borrar");
            System.out.println("3. Modificar");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
        }while(opcion != 4);

    }
    
    public void añadirEmpleado(){

        String idEmpleado;
        boolean pasar;

        do{
            System.out.println("Introduzca el ID del empleado");
            idEmpleado = sc.nextLine();
            pasar = false;

            for(Empleado empleado : this.empleados){
                if(empleado.getID().equals(idEmpleado)){
                    System.out.println("Ese ID ya pertenece a un empleado");
                    pasar = true;
                    break;
                }
            }
        }while(pasar == true);

        System.out.println("Nombre del empleado:");
        String nombre = sc.nextLine();

        System.out.println("Numero de telefono:");
        int telefono = sc.nextInt();
        sc.nextLine();

        System.out.println("Direccion del empleado:");
        String direccion = sc.nextLine();

        System.out.println("Salario");
        double salario = sc.nextDouble();
        sc.nextLine();

        empleados.add(new Empleado(idEmpleado, nombre, telefono, direccion, salario));
        System.out.println("El empleado a sido añadido con exito");
    }
    public void borrarEmpleado(){
        
        String idEmpleado;
        boolean seguir = true;

        do{
            System.out.println("ID del empleado que quiere borrar");
            idEmpleado = sc.nextLine();

            for(Empleado empleado : this.empleados){
                if(idEmpleado.equals(empleado.getID())){
                    this.empleados.remove(empleado);
                    System.out.println("El empleado ha sido borrado con exito");
                    seguir = false;
                    return;
                }
            }
            System.out.println("El empleado no ha sido encontrado");
        }while(seguir = true);
    }

    public void menuModificarEmpleado(){

        if(!empleados.isEmpty()){
            Empleado empleado = encontrarEmpleado();

            System.out.println("Menu de modificar empleado:");
            System.out.println("1. Modificar el telefono");
            System.out.println("2. Modificar el direccion");
            System.out.println("3. Modificar el salario");
            int opcion = sc.nextInt();
    
            switch(opcion){
                case 1-> {
                    System.out.println("Dime el nuevo numero de telefono");
                    int nuevoTelefono = sc.nextInt();
                    sc.nextLine();
                    empleado.setTelefono(nuevoTelefono);
                }
                case 2->{
                    System.out.println("Dime la nueva direccion");
                    String nuevaDireccion = sc.nextLine();
                    empleado.setDireccion(nuevaDireccion);
                }
                case 3->{
                    System.out.println("Dime el nuevo salario");
                    Double nuevoSalario = sc.nextDouble();
                    sc.nextLine();
                    empleado.setSalario(nuevoSalario);
                }
            }
        }
    }
    public Empleado encontrarEmpleado(){
        String idEmpleado;
        boolean seguir = true;

        do{
            System.out.println("Introduce el ID del empleado");
            idEmpleado = sc.nextLine();

            for(Empleado empleado : this.empleados){
                if(empleado.getID().equals(idEmpleado)){
                    return empleado;
                }
            }
        }while(seguir == true);
        return null;
    }



    //Metodos pedidos
    public void pedidos(){
        
    }


}   

