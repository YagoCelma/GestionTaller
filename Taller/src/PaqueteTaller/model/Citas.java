package PaqueteTaller.model;

import java.time.LocalDateTime;


public class Citas {

    
    private LocalDateTime fechaCita;
    private String DNI_Cliente;
    private String asunto;
    private String matricula;
    boolean acudido;

    public Citas(LocalDateTime fechaCita, String DNI_Cliente, String asunto, String matricula){
        this.asunto=asunto;
        this.fechaCita = fechaCita;
        this.DNI_Cliente = DNI_Cliente;
        this.matricula=matricula;
        this.acudido = false;
    }


        public LocalDateTime getFechaCita() { return fechaCita; }
        public void setFechaCita(LocalDateTime fechaCita) { this.fechaCita = fechaCita; }

        public String getDNI_Cliente() { return DNI_Cliente; }
        public void setDNI_Cliente(String DNI_Cliente) { this.DNI_Cliente = DNI_Cliente; }

        public String getAsunto() { return asunto; }
        public void setAsunto(String asunto) { this.asunto = asunto; }

        public String getMatricula() { return matricula; }
        public void setMatricula(String matricula) { this.matricula = matricula; }
        
        public boolean getAcudido() { return acudido; }
        public void setAcudido(boolean acudido) { this.acudido = true; }

}
