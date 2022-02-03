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

    private static DepartamentoController controller;
    private final DepartamentoService departamentoService;

    /**
     * Constructor privado
     * @param departamentoService
     */
    private DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    /**
     * Patron Singleton
     * @return DepartamentoController
     */
    public static DepartamentoController getInstance() {
        if (controller == null) {
            controller = new DepartamentoController(new DepartamentoService(new RepoDepartamento()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de DepartamentoDTO
     * @return List<DepartamentoDTO>
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
     * LLama al servicio y devuelve DepartamentoDTO según una ID
     * @param id Long
     * @return DepartamentoDTO
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
     * LLama al servicio para insertar un Departamento
     * @param departamentoDTO
     * @return DepartamentoDTO
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
     * Llama al servicio para actualizar un Departamento
     * @param departamentoDTO
     * @return DepartamentoDTO
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
     * Llama al servicio para eliminar un Departamento
     * @param departamentoDTO
     * @return DepartamentoDTO
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