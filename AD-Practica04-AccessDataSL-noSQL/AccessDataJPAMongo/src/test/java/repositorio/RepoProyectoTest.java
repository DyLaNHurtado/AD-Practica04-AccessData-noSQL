package repositorio;

import dao.Departamento;
import dao.Programador;
import dao.Proyecto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import repository.RepoProyecto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RepoProyectoTest {
/*
    private static RepoProyecto repoProyecto=new RepoProyecto();
    private static List<Proyecto> list =new ArrayList<>();

    @BeforeAll
    static void init(){
        list.add(new Proyecto("81ee1211-760c-493d-968a-380e6af67363","Power Project",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador())));
        list.add(new Proyecto("f89062d9-ba34-40a4-b6af-a21a0dc093be", "HR Project",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador())));
        list.add(new Proyecto("10f2db5c-a0c3-40ec-a1bf-a95cab6bebdf", "DF Project",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador())));
        list.add(new Proyecto("2d1d1422-fede-4e27-8883-3ffdb1be1a7c", "CD Project",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador())));
        list.add(new Proyecto("233b5d47-0ced-4e6f-8982-b2f95b6b25b9", "Logic Project",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador())));
        list.add(new Proyecto("3730b275-3ed2-4d77-8ff4-f5ce82ea98ea", "JS Project",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador())));
    }



    @Test
    @Order(1)
    void getAll() throws SQLException {

        int num=repoProyecto.getAll().get().size();
        Assertions.assertEquals(list.size(),num);
    }

    @Test
    @Order(2)
    void getById() throws SQLException {
        Optional<Proyecto> proyecto = repoProyecto.getById("10f2db5c-a0c3-40ec-a1bf-a95cab6bebdf");
        Optional<Proyecto> proyectoNotFound = repoProyecto.getById("8e4-4325-b037-bd4fcfafe783");
        assertTrue(proyecto.isPresent());
        assertFalse(proyectoNotFound.isPresent());
    }

    @Test
    @Order(3)
    void save() throws SQLException {
        Proyecto proyecto =new Proyecto("81ee1211-760c-493d-968a-380e6af61234","prueba",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador()));
        Optional<Proyecto> proyectoOptional = repoProyecto.save(proyecto);
        Assertions.assertEquals(proyectoOptional.orElse(null),proyecto);

    }

    @Test
    @Order(4)
    void update() throws SQLException {
        Proyecto proyecto =new Proyecto("81ee1211-760c-493d-968a-380e6af61234","prueba2",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador()));
        Optional<Proyecto> proyectoOptional = repoProyecto.update(proyecto);
        Assertions.assertEquals(proyectoOptional.orElse(null),proyecto);
    }

    @Test
    @Order(5)
    void delete() throws SQLException {
        Proyecto proyecto =new Proyecto("81ee1211-760c-493d-968a-380e6af61234","prueba2",2222222.0,LocalDate.now(), LocalDate.now(),List.of(new Tecnologia()),new Departamento(),List.of(new Programador()));
        Optional<Proyecto> proyectoOptional = repoProyecto.delete(proyecto);
        Assertions.assertEquals(proyectoOptional.orElse(null),proyecto);
    }
 */
}