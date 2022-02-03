package controller;

import dto.ProgramadorDTO;
import repository.RepoProgramador;
import service.ProgramadorService;
import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de Programador
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class ProgramadorController {

    private static ProgramadorController controller;
    private final ProgramadorService programadorService;

    /**
     * Constructor privado
     * @param programadorService
     */
    private ProgramadorController(ProgramadorService programadorService) {
        this.programadorService = programadorService;
    }

    /**
     * Patron Singleton
     * @return ProgramadorController
     */
    public static ProgramadorController getInstance() {
        if (controller == null) {
            controller = new ProgramadorController(new ProgramadorService(new RepoProgramador()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de ProgramadorDTO
     * @return List<ProgramadorDTO>
     */
    public List<ProgramadorDTO> getAllProgramadores() {
        try {
            return programadorService.getAllProgramadores().get();
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio y devuelve ProgramadorDTO según una ID
     * @param id Long
     * @return ProgramadorDTO
     */
    public ProgramadorDTO getProgramadorById(Long id) {
        try {
            return programadorService.getProgramadorById(id);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getProgramadorById: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio para insertar un Programador
     * @param programadorDTO
     * @return ProgramadorDTO
     */
    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.postProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en postProgramador: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para actualizar un Programador
     * @param programadorDTO
     * @return ProgramadorDTO
     */
    public ProgramadorDTO updateProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.updateProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en updateProgramador: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para eliminar un Programador
     * @param programadorDTO
     * @return ProgramadorDTO
     */
    public ProgramadorDTO deleteProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.deleteProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en deleteProgramador: " + e.getMessage());
            return null;
        }
    }
}