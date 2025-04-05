package PaqueteTaller.model;

public class Cliente {

    private String DNI;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private String cuentaBancaria;
    private String email;




    //Constructor
    public Cliente(String DNI, String nombre, String apellido, int telefono, String direccion, String cuentaBancaria, String email){
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
        this.email=email;
    }

    //Get y Set
    //public Cliente getCliente(String DNI){return this;}
    public String getDNI() {return this.DNI;}
    public String getNombre() {return this.nombre;}
    public String getApellido() {return this.apellido;}
    public int getTelefono() {return this.telefono;}
    public String getDireccion() {return this.direccion;}
    public String getCuentaBancaria() {return this.cuentaBancaria;}
    public String getEmail() {return this.email;}
    public void setDireccion(String direccion) { this.direccion = direccion;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public void setApellido(String apellido){this.apellido=apellido;}
    public void setCuentaBancaria(String cuentaBancaria) {this.cuentaBancaria =cuentaBancaria;}
}


