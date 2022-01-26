package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.RepositorioDTO;
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
    public String getAllRepositorio() {
        try {
            // Vamos a devolver el JSON de los proyectos
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.getAllRepositorios());
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en getAll: " + e.getMessage());
            return "Error RepositorioController en getAll: " + e.getMessage();
        }
    }
    /**
     * Printea proyecto POR ID en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getRepositorioById(Long id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.getRepositorioById(id));
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en getRepositorioById: " + e.getMessage());
            return "Error RepositorioController en getRepositorioById: " + e.getMessage();
        }
    }
    /**
     * Printea el save de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String postRepositorio(RepositorioDTO repositorioDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.postRepositiorio(repositorioDTO));
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en postRepositorio: " + e.getMessage());
            return "Error RepositorioController en postRepositorio: " + e.getMessage();
        }
    }
    /**
     * Printea el update de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String updateRepositorioJSON(RepositorioDTO repositorioDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.updateRepositorio(repositorioDTO));
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en update: " + e.getMessage());
            return "Error RepositorioController en update: " + e.getMessage();
        }
    }
    /**
     * Printea el delete de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String deleteRepositorio(RepositorioDTO repositorioDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.deleteRepositorio(repositorioDTO));
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en delete: " + e.getMessage());
            return "Error RepositorioController en delete: " + e.getMessage();
        }
    }
}