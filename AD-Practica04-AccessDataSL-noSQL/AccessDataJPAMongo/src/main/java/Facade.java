import controller.*;
import dao.*;
import database.DataBaseController;
import dto.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Facade {
    private static Facade instance;

    private Facade() {
    }
    /**
     * Patron Singleton
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
    /**
     * Metodos que carga la base de datos de nuevo a traves del archivo init-db.sql
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void initDataBase() {
        String sqlFile = System.getProperty("user.dir") + File.separator + "sql" + File.separator + "init-db.sql";
        System.out.println("***************************\n" +
                "\t\tSQL FILE\n" +
                "***************************");
        System.out.println(sqlFile);
        DataBaseController controller = DataBaseController.getInstance();
        try {
            controller.open();
            controller.initData(sqlFile);
            controller.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el fichero de datos iniciales: " + e.getMessage());
            System.exit(1);
        }
    }
    /**
     * Metodo para seleccionar por scanner la salida
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void selectJsonOrXml() {
        System.out.println("Selecciona una salida para visualizar las operaciones (xml or json): ");
        Scanner sc = new Scanner (System.in);
        String value=sc.next().toLowerCase(Locale.ROOT);



        while (!(value.equals("xml") || value.equals("json"))) {
            System.out.println("Error: No se ha introducido un valor valido");
            System.out.println("Introduzca json o introduzca xml :");
            value=sc.next();
        }

        if (value.equals("json")){
            salidaJSON();
        }
        if (value.equals("xml")){
            salidaXML();
        }

    }
    /**
     * Dar salida al JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void salidaJSON() {
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

        System.out.println("**********************\n"+
                "\t\tPROGRAMADOR\n"+
                "**********************");
        this.programadorJSON();



System.out.println("**********************\n"+
                "\t\tTECNOLOGIA\n"+
                "**********************");
        this.tecnologiaJSON();


    }
    /**
     * Dar salida al XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void salidaXML() {
        System.out.println("-------------------------------\n" +
                "\t\tOPERACIONES CRUD\n" +
                "-------------------------------\n");

        System.out.println("**********************\n" +
                "\t\tDEPARTAMENTO\n" +
                "**********************");
        this.departamentoXML();

        System.out.println("**********************\n"+
                "\t\tPROYECTO\n"+
                "**********************");
        this.proyectoXML();


        System.out.println("**********************\n"+
                "\t\tPROGRAMADOR\n"+
                "**********************");

        this.programadorXML();


        System.out.println("**********************\n"+
                "\t\tTECNOLOGIA\n"+
                "**********************");
        this.tecnologiaXML();

    }
    /**
     * Metodos CRUD departamento en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void departamentoXML() {
        DepartamentoController departamentoController = DepartamentoController.getInstance();

        System.out.println("GET Todos las Departamentos");
        departamentoController.getAllDepartamentosXML();

        System.out.println("GET Departamento con ID = 1e89386d-be37-4930-b6ae-bcba6c9917b4");
        departamentoController.getDepartamentoByIdXML("1e89386d-be37-4930-b6ae-bcba6c9917b4");

        System.out.println("POST Insertando Departamento");
        DepartamentoDTO departamentoDTO = DepartamentoDTO.builder()
                .idDepartamento(UUID.randomUUID().toString())
                .nombre("DepartamentoPrueba")
                .trabajadores(List.of(new Programador()))
                .presupuesto(10000.0)
                .presupuestoAnual(100000.0)
                .build();
        departamentoController.postDepartamentoXML(departamentoDTO);

        System.out.println("UPDATE Departamento con ID = 512a0695-3294-4c2c-86d9-4babd4485fa8");
        departamentoDTO = DepartamentoDTO.builder()
                .idDepartamento("512a0695-3294-4c2c-86d9-4babd4485fa8")
                .nombre("DepartamentoPruebaUpdated")
                .trabajadores(List.of(new Programador()))
                .presupuesto(10000.0)
                .presupuestoAnual(100000.0)
                .build();
        departamentoController.updateDepartamentoXML(departamentoDTO);

        System.out.println("DELETE Departamento con ID = 512a0695-3294-4c2c-86d9-4babd4485fa8");
        departamentoDTO = DepartamentoDTO.builder()
                .idDepartamento("512a0695-3294-4c2c-86d9-4babd4485fa8")
                .build();
        departamentoController.deleteDepartamentoXML(departamentoDTO);
    }
    /**
     * Metodos CRUD programador en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void programadorXML() {

        ProgramadorController programadorController = ProgramadorController.getInstance();

        System.out.println("GET Todos los Programadores");
        programadorController.getAllProgramadoresXML();

        System.out.println("GET Programador con ID = 1376acc9-79a9-4bf1-9084-c82e9a07f432");
        programadorController.getProgramadorByIdXML("1376acc9-79a9-4bf1-9084-c82e9a07f432");

        System.out.println("POST Insertando Programador");
        ProgramadorDTO programadorDTO = ProgramadorDTO.builder()
                .idProgramador(UUID.randomUUID().toString())
                .nombre("Prueba")
                .fechaAlta(LocalDate.now())
                //Cuidado que es tipo Date
                .departamento(new Departamento("2d1d1422-fede-4e27-8883-3ffdb1be1a7c"))
                .proyectosParticipa(List.of(new Proyecto()))
                .tecnologias(List.of(new Tecnologia()))
                .salario(1350.0)
                .build();
        programadorController.postProgramadorXML(programadorDTO);

        System.out.println("UPDATE Programador con ID = 53269670-1586-49ac-9df5-62ddd55f96cc");
        programadorDTO = ProgramadorDTO.builder()
                .idProgramador("53269670-1586-49ac-9df5-62ddd55f96cc")
                .nombre("Prueba2")
                .fechaAlta(LocalDate.now())
                //Cuidado que es tipo Date
                .departamento(new Departamento("2d1d1422-fede-4e27-8883-3ffdb1be1a7c"))
                .proyectosParticipa(List.of(new Proyecto()))
                .tecnologias(List.of(new Tecnologia()))
                .salario(1350.0)
                .build();
        programadorController.updateProgramadorXML(programadorDTO);

        System.out.println("DELETE Programador con ID = 1376acc9-79a9-4bf1-9084-c82e9a07f432");
        programadorDTO = ProgramadorDTO.builder()
                .idProgramador("1376acc9-79a9-4bf1-9084-c82e9a07f432")
                .fechaAlta(LocalDate.now())
                .build();
        programadorController.deleteProgramadorXML(programadorDTO);
    }

    /**
     * Metodos CRUD proyecto en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void proyectoXML() {
        ProyectoController proyectoController = ProyectoController.getInstance();

        System.out.println("GET Todos los Proyectos");
        proyectoController.getAllProyectosXML();

        System.out.println("GET Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        proyectoController.getProyectoByIdXML("81ee1211-760c-493d-968a-380e6af67363");

        System.out.println("POST Insertando Proyecto");
        ProyectoDTO proyectoDTO = ProyectoDTO.builder()
                .idProyecto(UUID.randomUUID().toString())
                .nombre("Prueba")
                .presupuesto(100.0)
                .fechaInicio(LocalDate.of(2015, 2, 13))
                .fechaFin(LocalDate.now())
                .tecnologias(List.of(new Tecnologia()))
                .departamento(new Departamento("1e89386d-be37-4930-b6ae-bcba6c9917b4"))
                .build();
        proyectoController.postProyectoXML(proyectoDTO);

        System.out.println("UPDATE Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        proyectoDTO = ProyectoDTO.builder()
                .idProyecto("81ee1211-760c-493d-968a-380e6af67363")
                .nombre("Prueba")
                .presupuesto(100.0)
                .fechaInicio(LocalDate.of(2015, 2, 13))
                .fechaFin(LocalDate.now())
                .tecnologias(List.of(new Tecnologia()))
                .departamento(new Departamento("1e89386d-be37-4930-b6ae-bcba6c9917b4"))
                .build();
        proyectoController.updateProyectoXML(proyectoDTO);

        System.out.println("DELETE Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        proyectoDTO = ProyectoDTO.builder()
                .idProyecto("81ee1211-760c-493d-968a-380e6af67363")
                .fechaInicio(LocalDate.of(2015, 2, 13))
                .fechaFin(LocalDate.now())
                .build();
        proyectoController.deleteProyectoXML(proyectoDTO);

    }
    /**
     * Metodos CRUD tecnologia en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void tecnologiaXML() {

        TecnologiaController tecnologiaController = TecnologiaController.getInstance();

        System.out.println("GET Todos las Tecnologias");
        tecnologiaController.getAllTecnologiasXML();

        System.out.println("GET Tecnologia con ID = 4f119f1b-7ccf-49f4-b56f-fdace8589b1c");
        tecnologiaController.getTecnologiaByIdXML("4f119f1b-7ccf-49f4-b56f-fdace8589b1c");

        System.out.println("POST Insertando Tecnologia");
        TecnologiaDTO tecnologiaDTO = TecnologiaDTO.builder()
                .idTecnologia(UUID.randomUUID().toString())
                .nombre("NodeJS")
                .build();
        tecnologiaController.postTecnologiaXML(tecnologiaDTO);

        System.out.println("UPDATE Tecnologia con ID = 4f119f1b-7ccf-49f4-b56f-fdace8589b1c");
        tecnologiaDTO = TecnologiaDTO.builder()
                .idTecnologia("4f119f1b-7ccf-49f4-b56f-fdace8589b1c")
                .nombre("Swift")
                .build();
        tecnologiaController.updateTecnologiaXML(tecnologiaDTO);

        System.out.println("DELETE Tecnologia con ID = 4f119f1b-7ccf-49f4-b56f-fdace8589b1c");
        tecnologiaDTO = TecnologiaDTO.builder()
                .idTecnologia("4f119f1b-7ccf-49f4-b56f-fdace8589b1c")
                .build();
        tecnologiaController.deleteTecnologiaXML(tecnologiaDTO);

    }


    /**
     * Metodos CRUD departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void departamentoJSON() {
        DepartamentoController departamentoController = DepartamentoController.getInstance();

        System.out.println("GET Todos las Departamentos");
        System.out.println(departamentoController.getAllDepartamentosJSON());

        System.out.println("GET Departamento con ID = 1e89386d-be37-4930-b6ae-bcba6c9917b4");
        System.out.println(departamentoController.getDepartamentoByIdJSON("1e89386d-be37-4930-b6ae-bcba6c9917b4"));

        System.out.println("POST Insertando Departamento");
        DepartamentoDTO departamentoDTO = DepartamentoDTO.builder()
                .idDepartamento(UUID.randomUUID().toString())
                .nombre("DepartamentoPrueba")
                .trabajadores(List.of(new Programador()))
                .proyDesarrollo(List.of(new Proyecto()))
                .proyFinalizados(List.of(new Proyecto()))
                .presupuesto(10000.0)
                .presupuestoAnual(100000.0)
                .build();
        System.out.println(departamentoController.postDepartamentoJSON(departamentoDTO));

        System.out.println("UPDATE Departamento con ID = 512a0695-3294-4c2c-86d9-4babd4485fa8");
        departamentoDTO = DepartamentoDTO.builder()
                .idDepartamento("512a0695-3294-4c2c-86d9-4babd4485fa8")
                .nombre("DepartamentoPruebaUpdated")
                .trabajadores(List.of(new Programador()))
                .proyDesarrollo(List.of(new Proyecto()))
                .proyFinalizados(List.of(new Proyecto()))
                .presupuesto(10000.0)
                .presupuestoAnual(100000.0)
                .build();
        System.out.println(departamentoController.updateDepartamentoJSON(departamentoDTO));

        System.out.println("DELETE Departamento con ID = 512a0695-3294-4c2c-86d9-4babd4485fa8");
        departamentoDTO = DepartamentoDTO.builder()
                .idDepartamento("512a0695-3294-4c2c-86d9-4babd4485fa8")
                .build();
        System.out.println(departamentoController.deleteDepartamentoJSON(departamentoDTO));
    }

    /**
     * Metodos CRUD programador en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void programadorJSON() {
        ProgramadorController programadorController = ProgramadorController.getInstance();

        System.out.println("GET Todos los Programadores");
        System.out.println(programadorController.getAllProgramadorsJSON());

        System.out.println("GET Programador con ID = d63f0d73-3f1b-4afd-b5d0-821449daa4a3");
        System.out.println(programadorController.getProgramadorByIdJSON("d63f0d73-3f1b-4afd-b5d0-821449daa4a3"));

        System.out.println("POST Insertando Programador");
        ProgramadorDTO programadorDTO = ProgramadorDTO.builder()
                .idProgramador(UUID.randomUUID().toString())
                .nombre("Prueba")
                .fechaAlta(LocalDate.now())
                //Cuidado que es tipo Date
                .departamento(new Departamento("2d1d1422-fede-4e27-8883-3ffdb1be1a7c"))
                .proyectosParticipa(List.of(new Proyecto()))
                .tecnologias(List.of(new Tecnologia()))
                .salario(1350.0)
                .build();
        System.out.println(programadorController.postProgramadorJSON(programadorDTO));

        System.out.println("UPDATE Programador con ID = 53269670-1586-49ac-9df5-62ddd55f96cc");
        programadorDTO = ProgramadorDTO.builder()
                .idProgramador("53269670-1586-49ac-9df5-62ddd55f96cc")
                .nombre("Prueba2")
                .fechaAlta(LocalDate.now())
                //Cuidado que es tipo Date
                .departamento(new Departamento("2d1d1422-fede-4e27-8883-3ffdb1be1a7c"))
                .proyectosParticipa(List.of(new Proyecto()))
                .tecnologias(List.of(new Tecnologia()))
                .salario(1350.0)
                .build();
        System.out.println(programadorController.updateProgramadorJSON(programadorDTO));

        System.out.println("DELETE Programador con ID = d63f0d73-3f1b-4afd-b5d0-821449daa4a3");
        programadorDTO = ProgramadorDTO.builder()
                .idProgramador("d63f0d73-3f1b-4afd-b5d0-821449daa4a3")
                .fechaAlta(LocalDate.now())
                .build();
        System.out.println(programadorController.deleteProgramadorJSON(programadorDTO));
    }

    /**
     * Metodos CRUD proyecto en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void proyectoJSON() {
        ProyectoController proyectoController = ProyectoController.getInstance();

        System.out.println("GET Todos los Proyectos");
        System.out.println(proyectoController.getAllProyectosJSON());

        System.out.println("GET Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        System.out.println(proyectoController.getProyectoByIdJSON("81ee1211-760c-493d-968a-380e6af67363"));

        System.out.println("POST Insertando Proyecto");
        ProyectoDTO proyectoDTO = ProyectoDTO.builder()
                .idProyecto(UUID.randomUUID().toString())
                .nombre("Prueba")
                .presupuesto(100.0)
                .fechaInicio(LocalDate.of(2015, 2, 13))
                .fechaFin(LocalDate.now())
                .tecnologias(List.of(new Tecnologia()))
                .departamento(new Departamento("1e89386d-be37-4930-b6ae-bcba6c9917b4"))
                .build();
        System.out.println(proyectoController.postProyectoJSON(proyectoDTO));

        System.out.println("UPDATE Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        proyectoDTO = ProyectoDTO.builder()
                .idProyecto("81ee1211-760c-493d-968a-380e6af67363")
                .nombre("Prueba")
                .presupuesto(100.0)
                .fechaInicio(LocalDate.of(2015, 2, 13))
                .fechaFin(LocalDate.now())
                .tecnologias(List.of(new Tecnologia()))
                .departamento(new Departamento("1e89386d-be37-4930-b6ae-bcba6c9917b4"))
                .build();
        System.out.println(proyectoController.updateProyectoJSON(proyectoDTO));

        System.out.println("DELETE Proyecto con ID = 81ee1211-760c-493d-968a-380e6af67363");
        proyectoDTO = ProyectoDTO.builder()
                .idProyecto("81ee1211-760c-493d-968a-380e6af67363")
                .fechaInicio(LocalDate.of(2015, 2, 13))
                .fechaFin(LocalDate.now())
                .build();
        System.out.println(proyectoController.deleteProyectoJSON(proyectoDTO));
    }


    /**
     * Metodos CRUD tecnologia en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    private void tecnologiaJSON() {
        TecnologiaController tecnologiaController = TecnologiaController.getInstance();

        System.out.println("GET Todos las Tecnologias");
        System.out.println(tecnologiaController.getAllTecnologiasJSON());

        System.out.println("GET Tecnologia con ID = 4f119f1b-7ccf-49f4-b56f-fdace8589b1c");
        System.out.println(tecnologiaController.getTecnologiaByIdJSON("4f119f1b-7ccf-49f4-b56f-fdace8589b1c"));

        System.out.println("POST Insertando Tecnologia");
        TecnologiaDTO tecnologiaDTO = TecnologiaDTO.builder()
                .idTecnologia(UUID.randomUUID().toString())
                .nombre("NodeJS")
                .build();
        System.out.println(tecnologiaController.postTecnologiaJSON(tecnologiaDTO));

        System.out.println("UPDATE Tecnologia con ID = 4f119f1b-7ccf-49f4-b56f-fdace8589b1c");
        tecnologiaDTO = TecnologiaDTO.builder()
                .idTecnologia("4f119f1b-7ccf-49f4-b56f-fdace8589b1c")
                .nombre("Swift")
                .build();
        System.out.println(tecnologiaController.updateTecnologiaJSON(tecnologiaDTO));

        System.out.println("DELETE Tecnologia con ID = 4f119f1b-7ccf-49f4-b56f-fdace8589b1c");
        tecnologiaDTO = TecnologiaDTO.builder()
                .idTecnologia("4f119f1b-7ccf-49f4-b56f-fdace8589b1c")
                .build();
        System.out.println(tecnologiaController.deleteTecnologiaJSON(tecnologiaDTO));
    }
}