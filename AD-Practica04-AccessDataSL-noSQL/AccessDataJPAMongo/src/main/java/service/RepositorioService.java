package service;

import dao.Repositorio;
import dto.RepositorioDTO;
import mapper.RepositorioMapper;
import repository.RepoRepositorio;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RepositorioService extends BaseService<Repositorio, Long, RepoRepositorio> {


    RepositorioMapper mapper = new RepositorioMapper();

    // Inyección de dependencias en el constructor. El servicio necesita este repositorio
    public RepositorioService(RepoRepositorio repository) {
        super(repository);
    }

    /**
     * Mapea todos los repositorios a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<RepositorioDTO>> getAllRepositorios() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un repositorio por id a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public RepositorioDTO getRepositorioById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el save de repositorio a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public RepositorioDTO postRepositiorio(RepositorioDTO repositorioDTO) throws SQLException {
        Optional<Repositorio> res = this.save(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de repositorio a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public RepositorioDTO updateRepositorio(RepositorioDTO repositorioDTO) throws SQLException {
        Optional<Repositorio> res = this.update(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de repositorio a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public RepositorioDTO deleteRepositorio(RepositorioDTO repositorioDTO) throws SQLException {
        Optional<Repositorio> res = this.delete(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res.get());
    }

}

