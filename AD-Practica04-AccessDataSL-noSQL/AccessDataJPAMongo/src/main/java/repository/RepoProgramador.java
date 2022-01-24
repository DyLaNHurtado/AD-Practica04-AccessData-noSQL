package repository;

import dao.*;
import manager.HibernateController;

import javax.persistence.TypedQuery;

import java.sql.SQLException;
import java.util.*;

public class RepoProgramador implements CrudRepository<Programador, Long> {

    @Override
    public Optional<List<Programador>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Programador> query = hc.getManager().createNamedQuery("Programador.getAll", Programador.class);
        List<Programador> list = query.getResultList();
        list.forEach(x -> System.out.println(x.toString()));
        hc.close();
        return Optional.of(list);
    }

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


    @Override
    public Optional<Programador> save(Programador programador) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            //programador.setId(UUID.randomUUID().toString());
            hc.getManager().persist(programador);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(programador);

        } catch (Exception e) {
            throw new SQLException("Error RepoProgramador al insertar Programador en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

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


    @Override
    public Optional<Programador> delete(Programador programador) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            // Ojo que borrar implica que estemos en la misma sesión y nos puede dar problemas, por eso lo recuperamos otra vez
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

    //Operacion 4
    // Programadores con su productividad completa: proyectos , commits
    //(información completa) e issues asignadas (información completa).
    public void allProgramadoresInfo() throws SQLException {
        if (this.getAll().isPresent()) {
            List<Programador> programadores = this.getAll().get();
            //programadores.forEach(x-> System.out.println(x.toStringProductividad()));
        }
    }
}
