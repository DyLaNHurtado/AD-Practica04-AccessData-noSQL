package controller;

import dto.IssueDTO;
import repository.RepoIssue;
import service.IssueService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de Issue
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class IssueController {

    private static IssueController controller;
    private final IssueService service;

    /**
     * Constructor privado
     * @param service IssueService
     */
    private IssueController(IssueService service){
        this.service=service;
    }

    /**
     * Patron Singleton
     * @return IssueController
     */
    public static IssueController getInstance(){
        if(controller==null){
            controller=new IssueController(new IssueService(new RepoIssue()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de IssueDTO
     * @return List<IssueDTO>
     */
    public List<IssueDTO> getAllIssue() {
        try {
            return service.getAllIssues().get();
        } catch (SQLException e) {
            System.err.println("Error IssueController en getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio y devuelve IssueDTO según una ID
     * @param id Long
     * @return IssueDTO
     */
    public IssueDTO getIssueById(Long id) {
        try {
            return service.getIssueById(id);
        } catch (SQLException e) {
            System.err.println("Error IssueController en getIssueById: " + e.getMessage());
            return null;
        }
    }

    /**
     * LLama al servicio para insertar un Issue
     * @param issueDTO
     * @return IssueDTO
     */
    public IssueDTO postIssue(IssueDTO issueDTO) {
        try {
            return service.postIssue(issueDTO);
        } catch (SQLException e) {
            System.err.println("Error IssueController en postIssue: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para actualizar un Issue
     * @param issueDTO
     * @return IssueDTO
     */
    public IssueDTO updateIssue(IssueDTO issueDTO) {
        try {
            return service.updateIssue(issueDTO);
        } catch (SQLException e) {
            System.err.println("Error IssueController en updateIssue: " + e.getMessage());
            return null;
        }
    }

    /**
     * Llama al servicio para eliminar un Issue
     * @param issueDTO
     * @return IssueDTO
     */
    public IssueDTO deleteIssue(IssueDTO issueDTO) {
        try {
            return service.deleteIssue(issueDTO);
        } catch (SQLException e) {
            System.err.println("Error IssueController en deleteIssue: " + e.getMessage());
            return null;
        }
    }
}