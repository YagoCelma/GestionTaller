package model;

public class Reparaciones {

    private String nombreReparacion;
    private String DNI_Cliente;
    private String matricula;
    private double precio;
    private int idEmpleado;
    private boolean pagado;
    
    public Reparaciones(String nombreReparacion, String DNI_Cliente, String matricula, double precio, int idEmpleado, boolean pagado){

        this.nombreReparacion = nombreReparacion;
        this.DNI_Cliente = DNI_Cliente;
        this.matricula = matricula;
        this.precio = precio;
        this.idEmpleado = idEmpleado;
        this.pagado = pagado;
    }

    
}
