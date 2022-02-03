package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.RepositorioController;
import dto.RepositorioDTO;
import manager.HibernateController;
import mapper.RepositorioMapper;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Repositorio")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositorioTest {
    private HibernateController hc;
    private RepositorioController rc;
    private List<RepositorioDTO> repos;
    private RepositorioMapper mapper;

    @BeforeAll
    void init() {
        hc = HibernateController.getInstance();
        rc = RepositorioController.getInstance();
        mapper=new RepositorioMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        mongoDB = mongoClient.getDatabase("test");
        mongoDB.drop();
        RepositorioDTO repo1 =RepositorioDTO.builder()
                .nombre("repo1")
                .fechaCreacion(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        RepositorioDTO repo2 = RepositorioDTO.builder()
                .nombre("repos2")
                .fechaCreacion(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(mapper.fromDTO(repo1));
        hc.getManager().persist(mapper.fromDTO(repo2));
        hc.getTransaction().commit();
        hc.close();
        repos = rc.getAllRepositorio();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(repos.size(), rc.getAllRepositorio().size());
        assertEquals(repos, rc.getAllRepositorio());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(repos.get(0), rc.getRepositorioById(repos.get(0).getId()));
        assertNull(rc.getRepositorioById(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(repos.get(0), rc.updateRepositorio(repos.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        RepositorioDTO commit3=RepositorioDTO.builder()
                .fechaCreacion(Timestamp.valueOf(LocalDateTime.now()))
                .nombre("repo3")
                .build();
        assertNotNull(rc.postRepositorio(commit3));
        commit3.setId(3L);
        assertNull(rc.postRepositorio(commit3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(repos.get(0), rc.deleteRepositorio(repos.get(0)));
        assertThrows(NullPointerException.class,()-> rc.deleteRepositorio(repos.get(0)));
    }
}
