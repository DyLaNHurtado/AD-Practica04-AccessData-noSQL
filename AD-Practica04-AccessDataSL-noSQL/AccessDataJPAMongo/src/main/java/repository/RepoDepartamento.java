package repository;

import dao.Departamento;
import manager.HibernateController;
import org.bson.types.ObjectId;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de Departamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepoDepartamento implements CrudRepository<Departamento, Long> {
    @Override
    public Optional<List<Departamento>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Departamento> query = hc.getManager().createNamedQuery("Departamento.getAll", Departamento.class);
        List<Departamento> list = query.getResultList();
        hc.close();
        return Optional.of(list);
    }

    @Override
    public Optional<Departamento> getById(Long id) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Departamento departamento = hc.getManager().find(Departamento.class, id);
        hc.close();
        if (departamento != null) {
            return Optional.of(departamento);
        }
        throw new SQLException("Error RepoDepartamento no existe Departamento con ID: " + id);
    }

    @Override
    public Optional<Departamento> save(Departamento departamento) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(departamento);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(departamento);

        } catch (Exception e) {
            throw new SQLException("Error RepoDepartamento al insertar Departamento en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<Departamento> update(Departamento departamento) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(departamento);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(departamento);
        } catch (Exception e) {
            throw new SQLException("Error RepoDepartamento al actualizar departamento con id: " + departamento.getId() + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<Departamento> delete(Departamento departamento) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            departamento = hc.getManager().find(Departamento.class, departamento.getId());
            hc.getManager().remove(departamento);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(departamento);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error DepartamentoRepository al eliminar Departamento con id: " + departamento.getId() + e.getMessage());

        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
