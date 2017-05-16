package br.com.uff.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Leo on 15/05/2017.
 */
public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("dw_trabalho");

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
