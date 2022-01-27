package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.JefeDepartamento;
import dto.DepartamentoDTO;
import dto.JefeDepartamentoDTO;
import repository.RepoDepartamento;
import repository.RepoJefeDepartamento;
import repository.RepoJefeProyecto;
import service.DepartamentoService;
import service.JefeDepartamentoService;

import java.sql.SQLException;

public class JefeDepartamentoController {

    private static JefeDepartamentoController controller = null;

    // Mi Servicio unido al repositorio
    private final JefeDepartamentoService jefeDepartamentoService;

    // Implementamos nuestro Singleton para el controlador
    private JefeDepartamentoController(JefeDepartamentoService jefeDepartamentoService) {
        this.jefeDepartamentoService = jefeDepartamentoService;
    }
    /**
     * Patron singleton
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public static JefeDepartamentoController getInstance() {
        if (controller == null) {
            controller = new JefeDepartamentoController(new JefeDepartamentoService(new RepoJefeDepartamento()));
        }
        return controller;
    }

    /**
     * Printea  todos los jefe departamemtos en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getAllDepartamentos() {
        try {
            // Vamos a devolver el JSON de los jefe de departamentos
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(jefeDepartamentoService.getAllJefeDepartamento());
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en getAll: " + e.getMessage());
            return "Error JefeDepartamentoController en getAll: " + e.getMessage();
        }
    }

    /**
     * Printea  jefedepartamento por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getJefeDepartamentoByIdJSON(Long id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(jefeDepartamentoService.getJefeDepartamentoById(id));
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en getJefeDepartamentoById: " + e.getMessage());
            return "Error JefeDepartamentoController en getJefeDepartamentoById: " + e.getMessage();
        }
    }

    /**
     * Printea  el save de jefe departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String postJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(jefeDepartamentoService.postJefeDepartamento(jefeDepartamentoDTO));
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en postJefeDepartamento: " + e.getMessage());
            return "Error JefeDepartamentoController en postJefeDepartamento: " + e.getMessage();
        }
    }
    /**
     * Printea  el update de jefe departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String updateJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(jefeDepartamentoService.updateJefeDepartamento(jefeDepartamentoDTO));
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en updateJefeDepartamento: " + e.getMessage());
            return "Error JefeDepartamentoController en updateJefeDepartamento: " + e.getMessage();
        }
    }
    /**
     * Printea  el delete de jefe departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String deleteJegeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(jefeDepartamentoService.deleteJefeDepartamento(jefeDepartamentoDTO));
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en deleteJefeDepartamento: " + e.getMessage());
            return "Error JefeDepartamentoController en deleteJefeDepartamento: " + e.getMessage();
        }
    }
}
