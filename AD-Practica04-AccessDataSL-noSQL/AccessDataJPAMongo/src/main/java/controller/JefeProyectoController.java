package controller;

import dto.JefeProyectoDTO;
import repository.RepoJefeProyecto;
import service.JefeProyectoService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de JefeProyecto
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class JefeProyectoController {

    private static JefeProyectoController controller;
    private final JefeProyectoService service;

    /**
     * Constructor privado
     * @param service JefeProyectoService
     */
    private JefeProyectoController(JefeProyectoService service){
        this.service=service;
    }

    /**
     * Patron Singleton
     * @return JefeProyectoController
     */
    public static JefeProyectoController getInstance(){
        if(controller==null){
            controller=new JefeProyectoController(new JefeProyectoService(new RepoJefeProyecto()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de JefeProyectoDTO
     * @return List<JefeProyectoDTO>
     */
    public List<JefeProyectoDTO> getAllJefeProyecto() {
        try {
            return service.getAllJefeProyecto().get();
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio y devuelve JefeProyectoDTO según una ID
     * @param id Long
     * @return JefeProyectoDTO
     */
    public JefeProyectoDTO getJefeProyectoById(Long id) {
        try {
            return service.getJefeProyectoById(id);
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en getJefeProyectoById: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio para insertar un JefeProyecto
     * @param jefeProyectoDTO
     * @return JefeProyectoDTO
     */
    public JefeProyectoDTO postJefeProyecto(JefeProyectoDTO jefeProyectoDTO) {
        try {
            return service.postJefeProyecto(jefeProyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en postJefeProyecto: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para actualizar un JefeProyecto
     * @param jefeProyectoDTO
     * @return JefeProyectoDTO
     */
    public JefeProyectoDTO updateJefeProyecto(JefeProyectoDTO jefeProyectoDTO) {
        try {
            return service.updateJefeProyecto(jefeProyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en updateJefeProyecto: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para eliminar un JefeProyecto
     * @param jefeProyectoDTO
     * @return JefeProyectoDTO
     */
    public JefeProyectoDTO deleteJefeProyecto(JefeProyectoDTO jefeProyectoDTO) {
        try {
            return service.deleteJefeProyecto(jefeProyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en deleteJefeProyecto: " + e.getMessage());
            return null;
        }
    }
}
