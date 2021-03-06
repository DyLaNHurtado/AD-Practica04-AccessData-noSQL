package repository;

import dao.*;
import manager.HibernateController;

import javax.persistence.TypedQuery;

import java.sql.SQLException;
import java.util.*;

/**
 * Repositorio de Programador
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepoProgramador implements CrudRepository<Programador, Long> {

    /**
     * Coge todos los Programador de la DB
     * @return Optional<List<Programador>>
     * @throws SQLException Exception
     */
    @Override
    public Optional<List<Programador>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Programador> query = hc.getManager().createNamedQuery("Programador.getAll", Programador.class);
        List<Programador> list = query.getResultList();
        hc.close();
        return Optional.of(list);
    }

    /**
     * Devuelve un Programador a partir de una ID
     * @param id Long
     * @return Optional<Programador>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Programador> getById(Long id) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Programador programador = hc.getManager().find(Programador.class, id);
        hc.close();
        if (programador != null) {
            return Optional.of(programador);
        }
        throw new SQLException("Error RepoProgramador no existe programador con ID: " + id);
    }

    /**
     * Guarda un Programador en la BD
     * @param programador Programador
     * @return Optional<Programador>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Programador> save(Programador programador) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(programador);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(programador);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SQLException("Error RepoProgramador al insertar Programador en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    /**
     * Actualiza un Programador y si no se encuentra lo almacena
     * @param programador Programador
     * @return Optional<Programador>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Programador> update(Programador programador) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(programador);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(programador);
        } catch (Exception e) {
            throw new SQLException("Error RepoProgramador al actualizar Programador con id: " + programador.getId());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    /**
     * Elimina un Programador de la BD
     * @param programador Programador
     * @return Optional<Programador>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Programador> delete(Programador programador) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            programador = hc.getManager().find(Programador.class, programador.getId());
            hc.getManager().remove(programador);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(programador);
        } catch (Exception e) {
            throw new SQLException("Error RepoProgramador al eliminar Programador con id: " + programador.getId());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
