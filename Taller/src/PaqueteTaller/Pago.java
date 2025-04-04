package PaqueteTaller;
import PaqueteTaller.DAO.PagosDao;
import java.time.LocalDateTime;


public class Pago {

    PagosDao pagosDao = new PagosDao();

    private String nombreReparacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double horas;
    private Double precioHora;
    private Double precioTotal;
    private Double precioProductos;
    private Double total = null;

    public Pago (String nombreReparacion, LocalDateTime fechaInicio, LocalDateTime fechaFinal, 
    Double horas, Double precioHora, Double precioTotal, Double precioProductos){
        this.nombreReparacion = nombreReparacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horas = horas;
        this.precioHora = precioHora;
        this.precioTotal = precioTotal;
        this.precioProductos = precioProductos;
        
    }

    public Double getTotal (){
        Double total= null;
        return total;
    }

    public String toString(){
        return null;
    }




}
