package controller;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ProyectoDTO;
import repository.RepoRepositorio;
import service.RepositorioService;

import java.sql.SQLException;

public class RepositorioController {
    private static RepositorioController controller = null;

    // Mi Servicio unido al repositorio
    private final RepositorioService repositorioService;

    // Implementamos nuestro Singleton para el controlador
    private RepositorioController(RepositorioService repositorioService) {
        this.repositorioService = repositorioService;
    }

    public static RepositorioController getInstance() {
        if (controller == null) {
            controller = new RepositorioController(new RepositorioService(new RepoRepositorio()));
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
            return prettyGson.toJson(repositorioService.getAllProyectos());
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
            return prettyGson.toJson(repositorioService.getProyectoById(id));
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
            return prettyGson.toJson(repositorioService.postProyecto(proyectoDTO));
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
    public String updateProyectoJSON(ProyectoDTO comitDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.updateProyecto(comitDTO));
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
            return prettyGson.toJson(repositorioService.deleteProyecto(proyectoDTO));
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en deleteProyecto: " + e.getMessage());
            return "Error ProyectoController en deleteProyecto: " + e.getMessage();
        }
    }

    public String getProyectosMasCaros() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.getProyectosMasCaros());
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getProyectosMasCaros: " + e.getMessage());
            return "Error ProyectoController en getProyectosMasCaros: " + e.getMessage();
        }
    }
}