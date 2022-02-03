package controller;

import dto.DepartamentoDTO;
import repository.RepoDepartamento;
import service.DepartamentoService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de Departamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class DepartamentoController {
    private static DepartamentoController controller = null;

    private final DepartamentoService departamentoService;

    private DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }
    /**
     * Patron singleton
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public static DepartamentoController getInstance() {
        if (controller == null) {
            controller = new DepartamentoController(new DepartamentoService(new RepoDepartamento()));
        }
        return controller;
    }
    /**
     * Printea  todos los departamentos en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public List<DepartamentoDTO> getAllDepartamentos() {
        try {
            return departamentoService.getAllDepartamentos().get();
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getAll: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea  departamento por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public DepartamentoDTO getDepartamentoById(Long id) {
        try {
            return departamentoService.getDepartamentoById(id);
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getDepartamentoById: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea  el save de departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public DepartamentoDTO postDepartamento(DepartamentoDTO departamentoDTO) {
        try {
            return departamentoService.postDepartamento(departamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en postDepartamento: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea  el update de departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) {
        try {
            return departamentoService.updateDepartamento(departamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en updateDepartamento: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea  el delete de departamento en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public DepartamentoDTO deleteDepartamento(DepartamentoDTO departamentoDTO) {
        try {
            return departamentoService.deleteDepartamento(departamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en deleteDepartamento: " + e.getMessage());
            return null;
        }
    }
}