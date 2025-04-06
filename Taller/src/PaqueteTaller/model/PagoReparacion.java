package PaqueteTaller.model;
import PaqueteTaller.DAO.PagosDao;
import java.time.LocalDateTime;


public class PagoReparacion {

    PagosDao pagosDao = new PagosDao();

    private String concepto;
    private int idReparacion;
    
    
    private Double precio;
    


    public PagoReparacion (String concepto, int idReparacion, Double precio){
        this.concepto = concepto;
        this.idReparacion = idReparacion;
        this.precio = precio;
        
    }

    public PagoReparacion(){
        
    }
    public String getConcepto() {return concepto;}
    public void setConcepto(String concepto) {this.concepto = concepto;}

    public int getIdReparacion() {return idReparacion;}
    public void setIdReparacion(int idReparacion) {this.idReparacion = idReparacion;}

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}




}
