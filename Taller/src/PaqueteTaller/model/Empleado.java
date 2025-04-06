package PaqueteTaller.model;

import java.time.LocalDate;

public class Empleado {

    private String ID;
    private String nombre;
    private String telefono;
    private String direccion;
    private double salario;
    private String email;
    private String puesto;
    private LocalDate fechaContratacion;

    public Empleado(String ID, String nombre, String telefono, String direccion, double salario, String email, String puesto, LocalDate fechaContratacion) {

        this.ID = ID;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.salario = salario;
        this.email = email;
        this.puesto = puesto;
        this.fechaContratacion = fechaContratacion;
    }

    public String getID() { return this.ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion;}
}
