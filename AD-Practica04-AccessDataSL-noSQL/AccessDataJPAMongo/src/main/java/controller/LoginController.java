package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.LoginDTO;
import repository.RepoLogin;
import service.LoginService;

import java.sql.SQLException;

public class LoginController {
    private static LoginController controller;
    private final LoginService service;
    private LoginController(LoginService service){
        this.service=service;
    }
    public LoginController getInstance(){
        if(controller==null){
            controller=new LoginController(new LoginService(new RepoLogin()));
        }
        return controller;
    }
    /**
     * Printea  todos los login en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getAllLogin() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.getAllLogins());
        } catch (SQLException e) {
            System.err.println("Error LoginController en getAll: " + e.getMessage());
            return "Error LoginController en getAll: " + e.getMessage();
        }
    }
    /**
     * Printea login por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getLoginByIdJSON(Long id) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.getLoginById(id));
        } catch (SQLException e) {
            System.err.println("Error LoginController en getLoginById: " + e.getMessage());
            return "Error LoginController en getLoginById: " + e.getMessage();
        }
    }
    /**
     * Printea  el save de login en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String postLogin(LoginDTO loginDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.postLogin(loginDTO));
        } catch (SQLException e) {
            System.err.println("Error LoginController en postLogin: " + e.getMessage());
            return "Error LoginController en postLogin: " + e.getMessage();
        }
    }
    /**
     * Printea  el update de login en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String updateLogin(LoginDTO loginDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.updateLogin(loginDTO));
        } catch (SQLException e) {
            System.err.println("Error LoginController en updateLogin: " + e.getMessage());
            return "Error LoginController en updateLogin: " + e.getMessage();
        }
    }
    /**
     * Printea  el delete de login en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String deleteLogin(LoginDTO loginDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.deleteLogin(loginDTO));
        } catch (SQLException e) {
            System.err.println("Error LoginController en deleteLogin: " + e.getMessage());
            return "Error LoginController en deleteLogin: " + e.getMessage();
        }
    }
}
