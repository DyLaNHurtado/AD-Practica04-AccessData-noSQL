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

    /**
     * Constructor privado
     * @param service LoginService
     */
    private LoginController(LoginService service){
        this.service=service;
    }

    /**
     * Patron Singleton
     * @return LoginController
     */
    public static LoginController getInstance(){
        if(controller==null){
            controller=new LoginController(new LoginService(new RepoLogin()));
        }
        return controller;
    }

    /**
     * LLama al servicio y devuelve una lista de LoginDTO
     * @return List<LoginDTO>
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
     * LLama al servicio y devuelve LoginDTO según una ID
     * @param id Long
     * @return LoginDTO
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
     * LLama al servicio para insertar un Login
     * @param loginDTO
     * @return LoginDTO
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
     * Llama al servicio para actualizar un Login
     * @param loginDTO
     * @return LoginDTO
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
     * Llama al servicio para eliminar un Login
     * @param loginDTO
     * @return LoginDTO
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
