package repository;

import dao.Departamento;
import dao.Programador;
import dao.Proyecto;
import dao.Tecnologia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RepoProgramadorTest {

    private static final RepoProgramador repoProgramador=new RepoProgramador();
    private static List<Programador> list =new ArrayList<>();
    @BeforeAll
    static void init(){

        list.add(new Programador("1376acc9-79a9-4bf1-9084-c82e9a07f432", "Barnie Stinson",LocalDate.now(), Departamento.builder().idDepartamento("2d1d1422-fede-4e27-8883-3ffdb1be1a7c").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false));

        list.add(new Programador("53269670-1586-49ac-9df5-62ddd55f96cc", "Rick Sanchez",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,false,false));


        list.add(new Programador("53269670-1586-49ac-9df5-62ddd55f96cc", "SPOCK",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false));


        list.add(new Programador("53269670-1586-49ac-9df5-62ddd55f96cc", "R2D2",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false));

        list.add(new Programador("53269670-1586-49ac-9df5-62ddd55f96cc", "C3PO",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false));

        list.add(new Programador("6ba7cbcb-7f95-4c6f-b735-2a5e0a363e52", "Mark Knofler",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false));


        list.add(new Programador("5cc55142-469b-4d42-9b9b-b9df2614bcc7", "Will Smith",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false));
        list.add(new Programador("d63f0d73-3f1b-4afd-b5d0-821449daa4a3", "Mike Wazowski",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false));
    }


    @Test
    @Order(1)
    void getAll() throws SQLException {

        int num=repoProgramador.getAll().get().size();
        Assertions.assertEquals(list.size(),num);
    }

    @Test
    @Order(2)
    void getById() throws SQLException {
        Optional<Programador> programador = repoProgramador.getById("d63f0d73-3f1b-4afd-b5d0-821449daa4a3");
        Optional<Programador> programadorNotFound = repoProgramador.getById("8e4-4325-b037-bd4fcfafe783");
        assertTrue(programador.isPresent());
        assertFalse(programadorNotFound.isPresent());
    }

    @Test
    @Order(3)
    void save() throws SQLException {
        Programador programador =new Programador("12345142-469b-4d42-9b9b-b9df2614bcc7", "prueba",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false);
        Optional<Programador> programadorOptional = repoProgramador.save(programador);
        Assertions.assertEquals(programadorOptional.orElse(null),programador);

    }

    @Test
    @Order(4)
    void update() throws SQLException {
        Programador programador =new Programador("12345142-469b-4d42-9b9b-b9df2614bcc7", "prueba",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false);
        Optional<Programador> programadorOptional = repoProgramador.update(programador);
        Assertions.assertEquals(programadorOptional.orElse(null),programador);
    }

    @Test
    @Order(5)
    void delete() throws SQLException {
        Programador programador =new Programador("12345142-469b-4d42-9b9b-b9df2614bcc7", "prueba",LocalDate.now(), Departamento.builder().idDepartamento("1e89386d-be37-4930-b6ae-bcba6c9917b4").build(),List.of(new Proyecto()),List.of(new Tecnologia()),222.0,true,false);
        Optional<Programador> programadorOptional = repoProgramador.delete(programador);
        Assertions.assertEquals(programadorOptional.orElse(null),programador);
    }

}