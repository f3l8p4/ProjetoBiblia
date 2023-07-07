package br.com.empresa.dao;

import javax.persistence.*;


public class HibernateUtil {
    private static final EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("ProjetoExemploPU");
    }

    /**
     * Static method returning EntityManager.
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
