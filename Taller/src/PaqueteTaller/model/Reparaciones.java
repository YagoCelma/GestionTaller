package PaqueteTaller.model;
import java.time.LocalDateTime;
public class Reparaciones {

    private int idReparacion;
    private String nombreReparacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private boolean acabado;
    private String asunto;
    private Double horas;
    private int idCita;
    
    public Reparaciones(int idReparacion, String nombreReparacion, LocalDateTime fechaInicio, LocalDateTime fechaFinal,
    String asunto, boolean acabado, Double horas, int idCita){

        this.idReparacion = idReparacion;
        this.nombreReparacion = nombreReparacion;
        this.asunto = asunto;
        this.idCita = idCita; 
        this.fechaInicio=fechaInicio;
        this.fechaFinal=fechaFinal;
        this.acabado=acabado;
        this.horas=horas;

    }

    public int getIdReparacion() {return idReparacion;}
    public void setIdReparacion(int idReparacion) {this.idReparacion = idReparacion;}

    public String getNombreReparacion() {return nombreReparacion;}
    public void setNombreReparacion(String nombreReparacion) {this.nombreReparacion = nombreReparacion;}

    public LocalDateTime getFechaInicio() {return fechaInicio;}
    public void setFechaInicio(LocalDateTime fechaInicio) {this.fechaInicio = fechaInicio;}

    public LocalDateTime getFechaFinal() {return fechaFinal;}
    public void setFechaFinal(LocalDateTime fechaFinal) {this.fechaFinal = fechaFinal;}

    public boolean getAcabado() {return acabado;}
    public void setAcabado(boolean acabado) {this.acabado = acabado;}

    public String getAsunto() {return asunto;}
    public void setAsunto(String asunto) {this.asunto = asunto;}

    public Double getHoras() {return horas;}
    public void setHoras(Double horas) {this.horas = horas;}

    public int getIdCita() {return idCita;}
    public void setIdCita(int idCita) {this.idCita = idCita;}
}
