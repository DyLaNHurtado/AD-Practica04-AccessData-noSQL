package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.ProgramadorController;
import dto.ProgramadorDTO;
import manager.HibernateController;
import mapper.ProgramadorMapper;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Programador")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProgramadorTest {
    private HibernateController hc;
    private ProgramadorController pc;
    private List<ProgramadorDTO> programadores;
    private ProgramadorMapper mapper;

    @BeforeAll
    void init() {
        hc = HibernateController.getInstance();
        pc = ProgramadorController.getInstance();
        mapper=new ProgramadorMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        mongoDB = mongoClient.getDatabase("test");
        mongoDB.drop();
        ProgramadorDTO prog1 =ProgramadorDTO.builder()
                .nombre("prog1")
                .salario(1000.0)
                .build();
        ProgramadorDTO prog2 = ProgramadorDTO.builder()
                .nombre("prog2")
                .salario(1000.0)
                .build();
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(mapper.fromDTO(prog1));
        hc.getManager().persist(mapper.fromDTO(prog2));
        hc.getTransaction().commit();
        hc.close();
        programadores = pc.getAllProgramadores();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(programadores.size(), pc.getAllProgramadores().size());
        assertEquals(programadores, pc.getAllProgramadores());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(programadores.get(0), pc.getProgramadorById(programadores.get(0).getId()));
        assertNull(pc.getProgramadorById(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(programadores.get(0), pc.updateProgramador(programadores.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        ProgramadorDTO commit3=ProgramadorDTO.builder()
                .nombre("repo3")
                .build();
        assertNotNull(pc.postProgramador(commit3));
        commit3.setId(3L);
        assertNull(pc.postProgramador(commit3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(programadores.get(0), pc.deleteProgramador(programadores.get(0)));
        assertThrows(NullPointerException.class,()-> pc.deleteProgramador(programadores.get(0)));
    }
}
