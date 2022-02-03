package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.CommitController;
import dto.CommitDTO;
import manager.HibernateController;
import mapper.CommitMapper;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Commit")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommitTest {
    private HibernateController hc;
    private CommitController cc;
    private List<CommitDTO> commits;
    private CommitMapper mapper;

    @BeforeAll
    void init() {
        hc = HibernateController.getInstance();
        cc = CommitController.getInstance();
        mapper=new CommitMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        mongoDB = mongoClient.getDatabase("test");
        mongoDB.drop();
        CommitDTO commit1 =CommitDTO.builder()
                .titulo("Prueba1")
                .texto("Test")
                .fecha(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        CommitDTO commit2 =CommitDTO.builder()
                .titulo("Prueba2")
                .texto("Test")
                .fecha(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(mapper.fromDTO(commit1));
        hc.getManager().persist(mapper.fromDTO(commit2));
        hc.getTransaction().commit();
        hc.close();
        commits = cc.getAllCommit();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(commits.size(),cc.getAllCommit().size());
        assertEquals(commits,cc.getAllCommit());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(commits.get(0),cc.getCommitById(commits.get(0).getId()));
        assertNull(cc.getCommitById(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(commits.get(0),cc.updateCommit(commits.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        CommitDTO commit3=CommitDTO.builder()
                .titulo("Prueba3")
                .texto("Test")
                .fecha(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        assertNotNull(cc.postCommit(commit3));
        commit3.setId(3L);
        assertNull(cc.postCommit(commit3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(commits.get(0),cc.deleteCommit(commits.get(0)));
        assertThrows(NullPointerException.class,()->cc.deleteCommit(commits.get(0)));
    }
}
