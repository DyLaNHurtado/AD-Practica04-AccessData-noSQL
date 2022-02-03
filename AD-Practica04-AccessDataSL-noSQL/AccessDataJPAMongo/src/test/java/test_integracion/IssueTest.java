package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.IssueController;
import dto.IssueDTO;
import manager.HibernateController;
import mapper.IssueMapper;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Issue")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IssueTest {
    private HibernateController hc;
    private IssueController ic;
    private List<IssueDTO> issues;
    private IssueMapper mapper;

    @BeforeAll
    void init() {
        hc = HibernateController.getInstance();
        ic = IssueController.getInstance();
        mapper=new IssueMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        mongoDB = mongoClient.getDatabase("test");
        mongoDB.drop();
        IssueDTO issue1 = IssueDTO.builder()
                .fecha(Timestamp.valueOf(LocalDateTime.now()))
                .resuelta(true)
                .texto("issue1")
                .titulo("test")
                .build();
        IssueDTO issue2 = IssueDTO.builder()
                .fecha(Timestamp.valueOf(LocalDateTime.now()))
                .resuelta(false)
                .titulo("test")
                .texto("issue2")
                .build();
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(mapper.fromDTO(issue1));
        hc.getManager().persist(mapper.fromDTO(issue2));
        hc.getTransaction().commit();
        hc.close();
        issues = ic.getAllIssue();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(issues.size(), ic.getAllIssue().size());
        assertEquals(issues, ic.getAllIssue());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(issues.get(0), ic.getIssueById(issues.get(0).getId()));
        assertNull(ic.getIssueById(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(issues.get(0), ic.updateIssue(issues.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        IssueDTO issue3=IssueDTO.builder()
                .titulo("prueba")
                .texto("issue3")
                .resuelta(false)
                .fecha(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        assertNotNull(ic.postIssue(issue3));
        issue3.setId(3L);
        assertNull(ic.postIssue(issue3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(issues.get(0), ic.deleteIssue(issues.get(0)));
        assertThrows(NullPointerException.class,()-> ic.deleteIssue(issues.get(0)));
    }
}
