package org.example.persistence;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Cliente;

import java.util.List;

 public class ClienteJPA {

     public List<Cliente> findAll() {
         EntityManager em = configJPA.getEntityManager();
         try {
             TypedQuery<Cliente> query = em.createQuery("SELECT p FROM clientes p", Cliente.class);
             return query.getResultList();
         } finally {
             em.close();
         }


     }


     public void create(Cliente nuevoCliente) {
         EntityManager em = configJPA.getEntityManager();

         try {
             em.getTransaction().begin(); //para guardar en caso que se borre algo
             em.persist(nuevoCliente);
             em.getTransaction().commit();  //para guardar datos en caso de delete

         } finally {
             em.close();

         }
     }


     public Cliente findOne(Integer idBuscado) {
         EntityManager em = configJPA.getEntityManager();

         try {
             return em.find(Cliente.class, idBuscado);


         }finally {
             em.close();

         }
     }

     public Cliente findCity(String ciudadBuscada) {
         EntityManager em = configJPA.getEntityManager();

         try {
             return em.find(Cliente.class ,ciudadBuscada);

         }finally {
             em.close();

         }

     }

     public void update(Cliente clienteActualizar) {
         EntityManager em = configJPA.getEntityManager();
         try {
             em.getTransaction().begin();  //iniciar la actualization
             em.merge(clienteActualizar);  //merge unir para actualizar
             em.getTransaction().commit(); //guardar actualization

         }finally {
          em.close();

         }
     }

     public void delete(Integer IdRemove) {
         EntityManager em = configJPA.getEntityManager();
         try {
             em.getTransaction().begin();  //iniciar elimination
             Cliente clienteEncontrado = em.find(Cliente.class,IdRemove);
             if (clienteEncontrado != null){
              em.remove(clienteEncontrado);
         }else {
                 System.out.println("el id " + IdRemove +"no existe");
         }
             em.getTransaction().commit(); //ejecutar elimination

         }finally {
            em.close();
         }

     }
 }
