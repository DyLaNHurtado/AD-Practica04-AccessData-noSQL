package service;

import dao.Repositorio;
import dto.RepositorioDTO;
import mapper.RepositorioMapper;
import repository.RepoRepositorio;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Repositorio
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepositorioService extends BaseService<Repositorio, Long, RepoRepositorio> {


    RepositorioMapper mapper = new RepositorioMapper();

    /**
     * Constructor con inyección de dependencias
     * @param repository RepositorioService
     */
    public RepositorioService(RepoRepositorio repository) {
        super(repository);
    }

    /**
     * Mapea una lista de Repositorio a RepositorioDTO
     * @return Optional<List<RepositorioDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<RepositorioDTO>> getAllRepositorios() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un Repositorio a RepositorioDTO a partir de una ID
     * @param id de Repositorio
     * @return RepositorioDTO
     * @throws SQLException Exception
     */
    public RepositorioDTO getRepositorioById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el Repositorio de save a RepositorioDTO
     * @param repositorioDTO RepositorioDTO
     * @return RepositorioDTO
     * @throws SQLException Exception
     */
    public RepositorioDTO postRepositiorio(RepositorioDTO repositorioDTO) throws SQLException {
        Optional<Repositorio> res = this.save(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de Repositorio a RepositorioDTO
     * @param repositorioDTO RepositorioDTO
     * @return RepositorioDTO
     * @throws SQLException Exception
     */
    public RepositorioDTO updateRepositorio(RepositorioDTO repositorioDTO) throws SQLException {
        Optional<Repositorio> res = this.update(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de Repositorio a RepositorioDTO
     * @param repositorioDTO RepositorioDTO
     * @return RepositorioDTO
     * @throws SQLException Exception
     */
    public RepositorioDTO deleteRepositorio(RepositorioDTO repositorioDTO) throws SQLException {
        Optional<Repositorio> res = this.delete(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res.get());
    }

}

