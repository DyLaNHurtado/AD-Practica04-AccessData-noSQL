import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.*;
import dao.*;
import dto.*;
import manager.HibernateController;

import java.sql.Timestamp;
import java.time.Instant;
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

    public void initDataBase() {
        // Borramos los datos previos
        removeData();

        HibernateController hc = HibernateController.getInstance();
        hc.open();
        // Commit
        Commit c1 = new Commit("Titulo1", "Texto1", Timestamp.from(Instant.now()));
        Commit c2 = new Commit("Titulo2", "Texto2", Timestamp.from(Instant.now()));
        Departamento d1 = new Departamento("Pepe Perez", 100d, 1000d);
        Departamento d2 = new Departamento("Ana Anaya", 200d, 2000d);
        Issue i1 = new Issue("Issue 1", "Textoooo1", Timestamp.from(Instant.now()), true);
        Issue i2 = new Issue("Issue 2", "Textoooo2", Timestamp.from(Instant.now()), false);
        JefeDepartamento jd1 = new JefeDepartamento();
        JefeDepartamento jd2 = new JefeDepartamento();
        JefeProyecto jp1 = new JefeProyecto();
        JefeProyecto jp2 = new JefeProyecto();
        Login login1 = new Login("programador1@gmail.com", "f8638b979b2f4f793ddb6dbd197e0ee25a7a6ea32b0ae22f5e3c5d119d839e75", Timestamp.from(Instant.now()));
        Login login2 = new Login("programador2@gmail.com", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", Timestamp.from(Instant.now()));
        Programador pro1 = new Programador();
        Programador pro2 = new Programador();
        Proyecto proy1 = new Proyecto("Proyecto X", 100d, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));//15
        Proyecto proy2 = new Proyecto("Proyecto Y", 300d, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));//15
        Repositorio rep1 = new Repositorio("Repo 1", Timestamp.from(Instant.now()));//15
        Repositorio rep2 = new Repositorio("Repo 2", Timestamp.from(Instant.now()));//15


        //Commit
        c1.setIssue(i1);
        c2.setIssue(i2);
        c1.setRepositorio(rep1);
        c2.setRepositorio(rep2);
        c1.setProgramador(pro1);
        c2.setProgramador(pro2);

        //Departamento

        d1.setJefeDepartamento(jd1);
        d2.setJefeDepartamento(jd2);
        d1.setProyDesarrollo(List.of(proy1));
        d2.setProyFinalizados(List.of(proy2));
        d1.setTrabajadores(List.of(pro2));
        d2.setTrabajadores(List.of(pro1));

        //Issue

        i1.setJefe(jp1);
        i2.setJefe(jp2);
        i1.setProgramadores(List.of(pro1));
        i2.setProgramadores(List.of(pro2));
        i1.setRepositorio(rep1);
        i2.setRepositorio(rep2);
        i1.setCommit(c1);
        i2.setCommit(c2);

        //JefeDepartamento

        jd1.setNombre("Adolfo");
        jd2.setNombre("JoseLuis perro apruebame");
        jd1.setFechaAlta(Timestamp.from(Instant.now()));
        jd2.setFechaAlta(Timestamp.from(Instant.now()));
        jd1.setSalario(100d);
        jd2.setSalario(3000000d);
        jd1.setTecnologias(List.of("Python","Java"));
        jd2.setTecnologias(List.of("Kotlin","Kotlin","Y MAS KOTLIN"));
        jd1.setDepartamento(d1);
        jd2.setDepartamento(d2);

        //JefeProyecto

        jp1.setNombre("Andres Iniesta");
        jp2.setNombre("El bicho SIUiUIUIUUUU xD");
        jp1.setFechaAlta(Timestamp.from(Instant.now()));
        jp2.setFechaAlta(Timestamp.from(Instant.now()));
        jp1.setSalario(100d);
        jp2.setSalario(3000000d);
        jp1.setTecnologias(List.of("Angular","Javascript"));
        jp2.setTecnologias(List.of("Pascal","PHP","WHITESPACE"));
        jp1.setProyecto(proy1);
        jp2.setProyecto(proy2);
        jp1.setIssues(List.of(i1));
        jp1.setIssues(List.of(i2));

        //Programador
        pro1.setNombre("Manolo");
        pro2.setNombre("Casemiro");
        pro1.setFechaAlta(Timestamp.from(Instant.now()));
        pro2.setFechaAlta(Timestamp.from(Instant.now()));
        pro1.setSalario(1000d);
        pro2.setSalario(1022d);
        pro1.setTecnologias(List.of("PHP","DJango"));
        pro2.setTecnologias(List.of("Vue","SpringBoot"));
        pro1.setDepartamento(d1);
        pro2.setDepartamento(d2);
        pro1.setProyectosParticipa(List.of(proy1));
        pro2.setProyectosParticipa(List.of(proy2));
        pro1.setCommits(List.of(c1));
        pro2.setCommits(List.of(c2));
        pro1.setIssues(List.of(i1));
        pro2.setIssues(List.of(i2));

        //Proyecto
        proy1.setTecnologias(List.of("Flutter","MongoDB"));
        proy2.setTecnologias(List.of("Angular","Spring"));
        proy1.setJefe(jp1);
        proy2.setJefe(jp2);
        proy1.setRepositorio(rep1);
        proy2.setRepositorio(rep2);
        proy1.setProgramadores(List.of(pro1));
        proy2.setProgramadores(List.of(pro2));
        proy1.setDepartamento(d1);
        proy2.setDepartamento(d2);

        //Repositorio

        rep1.setProyecto(proy1);
        rep2.setProyecto(proy2);
        rep1.setIssues(List.of(i1));
        rep2.setIssues(List.of(i2));
        rep1.setCommits(List.of(c1));
        rep2.setCommits(List.of(c2));

        hc.getTransaction().begin();

        hc.getManager().persist(d1);
        hc.getManager().persist(d2);

        hc.getManager().persist(jd1);
        hc.getManager().persist(jd2);

        hc.getManager().persist(jp1);
        hc.getManager().persist(jp2);

        hc.getManager().persist(pro1);
        hc.getManager().persist(pro2);

        hc.getManager().persist(proy1);
        hc.getManager().persist(proy2);

        hc.getManager().persist(rep1);
        hc.getManager().persist(rep2);

        hc.getManager().persist(c1);
        hc.getManager().persist(c2);

        hc.getManager().persist(i1);
        hc.getManager().persist(i2);

        hc.getTransaction().commit();

        hc.close();

    }

    private void removeData() {
        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/mongodb?authSource=admin");
        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase mongoDB = mongoClient.getDatabase("mongodb");
        mongoDB.drop();
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
