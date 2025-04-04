package PaqueteTaller.DAO;
import PaqueteTaller.model.Reparaciones;
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

    public void mostrarReparaciones(){

    }

    public void mostrarReparacionByTrabajador(int idEmpleado){

    }

    public void mostrarReparacionActiva(){

    }

    public void mostrarReparacionByFechaInicio(LocalDateTime fechaInicio){
        
    }

    public void mostrarReparacionByFechaFinal(LocalDateTime fechaFinal){
        
    }

    public void mostrarReparacionByFechaReciente(LocalDateTime fechaReciente){
        
    }

    public void mostrarReparacionByMatricula(String matricula){
        
    }


    //gets
    public int getIdReparacion(){
        int idReparacion=0;
        return idReparacion;
    }

    public LocalDateTime getFechaInicioReparacion(int idReparacion){
        LocalDateTime fecha = null;
        return fecha;
    }

    public LocalDateTime getFechaFinalReparacion(int idReparacion){
        LocalDateTime fecha = null;
        return fecha;
    }

    public Double getHoras(int idReparacion){
        Double horas=null;
        return horas;
    }

    public String getNombreReparacion(int idReparacion){
        String nombreReparacion = "nombre";
        return nombreReparacion;

    }
}
