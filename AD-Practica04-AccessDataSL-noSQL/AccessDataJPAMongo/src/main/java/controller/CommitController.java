package controller;

import dto.CommitDTO;
import repository.RepoCommit;
import service.CommitService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de Commit
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class CommitController {

    private static CommitController controller;
    private final CommitService service;

    /**
     * Constructor privado
     * @param service CommitService
     */
    private CommitController(CommitService service){
        this.service=service;
    }

    /**
     * Patron Singleton
     * @return CommitController
     */
    public static CommitController getInstance(){
        if(controller==null){
            controller=new CommitController(new CommitService(new RepoCommit()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de CommitDTO
     * @return List<CommitDTO>
     */
    public List<CommitDTO> getAllCommit() {
        try {
            return service.getAllCommits().get();
        } catch (SQLException e) {
            System.err.println("Error CommitController en getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio y devuelve CommitDTO según una ID
     * @param id Long
     * @return CommitDTO
     */
    public CommitDTO getCommitById(Long id) {
        try {
            return service.getCommitById(id);
        } catch (SQLException e) {
            System.err.println("Error CommitController en getCommitById: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio para insertar un Commit
     * @param commitDTO
     * @return CommitDTO
     */
    public CommitDTO postCommit(CommitDTO commitDTO) {
        try {
            return service.postCommit(commitDTO);
        } catch (SQLException e) {
            System.err.println("Error CommitController en postCommit: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para actualizar un Commit
     * @param commitDTO
     * @return CommitDTO
     */
    public CommitDTO updateCommit(CommitDTO commitDTO) {
        try {
            return service.updateCommit(commitDTO);
        } catch (SQLException e) {
            System.err.println("Error CommitController en updateCommit: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para eliminar un Commit
     * @param commitDTO
     * @return CommitDTO
     */
    public CommitDTO deleteCommit(CommitDTO commitDTO) {
        try {
            return service.deleteCommit(commitDTO);
        } catch (SQLException e) {
            System.err.println("Error CommitController en deleteCommit: " + e.getMessage());
            return null;
        }
    }
}