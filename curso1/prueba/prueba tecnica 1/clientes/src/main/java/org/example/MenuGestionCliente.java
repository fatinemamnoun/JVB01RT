package org.example;

import org.example.controllers.ClienteController;
import org.example.entities.Cliente;

import java.util.Scanner;

public class MenuGestionCliente {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();
        int opcion = 0;


        do {
            System.out.println("\nMenú:");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    Cliente nuevoCliente = new Cliente(nombre);
                    clienteController.create(nuevoCliente);
                    System.out.println("Cliente creado correctamente.");
                }
                case 2 -> {
                    System.out.print("Ingrese ID del cliente a buscar: ");
                    int id = scanner.nextInt();
                    Cliente clienteEncontrado = clienteController.findOne(1);
                    System.out.println(clienteEncontrado != null ? clienteEncontrado : "Cliente no encontrado.");
                }
                case 3 -> {
                    System.out.print("Ingrese ID del cliente a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    Cliente clienteActualizar = new Cliente(2);
                    clienteController.update(clienteActualizar);
                    System.out.println("Cliente actualizado.");
                }
                case 4 -> {
                    System.out.print("Ingrese ID del cliente a eliminar: ");
                    int idRemove = scanner.nextInt();
                    clienteController.delete(idRemove);
                    System.out.println("Cliente eliminado correctamente.");
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
