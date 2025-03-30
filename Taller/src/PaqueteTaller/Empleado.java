package PaqueteTaller;
public class Empleado {

    private String ID;
    private String nombre;
    private int telefono;
    private String direccion;
    private double salario;

    public Empleado(String ID, String nombre, int telefono, String direccion, double salario){

        this.ID = ID;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.salario = salario;
    }

    public String getID() {return ID;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setSalario(double salario) {this.salario = salario;}
}
