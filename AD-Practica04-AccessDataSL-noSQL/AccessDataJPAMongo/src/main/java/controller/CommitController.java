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
    private CommitController(CommitService service){
        this.service=service;
    }
    public static CommitController getInstance(){
        if(controller==null){
            controller=new CommitController(new CommitService(new RepoCommit()));
        }
        return controller;
    }
    /**
     * Printea  todos los commit en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea commit por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el save de commit en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el update de commit en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el delete de commit en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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