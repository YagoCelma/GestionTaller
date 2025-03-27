
public class Coche {

    private String matricula;
    private String marca;
    private String modelo;
    private int año;
    private String DNI_Cliente;
    private boolean estado;

    //Constructor
    public Coche(String matricula, String marca, String modelo, int año, String DNI_Cliente, boolean estado ){

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.DNI_Cliente = DNI_Cliente;
        this.estado = estado;
    }

    //Gets y Sets
    public String getMatricula(){return matricula;}
    
}
