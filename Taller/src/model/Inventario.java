package model;

public class Inventario {

    String nombreObjeto;
    int cantidad;
    double precio;

    public Inventario(String nombreObjeto, int cantidad, double precio){
        this.nombreObjeto = nombreObjeto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombreObjeto(){return nombreObjeto;}
    public void setNombreObjeto(String nombreObjeto) {this.nombreObjeto = nombreObjeto;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}
}
