package PaqueteTaller.model;

public class Coche {

    private String matricula;
    private String marca;
    private String modelo;
    private int año;
    private String DNI_Cliente;
    

    //Constructor
    public Coche(String matricula, String marca, String modelo, int año, String DNI_Cliente){

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.DNI_Cliente = DNI_Cliente;
    }

    
    public Coche(){
        
    }

    //Gets y Sets
    public String getMatricula(){return matricula;}
    public void setMatricula(String matricula){this.matricula = matricula;}

    public String getMarca(){return marca;}
    public void setMarca(String marca){this.marca = marca;}
    
    public String getModelo(){return modelo;}
    public void setModelo(String modelo){this.modelo = modelo;}
    
    public int getAño(){return año;}
    public void setAño(int año){this.año = año;}
    
    public String getDNI_Cliente(){return DNI_Cliente;}
    public void setDNI_Cliente(String DNI_Cliente){this.DNI_Cliente = DNI_Cliente;}
    
}

