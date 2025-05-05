package org.example.controllers;

import org.example.entities.Cliente;
import org.example.persistence.ClienteJPA;

import java.util.List;


public class ClienteController {

   static ClienteJPA clienteJPA = new ClienteJPA();

    public static void create(Cliente nuevoCliente) {
      clienteJPA.create(nuevoCliente);
    }

    public List<Cliente> findAll() {
        return clienteJPA.findAll();
    }


    public Cliente findOne(Integer idBuscado) {
         return clienteJPA.findOne(idBuscado);
    }

    public Cliente findCity(String ciudadBuscada) {
        return clienteJPA.findCity(ciudadBuscada);
    }

    public void update(Cliente clienteActualizar) {
        clienteJPA.update(clienteActualizar);
    }


    public void delete(Integer IdRemove) {
        clienteJPA.delete(IdRemove);
    }
}
