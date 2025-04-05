/*package PaqueteTaller.model;
import java.time.LocalDate;
import java.util.*;

public class Pedido {

    Scanner sc = new Scanner(System.in);
    HashMap <Integer, ArrayList <ProductoPedido>> mapaPedidos = new HashMap <>();

    //private int idPedido;
    //private LocalDate fechaCompra; //=LocalDate.of(1990, 5, 15);
    //private LocalDate fechaLLegada = null;

    public void crearPedido(){
        int codigoProducto = 0;
        int idProveedor = 0;
        String nombre = null;
        Double precioProducto = 0.0;
        Double cantidad = 0.0;
        LocalDate fechaLlegada;
        LocalDate fechaCompra;
        Double precio =0.0;
        String codigoPedido;
        
        System.out.println("Registra el producto para incorprarlo al pedido");
        System.out.println("Introduce el código del producto:");
       
        
        
            System.out.println("Introduce el código del pedido:");
            codigoPedido= sc.nextLine();
        
        
        
        
        do{
            System.out.println("Introduce el código del producto:");
            codigoProducto= sc.nextInt();
            sc.nextLine();
        }while (codigoProducto<0);


        do{
            System.out.println("Introduce el ID del proveedor:");
            idProveedor= sc.nextInt();
            sc.nextLine();
        }while (idProveedor<0);

        
            System.out.println("Introduce el nombre del producto:");
            nombre= sc.nextLine();
        

        do{
            System.out.println("Introduce el precio del producto:");
            precio= sc.nextDouble();

        }while (precio<0);

        do{
            System.out.println("Introduce la cantidad del producto:");
            cantidad= sc.nextDouble();
        }while (codigoProducto<0);

        fechaCompra = this.introducirFecha();
        fechaLlegada = this.introducirFecha();
        
        ProductoPedido producto = new ProductoPedido(codigoPedido, codigoProducto, idProveedor, nombre, precio, cantidad, fechaCompra, fechaLlegada);
        
        ProductoDao productoDao = new ProductoDao(producto);
    }

    public LocalDate introducirFecha(){
        int año;
        int mes;
        int dia;
        
        LocalDate fecha;
        System.out.println("Introduce la fecha:");
        System.out.println("Año:");
        año=sc.nextInt();
        sc.nextLine();
        System.out.println("Mes:");
        mes=sc.nextInt();
        sc.nextLine();
        System.out.println("Día:");
        dia=sc.nextInt();
        sc.nextLine();
        
        fecha=LocalDate.of(año, mes, dia);
        return fecha;
    }    
}
*/