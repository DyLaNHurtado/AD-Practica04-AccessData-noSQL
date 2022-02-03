package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.JefeProyectoController;
import dto.JefeProyectoDTO;
import manager.HibernateController;
import mapper.JefeProyectoMapper;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test JefeProyecto")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JefeProyectoTest {
    private HibernateController hc;
    private JefeProyectoController jpc;
    private List<JefeProyectoDTO> jefes;
    private JefeProyectoMapper mapper;

    @BeforeAll
    void init() {
        hc = HibernateController.getInstance();
        jpc = JefeProyectoController.getInstance();
        mapper=new JefeProyectoMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        mongoDB = mongoClient.getDatabase("test");
        mongoDB.drop();
        JefeProyectoDTO jefe1 =JefeProyectoDTO.builder()
                .nombre("jefe1")
                .build();
        JefeProyectoDTO jefe2 = JefeProyectoDTO.builder()
                .nombre("jefe2")
                .build();
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(mapper.fromDTO(jefe1));
        hc.getManager().persist(mapper.fromDTO(jefe2));
        hc.getTransaction().commit();
        hc.close();
        jefes = jpc.getAllJefeProyecto();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(jefes.size(), jpc.getAllJefeProyecto().size());
        assertEquals(jefes, jpc.getAllJefeProyecto());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(jefes.get(0), jpc.getJefeProyectoById(jefes.get(0).getId()));
        assertNull(jpc.getJefeProyectoById(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(jefes.get(0), jpc.updateJefeProyecto(jefes.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        JefeProyectoDTO commit3=JefeProyectoDTO.builder()
                .nombre("repo3")
                .build();
        assertNotNull(jpc.postJefeProyecto(commit3));
        commit3.setId(3L);
        assertNull(jpc.postJefeProyecto(commit3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(jefes.get(0), jpc.deleteJefeProyecto(jefes.get(0)));
        assertThrows(NullPointerException.class,()-> jpc.deleteJefeProyecto(jefes.get(0)));
    }
}
