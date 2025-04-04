package PaqueteTaller;

public class Cliente {

    private String DNI;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private String cuentaBancaria; //Quizas cambiarla a string




    //Constructor
    public Cliente(String DNI, String nombre, String apellido, int telefono, String direccion, String cuentaBancaria){
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
    }

    //Get y Set
    //public Cliente getCliente(String DNI){return this;}
    public String getDNI() {return DNI;}
    public void setDireccion(String direccion) { this.direccion = direccion;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public void setApellido(String apellido){this.apellido=apellido;}
    public void setCuentaBancaria(String cuentaBancaria) {this.cuentaBancaria =cuentaBancaria;}
}


