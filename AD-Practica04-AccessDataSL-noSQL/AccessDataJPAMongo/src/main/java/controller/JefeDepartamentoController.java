package controller;

import dto.JefeDepartamentoDTO;
import repository.RepoJefeDepartamento;
import service.JefeDepartamentoService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de JefeDepartamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class JefeDepartamentoController {

    private static JefeDepartamentoController controller;
    private final JefeDepartamentoService jefeDepartamentoService;

    /**
     * Constructor privado
     * @param jefeDepartamentoService
     */
    private JefeDepartamentoController(JefeDepartamentoService jefeDepartamentoService) {
        this.jefeDepartamentoService = jefeDepartamentoService;
    }

    /**
     * Patron Singleton
     * @return JefeDepartamentoController
     */
    public static JefeDepartamentoController getInstance() {
        if (controller == null) {
            controller = new JefeDepartamentoController(new JefeDepartamentoService(new RepoJefeDepartamento()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de JefeDepartamentoDTO
     * @return List<JefeDepartamentoDTO>
     */
    public List<JefeDepartamentoDTO> getAllJefesDepartamento() {
        try {
            return jefeDepartamentoService.getAllJefeDepartamento().get();
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio y devuelve JefeDepartamentoDTO según una ID
     * @param id Long
     * @return JefeDepartamentoDTO
     */
    public JefeDepartamentoDTO getJefeDepartamentoById(Long id) {
        try {
            return jefeDepartamentoService.getJefeDepartamentoById(id);
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en getJefeDepartamentoById: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio para insertar un JefeDepartamento
     * @param jefeDepartamentoDTO
     * @return JefeDepartamentoDTO
     */
    public JefeDepartamentoDTO postJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) {
        try {
            return jefeDepartamentoService.postJefeDepartamento(jefeDepartamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en postJefeDepartamento: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para actualizar un JefeDepartamento
     * @param jefeDepartamentoDTO
     * @return JefeDepartamentoDTO
     */
    public JefeDepartamentoDTO updateJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) {
        try {

            return jefeDepartamentoService.updateJefeDepartamento(jefeDepartamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en updateJefeDepartamento: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para eliminar un JefeDepartamento
     * @param jefeDepartamentoDTO
     * @return JefeDepartamentoDTO
     */
    public JefeDepartamentoDTO deleteJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) {
        try {
            return jefeDepartamentoService.deleteJefeDepartamento(jefeDepartamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error JefeDepartamentoController en deleteJefeDepartamento: " + e.getMessage());
            return null;
        }
    }
}