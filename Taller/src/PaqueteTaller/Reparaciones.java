package PaqueteTaller;
import java.util.LinkedList;
public class Reparaciones {

    private String nombreReparacion;
    private double precio;
    private LinkedList<Integer> idEmpleados;
    private String asunto;
    private int idCita;
    
    public Reparaciones(String nombreReparacion, double precio, LinkedList idEmpleados, String asunto, int idCita){

        this.nombreReparacion = nombreReparacion;
        this.precio = precio;
        this.idEmpleados = idEmpleados;
        this.asunto = asunto;
        this.idCita = idCita; 


    }
    
}
