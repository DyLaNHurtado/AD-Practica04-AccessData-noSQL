package controller;

import dto.ProyectoDTO;
import repository.RepoProyecto;
import service.ProyectoService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de Proyecto
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class ProyectoController {

    private static ProyectoController controller;
    private final ProyectoService proyectoService;

    /**
     * Constructor privado
     * @param proyectoService
     */
    private ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    /**
     * Patron Singleton
     * @return ProyectoController
     */
    public static ProyectoController getInstance() {
        if (controller == null) {
            controller = new ProyectoController(new ProyectoService(new RepoProyecto()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de ProyectoDTO
     * @return List<ProyectoDTO>
     */
    public List<ProyectoDTO> getAllProyectos() {
        try {
            return proyectoService.getAllProyectos().get();
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio y devuelve ProyectoDTO según una ID
     * @param id Long
     * @return ProyectoDTO
     */
    public ProyectoDTO getProyectoById(Long id) {
        try {
            return proyectoService.getProyectoById(id);
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getProyectoById: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio para insertar un Proyecto
     * @param proyectoDTO
     * @return ProyectoDTO
     */
    public ProyectoDTO postProyecto(ProyectoDTO proyectoDTO) {
        try {
            return proyectoService.postProyecto(proyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en postProyecto: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para actualizar un Proyecto
     * @param proyectoDTO
     * @return ProyectoDTO
     */
    public ProyectoDTO updateProyecto(ProyectoDTO proyectoDTO) {
        try {
            return proyectoService.updateProyecto(proyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en updateProyecto: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para eliminar un Proyecto
     * @param proyectoDTO
     * @return ProyectoDTO
     */
    public ProyectoDTO deleteProyecto(ProyectoDTO proyectoDTO) {
        try {
            return proyectoService.deleteProyecto(proyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en deleteProyecto: " + e.getMessage());
            return null;
        }
    }
}