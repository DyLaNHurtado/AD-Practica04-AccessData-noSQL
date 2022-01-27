package controller;

import dto.ProgramadorDTO;
import repository.RepoProgramador;
import service.ProgramadorService;
import java.sql.SQLException;
import java.util.List;

public class ProgramadorController {
    private static ProgramadorController controller = null;

    private final ProgramadorService programadorService;

    private ProgramadorController(ProgramadorService programadorService) {
        this.programadorService = programadorService;
    }

    public static ProgramadorController getInstance() {
        if (controller == null) {
            controller = new ProgramadorController(new ProgramadorService(new RepoProgramador()));
        }
        return controller;
    }

    public List<ProgramadorDTO> getAllProgramadores() {
        try {
            return programadorService.getAllProgramadores().get();
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getAll: " + e.getMessage());
            return null;
        }
    }

    public ProgramadorDTO getProgramadorById(Long id) {
        try {
            return programadorService.getProgramadorById(id);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getProgramadorById: " + e.getMessage());
            return null;
        }
    }

    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.postProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en postProgramador: " + e.getMessage());
            return null;
        }
    }

    public ProgramadorDTO updateProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.updateProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en updateProgramador: " + e.getMessage());
            return null;
        }
    }

    public ProgramadorDTO deleteProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.deleteProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en deleteProgramador: " + e.getMessage());
            return null;
        }
    }
}