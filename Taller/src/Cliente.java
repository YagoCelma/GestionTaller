
import java.util.ArrayList;

public class Cliente {

    private String DNI;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private int cuentaBancaria;




    //Constructor
    public Cliente(String DNI, String nombre, String apellido, int telefono, String direccion, int cuentaBancaria){
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
    }

    //Get y Set
    public String getDNI() {return DNI;}
    public void setDireccion(String direccion) { this.direccion = direccion;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setCuentaBancaria(int cuentaBancaria) {this.cuentaBancaria =cuentaBancaria;}
}


