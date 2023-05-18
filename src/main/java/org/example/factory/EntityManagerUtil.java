package org.example.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManager entityManager;

    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerUtil() {

    }

    public static EntityManager getManager(String persistenceUnit){

        if(entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
            entityManager = entityManagerFactory.createEntityManager();

            return entityManager;
        }

        return entityManager;

    }
}
