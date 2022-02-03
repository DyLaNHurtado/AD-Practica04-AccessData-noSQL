package repository;

import dao.*;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Repositorio de Proyecto
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepoProyecto implements CrudRepository<Proyecto, Long> {

    /**
     * Coge todos los Proyecto de la DB
     * @return Optional<List<Proyecto>>
     * @throws SQLException Exception
     */
    @Override
    public Optional<List<Proyecto>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Proyecto> query = hc.getManager().createNamedQuery("Proyecto.getAll", Proyecto.class);
        List<Proyecto> list = query.getResultList();
        hc.close();
        return Optional.of(list);
    }

    /**
     * Devuelve un Proyecto a partir de una ID
     * @param id Long
     * @return Optional<Proyecto>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Proyecto> getById(Long id) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Proyecto proyecto = hc.getManager().find(Proyecto.class, id);
        hc.close();
        if (proyecto != null) {
            return Optional.of(proyecto);
        }
        throw new SQLException("Error RepoIssue no existe proyecto con ID: " + id);
    }

    /**
     * Guarda un Proyecto en la BD
     * @param proyecto Proyecto
     * @return Optional<Proyecto>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Proyecto> save(Proyecto proyecto) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(proyecto);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(proyecto);

        } catch (Exception e) {
            throw new SQLException("Error " + this.getClass().toString() + " al insertar proyecto en BD" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    /**
     * Actualiza un Proyecto y si no se encuentra lo almacena
     * @param proyecto Proyecto
     * @return Optional<Proyecto>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Proyecto> update(Proyecto proyecto) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(proyecto);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(proyecto);
        } catch (Exception e) {
            throw new SQLException("Error RepoCommit al actualizar proyecto con id: " + proyecto.getId());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    /**
     * Elimina un Proyecto de la BD
     * @param proyecto Proyecto
     * @return Optional<Proyecto>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Proyecto> delete(Proyecto proyecto) throws SQLException {

        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            proyecto = hc.getManager().find(Proyecto.class, proyecto.getId());
            hc.getManager().remove(proyecto);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(proyecto);
        } catch (Exception e) {
            throw new SQLException("Error CategoryRepository al eliminar categoria con id: " + proyecto.getId());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
