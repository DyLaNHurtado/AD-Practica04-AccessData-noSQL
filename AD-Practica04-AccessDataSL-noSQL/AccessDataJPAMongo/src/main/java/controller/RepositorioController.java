package controller;

import dto.RepositorioDTO;
import repository.RepoRepositorio;
import service.RepositorioService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de Repositorio
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepositorioController {

    private static RepositorioController controller;
    private final RepositorioService repositorioService;

    /**
     * Constructor privado
     * @param repositorioService
     */
    private RepositorioController(RepositorioService repositorioService) {
        this.repositorioService = repositorioService;
    }

    /**
     * Patron Singleton
     * @return RepositorioController
     */
    public static RepositorioController getInstance() {
        if (controller == null) {
            controller = new RepositorioController(new RepositorioService(new RepoRepositorio()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de RepositorioDTO
     * @return List<RepositorioDTO>
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
     * LLama al servicio y devuelve RepositorioDTO según una ID
     * @param id Long
     * @return RepositorioDTO
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
     * LLama al servicio para insertar un Repositorio
     * @param repositorioDTO
     * @return RepositorioDTO
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
     * Llama al servicio para actualizar un Repositorio
     * @param repositorioDTO
     * @return RepositorioDTO
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
     * Llama al servicio para eliminar un Repositorio
     * @param repositorioDTO
     * @return RepositorioDTO
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