package controller;

import dto.JefeProyectoDTO;
import repository.RepoJefeProyecto;
import service.JefeProyectoService;

import java.sql.SQLException;
import java.util.List;

public class JefeProyectoController {
    private static JefeProyectoController controller;
    private final JefeProyectoService service;
    private JefeProyectoController(JefeProyectoService service){
        this.service=service;
    }
    public JefeProyectoController getInstance(){
        if(controller==null){
            controller=new JefeProyectoController(new JefeProyectoService(new RepoJefeProyecto()));
        }
        return controller;
    }
    /**
     * Printea  todos los jefes de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea jefe de proyecto por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeProyectoDTO getJefeProyectoByIdJSON(Long id) {
        try {
            return service.getJefeProyectoById(id);
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en getJefeProyectoById: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea  el save de jefe de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el update de jefe de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el delete de jefe de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
