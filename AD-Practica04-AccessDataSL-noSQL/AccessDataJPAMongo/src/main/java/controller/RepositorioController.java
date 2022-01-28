package controller;

import dto.RepositorioDTO;
import repository.RepoRepositorio;
import service.RepositorioService;

import java.sql.SQLException;
import java.util.List;

public class RepositorioController {
    private static RepositorioController controller = null;

    private final RepositorioService repositorioService;

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
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public List<RepositorioDTO> getAllRepositorio() {
        try {
            return repositorioService.getAllRepositorios().get();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Printea proyecto POR ID en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public RepositorioDTO getRepositorioById(Long id) {
        try {
            return repositorioService.getRepositorioById(id);
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * Printea el save de proyecto en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public RepositorioDTO postRepositorio(RepositorioDTO repositorioDTO) {
        try {
            return repositorioService.postRepositiorio(repositorioDTO);
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en postRepositorio: " + e.getMessage());
            return null;
        }
    }

    /**
     * Printea el update de proyecto en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public RepositorioDTO updateRepositorio(RepositorioDTO repositorioDTO) {
        try {
            return repositorioService.updateRepositorio(repositorioDTO);
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en update: " + e.getMessage());
            return null;
        }
    }

    /**
     * Printea el delete de proyecto en JSON
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public RepositorioDTO deleteRepositorio(RepositorioDTO repositorioDTO) {
        try {
            return repositorioService.deleteRepositorio(repositorioDTO);
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en delete: " + e.getMessage());
            return null;
        }
    }
}