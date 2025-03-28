
import java.time.LocalDate;
import java.util.*;

public class Pedido {

    Scanner sc = new Scanner(System.in);
    HashMap <Integer, ArrayList <ProductoPedido>> mapaPedidos = new HashMap <>();

    private int idPedido;
    private LocalDate fechaCompra; //=LocalDate.of(1990, 5, 15);
    private LocalDate fechaLLegada = null;

    public void crearPedido(){
        int codigoProducto;
        int idProveedor;
        String nombre;
        Double precioProducto;
        Double cantidad;
        System.out.println("Registra el producto para incorprarlo al pedido");
        System.out.println("Introduce el código del producto:");
        do{
            System.out.println("Introduce el código del producto:");
            codigoProducto= sc.nextInt();
        }while (codigoProducto<0);


        do{
            System.out.println("Introduce el ID del proveedor:");
            idProveedor= sc.nextInt();
        }while (codigoProducto<0);

        do{
            System.out.println("Introduce el nombre del producto:");
            nombre= sc.nextLine();
            sc.next();
        }while (codigoProducto<0);
        do{
            System.out.println("Introduce el código del producto:");
            codigoProducto= sc.nextInt();
        }while (codigoProducto<0);

        do{
            System.out.println("Introduce la cantidad del producto:");
            codigoProducto= sc.nextInt();
        }while (codigoProducto<0);

        ProductoPedido producto = new ProductoPedido(int codigoProducto, int idProveedor, String nombre, Double precioProducto, Double cantidad);

    }


}
