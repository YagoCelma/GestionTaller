package PaqueteTaller;
import java.time.LocalDateTime;
public class Reparaciones {

    private String nombreReparacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private boolean acabado;
    private String asunto;
    private Double horas;
    private int idCita;
    
    public Reparaciones(String nombreReparacion, LocalDateTime fechaInicio, LocalDateTime fechaFinal,
    String asunto, boolean acabado, Double horas, int idCita){

        this.nombreReparacion = nombreReparacion;
        this.asunto = asunto;
        this.idCita = idCita; 
        this.fechaInicio=fechaInicio;
        this.fechaFinal=fechaFinal;
        this.acabado=acabado;
        this.horas=horas;

    }
    
}
