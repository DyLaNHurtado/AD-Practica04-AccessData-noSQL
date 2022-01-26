package repositorio;

import dao.Departamento;
import dao.Programador;
import dao.Proyecto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import repository.RepoDepartamento;

import java.sql.SQLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RepoDepartamentoTest {
    /*
    private static RepoDepartamento repoDepartamento=new RepoDepartamento();
    private static List<Departamento> list =new ArrayList<>();

    @BeforeAll
    static void init() {
        //list.add(new Departamento("1e89386d-be37-4930-b6ae-bcba6c9917b4", "Recursos Humanos",List.of(new Programador()),List.of(new Proyecto()),List.of(new Proyecto()),22222.0,222222.0,List.of(new Programador())));

        //list.add(new Departamento("2d1d1422-fede-4e27-8883-3ffdb1be1a7c", "Marketing",List.of(new Programador()),List.of(new Proyecto()),List.of(new Proyecto()),5555.0,222222.0,List.of(new Programador())));

        //list.add(new Departamento("512a0695-3294-4c2c-86d9-4babd4485fa8", "Logistica",List.of(new Programador()),List.of(new Proyecto()),List.of(new Proyecto()),9999.0,222222.0,List.of(new Programador())));

    }

    @Test
    @Order(1)
    void getAll() throws SQLException {

        int num=repoDepartamento.getAll().get().size();
        Assertions.assertEquals(list.size(),num);

    }

    @Test
    @Order(2)
    void getById() throws SQLException {
        Optional<Departamento> departamento = repoDepartamento.getById("1e89386d-be37-4930-b6ae-bcba6c9917b4");
        Optional<Departamento> departamentoNotFound = repoDepartamento.getById("be37-4930-b6ae");
        assertTrue(departamento.isPresent());
        assertFalse(departamentoNotFound.isPresent());
    }

    @Test
    @Order(3)
    void save() throws SQLException {
        Departamento departamento =new Departamento("1234386d-be37-4930-b6ae-bcba6c991234", "prueba",List.of(new Programador()),List.of(new Proyecto()),List.of(new Proyecto()),22222.0,222222.0,List.of(new Programador()));
        Optional<Departamento> departamentoOptional  = repoDepartamento.save(departamento);
        Assertions.assertEquals(departamentoOptional.orElse(null),departamento);
    }

    @Test
    @Order(4)
    void update() throws SQLException {
        Departamento departamento =new Departamento("1234386d-be37-4930-b6ae-bcba6c991234", "prueba2",List.of(new Programador()),List.of(new Proyecto()),List.of(new Proyecto()),22222.0,222222.0,List.of(new Programador()));
        Optional<Departamento> departamentoOptional  = repoDepartamento.update(departamento);
        Assertions.assertEquals(departamentoOptional.orElse(null),departamento);
    }

    @Test
    @Order(5)
    void delete() throws SQLException {
        Departamento departamento =new Departamento("1234386d-be37-4930-b6ae-bcba6c991234", "prueba2",List.of(new Programador()),List.of(new Proyecto()),List.of(new Proyecto()),22222.0,222222.0,List.of(new Programador()));
        Optional<Departamento> departamentoOptional  = repoDepartamento.delete(departamento);
        Assertions.assertEquals(departamentoOptional.orElse(null),departamento);
    }
     */
}