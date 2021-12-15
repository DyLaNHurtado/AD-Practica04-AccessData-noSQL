package repository;

import dao.Departamento;
import dao.Programador;
import dao.Proyecto;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RepoDepartamento implements CrudRepository<Departamento, String> {
    @Override
    public Optional<List<Departamento>> getAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Departamento> query = hc.getManager().createNamedQuery("Departamento.getAll",Departamento.class);
        List<Departamento> list = query.getResultList();
        list.forEach(x-> System.out.println(x.toString()));
        hc.close();
        return Optional.of(list);

    }

    @Override
    public Optional<Departamento> getById(String id) throws SQLException {
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
            departamento.setIdDepartamento(UUID.randomUUID().toString());
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
            throw new SQLException("Error RepoDepartamento al actualizar departamento con id: " + departamento.getIdDepartamento()+e.getMessage());
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
                // Ojo que borrar implica que estemos en la misma sesión y nos puede dar problemas, por eso lo recuperamos otra vez
                departamento = hc.getManager().find(Departamento.class, departamento.getIdDepartamento());
                hc.getManager().remove(departamento);
                hc.getTransaction().commit();
                hc.close();
                return Optional.of(departamento);
            } catch (Exception e) {
                e.printStackTrace();
                throw new SQLException("Error DepartamentoRepository al eliminar Departamento con id: " + departamento.getIdDepartamento()+e.getMessage());

            } finally {
                if (hc.getTransaction().isActive()) {
                    hc.getTransaction().rollback();
                }
                hc.close();
            }
        }

    // Operacion 1:
    //Obtener de un departamento, los proyectos (información completa) y trabajadores
    //asociados con sus datos completos
    public void departamentoInfo(String id) throws SQLException {

        if(this.getById(id).isPresent()){
            Departamento departamento = this.getById(id).get();

            //System.out.println(departamento.toStringInfo());
    }}

}
