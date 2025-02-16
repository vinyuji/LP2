package ifmt.cba.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("vendas2");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}