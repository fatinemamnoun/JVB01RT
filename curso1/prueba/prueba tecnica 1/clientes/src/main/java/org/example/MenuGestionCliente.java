package org.example;

import org.example.controllers.ClienteController;
import org.example.entities.Cliente;

import java.util.Scanner;

public class MenuGestionCliente {



    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int opcion =0;




        switch (opcion){

             case 1 ->   ClienteController.create(nuevoCliente);
                 break;;
             case 2 ->   Cliente clienteEncontrado = clienteController.findOne(idBuscado);
                 break;;
             case 3 ->   Cliente clienteActualizar = clienteController.findOne(3); ;;
                 break;;
             case 4 ->   clienteController.delete(IdRemove);;
                 break;;
             default -> System.out.println("Opción no válida.");
        }

    }
}
