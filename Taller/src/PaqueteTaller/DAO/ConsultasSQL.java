package PaqueteTaller.DAO;
import PaqueteTaller.model.Cliente;

public class ConsultasSQL {

    public void insertarCliente (Cliente cliente){

    }

    public void eliminarCliente (String DNI){

    }


    public void modificarCliente (Cliente cliente){

    }


    public boolean dniRepetido (String dni){

        //Realizamos un recorrido de la BD en la columna DNI
        //Si está, devolvemos un true, si no un false
        String dniBucle;
        for(/*Aqui iria el bucle para recorrer la tabla*/){
        if(dni.equals(dniBucle)){
            return true;
        }else{return false;}

         
        }
    }

    public Cliente getClienteByDni(String dni){
        Cliente cliente = new Cliente();
        
        //hacer los selects
        return cliente;
    }

}
