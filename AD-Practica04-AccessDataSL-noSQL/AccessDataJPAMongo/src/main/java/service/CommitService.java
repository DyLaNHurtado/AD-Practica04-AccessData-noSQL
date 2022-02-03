package service;

import dao.Commit;
import dto.CommitDTO;
import mapper.CommitMapper;
import repository.RepoCommit;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Commit
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class CommitService extends BaseService<Commit, Long, RepoCommit> {

    CommitMapper mapper = new CommitMapper();

    /**
     * Constructor con inyección de dependencias
     * @param repository CommitService
     */
    public CommitService(RepoCommit repository) {
        super(repository);
    }

    /**
     * Mapea una lista de Commit a CommitDTO
     * @return Optional<List<CommitDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<CommitDTO>> getAllCommits() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un Commit a CommitDTO a partir de una ID
     * @param id de Commit
     * @return CommitDTO
     * @throws SQLException Exception
     */
    public CommitDTO getCommitById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el Commit de save a CommitDTO
     * @param commitDTO CommitDTO
     * @return CommitDTO
     * @throws SQLException Exception
     */
    public CommitDTO postCommit(CommitDTO commitDTO) throws SQLException {
        Optional<Commit> res = this.save(mapper.fromDTO(commitDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de Commit a CommitDTO
     * @param commitDTO CommitDTO
     * @return CommitDTO
     * @throws SQLException Exception
     */
    public CommitDTO updateCommit(CommitDTO commitDTO) throws SQLException {
        Optional<Commit> res = this.update(mapper.fromDTO(commitDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de Commit a CommitDTO
     * @param commitDTO CommitDTO
     * @return CommitDTO
     * @throws SQLException Exception
     */
    public CommitDTO deleteCommit(CommitDTO commitDTO) throws SQLException {
        Optional<Commit> res = this.delete(mapper.fromDTO(commitDTO));
        return mapper.toDTO(res.get());
    }

}
