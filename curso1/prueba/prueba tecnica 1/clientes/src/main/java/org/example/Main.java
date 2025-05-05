package org.example;

import org.example.controllers.ClienteController;
import org.example.entities.Cliente;

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

        Cliente nuevoCliente = new Cliente(null, "Donald", "Trump Walker",
                "M", "Barcelona", "14/06/1946", 6177777,
                "d.trump@gmail.com");


        ClienteController.create(nuevoCliente);

        /*Arraylist initial
        ("'1', 'g.diaz@gmail.com', 'Gonzalez Diaz', 'Madrid', '09-09-1999', 'Antonio', 'M', NULL, '6122222')
        ('2', 'g.diaz@gmail.com', 'Gonzalez Diaz', 'Madrid', '09-09-1999', 'Antonio', 'M', NULL, '6122222')
        ('3', 'n.gomes@gmail.com', 'Valdes Gomes', 'Alicante', '10-10-2001', 'Natalia', 'F', NULL, '6123333')
        ('4', 'a.nathan@gmail.com', 'Nathan Vincent', 'Gijon', '11/11/1991', 'Aron', 'M', NULL, '6166666')
         (5, "Donald", "Trump Walker" ,"M", "Barcelona", "14/06/1946", 6177777, "d.trump@gmail.com");*/




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

    Integer IdRemove = 2;
    clienteController.delete(IdRemove);
        System.out.println("se elimino el cliente con id " + IdRemove);


    }






}