package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ProyectoDTO;
import repository.RepoProyecto;
import service.ProyectoService;

import java.sql.SQLException;

public class ProyectoController {
    private static ProyectoController controller = null;

    // Mi Servicio unido al repositorio
    private final ProyectoService proyectoService;

    // Implementamos nuestro Singleton para el controlador
    private ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    public static ProyectoController getInstance() {
        if (controller == null) {
            controller = new ProyectoController(new ProyectoService(new RepoProyecto()));
        }
        return controller;
    }
    /**
     * Printea todos los proyectos en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getAllProyectos() {
        try {
            // Vamos a devolver el JSON de los proyectos
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoService.getAllProyectos());
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getAll: " + e.getMessage());
            return "Error ProyectoController en getAll: " + e.getMessage();
        }
    }
    /**
     * Printea proyecto POR ID en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getProyectoById(Long id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoService.getProyectoById(id));
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getProyectoById: " + e.getMessage());
            return "Error ProyectoController en getProyectoById: " + e.getMessage();
        }
    }
    /**
     * Printea el save de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String postProyecto(ProyectoDTO proyectoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoService.postProyecto(proyectoDTO));
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en postProyecto: " + e.getMessage());
            return "Error ProyectoController en postProyecto: " + e.getMessage();
        }
    }
    /**
     * Printea el update de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String updateProyecto(ProyectoDTO proyectoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoService.updateProyecto(proyectoDTO));
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en updateProyecto: " + e.getMessage());
            return "Error ProyectoController en updateProyecto: " + e.getMessage();
        }
    }
    /**
     * Printea el delete de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String deleteProyecto(ProyectoDTO proyectoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoService.deleteProyecto(proyectoDTO));
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en deleteProyecto: " + e.getMessage());
            return "Error ProyectoController en deleteProyecto: " + e.getMessage();
        }
    }

    public String getProyectosMasCaros() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoService.getProyectosMasCaros());
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getProyectosMasCaros: " + e.getMessage());
            return "Error ProyectoController en getProyectosMasCaros: " + e.getMessage();
        }
    }
}