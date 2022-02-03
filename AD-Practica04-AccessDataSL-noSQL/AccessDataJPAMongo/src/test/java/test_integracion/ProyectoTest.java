package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.ProyectoController;
import dto.ProyectoDTO;
import manager.HibernateController;
import mapper.ProyectoMapper;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Proyecto")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProyectoTest {
    private HibernateController hc;
    private ProyectoController pc;
    private List<ProyectoDTO> proyectos;
    private ProyectoMapper mapper;

    @BeforeAll
    void init() {
        hc = HibernateController.getInstance();
        pc = ProyectoController.getInstance();
        mapper=new ProyectoMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        mongoDB = mongoClient.getDatabase("test");
        mongoDB.drop();
        ProyectoDTO proy1 =ProyectoDTO.builder()
                .nombre("proy1")
                .presupuesto(50000.0)
                .build();
        ProyectoDTO proy2 = ProyectoDTO.builder()
                .nombre("proy2")
                .presupuesto(50000.0)
                .build();
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(mapper.fromDTO(proy1));
        hc.getManager().persist(mapper.fromDTO(proy2));
        hc.getTransaction().commit();
        hc.close();
        proyectos = pc.getAllProyectos();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(proyectos.size(), pc.getAllProyectos().size());
        assertEquals(proyectos, pc.getAllProyectos());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(proyectos.get(0), pc.getProyectoById(proyectos.get(0).getId()));
        assertNull(pc.getProyectoById(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(proyectos.get(0), pc.updateProyecto(proyectos.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        ProyectoDTO commit3=ProyectoDTO.builder()
                .nombre("repo3")
                .presupuesto(50000.0)
                .build();
        assertNotNull(pc.postProyecto(commit3));
        commit3.setId(3L);
        assertNull(pc.postProyecto(commit3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(proyectos.get(0), pc.deleteProyecto(proyectos.get(0)));
        assertThrows(NullPointerException.class,()-> pc.deleteProyecto(proyectos.get(0)));
    }
}
