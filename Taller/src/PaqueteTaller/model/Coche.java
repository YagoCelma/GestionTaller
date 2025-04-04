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

    //Gets y Sets
    public String getMatricula(){return matricula;}
    
}
