package PaqueteTaller;

import java.time.LocalDateTime;


public class Citas {

    
    private LocalDateTime fechaCita;
    private String DNI_Cliente;
    private String asunto;
    private String matricula;
    boolean completado;

    public Citas(LocalDateTime fechaCita, String DNI_Cliente, String asunto, String matricula){
        this.asunto=asunto;
        this.fechaCita = fechaCita;
        this.DNI_Cliente = DNI_Cliente;
        this.matricula=matricula;
        this.completado=false;
    }

    //Get y Set
    public void setCompletado(){
        this.completado=true;
    }

}
