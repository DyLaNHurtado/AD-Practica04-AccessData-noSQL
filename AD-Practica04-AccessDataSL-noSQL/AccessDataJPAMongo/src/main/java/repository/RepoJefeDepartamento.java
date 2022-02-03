package repository;

import dao.JefeDepartamento;
import manager.HibernateController;
import org.bson.types.ObjectId;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de JefeDepartamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepoJefeDepartamento implements CrudRepository<JefeDepartamento,Long>{

    /**
     * Coge todos los JefeDepartamento de la DB
     * @return Optional<List<JefeDepartamento>>
     * @throws SQLException Exception
     */
    @Override
    public Optional<List<JefeDepartamento>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<JefeDepartamento> query = hc.getManager().createNamedQuery("JefeDepartamento.getAll",JefeDepartamento.class);
        List<JefeDepartamento> list = query.getResultList();
        hc.close();
        return Optional.of(list);
    }

    /**
     * Devuelve un JefeDepartamento a partir de una ID
     * @param id Long
     * @return Optional<JefeDepartamento>
     * @throws SQLException Exception
     */
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

    /**
     * Guarda un JefeDepartamento en la BD
     * @param jefe JefeDepartamento
     * @return Optional<JefeDepartamento>
     * @throws SQLException Exception
     */
    @Override
    public Optional<JefeDepartamento> save(JefeDepartamento jefe) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
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

    /**
     * Actualiza un JefeDepartamento y si no se encuentra lo almacena
     * @param jefe JefeDepartamento
     * @return Optional<JefeDepartamento>
     * @throws SQLException Exception
     */
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

    /**
     * Elimina un JefeDepartamento de la BD
     * @param jefe JefeDepartamento
     * @return Optional<JefeDepartamento>
     * @throws SQLException Exception
     */
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