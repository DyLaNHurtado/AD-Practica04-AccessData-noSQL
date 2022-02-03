package repository;

import dao.Repositorio;
import manager.HibernateController;
import org.bson.types.ObjectId;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de Repositorio
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepoRepositorio implements CrudRepository<Repositorio,Long>{

    /**
     * Coge todos los Repositorio de la DB
     * @return Optional<List<Repositorio>>
     * @throws SQLException Exception
     */
    @Override
    public Optional<List<Repositorio>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Repositorio> query = hc.getManager().createNamedQuery("Repositorio.getAll",Repositorio.class);
        List<Repositorio> list = query.getResultList();
        hc.close();
        return Optional.of(list);
    }

    /**
     * Devuelve un Repositorio a partir de una ID
     * @param id Long
     * @return Optional<Repositorio>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Repositorio> getById(Long id) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Repositorio repositorio = hc.getManager().find(Repositorio.class, id);
        hc.close();
        if (repositorio != null) {
            return Optional.of(repositorio);
        }
        throw new SQLException("Error RepoRepositorio no existe repositorio con ID: " + id);
    }

    /**
     * Guarda un Repositorio en la BD
     * @param repositorio Repositorio
     * @return Optional<Repositorio>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Repositorio> save(Repositorio repositorio) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(repositorio);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(repositorio);
        } catch (Exception e) {
            throw new SQLException("Error RepoRepositorio al insertar repositorio en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    /**
     * Actualiza un Repositorio y si no se encuentra lo almacena
     * @param repositorio Repositorio
     * @return Optional<Repositorio>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Repositorio> update(Repositorio repositorio) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(repositorio);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(repositorio);
        } catch (Exception e) {
            throw new SQLException("Error RepoRepositorio al actualizar repositorio con id: " + repositorio.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    /**
     * Elimina un Repositorio de la BD
     * @param repositorio Repositorio
     * @return Optional<Repositorio>
     * @throws SQLException Exception
     */
    @Override
    public Optional<Repositorio> delete(Repositorio repositorio) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            repositorio = hc.getManager().find(Repositorio.class, repositorio.getId());
            hc.getManager().remove(repositorio);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(repositorio);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error RepoRepositorio al eliminar repositorio con id: " + repositorio.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
