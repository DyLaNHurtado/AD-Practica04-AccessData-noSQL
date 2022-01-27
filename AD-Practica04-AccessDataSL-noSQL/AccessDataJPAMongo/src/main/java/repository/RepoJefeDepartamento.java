package repository;

import dao.JefeDepartamento;
import manager.HibernateController;
import org.bson.types.ObjectId;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RepoJefeDepartamento implements CrudRepository<JefeDepartamento,Long>{
    @Override
    public Optional<List<JefeDepartamento>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<JefeDepartamento> query = hc.getManager().createNamedQuery("JefeDepartamento.getAll",JefeDepartamento.class);
        List<JefeDepartamento> list = query.getResultList();
        list.forEach(x-> System.out.println(x.toString()));
        hc.close();
        return Optional.of(list);
    }

    @Override
    public Optional<JefeDepartamento> getById(Long id) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        JefeDepartamento jefe = hc.getManager().find(JefeDepartamento.class, id);
        hc.close();
        if (jefe != null) {
            return Optional.of(jefe);
        }
        throw new SQLException("Error RepoJefeDepartamento no existe jefe con ID: " + id);
    }

    @Override
    public Optional<JefeDepartamento> save(JefeDepartamento jefe) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            jefe.setId(Long.parseLong(ObjectId.get().toString()));
            hc.getManager().persist(jefe);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(jefe);
        } catch (Exception e) {
            throw new SQLException("Error RepoJefeDepartamento al insertar jefe en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<JefeDepartamento> update(JefeDepartamento jefe) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(jefe);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(jefe);
        } catch (Exception e) {
            throw new SQLException("Error RepoJefeDepartamento al actualizar jefe con id: " + jefe.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<JefeDepartamento> delete(JefeDepartamento jefe) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            jefe = hc.getManager().find(JefeDepartamento.class, jefe.getId());
            hc.getManager().remove(jefe);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(jefe);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error RepoJefeDepartamento al eliminar jefe con id: " + jefe.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}