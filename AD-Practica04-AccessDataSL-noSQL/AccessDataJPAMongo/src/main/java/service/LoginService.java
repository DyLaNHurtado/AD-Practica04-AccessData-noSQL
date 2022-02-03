package service;

import dao.Login;
import dto.LoginDTO;
import mapper.LoginMapper;
import repository.RepoLogin;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Login
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class LoginService extends BaseService<Login, Long, RepoLogin> {


    LoginMapper mapper = new LoginMapper();

    /**
     * Constructor con inyección de dependencias
     * @param repository LoginService
     */
    public LoginService(RepoLogin repository) {
        super(repository);
    }

    /**
     * Mapea una lista de Login a LoginDTO
     * @return Optional<List<LoginDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<LoginDTO>> getAllLogins() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un Login a LoginDTO a partir de una ID
     * @param id de Login
     * @return LoginDTO
     * @throws SQLException Exception
     */
    public LoginDTO getLoginById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el Login de save a LoginDTO
     * @param loginDTO LoginDTO
     * @return LoginDTO
     * @throws SQLException Exception
     */
    public LoginDTO postLogin(LoginDTO loginDTO) throws SQLException {
        Optional<Login> res = this.save(mapper.fromDTO(loginDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de Login a LoginDTO
     * @param loginDTO LoginDTO
     * @return LoginDTO
     * @throws SQLException Exception
     */
    public LoginDTO updateLogin(LoginDTO loginDTO) throws SQLException {
        Optional<Login> res = this.update(mapper.fromDTO(loginDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de Login a LoginDTO
     * @param loginDTO LoginDTO
     * @return LoginDTO
     * @throws SQLException Exception
     */
    public LoginDTO deleteLogin(LoginDTO loginDTO) throws SQLException {
        Optional<Login> res = this.delete(mapper.fromDTO(loginDTO));
        return mapper.toDTO(res.get());
    }

}
