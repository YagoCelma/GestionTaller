/*package PaqueteTaller.model;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductoPedido {
    ArrayList<Pedido> pedido= new ArrayList<>();
    HashMap <Integer, ArrayList<Pedido>> listaPedidos=new HashMap <>();
    private int codigoProducto;
    private String codigoPedido;
    private int idProveedor;
    private String nombre;
    private Double precioProducto;
    private Double precioTotal;
    private Double cantidad;
    private LocalDate fechaCompra; //=LocalDate.of(1990, 5, 15);
    private LocalDate fechaLlegada = null;

    public ProductoPedido (String codigoPedido, int codigoProducto, int idProveedor, String nombre, Double precioProducto, Double cantidad, LocalDate fechaCompra, LocalDate fechaLlegada){
        this.codigoProducto=codigoProducto;
        this.codigoPedido=codigoPedido;
        this.idProveedor=idProveedor;
        this.nombre=nombre;
        this.precioProducto=precioProducto;
        this.fechaCompra = fechaCompra;
        this.fechaLlegada = fechaLlegada;
        this.precioTotal= precioProducto * cantidad;
    }

    public ProductoPedido(){
        
    }
    public Double precioTotal(ArrayList<Pedido> pedidos) {
        Double total = 0.0;
        
        for (Pedido pedido : pedidos) {
            total += pedido.getPrecio(); // Asumiendo que la clase Pedido tiene un método getPrecio()
        }
        
        return total;
    }



}
*/