public class Inventario {
    private String nombre;
    private Double cantidad;
    private Double precio;

    public Inventario (String nombre, Double cantidad, Double precio){
        this.nombre = nombre;
        this.cantidad=cantidad;
        this.precio=precio;
    }

    public String getNombre() { return nombre;}
    public Double getCantidad() {return cantidad;}
    public Double getPrecio(){return precio;}
    
    public void setNombre (String nombre) { this.nombre= nombre;}
    public void setCantidad  ( Double cantidad) { this.cantidad=cantidad;}
    public void setPrecio( Double precio) { this.precio=precio;}




}
