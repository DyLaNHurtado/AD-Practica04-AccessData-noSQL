package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.JefeDepartamentoController;
import dto.JefeDepartamentoDTO;
import manager.HibernateController;
import mapper.JefeDepartamentoMapper;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test JefeDepartamento")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JefeDepartamentoTest {
    private HibernateController hc;
    private JefeDepartamentoController jdc;
    private List<JefeDepartamentoDTO> jefes;
    private JefeDepartamentoMapper mapper;

    @BeforeAll
    void init() {
        hc = HibernateController.getInstance();
        jdc = JefeDepartamentoController.getInstance();
        mapper=new JefeDepartamentoMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        mongoDB = mongoClient.getDatabase("test");
        mongoDB.drop();
        JefeDepartamentoDTO jefe1 =JefeDepartamentoDTO.builder()
                .nombre("jefe1")
                .build();
        JefeDepartamentoDTO jefe2 = JefeDepartamentoDTO.builder()
                .nombre("jefe2")
                .build();
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(mapper.fromDTO(jefe1));
        hc.getManager().persist(mapper.fromDTO(jefe2));
        hc.getTransaction().commit();
        hc.close();
        jefes = jdc.getAllJefesDepartamento();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(jefes.size(), jdc.getAllJefesDepartamento().size());
        assertEquals(jefes, jdc.getAllJefesDepartamento());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(jefes.get(0), jdc.getJefeDepartamentoById(jefes.get(0).getId()));
        assertNull(jdc.getJefeDepartamentoById(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(jefes.get(0), jdc.updateJefeDepartamento(jefes.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        JefeDepartamentoDTO commit3=JefeDepartamentoDTO.builder()
                .nombre("repo3")
                .build();
        assertNotNull(jdc.postJefeDepartamento(commit3));
        commit3.setId(3L);
        assertNull(jdc.postJefeDepartamento(commit3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(jefes.get(0), jdc.deleteJefeDepartamento(jefes.get(0)));
        assertThrows(NullPointerException.class,()-> jdc.deleteJefeDepartamento(jefes.get(0)));
    }
}
