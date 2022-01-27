package controller;

import dto.ProyectoDTO;
import repository.RepoProyecto;
import service.ProyectoService;

import java.sql.SQLException;
import java.util.List;

public class ProyectoController {
    private static ProyectoController controller = null;

    private final ProyectoService proyectoService;

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
    public List<ProyectoDTO> getAllProyectos() {
        try {
            return proyectoService.getAllProyectos().get();
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getAll: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea proyecto POR ID en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea el save de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea el update de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea el delete de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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