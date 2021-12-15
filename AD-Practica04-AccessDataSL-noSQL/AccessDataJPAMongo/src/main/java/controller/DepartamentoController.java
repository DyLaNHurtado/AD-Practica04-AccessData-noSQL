package controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.DepartamentoDTO;
import repository.RepoDepartamento;
import service.DepartamentoService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.sql.SQLException;


public class DepartamentoController {
    private static DepartamentoController controller = null;

    // Mi Servicio unido al repositorio
    private final DepartamentoService departamentoService;
    private Marshaller marshaller;

    // Implementamos nuestro Singleton para el controlador
    private DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }
    /**
     * Patron singleton
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public static DepartamentoController getInstance() {
        if (controller == null) {
            controller = new DepartamentoController(new DepartamentoService(new RepoDepartamento()));
        }
        return controller;
    }
    /**
     * Printea  todos los departamentos en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getAllDepartamentosJSON() {
        try {
            // Vamos a devolver el JSON de los departamentos
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoService.getAllDepartamentos());
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getAll: " + e.getMessage());
            return "Error DepartamentoController en getAll: " + e.getMessage();
        }
    }
    /**
     * Printea  departamento por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getDepartamentoByIdJSON(String id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoService.getDepartamentoById(id));
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getDepartamentoById: " + e.getMessage());
            return "Error DepartamentoController en getDepartamentoById: " + e.getMessage();
        }
    }
    /**
     * Printea  el save de departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String postDepartamentoJSON(DepartamentoDTO departamentoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoService.postDepartamento(departamentoDTO));
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en postDepartamento: " + e.getMessage());
            return "Error DepartamentoController en postDepartamento: " + e.getMessage();
        }
    }
    /**
     * Printea  el update de departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String updateDepartamentoJSON(DepartamentoDTO comitDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoService.updateDepartamento(comitDTO));
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en updateDepartamento: " + e.getMessage());
            return "Error DepartamentoController en updateDepartamento: " + e.getMessage();
        }
    }
    /**
     * Printea  el delete de departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String deleteDepartamentoJSON(DepartamentoDTO departamentoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoService.deleteDepartamento(departamentoDTO));
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en deleteDepartamento: " + e.getMessage());
            return "Error DepartamentoController en deleteDepartamento: " + e.getMessage();
        }
    }

    //XML

    /**
     * Printea  todos los departamentos  en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void getAllDepartamentosXML() {
        try {
            // Vamos a devolver el XML de los commits
            JAXBContext jaxbContext = JAXBContext.newInstance(dto.DepartamentoDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(departamentoService.getAllDepartamentos(), System.out);
        } catch (JAXBException | SQLException e) {
            System.err.println("Error DepartamentoController en getAll: " + e.getMessage() );
        }
    }
    /**
     * Printea   departamento por id en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void getDepartamentoByIdXML(String id) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartamentoDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(departamentoService.getDepartamentoById(id), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error CommitController en getCommitById: " + e.getMessage());
        }
    }
    /**
     * Printea  el save de departamento en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void postDepartamentoXML(DepartamentoDTO departamentoDTO) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartamentoDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(departamentoService.postDepartamento(departamentoDTO), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error CommitController en postCommit: " + e.getMessage());
        }
    }
    /**
     * Printea  el update de departamento en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void updateDepartamentoXML(DepartamentoDTO departamentoDTO) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartamentoDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(departamentoService.updateDepartamento(departamentoDTO), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error CommitController en updateCommit: " + e.getMessage());
        }
    }
    /**
     * Printea  el delete de departamento en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void deleteDepartamentoXML(DepartamentoDTO departamentoDTO) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartamentoDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(departamentoService.deleteDepartamento(departamentoDTO), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error CommitController en deleteCommit: " + e.getMessage());
        }
    }
}