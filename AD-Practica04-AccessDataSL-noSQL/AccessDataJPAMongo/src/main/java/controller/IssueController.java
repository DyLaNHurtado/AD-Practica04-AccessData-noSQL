package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.IssueDTO;
import repository.RepoIssue;
import service.IssueService;

import java.sql.SQLException;

public class IssueController {
    private static IssueController controller;
    private final IssueService service;
    private IssueController(IssueService service){
        this.service=service;
    }
    public IssueController getInstance(){
        if(controller==null){
            controller=new IssueController(new IssueService(new RepoIssue()));
        }
        return controller;
    }
    /**
     * Printea  todos los issue en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getAllIssue() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.getAllIssues());
        } catch (SQLException e) {
            System.err.println("Error IssueController en getAll: " + e.getMessage());
            return "Error IssueController en getAll: " + e.getMessage();
        }
    }
    /**
     * Printea issue por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getIssueByIdJSON(Long id) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.getIssueById(id));
        } catch (SQLException e) {
            System.err.println("Error IssueController en getIssueById: " + e.getMessage());
            return "Error IssueController en getIssueById: " + e.getMessage();
        }
    }
    /**
     * Printea  el save de issue en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String postIssue(IssueDTO issueDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.postIssue(issueDTO));
        } catch (SQLException e) {
            System.err.println("Error IssueController en postIssue: " + e.getMessage());
            return "Error IssueController en postIssue: " + e.getMessage();
        }
    }
    /**
     * Printea  el update de issue en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String updateIssue(IssueDTO issueDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.updateIssue(issueDTO));
        } catch (SQLException e) {
            System.err.println("Error IssueController en updateIssue: " + e.getMessage());
            return "Error IssueController en updateIssue: " + e.getMessage();
        }
    }
    /**
     * Printea  el delete de issue en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String deleteIssue(IssueDTO issueDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.deleteIssue(issueDTO));
        } catch (SQLException e) {
            System.err.println("Error IssueController en deleteIssue: " + e.getMessage());
            return "Error IssueController en deleteIssue: " + e.getMessage();
        }
    }
}
