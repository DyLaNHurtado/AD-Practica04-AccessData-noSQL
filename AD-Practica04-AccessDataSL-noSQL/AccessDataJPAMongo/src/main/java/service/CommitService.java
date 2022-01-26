package service;

import dao.Commit;
import dto.CommitDTO;
import mapper.CommitMapper;
import repository.RepoCommit;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CommitService extends BaseService<Commit, Long, RepoCommit> {


    CommitMapper mapper = new CommitMapper();

    // Inyección de dependencias en el constructor. El servicio necesita este repositorio
    public CommitService(RepoCommit repository) {
        super(repository);
    }

    /**
     * Mapea todos los commit a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<CommitDTO>> getAllCommits() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un commit por id a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public CommitDTO getCommitById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el save de commit a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public CommitDTO postCommit(CommitDTO commitDTO) throws SQLException {
        Optional<Commit> res = this.save(mapper.fromDTO(commitDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de commit a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public CommitDTO updateCommit(CommitDTO commitDTO) throws SQLException {
        Optional<Commit> res = this.update(mapper.fromDTO(commitDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de commit a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public CommitDTO deleteCommit(CommitDTO commitDTO) throws SQLException {
        Optional<Commit> res = this.delete(mapper.fromDTO(commitDTO));
        return mapper.toDTO(res.get());
    }

}
