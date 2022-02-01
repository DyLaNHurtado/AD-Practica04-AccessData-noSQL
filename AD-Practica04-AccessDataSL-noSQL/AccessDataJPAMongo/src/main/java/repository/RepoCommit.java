package repository;

import dao.Commit;
import manager.HibernateController;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RepoCommit implements CrudRepository<Commit,Long>{
    @Override
    public Optional<List<Commit>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        List<Commit> list = hc.getManager().createNamedQuery("Commit.getAll",Commit.class).getResultList();
        hc.close();
        return Optional.of(list);
    }

    @Override
    public Optional<Commit> getById(Long id) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Commit commit = hc.getManager().find(Commit.class, id);
        hc.close();
        if (commit != null) {
            return Optional.of(commit);
        }
        throw new SQLException("Error RepoCommit no existe Commit con ID: " + id);
    }

    @Override
    public Optional<Commit> save(Commit commit) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(commit);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(commit);
        } catch (Exception e) {
            throw new SQLException("Error RepoCommit al insertar Commit en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<Commit> update(Commit commit) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(commit);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(commit);
        } catch (Exception e) {
            throw new SQLException("Error RepoCommit al actualizar commit con id: " + commit.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<Commit> delete(Commit commit) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            commit = hc.getManager().find(Commit.class, commit.getId());
            hc.getManager().remove(commit);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(commit);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error RepoCommit al eliminar Commit con id: " + commit.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
