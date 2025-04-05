package PaqueteTaller.model;
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

    public String getID() { return this.ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}
