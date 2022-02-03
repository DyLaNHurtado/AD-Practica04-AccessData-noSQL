package test_integracion;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.DepartamentoController;
import dto.DepartamentoDTO;
import manager.HibernateController;
import mapper.DepartamentoMapper;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Departamento")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartamentoTest {
    private HibernateController hc;
    private DepartamentoController dc;
    private List<DepartamentoDTO> departamentos;
    private DepartamentoMapper mapper;

    @BeforeAll
    void init() {
        hc = HibernateController.getInstance();
        dc = DepartamentoController.getInstance();
        mapper=new DepartamentoMapper();
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
        mongoDB = mongoClient.getDatabase("test");
        mongoDB.drop();
        DepartamentoDTO departamento1 = DepartamentoDTO.builder()
                .nombre("dep1")
                .presupuesto(50000.0)
                .presupuestoAnual(100000.0)
                .build();
        DepartamentoDTO departamento2 = DepartamentoDTO.builder()
                .nombre("dep2")
                .presupuesto(50000.0)
                .presupuestoAnual(100000.0)
                .build();
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(mapper.fromDTO(departamento1));
        hc.getManager().persist(mapper.fromDTO(departamento2));
        hc.getTransaction().commit();
        hc.close();
        departamentos = dc.getAllDepartamentos();
    }

    @Test
    @Order(1)
    void getAll() {
        assertEquals(departamentos.size(), dc.getAllDepartamentos().size());
        assertEquals(departamentos, dc.getAllDepartamentos());
    }

    @Test
    @Order(2)
    void getById(){
        assertEquals(departamentos.get(0), dc.getDepartamentoById(departamentos.get(0).getId()));
        assertNull(dc.getDepartamentoById(3L));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(departamentos.get(0), dc.updateDepartamento(departamentos.get(0)));
    }

    @Test
    @Order(4)
    void insert(){
        DepartamentoDTO dep3=DepartamentoDTO.builder()
                .nombre("dep3")
                .presupuesto(50000.0)
                .presupuestoAnual(100000.0)
                .build();
        assertNotNull(dc.postDepartamento(dep3));
        dep3.setId(3L);
        assertNull(dc.postDepartamento(dep3));
    }

    @Test
    @Order(5)
    void delete(){
        assertEquals(departamentos.get(0), dc.deleteDepartamento(departamentos.get(0)));
        assertThrows(NullPointerException.class,()-> dc.deleteDepartamento(departamentos.get(0)));
    }
}
