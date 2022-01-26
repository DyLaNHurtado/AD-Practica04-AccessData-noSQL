import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.*;
import dao.*;
import database.DataBaseController;
import dto.*;
import manager.HibernateController;
import org.bson.types.ObjectId;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Facade {
    private static Facade instance;

    private Facade() {
    }

    /**
     * Patron Singleton
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    /**
     * Metodos que comprueba el servicio de la base de datos
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void checkService() {
        DataBaseController controller = DataBaseController.getInstance();
        try {
            controller.open();
            Optional<ResultSet> rs = controller.select("SELECT 'Hello World'");
            if (rs.isPresent()) {
                rs.get().first();
                controller.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
            System.exit(1);
        }
    }

    public void initDataBase() {
        // Borramos los datos previos
        removeData();

        HibernateController hc = HibernateController.getInstance();
        hc.open();
        // Commit
        hc.getTransaction().begin();
        Commit c1 = new Commit("Titulo1", "Texto1", Timestamp.from(Instant.now())); // 1
        Commit c2 = new Commit("Titulo2", "Texto2", Timestamp.from(Instant.now())); // 2
        Commit c3 = new Commit("Titulo3", "Texto3", Timestamp.from(Instant.now())); // 3

        hc.getManager().persist(c1);
        hc.getManager().persist(c2);
        hc.getManager().persist(c3);

        hc.getTransaction().commit();

        // Usuarios
        System.out.println("Insertando Usuarios de Ejemplo");

        hc.getTransaction().begin();
        Departamento d1 = new Departamento("Pepe Perez", 100d, 1000d); // 5
        Departamento d2 = new Departamento("Ana Anaya", 200d, 2000d); // 6
        Departamento d3 = new Departamento("Paco Perez", 300d, 3000d); // 7

        hc.getManager().persist(d1);
        hc.getManager().persist(d2);
        hc.getManager().persist(d3);

        hc.getTransaction().commit();

        // Post
        System.out.println("Insertando Post de Ejemplo");

        hc.getTransaction().begin();
        Issue p1 = new Issue("Issue 1", "Textoooo1", Timestamp.from(Instant.now()), true); //10
        Issue p2 = new Issue("Issue 2", "Textoooo2", Timestamp.from(Instant.now()), false); //11
        Issue p3 = new Issue("Issue 3", "Textoooo3", Timestamp.from(Instant.now()), true); //12
        hc.getManager().persist(p1);
        hc.getManager().persist(p2);
        hc.getManager().persist(p3);

        hc.getTransaction().commit();

        // Comentarios
        System.out.println("Insertando Comentarios de Ejemplo");

        hc.getTransaction().begin();
        JefeDepartamento jd1 = new JefeDepartamento();//15
        JefeDepartamento jd2 = new JefeDepartamento();//15

        hc.getManager().persist(jd1);
        hc.getManager().persist(jd2);

        hc.getTransaction().commit();

        // Comentarios
        System.out.println("Insertando Comentarios de Ejemplo");

        hc.getTransaction().begin();
        JefeProyecto jp1 = new JefeProyecto();//15
        JefeProyecto jp2 = new JefeProyecto();//15

        hc.getManager().persist(jp1);
        hc.getManager().persist(jp2);

        hc.getTransaction().commit();

        // Comentarios
        System.out.println("Insertando Comentarios de Ejemplo");

        hc.getTransaction().begin();
        Login login1 = new Login("programador1@gmail.com", "f8638b979b2f4f793ddb6dbd197e0ee25a7a6ea32b0ae22f5e3c5d119d839e75", Timestamp.from(Instant.now()));//15
        Login login2 = new Login("programador2@gmail.com", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", Timestamp.from(Instant.now()));//15

        hc.getManager().persist(login1);
        hc.getManager().persist(login2);

        hc.getTransaction().commit();

        // Comentarios
        System.out.println("Insertando Comentarios de Ejemplo");

        hc.getTransaction().begin();
        Programador pro1 = new Programador();//15
        Programador pro2 = new Programador();//15
        Programador pro3 = new Programador();//15

        hc.getManager().persist(pro1);
        hc.getManager().persist(pro2);
        hc.getManager().persist(pro3);

        hc.getTransaction().commit();

        // Comentarios
        System.out.println("Insertando Comentarios de Ejemplo");

        hc.getTransaction().begin();
        Proyecto proy1 = new Proyecto("Proyecto X", 100d, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));//15
        Proyecto proy2 = new Proyecto("Proyecto Y", 300d, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));//15

        hc.getManager().persist(proy1);
        hc.getManager().persist(proy2);

        hc.getTransaction().commit();

        // Comentarios
        System.out.println("Insertando Comentarios de Ejemplo");

        hc.getTransaction().begin();
        Repositorio rep1 = new Repositorio("Repo 1", Timestamp.from(Instant.now()));//15
        Repositorio rep2 = new Repositorio("Repo 2", Timestamp.from(Instant.now()));//15

        hc.getManager().persist(rep1);
        hc.getManager().persist(rep2);

        hc.getTransaction().commit();

        hc.close();

    }

    private void removeData() {
        // Usando Hibernate
//        transactionManager.begin();
//        // Collection == name of the class being saved ⮧
//        entityManager.createNativeQuery("db.GameCharacter.drop()").executeUpdate();
//        transactionManager.commit();
        // Lo sutyo sería un controlador
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);

        // Obtenemos la base de datos que necesitamos
        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop(); // Si queremos borrar toda la base de datos
    }

    /**
     * Dar salida al JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void salidaJSON() {
        System.out.println("-------------------------------\n" +
                "\t\tOPERACIONES CRUD\n" +
                "-------------------------------\n");

        System.out.println("**********************\n" +
                "\t\tDEPARTAMENTO\n" +
                "**********************");
        this.departamentoJSON();

        System.out.println("**********************\n" +
                "\t\tPROYECTO\n" +
                "**********************");
        this.proyectoJSON();

        System.out.println("**********************\n" +
                "\t\tPROGRAMADOR\n" +
                "**********************");
        this.programadorJSON();
    }


    /**
     * Metodos CRUD departamento en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void departamentoJSON() {
        DepartamentoController departamentoController = DepartamentoController.getInstance();

        System.out.println("GET Todos las Departamentos");
        System.out.println(departamentoController.getAllDepartamentos());

        System.out.println("GET Departamento con ID = 1e89386d-be37-4930-b6ae-bcba6c9917b4");
        //System.out.println(departamentoController.getDepartamentoByIdJSON("1e89386d-be37-4930-b6ae-bcba6c9917b4"));

        System.out.println("POST Insertando Departamento");
        DepartamentoDTO departamentoDTO = DepartamentoDTO.builder()
                //.idDepartamento(UUID.randomUUID().toString())
                .nombre("DepartamentoPrueba")
                .trabajadores(List.of(new Programador()))
                .proyDesarrollo(List.of(new Proyecto()))
                .proyFinalizados(List.of(new Proyecto()))
                .presupuesto(10000.0)
                .presupuestoAnual(100000.0)
                .build();
        System.out.println(departamentoController.postDepartamento(departamentoDTO));

        System.out.println("UPDATE Departamento con ID = 512a0695-3294-4c2c-86d9-4babd4485fa8");
        departamentoDTO = DepartamentoDTO.builder()
                //.idDepartamento("512a0695-3294-4c2c-86d9-4babd4485fa8")
                .nombre("DepartamentoPruebaUpdated")
                .trabajadores(List.of(new Programador()))
                .proyDesarrollo(List.of(new Proyecto()))
                .proyFinalizados(List.of(new Proyecto()))
                .presupuesto(10000.0)
                .presupuestoAnual(100000.0)
                .build();
        System.out.println(departamentoController.updateDepartamento(departamentoDTO));

        System.out.println("DELETE Departamento con ID = 512a0695-3294-4c2c-86d9-4babd4485fa8");
        departamentoDTO = DepartamentoDTO.builder()
                //.idDepartamento("512a0695-3294-4c2c-86d9-4babd4485fa8")
                .build();
        System.out.println(departamentoController.deleteDepartamento(departamentoDTO));
    }

    /**
     * Metodos CRUD programador en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void programadorJSON() {
        ProgramadorController programadorController = ProgramadorController.getInstance();

        System.out.println("GET Todos los Programadores");
        System.out.println(programadorController.getAllProgramadores());

        System.out.println("GET Programador con ID = d63f0d73-3f1b-4afd-b5d0-821449daa4a3");
        //System.out.println(programadorController.getProgramadorByIdJSON("d63f0d73-3f1b-4afd-b5d0-821449daa4a3"));

        System.out.println("POST Insertando Programador");
        ProgramadorDTO programadorDTO = ProgramadorDTO.builder()
                //.idProgramador(UUID.randomUUID().toString())
                .nombre("Prueba")
                //.fechaAlta(LocalDate.now())
                //Cuidado que es tipo Date
                //.departamento(new Departamento("2d1d1422-fede-4e27-8883-3ffdb1be1a7c"))
                .proyectosParticipa(List.of(new Proyecto()))
                .salario(1350.0)
                .build();
        System.out.println(programadorController.postProgramador(programadorDTO));

        System.out.println("UPDATE Programador con ID = 53269670-1586-49ac-9df5-62ddd55f96cc");
        programadorDTO = ProgramadorDTO.builder()
                //.idProgramador("53269670-1586-49ac-9df5-62ddd55f96cc")
                .nombre("Prueba2")
                //.fechaAlta(LocalDate.now())
                //Cuidado que es tipo Date
                //.departamento(new Departamento("2d1d1422-fede-4e27-8883-3ffdb1be1a7c"))
                .proyectosParticipa(List.of(new Proyecto()))
                .salario(1350.0)
                .build();
        System.out.println(programadorController.updateProgramador(programadorDTO));

        System.out.println("DELETE Programador con ID = d63f0d73-3f1b-4afd-b5d0-821449daa4a3");
        programadorDTO = ProgramadorDTO.builder()
                //.idProgramador("d63f0d73-3f1b-4afd-b5d0-821449daa4a3")
                //.fechaAlta(LocalDate.now())
                .build();
        System.out.println(programadorController.deleteProgramador(programadorDTO));
    }

    /**
     * Metodos CRUD proyecto en XML
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void proyectoJSON() {
        ProyectoController proyectoController = ProyectoController.getInstance();

        System.out.println("GET Todos los Proyectos");
        System.out.println(proyectoController.getAllProyectos());

        System.out.println("GET Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        //System.out.println(proyectoController.getProyectoByIdJSON("81ee1211-760c-493d-968a-380e6af67363"));

        System.out.println("POST Insertando Proyecto");
        ProyectoDTO proyectoDTO = ProyectoDTO.builder()
                //.idProyecto(UUID.randomUUID().toString())
                .nombre("Prueba")
                .presupuesto(100.0)
                //.fechaInicio(LocalDate.of(2015, 2, 13))
                //.fechaFin(LocalDate.now())
                //.departamento(new Departamento("1e89386d-be37-4930-b6ae-bcba6c9917b4"))
                .build();
        System.out.println(proyectoController.postProyecto(proyectoDTO));

        System.out.println("UPDATE Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        proyectoDTO = ProyectoDTO.builder()
                //.idProyecto("81ee1211-760c-493d-968a-380e6af67363")
                .nombre("Prueba")
                .presupuesto(100.0)
                //.fechaInicio(LocalDate.of(2015, 2, 13))
                //.fechaFin(LocalDate.now())
                //.departamento(new Departamento("1e89386d-be37-4930-b6ae-bcba6c9917b4"))
                .build();
        System.out.println(proyectoController.updateProyecto(proyectoDTO));

        System.out.println("DELETE Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        proyectoDTO = ProyectoDTO.builder()
                //.idProyecto("81ee1211-760c-493d-968a-380e6af67363")
                //.fechaInicio(LocalDate.of(2015, 2, 13))
                //.fechaFin(LocalDate.now())
                .build();
        System.out.println(proyectoController.deleteProyecto(proyectoDTO));
    }
}
