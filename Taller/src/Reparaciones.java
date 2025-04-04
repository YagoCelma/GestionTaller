public class Reparaciones {

    private String nombreReparacion;
    private String DNI_Cliente;
    private String matricula;
    private double precio;
    private int idEmpleado;
    
    public Reparaciones(String nombreReparacion, String DNI_Cliente, String matricula, double precio, int idEmpleado){

        this.nombreReparacion = nombreReparacion;
        this.DNI_Cliente = DNI_Cliente;
        this.matricula = matricula;
        this.precio = precio;
        this.idEmpleado = idEmpleado;
    }
    
}
