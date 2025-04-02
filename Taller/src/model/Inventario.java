package model;

public class Inventario {

    int numeroProducto;
    String nombreObjeto;
    int cantidad;
    double precio;

    public Inventario(int numeroProducto, String nombreObjeto, int cantidad, double precio){
        this.numeroProducto = numeroProducto;
        this.nombreObjeto = nombreObjeto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getNumeroProducto() {return numeroProducto;}
    public void setNumeroProducto(int numeroProducto) {this.numeroProducto = numeroProducto;}

    public String getNombreObjeto(){return nombreObjeto;}
    public void setNombreObjeto(String nombreObjeto) {this.nombreObjeto = nombreObjeto;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}
}
