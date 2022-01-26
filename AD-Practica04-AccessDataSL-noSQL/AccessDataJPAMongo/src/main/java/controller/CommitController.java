package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CommitDTO;
import repository.RepoCommit;
import service.CommitService;

import java.sql.SQLException;

public class CommitController {
    private static CommitController controller;
    private final CommitService service;
    private CommitController(CommitService service){
        this.service=service;
    }
    public CommitController getInstance(){
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
    public String getAllCommit() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.getAllCommits());
        } catch (SQLException e) {
            System.err.println("Error CommitController en getAll: " + e.getMessage());
            return "Error CommitController en getAll: " + e.getMessage();
        }
    }
    /**
     * Printea commit por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getCommitByIdJSON(Long id) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.getCommitById(id));
        } catch (SQLException e) {
            System.err.println("Error CommitController en getCommitById: " + e.getMessage());
            return "Error CommitController en getCommitById: " + e.getMessage();
        }
    }
    /**
     * Printea  el save de commit en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String postCommit(CommitDTO commitDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.postCommit(commitDTO));
        } catch (SQLException e) {
            System.err.println("Error CommitController en postCommit: " + e.getMessage());
            return "Error CommitController en postCommit: " + e.getMessage();
        }
    }
    /**
     * Printea  el update de commit en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String updateCommit(CommitDTO commitDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.updateCommit(commitDTO));
        } catch (SQLException e) {
            System.err.println("Error CommitController en updateCommit: " + e.getMessage());
            return "Error CommitController en updateCommit: " + e.getMessage();
        }
    }
    /**
     * Printea  el delete de commit en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String deleteCommit(CommitDTO commitDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.deleteCommit(commitDTO));
        } catch (SQLException e) {
            System.err.println("Error CommitController en deleteCommit: " + e.getMessage());
            return "Error CommitController en deleteCommit: " + e.getMessage();
        }
    }
}
