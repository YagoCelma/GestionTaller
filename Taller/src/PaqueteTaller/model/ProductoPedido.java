package PaqueteTaller.model;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductoPedido {
    ArrayList<Pedidos> pedido= new ArrayList<>();
    HashMap <Integer, ArrayList<Pedidos>> listaPedidos=new HashMap <>();
    private int codigoProducto;
    private int idProveedor;
    private String nombre;
    private Double precioProducto;
    private Double precioTotal;
    private Double cantidad;
    private LocalDate fechaCompra; //=LocalDate.of(1990, 5, 15);
    private LocalDate fechaLLegada = null;

    public ProductoPedido (int codigoProducto, int idProveedor, String nombre, Double precioProducto, Double cantidad, int año, int mes, int dia, int año2, int mes2, int dia2){
        this.codigoProducto=codigoProducto;
        this.idProveedor=idProveedor;
        this.nombre=nombre;
        this.precioProducto=precioProducto;
        this.fechaCompra = LocalDate.of(año, mes, dia);
        this.fechaLLegada = LocalDate.of(año2, mes2, dia2);
        this.precioTotal= precioProducto * cantidad;
    }
    public Double precioTotal (ArrayList <Pedidos> pedidos){
        for (ArrayList pedido: pedidos){
            
        }

    }



}
