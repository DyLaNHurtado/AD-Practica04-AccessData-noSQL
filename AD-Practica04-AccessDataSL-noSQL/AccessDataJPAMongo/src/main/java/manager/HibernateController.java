package manager;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Controlador de entidades JPA de Hibernate
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@Getter
public class HibernateController {

    private static HibernateController controller;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;
    private EntityTransaction transaction;

    /**
     * Constructor privado
     */
    private HibernateController() {
    }

    /**
     * Patron Singleton
     * @return HibernateController
     */
    public static HibernateController getInstance() {
        if (controller == null)
            controller = new HibernateController();
        return controller;
    }

    /**
     * Abre la conexión Hibernate
     */
    public void open() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        manager = entityManagerFactory.createEntityManager();
        transaction = manager.getTransaction();
    }

    /**
     * Cierra la conexión Hibernate
     */
    public void close() {
        manager.close();
        entityManagerFactory.close();
    }
}
