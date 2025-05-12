package org.example;

import org.example.controllers.ClienteController;
import org.example.entities.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        List<Cliente> todosLosClientes = clienteController.findAll();
//buscar todos los clientes
        System.out.println(todosLosClientes);
       for (Cliente cliente : todosLosClientes) {
            System.out.println(cliente);
        }



//crear clientes
        //id null para dejar a la bd poner su propio id
        /*List<Cliente> listadoClientes =new ArrayList<>();
        listadoClientes.add(new Cliente(1, "Antonio", "Gonzalez Diaz", "M", "Madrid", "09-09-1999", 6122222, "g.diaz@gmail.com"));
        listadoClientes.add(new Cliente(2,"Roberto","Ronaldo","M","Barcelona","16-06-2004",062555,"r.ronaldo@gmail.com"));
        listadoClientes.add(new Cliente(3,"Cesar","Ronaldo","M","Barcelona","16-08-2003",0625556,"c.ronaldo@gmail.com"));
        listadoClientes.add(new Cliente(4,"Mercedes","Ronaldo","M","Barcelona","16-07-2001",0655556,"m.ronaldo@gmail.com"));*/

        Cliente nuevoCliente = new Cliente(null, "Cesar", "Ronaldo",
                "M", "Barcelona", "16-08-2003", 6125556,
                "dc.ronaldo@gmail.com");


        ClienteController.create(nuevoCliente);


  // buscar un cliente por Id
        Integer idBuscado = 4;
      Cliente clienteEncontrado = clienteController.findOne(idBuscado);

       System.out.println(clienteEncontrado);

  //buscar ciudad

        String ciudadBuscada = "Alicante" ;
        Cliente ciudadEncontrada = clienteController.findCity(ciudadBuscada);

        System.out.println("Alicante" + ciudadEncontrada.getCiudad());



  //update data 3 Natalia to nataly

   Cliente clienteActualizar = clienteController.findOne(3);
        System.out.println(clienteActualizar);
        clienteActualizar.setNombre("Nataly");
        clienteController.update(clienteActualizar);



  // delete data id 2 ('2', 'g.diaz@gmail.com', 'Gonzalez Diaz', 'Madrid', '09-09-1999', 'Antonio', 'M', NULL, '6122222')

    Integer IdRemove = 9;
    clienteController.delete(IdRemove);
        System.out.println("se elimino el cliente con id " + IdRemove);


    }






}