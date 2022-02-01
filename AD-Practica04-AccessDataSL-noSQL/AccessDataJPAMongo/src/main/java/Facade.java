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
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
        jd1.setTecnologias(List.of("Python", "Java"));
        jd2.setTecnologias(List.of("Kotlin", "Kotlin", "Y MAS KOTLIN"));
        jd1.setDepartamento(d1);
        jd2.setDepartamento(d2);

        //JefeProyecto

        jp1.setNombre("Andres Iniesta");
        jp2.setNombre("El bicho SIUiUIUIUUUU xD");
        jp1.setFechaAlta(Timestamp.from(Instant.now()));
        jp2.setFechaAlta(Timestamp.from(Instant.now()));
        jp1.setSalario(100d);
        jp2.setSalario(3000000d);
        jp1.setTecnologias(List.of("Angular", "Javascript"));
        jp2.setTecnologias(List.of("Pascal", "PHP", "WHITESPACE"));
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
        pro1.setTecnologias(List.of("PHP", "DJango"));
        pro2.setTecnologias(List.of("Vue", "SpringBoot"));
        pro1.setDepartamento(d1);
        pro2.setDepartamento(d2);
        pro1.setProyectosParticipa(List.of(proy1));
        pro2.setProyectosParticipa(List.of(proy2));
        pro1.setCommits(List.of(c1));
        pro2.setCommits(List.of(c2));
        pro1.setIssues(List.of(i1));
        pro2.setIssues(List.of(i2));

        //Proyecto
        proy1.setTecnologias(List.of("Flutter", "MongoDB"));
        proy2.setTecnologias(List.of("Angular", "Spring"));
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

    public void soluciones(){
        departamentoCompleto();
        issuesPorProyecto();
        programadoresProyectoOrdenados();
        proyectosCompletos();
    }

    private void departamentoCompleto(){
        System.out.println("Departamento con información completa.");
        DepartamentoController controller=DepartamentoController.getInstance();
        System.out.println(controller.getAllDepartamentos().get(0).getDepartamentoCompleto());
    }

    private void issuesPorProyecto(){
        System.out.println("Issues abiertas por proyecto.");
        ProyectoController controller=ProyectoController.getInstance();
        controller.getAllProyectos().stream()
                .filter(p->p.getRepositorio().getIssues().stream().filter(i->i.getResuelta()==false).collect(Collectors.toList()).size()!=0)
                .forEach(p-> System.out.println(p.issuesAbiertas()));
    }

    private void programadoresProyectoOrdenados(){
        System.out.println("Programadores de un proyecto ordenados por número de commits.");
        ProyectoController controller=ProyectoController.getInstance();
        controller.getAllProyectos().forEach(p-> System.out.println(p.ordenarProgramadoresCommit()));
    }

    private void proyectosCompletos(){
        System.out.println("Proyectos con información completa.");
        ProyectoController controller=ProyectoController.getInstance();
        controller.getAllProyectos().forEach(p-> System.out.println(p.proyectoCompleto()));
    }

    /**
     * Dar salida al JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void testingJSON() {
        System.out.println("-------------------------------\n" +
                "\t\tOPERACIONES CRUD\n" +
                "-------------------------------\n");

        System.out.println("**********************\n" +
                "\tDEPARTAMENTO\n" +
                "**********************");
        //this.departamentoJSON();

        System.out.println("**********************\n" +
                "\t\tPROYECTO\n" +
                "**********************");
        //this.proyectoJSON();

        System.out.println("**********************\n" +
                "\t\tPROGRAMADOR\n" +
                "**********************");
        //this.programadorJSON();
        System.out.println("**********************\n" +
                "\tREPOSITORIO\n" +
                "**********************");
        //this.repositorioJSON();
        System.out.println("**********************\n" +
                "\t\tCOMMIT\n" +
                "**********************");
        //this.commitJSON();
        System.out.println("**********************\n" +
                "\t\tISSUE\n" +
                "**********************");
        //this.issueJSON();
        System.out.println("**********************\n" +
                "\tJEFE DEPARTAMENTO\n" +
                "**********************");
        //this.jefeDepartamentoJSON();
        System.out.println("**********************\n" +
                "\tJEFE PROYECTO\n" +
                "**********************");
        //this.jefeProyectoJSON();
    }

    /**
     * Metodos CRUD departamento en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void departamentoJSON() {
        DepartamentoController departamentoController = DepartamentoController.getInstance();

        System.out.println("GET Todos los Departamentos");
        System.out.println(departamentoController.getAllDepartamentos());


        System.out.println("GET Departamento con ID = 3");
        System.out.println(departamentoController.getDepartamentoById(3L));

        System.out.println("POST Insertando Departamento");
        DepartamentoDTO departamentoDTO = DepartamentoDTO.builder()
                .nombre("DepartamentoPrueba")
                .programadores(List.of(new Programador()))
                .proyDesarrollo(List.of(new Proyecto()))
                .proyFinalizados(List.of(new Proyecto()))
                .presupuesto(10000.0)
                .presupuestoAnual(100000.0)
                .build();
        System.out.println(departamentoController.postDepartamento(departamentoDTO));

        System.out.println("UPDATE Departamento con ID = 3");
        departamentoDTO = DepartamentoDTO.builder()
                .id(3L)
                .nombre("DepartamentoPruebaUpdated")
                .programadores(List.of(new Programador()))
                .proyDesarrollo(List.of(new Proyecto()))
                .proyFinalizados(List.of(new Proyecto()))
                .presupuesto(10000.0)
                .presupuestoAnual(100000.0)
                .build();
        System.out.println(departamentoController.updateDepartamento(departamentoDTO));

        System.out.println("DELETE Departamento con ID = 3");
        departamentoDTO = DepartamentoDTO.builder()
                .id(3L)
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

        System.out.println("GET Programador con ID = 8");
        System.out.println(programadorController.getProgramadorById(8L));

        System.out.println("POST Insertando Programador");
        ProgramadorDTO programadorDTO = ProgramadorDTO.builder()
                .nombre("Prueba")
                .tecnologias(List.of(""))
                .salario(1000.0)
                .fechaAlta(Timestamp.valueOf(LocalDateTime.now()))
                .issues(List.of(new Issue()))
                .commits(List.of(new Commit()))
                .proyectosParticipa(List.of(new Proyecto()))
                .departamento(new Departamento())
                .build();
        System.out.println(programadorController.postProgramador(programadorDTO));

        System.out.println("UPDATE Programador con ID = 8");
        programadorDTO = ProgramadorDTO.builder()
                .id(8L)
                .nombre("Prueba2")
                .fechaAlta(Timestamp.valueOf(LocalDateTime.now()))
                .proyectosParticipa(List.of(new Proyecto()))
                .salario(1350.0)
                .departamento(new Departamento())
                .issues(List.of(new Issue()))
                .commits(List.of(new Commit()))
                .build();
        System.out.println(programadorController.updateProgramador(programadorDTO));

        System.out.println("DELETE Programador con ID = 8");
        Departamento d = new Departamento();
        d.setId(10L);
        programadorDTO = ProgramadorDTO.builder()
                .id(8L)
                .departamento(d)
                .proyectosParticipa(List.of(new Proyecto()))
                .issues(List.of(new Issue()))
                .commits(List.of(new Commit()))
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

        System.out.println("GET Proyecto con ID = 12");
        System.out.println(proyectoController.getProyectoById(12L));

        System.out.println("POST Insertando Proyecto");
        ProyectoDTO proyectoDTO = ProyectoDTO.builder()
                .nombre("Prueba")
                .presupuesto(100.0)
                .fechaInicio(Timestamp.from(Instant.now()))
                .fechaFin(Timestamp.from(Instant.now()))
                .tecnologias(new ArrayList<>())
                .jefe(new JefeProyecto())
                .departamento(new Departamento())
                .repositorio(new Repositorio())
                .programadores(new ArrayList<>())
                .build();
        System.out.println(proyectoController.postProyecto(proyectoDTO));

        System.out.println("UPDATE Proyecto con ID = 18");
        proyectoDTO = ProyectoDTO.builder()
                .id(18L)
                .nombre("Prueba")
                .presupuesto(100.0)
                .departamento(new Departamento())
                .programadores(List.of(new Programador()))
                .jefe(new JefeProyecto())
                .repositorio(new Repositorio())
                .build();
        System.out.println(proyectoController.updateProyecto(proyectoDTO));

        System.out.println("DELETE Proyecto con ID = 12");
        proyectoDTO = ProyectoDTO.builder()
                .id(12L)
                .build();
        System.out.println(proyectoController.deleteProyecto(proyectoDTO));
    }
    /**
     * Metodos CRUD jefeProyecto en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void jefeProyectoJSON() {
        JefeProyectoController jefeProyectoController = JefeProyectoController.getInstance();

        System.out.println("GET Todos los Jefes de Proyecto");
        System.out.println(jefeProyectoController.getAllJefeProyecto());

        System.out.println("GET JefeProyecto con ID = 5");
        System.out.println(jefeProyectoController.getJefeProyectoById(5L));

        System.out.println("POST Insertando JefeProyecto");
        JefeProyectoDTO jefeProyectoDTO = JefeProyectoDTO.builder()
                .nombre("jefeProyPrueba")
                .fechaAlta(Timestamp.from(Instant.now()))
                .salario(1000.0)
                .tecnologias(List.of("Tecnologia1","Tecnologia2"))
                .proyecto(new Proyecto())
                .issues(List.of(new Issue()))
                .build();
        System.out.println(jefeProyectoController.postJefeProyecto(jefeProyectoDTO));

        System.out.println("UPDATE JefeProyecto con ID = 6");
        jefeProyectoDTO = JefeProyectoDTO.builder()
                .id(6L)
                .nombre("jefeProyPrueba")
                .fechaAlta(Timestamp.from(Instant.now()))
                .salario(1000.0)
                .tecnologias(List.of("Tecnologia1","Tecnologia2"))
                .proyecto(new Proyecto())
                .issues(List.of(new Issue()))
                .build();
        System.out.println(jefeProyectoController.updateJefeProyecto(jefeProyectoDTO));

        System.out.println("DELETE JefeProyecto con ID = 5");
        jefeProyectoDTO = JefeProyectoDTO.builder()
                .id(5L)
                .build();
        System.out.println(jefeProyectoController.deleteJefeProyecto(jefeProyectoDTO));
    }
    /**
     * Metodos CRUD jefeDepartamento en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void jefeDepartamentoJSON() {
        JefeDepartamentoController jefeDepartamentoController = JefeDepartamentoController.getInstance();

        System.out.println("GET Todos los Jefes de Departamento");
        System.out.println(jefeDepartamentoController.getAllJefesDepartamento());

        System.out.println("GET JefeDepartamento con ID = 2");
        System.out.println(jefeDepartamentoController.getJefeDepartamentoById(2L));

        System.out.println("POST Insertando JefeDepartamento");
        JefeDepartamentoDTO jefeDepartamentoDTO = JefeDepartamentoDTO.builder()
                .nombre("jefeDepPrueba")
                .fechaAlta(Timestamp.from(Instant.now()))
                .salario(1000.0)
                .tecnologias(List.of("Tecnologia1","Tecnologia2"))
                .departamento(new Departamento())
                .build();
        System.out.println(jefeDepartamentoController.postJefeDepartamento(jefeDepartamentoDTO));

        System.out.println("UPDATE JefeDepartamento con ID = 2");
        jefeDepartamentoDTO = JefeDepartamentoDTO.builder()
                .id(2L)
                .nombre("jefeDepPruebaUpdated")
                .fechaAlta(Timestamp.from(Instant.now()))
                .salario(1000.0)
                .tecnologias(List.of("Tecnologia1","Tecnologia2"))
                .departamento(new Departamento())
                .build();
        System.out.println(jefeDepartamentoController.updateJefeDepartamento(jefeDepartamentoDTO));

        System.out.println("DELETE JefeDepartamento con ID = 2");
        jefeDepartamentoDTO = JefeDepartamentoDTO.builder()
                .id(2L)
                .build();
        System.out.println(jefeDepartamentoController.deleteJegeDepartamento(jefeDepartamentoDTO));
    }
    /**
     * Metodos CRUD issue en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void issueJSON() {
        IssueController issueController = IssueController.getInstance();

        System.out.println("GET Todos las Issues");
        System.out.println(issueController.getAllIssue());


        System.out.println("GET Issue con ID = 6");
        System.out.println(issueController.getIssueById(6L));

        System.out.println("POST Insertando Issue");
        IssueDTO issueDTO = IssueDTO.builder()
                .titulo("IssuePrueba")
                .texto("textoooPrueba")
                .fecha(Timestamp.from(Instant.now()))
                .resuelta(true)
                .jefe(new JefeProyecto())
                .programadores(List.of(new Programador()))
                .repositorio(new Repositorio())
                .commit(new Commit())
                .build();
        System.out.println(issueController.postIssue(issueDTO));

        System.out.println("UPDATE Issue con ID = 16");
        issueDTO = IssueDTO.builder()
                .id(16L)
                .titulo("IssuePruebaUpdated")
                .texto("textoooPrueba")
                .fecha(Timestamp.from(Instant.now()))
                .resuelta(true)
                .jefe(new JefeProyecto())
                .programadores(List.of(new Programador()))
                .repositorio(new Repositorio())
                .commit(new Commit())
                .build();
        System.out.println(issueController.updateIssue(issueDTO));

        System.out.println("DELETE Issue con ID = 16");
        issueDTO = IssueDTO.builder()
                .id(16L)
                .build();
        System.out.println(issueController.deleteIssue(issueDTO));
    }
    /**
     * Metodos CRUD commit en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void commitJSON() {
        CommitController commitController = CommitController.getInstance();

        System.out.println("GET Todos los Commits");
        System.out.println(commitController.getAllCommit().toString());


        System.out.println("GET Commit con ID = 7");
        System.out.println(commitController.getCommitById(7L));

        System.out.println("POST Insertando Commit");
        CommitDTO commitDTO = CommitDTO.builder()
                .titulo("CommitPrueba")
                .texto("textoooPrueba")
                .fecha(Timestamp.from(Instant.now()))
                .issue(new Issue())
                .repositorio(new Repositorio())
                .programador(new Programador())
                .build();
        System.out.println(commitController.postCommit(commitDTO));

        System.out.println("UPDATE Commit con ID = 7");
        commitDTO = CommitDTO.builder()
                .id(7L)
                .titulo("CommitPruebaUpdated")
                .texto("textoooPrueba")
                .fecha(Timestamp.from(Instant.now()))
                .issue(new Issue())
                .repositorio(new Repositorio())
                .programador(new Programador())
                .build();
        System.out.println(commitController.updateCommit(commitDTO));

        System.out.println("DELETE Commit con ID = 7");
        commitDTO = CommitDTO.builder()
                .id(7L)
                .build();
        System.out.println(commitController.deleteCommit(commitDTO));
    }
    /**
     * Metodos CRUD repositorio en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void repositorioJSON() {
        RepositorioController repositorioController = RepositorioController.getInstance();

        System.out.println("GET Todos los Repositorios");
        System.out.println(repositorioController.getAllRepositorio());


        System.out.println("GET Repositorio con ID = 11");
        System.out.println(repositorioController.getRepositorioById(11L));

        System.out.println("POST Insertando Repositorio");
        RepositorioDTO repositorioDTO = RepositorioDTO.builder()
                .nombre("RepositorioPrueba")
                .fechaCreacion(Timestamp.from(Instant.now()))
                .proyecto(new Proyecto())
                .issues(List.of(new Issue()))
                .commits(List.of(new Commit()))
                .build();
        System.out.println(repositorioController.postRepositorio(repositorioDTO));

        System.out.println("UPDATE Repositorio con ID = 11");
        repositorioDTO = RepositorioDTO.builder()
                .id(11L)
                .nombre("RepositorioPruebaUpdated")
                .fechaCreacion(Timestamp.from(Instant.now()))
                .proyecto(new Proyecto())
                .issues(List.of(new Issue()))
                .commits(List.of(new Commit()))
                .build();
        System.out.println(repositorioController.updateRepositorio(repositorioDTO));

        System.out.println("DELETE Repositorio con ID = 11");
        repositorioDTO = RepositorioDTO.builder()
                .id(11L)
                .build();
        System.out.println(repositorioController.deleteRepositorio(repositorioDTO));

    }
}
