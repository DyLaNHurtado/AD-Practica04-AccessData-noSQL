package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import controller.LoginController;
import dao.Login;
import dto.LoginDTO;
import manager.MongoDBController;
import mapper.LoginMapper;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Login")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    private MongoDBController db;
    private LoginController lc;
    private List<LoginDTO> logins;
    private LoginMapper mapper;

    @BeforeAll
    void init() {
        db = MongoDBController.getInstance();
        lc = LoginController.getInstance();
        mapper=new LoginMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        LoginDTO l1 =LoginDTO.builder()
                .id(1L)
                .token(UUID.randomUUID())
                .build();
        LoginDTO l2 = LoginDTO.builder()
                .id(2L)
                .token(UUID.randomUUID())
                .build();
        db.open();
        MongoCollection<Login> loginCollection = db.getCollection("mongodb", "login", Login.class);
        loginCollection.insertOne(mapper.fromDTO(l1));
        loginCollection.insertOne(mapper.fromDTO(l2));
        db.close();
        logins=lc.getAllLogin();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(logins.size(), lc.getAllLogin().size());
        assertEquals(logins, lc.getAllLogin());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(logins.get(0), lc.getLoginByIdJSON(logins.get(0).getId()));
        assertNull(lc.getLoginByIdJSON(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(logins.get(0), lc.updateLogin(logins.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        LoginDTO commit3=LoginDTO.builder()
                .id(3L)
                .token(UUID.randomUUID())
                .build();
        assertNotNull(lc.postLogin(commit3));
        assertNull(lc.postLogin(commit3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(logins.get(0), lc.deleteLogin(logins.get(0)));
        assertThrows(NoSuchElementException.class,()-> lc.deleteLogin(logins.get(0)));
    }
}
