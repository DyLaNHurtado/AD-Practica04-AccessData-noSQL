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
    private IssueController(IssueService service){
        this.service=service;
    }
    public static IssueController getInstance(){
        if(controller==null){
            controller=new IssueController(new IssueService(new RepoIssue()));
        }
        return controller;
    }
    /**
     * Printea  todos los issue en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     * @return
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
     * Printea issue por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     * @return
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
     * Printea  el save de issue en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el update de issue en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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
     * Printea  el delete de issue en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
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