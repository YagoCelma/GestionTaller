package PaqueteTaller.DAO;
import PaqueteTaller.Reparaciones;
import java.time.*;

public class ReparacionesDao {


    public void crearReparacion(Reparaciones reparacion){

    }

    public void eliminarReparacion(int idReparacion){

    }
    
    public void mostrarReparacionById(int idReparacion){


    }

    //sets
    
    public void setNombreReparacion(int idReparacion, String nombreReparacion){

    }
    public void setIdCita(int idReparacion,int idCita){

    }
    public void setFechaInicio(int idReparacion,LocalDateTime fechaInicio){
        
    }
    public void setFechaFinal(int idReparacion,LocalDateTime fechaFinal){
        
    }
    public void setAcabado(int idReparacion,boolean acabado){
        
    }
    public void setHoras(int idReparacion,Double horas){
        
    }
    public void setAsunto(int idReparacion,String asunto){
        
    }

    //este metodo enlaza en una tabla auxiliar los id de empleados y su id de reparacion
    public void añadirEmpleado(int idReparacion,int idEmpleados){

    }
    public void eliminarEmpleado(int idReparacion,int idEmpleados){

    }


    public void añadirProducto(String producto, int cantidad, Double precio, int reparacionId){

    }

    //gets
    public int getIdReparacion(){
        int idReparacion=0;
        return idReparacion;
    }

}
