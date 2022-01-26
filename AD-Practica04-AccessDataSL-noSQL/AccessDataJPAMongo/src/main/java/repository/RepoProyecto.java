package repository;

import dao.*;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class RepoProyecto implements CrudRepository<Proyecto, Long> {
    @Override
    public Optional<List<Proyecto>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Proyecto> query = hc.getManager().createNamedQuery("Proyecto.getAll", Proyecto.class);
        List<Proyecto> list = query.getResultList();
        list.forEach(x -> System.out.println(x.toString()));
        hc.close();
        return Optional.of(list);
    }

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

    @Override
    public Optional<Proyecto> save(Proyecto proyecto) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            //proyecto.setIdProyecto(UUID.randomUUID().toString());
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
            throw new SQLException("Error RepoCommit al actualizar proyecto con id: " + proyecto.getIdProyecto());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<Proyecto> delete(Proyecto proyecto) throws SQLException {

        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            // Ojo que borrar implica que estemos en la misma sesión y nos puede dar problemas, por eso lo recuperamos otra vez
            proyecto = hc.getManager().find(Proyecto.class, proyecto.getIdProyecto());
            hc.getManager().remove(proyecto);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(proyecto);
        } catch (Exception e) {
            throw new SQLException("Error CategoryRepository al eliminar categoria con id: " + proyecto.getIdProyecto());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }


    //Operacion 5

    //Obtener los tres proyectos más caros en base a su presupuesto asignado y el salario
    //de cada trabajador que participa

    public Optional<List<Object>> getProyectosMasCaros() throws SQLException {


        if (this.getAll().isPresent()) {
            List<Proyecto> proyCaros = this.getAll().get().stream()
                    .sorted(Comparator.comparingDouble(Proyecto::getPresupuesto).reversed())
                    .limit(3).collect(Collectors.toList());
            List<Double> salarios = new ArrayList<>();
            proyCaros.forEach(x -> {
                List<Programador> programadores = x.getProgramadores();
                programadores.forEach(s -> salarios.add(s.getSalario()));

            });

            return Optional.of(List.of(proyCaros, salarios));
        }
        System.out.println("No se han encontrado los tres proyectos mas caros y salarios getProyectosMasCaros");
        return Optional.empty();
    }

}
