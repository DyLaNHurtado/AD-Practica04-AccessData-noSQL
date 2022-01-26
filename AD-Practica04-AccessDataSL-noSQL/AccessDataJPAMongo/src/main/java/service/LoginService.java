package service;

import dao.Commit;
import dao.Login;
import dto.CommitDTO;
import dto.LoginDTO;
import mapper.CommitMapper;
import mapper.LoginMapper;
import repository.RepoCommit;
import repository.RepoLogin;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LoginService extends BaseService<Login, Long, RepoLogin> {


    LoginMapper mapper = new LoginMapper();

    // Inyección de dependencias en el constructor. El servicio necesita este repositorio
    public LoginService(RepoLogin repository) {
        super(repository);
    }

    /**
     * Mapea todos los logins a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<LoginDTO>> getAllLogins() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un login por id a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public LoginDTO getLoginById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el save de login a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public LoginDTO postLogin(LoginDTO loginDTO) throws SQLException {
        Optional<Login> res = this.save(mapper.fromDTO(loginDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de login a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public LoginDTO updateLogin(LoginDTO loginDTO) throws SQLException {
        Optional<Login> res = this.update(mapper.fromDTO(loginDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de login a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public LoginDTO deleteLogin(LoginDTO loginDTO) throws SQLException {
        Optional<Login> res = this.delete(mapper.fromDTO(loginDTO));
        return mapper.toDTO(res.get());
    }

}
