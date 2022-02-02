package controller;

import dto.JefeDepartamentoDTO;
import repository.RepoJefeDepartamento;
import service.JefeDepartamentoService;

import java.sql.SQLException;
import java.util.List;

public class JefeDepartamentoController {

    private static JefeDepartamentoController controller = null;

    private final JefeDepartamentoService jefeDepartamentoService;

    private JefeDepartamentoController(JefeDepartamentoService jefeDepartamentoService) {
        this.jefeDepartamentoService = jefeDepartamentoService;
    }
    /**
     * Patron singleton
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public static JefeDepartamentoController getInstance() {
        if (controller == null) {
            controller = new JefeDepartamentoController(new JefeDepartamentoService(new RepoJefeDepartamento()));
        }
        return controller;
    }

    /**
     * Printea  todos los jefe departamemtos en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  jefedepartamento por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el save de jefe departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el update de jefe departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el delete de jefe departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     * @return
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