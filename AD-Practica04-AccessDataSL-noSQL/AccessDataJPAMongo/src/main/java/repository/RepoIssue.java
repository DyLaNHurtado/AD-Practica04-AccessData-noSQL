package repository;

import dao.Issue;
import manager.HibernateController;
import org.bson.types.ObjectId;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de Issue
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepoIssue implements CrudRepository<Issue,Long>{
    @Override
    public Optional<List<Issue>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Issue> query = hc.getManager().createNamedQuery("Issue.getAll",Issue.class);
        List<Issue> list = query.getResultList();
        //list.forEach(x-> System.out.println(x.toString()));
        hc.close();
        return Optional.of(list);
    }

    @Override
    public Optional<Issue> getById(Long id) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Issue issue = hc.getManager().find(Issue.class, id);
        hc.close();
        if (issue != null) {
            return Optional.of(issue);
        }
        throw new SQLException("Error RepoIssue no existe Issue con ID: " + id);
    }

    @Override
    public Optional<Issue> save(Issue issue) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(issue);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(issue);
        } catch (Exception e) {
            throw new SQLException("Error RepoIssue al insertar Issue en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<Issue> update(Issue issue) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(issue);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(issue);
        } catch (Exception e) {
            throw new SQLException("Error RepoIssue al actualizar Issue con id: " + issue.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Optional<Issue> delete(Issue issue) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            issue = hc.getManager().find(Issue.class, issue.getId());
            hc.getManager().remove(issue);
            hc.getTransaction().commit();
            hc.close();
            return Optional.of(issue);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error RepoIssue al eliminar Issue con id: " + issue.getId()+e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
