package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class configJPA {


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("clientes");

    public static EntityManager getEntityManager(){
      return emf.createEntityManager();

    }

    public static void close(){
        emf.close();
    }
}
