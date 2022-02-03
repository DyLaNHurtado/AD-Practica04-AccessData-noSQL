package controller;

import dto.LoginDTO;
import repository.RepoLogin;
import service.LoginService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de Login
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class LoginController {
    private static LoginController controller;
    private final LoginService service;
    private LoginController(LoginService service){
        this.service=service;
    }

    public static LoginController getInstance(){
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
    public List<LoginDTO> getAllLogin() {
        try {
            return service.getAllLogins().get();
        } catch (SQLException e) {
            System.err.println("Error LoginController en getAll: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea login por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public LoginDTO getLoginByIdJSON(Long id) {
        try {
            return service.getLoginById(id);
        } catch (SQLException e) {
            System.err.println("Error LoginController en getLoginById: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea  el save de login en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public LoginDTO postLogin(LoginDTO loginDTO) {
        try {
            return service.postLogin(loginDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en postLogin: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea  el update de login en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public LoginDTO updateLogin(LoginDTO loginDTO) {
        try {
            return service.updateLogin(loginDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en updateLogin: " + e.getMessage());
            return null;
        }
    }
    /**
     * Printea  el delete de login en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public LoginDTO deleteLogin(LoginDTO loginDTO) {
        try {
            return service.deleteLogin(loginDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en deleteLogin: " + e.getMessage());
            return null;
        }
    }
}
