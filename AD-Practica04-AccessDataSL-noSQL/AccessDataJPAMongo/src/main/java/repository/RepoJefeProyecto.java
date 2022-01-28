package repository;

import dao.JefeProyecto;
import manager.HibernateController;
import org.bson.types.ObjectId;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RepoJefeProyecto implements CrudRepository<JefeProyecto,Long> {
    @Override
    public Optional<List<JefeProyecto>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<JefeProyecto> query = hc.getManager().createNamedQuery("JefeProyecto.getAll",JefeProyecto.class);
        List<JefeProyecto> list = query.getResultList();
        //list.forEach(x-> System.out.println(x.toString()));
        hc.close();
        return Optional.of(list);
    }

    @Override
    public Optional<JefeProyecto> getById(Long id) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        JefeProyecto jefe = hc.getManager().find(JefeProyecto.class, id);
        hc.close();
        if (jefe != null) {
            return Optional.of(jefe);
        }
        throw new SQLException("Error RepoJefeProyecto no existe jefe con ID: " + id);
    }

    @Override
    public Optional<JefeProyecto> save(JefeProyecto jefe) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(jefe);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(jefe);
        } catch (Exception e) {
            throw new SQLException("Error RepoJefeProyecto al insertar jefe en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<JefeProyecto> update(JefeProyecto jefe) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(jefe);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(jefe);
        } catch (Exception e) {
            throw new SQLException("Error RepoJefeProyecto al actualizar jefe con id: " + jefe.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<JefeProyecto> delete(JefeProyecto jefe) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            jefe = hc.getManager().find(JefeProyecto.class, jefe.getId());
            hc.getManager().remove(jefe);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(jefe);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error RepoJefeProyecto al eliminar jefe con id: " + jefe.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
